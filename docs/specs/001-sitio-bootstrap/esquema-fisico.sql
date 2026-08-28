-- ============================================================
-- OverText — Esquema físico de la base de datos
-- Fase SDD: Plan · Sprint 1 (E1-22) · Alimenta el informe §2.3
-- Motor: MySQL 8 · InnoDB · utf8mb4_unicode_ci
--
-- Este script es la forma FÍSICA del modelo descrito en data-model.md:
-- tipos SQL reales, claves primarias, foráneas, únicas e índices.
-- Se IMPLEMENTA por fases: categoria/producto/color en el ATF3 y el resto
-- en el TF. Aquí se escribe completo porque las cuatro rúbricas exigen el
-- diagrama físico desde el ATF1.
-- ============================================================

CREATE DATABASE IF NOT EXISTS overtext
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;
USE overtext;

-- ------------------------------------------------------------
-- 1. categoria — agrupa productos por submarca o línea (ATF3)
-- ------------------------------------------------------------
CREATE TABLE categoria (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(60)  NOT NULL,
    slug        VARCHAR(60)  NOT NULL,
    descripcion VARCHAR(255)     NULL,
    activo      BOOLEAN      NOT NULL DEFAULT TRUE,
    CONSTRAINT pk_categoria   PRIMARY KEY (id),
    CONSTRAINT uk_categoria_slug UNIQUE (slug)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 2. producto — prenda del catálogo (ATF3, CRUD completo)
-- ------------------------------------------------------------
CREATE TABLE producto (
    id               BIGINT        NOT NULL AUTO_INCREMENT,
    codigo           VARCHAR(40)   NOT NULL,
    nombre           VARCHAR(100)  NOT NULL,
    slogan           VARCHAR(150)      NULL,
    descripcion      TEXT              NULL,
    precio           DECIMAL(10,2) NOT NULL,
    precio_pack      DECIMAL(10,2)     NULL,
    stock            INT           NOT NULL DEFAULT 0,
    imagen_principal VARCHAR(255)      NULL,
    activo           BOOLEAN       NOT NULL DEFAULT TRUE,
    categoria_id     BIGINT        NOT NULL,
    CONSTRAINT pk_producto        PRIMARY KEY (id),
    CONSTRAINT uk_producto_codigo UNIQUE (codigo),
    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (categoria_id) REFERENCES categoria (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ck_producto_precio  CHECK (precio > 0),
    CONSTRAINT ck_producto_stock   CHECK (stock >= 0),
    INDEX ix_producto_categoria (categoria_id),
    INDEX ix_producto_activo    (activo)
) ENGINE=InnoDB;

-- El badge "últimas unidades" NO se guarda: se calcula con stock < 10.
-- Constitución art. 7 (un solo origen de verdad) y decisión del PO 2026-08-25.

-- ------------------------------------------------------------
-- 3. color — colores disponibles (ATF3)
-- ------------------------------------------------------------
CREATE TABLE color (
    id     BIGINT      NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    hex    CHAR(7)     NOT NULL,
    slug   VARCHAR(40) NOT NULL,
    CONSTRAINT pk_color      PRIMARY KEY (id),
    CONSTRAINT uk_color_slug UNIQUE (slug)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 4. variante_producto — producto x color x talla (TF)
-- ------------------------------------------------------------
CREATE TABLE variante_producto (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    talla       VARCHAR(4)  NOT NULL,
    stock       INT         NOT NULL DEFAULT 0,
    sku         VARCHAR(40) NOT NULL,
    producto_id BIGINT      NOT NULL,
    color_id    BIGINT      NOT NULL,
    CONSTRAINT pk_variante     PRIMARY KEY (id),
    CONSTRAINT uk_variante_sku UNIQUE (sku),
    CONSTRAINT uk_variante_combinacion UNIQUE (producto_id, color_id, talla),
    CONSTRAINT fk_variante_producto
        FOREIGN KEY (producto_id) REFERENCES producto (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_variante_color
        FOREIGN KEY (color_id) REFERENCES color (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ck_variante_stock CHECK (stock >= 0),
    INDEX ix_variante_producto (producto_id),
    INDEX ix_variante_color    (color_id)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 5. imagen_producto — galería de la ficha (TF)
-- ------------------------------------------------------------
CREATE TABLE imagen_producto (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    url         VARCHAR(255) NOT NULL,
    orden       INT          NOT NULL DEFAULT 1,
    producto_id BIGINT       NOT NULL,
    CONSTRAINT pk_imagen PRIMARY KEY (id),
    CONSTRAINT fk_imagen_producto
        FOREIGN KEY (producto_id) REFERENCES producto (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT ck_imagen_orden CHECK (orden >= 1),
    INDEX ix_imagen_producto (producto_id, orden)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 6. rol (TF)
-- ------------------------------------------------------------
CREATE TABLE rol (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(20)  NOT NULL,
    descripcion VARCHAR(100)     NULL,
    CONSTRAINT pk_rol        PRIMARY KEY (id),
    CONSTRAINT uk_rol_nombre UNIQUE (nombre)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 7. usuario (TF)
-- ------------------------------------------------------------
CREATE TABLE usuario (
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    email    VARCHAR(120) NOT NULL,
    password VARCHAR(72)  NOT NULL,  -- hash BCrypt, nunca texto plano (RNF-0004)
    nombre   VARCHAR(80)  NOT NULL,
    activo   BOOLEAN      NOT NULL DEFAULT TRUE,
    rol_id   BIGINT       NOT NULL,
    CONSTRAINT pk_usuario       PRIMARY KEY (id),
    CONSTRAINT uk_usuario_email UNIQUE (email),
    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (rol_id) REFERENCES rol (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    INDEX ix_usuario_rol (rol_id)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 8. pedido (TF)
-- ------------------------------------------------------------
CREATE TABLE pedido (
    id               BIGINT        NOT NULL AUTO_INCREMENT,
    numero           VARCHAR(20)   NOT NULL,          -- OT-2026-0001
    fecha            DATETIME      NOT NULL,
    cliente_nombre   VARCHAR(60)   NOT NULL,
    cliente_apellido VARCHAR(60)   NOT NULL,
    cliente_telefono VARCHAR(15)   NOT NULL,
    cliente_correo   VARCHAR(120)  NOT NULL,
    tipo_documento   VARCHAR(10)   NOT NULL,          -- DNI, CE, Pasaporte, RUC
    numero_documento VARCHAR(15)   NOT NULL,
    tipo_envio       VARCHAR(15)   NOT NULL,          -- recojo, delivery, provincia
    direccion_envio  VARCHAR(255)      NULL,
    costo_envio      DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    subtotal         DECIMAL(10,2) NOT NULL,
    total            DECIMAL(10,2) NOT NULL,
    metodo_pago      VARCHAR(15)   NOT NULL,          -- deposito, yape
    estado           VARCHAR(15)   NOT NULL DEFAULT 'PENDIENTE',
    usuario_id       BIGINT            NULL,          -- NULL = compra de invitado
    CONSTRAINT pk_pedido        PRIMARY KEY (id),
    CONSTRAINT uk_pedido_numero UNIQUE (numero),
    CONSTRAINT fk_pedido_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario (id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT ck_pedido_montos CHECK (costo_envio >= 0 AND subtotal >= 0 AND total >= 0),
    INDEX ix_pedido_usuario (usuario_id),
    INDEX ix_pedido_fecha   (fecha),
    INDEX ix_pedido_estado  (estado)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 9. detalle_pedido (TF)
-- ------------------------------------------------------------
CREATE TABLE detalle_pedido (
    id              BIGINT        NOT NULL AUTO_INCREMENT,
    variante_texto  VARCHAR(80)   NOT NULL,  -- "STONE BEIGE · TALLA M"
    precio_unitario DECIMAL(10,2) NOT NULL,  -- precio congelado al comprar (RN6)
    cantidad        INT           NOT NULL,
    subtotal        DECIMAL(10,2) NOT NULL,
    pedido_id       BIGINT        NOT NULL,
    producto_id     BIGINT        NOT NULL,
    CONSTRAINT pk_detalle PRIMARY KEY (id),
    CONSTRAINT fk_detalle_pedido
        FOREIGN KEY (pedido_id) REFERENCES pedido (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (producto_id) REFERENCES producto (id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ck_detalle_cantidad CHECK (cantidad >= 1),
    CONSTRAINT ck_detalle_precio   CHECK (precio_unitario > 0),
    INDEX ix_detalle_pedido   (pedido_id),
    INDEX ix_detalle_producto (producto_id)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- 10. mensaje_contacto — bandeja del formulario de contacto (TF)
-- Tabla independiente: no tiene ninguna clave foránea.
-- ------------------------------------------------------------
CREATE TABLE mensaje_contacto (
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    nombre   VARCHAR(60)  NOT NULL,
    correo   VARCHAR(120) NOT NULL,
    asunto   VARCHAR(120) NOT NULL,
    mensaje  TEXT         NOT NULL,
    fecha    DATETIME     NOT NULL,
    atendido BOOLEAN      NOT NULL DEFAULT FALSE,
    CONSTRAINT pk_mensaje PRIMARY KEY (id),
    INDEX ix_mensaje_atendido (atendido, fecha)
) ENGINE=InnoDB;

-- ============================================================
-- Datos semilla (data-model.md §3)
-- ============================================================
INSERT INTO categoria (nombre, slug, descripcion) VALUES
    ('Overcoming', 'overcoming', 'Submarca de shorts de hombre de OverText');

INSERT INTO rol (nombre, descripcion) VALUES
    ('ADMIN',   'Gestiona el catálogo, el inventario y los pedidos'),
    ('CLIENTE', 'Compra y consulta sus pedidos');

INSERT INTO color (nombre, hex, slug) VALUES
    ('Stone Beige', '#C4A882', 'beige'),
    ('Negro',       '#111111', 'negro'),
    ('Guinda',      '#8B1A2C', 'guinda'),
    ('Gris',        '#9E9E9E', 'gris'),
    ('Oliva',       '#5C6B3A', 'oliva'),
    ('Azul',        '#1A3A7A', 'azul'),
    ('Marrón',      '#6B4A2E', 'marron');

-- El BLANCO del configurador de packs NO se carga: no existe como producto
-- (spec I1, decisión del PO 2026-08-25).

INSERT INTO producto (codigo, nombre, precio, precio_pack, stock, categoria_id) VALUES
    ('short-beige',  'SHORT STONE BEIGE', 20.00, 100.00, 24, 1),
    ('short-negro',  'SHORT NEGRO',       20.00, 100.00, 24, 1),
    ('short-guinda', 'SHORT GUINDA',      20.00, 100.00, 24, 1),
    ('short-gris',   'SHORT GRIS',        20.00, 100.00, 24, 1),
    ('short-oliva',  'SHORT OLIVA',       20.00, 100.00, 24, 1),
    ('short-azul',   'SHORT AZUL',        20.00, 100.00, 24, 1),
    ('short-marron', 'SHORT MARRÓN',      20.00, 100.00, 24, 1);
