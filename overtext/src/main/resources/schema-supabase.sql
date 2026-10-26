-- ============================================================
-- OverText — Script DDL y Semilla para Supabase (PostgreSQL)
-- Práctica Calificada 3 (P3) / ATF3
-- Responsable: Jonathan (DevOps & Base de Datos)
-- ============================================================

-- 1. Tabla: categoria
CREATE TABLE IF NOT EXISTS categoria (
    id          BIGSERIAL PRIMARY KEY,
    nombre      VARCHAR(60) NOT NULL,
    slug        VARCHAR(60) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    activo      BOOLEAN NOT NULL DEFAULT TRUE
);

-- 2. Tabla: producto
CREATE TABLE IF NOT EXISTS producto (
    id               BIGSERIAL PRIMARY KEY,
    codigo           VARCHAR(40) NOT NULL UNIQUE,
    nombre           VARCHAR(100) NOT NULL,
    slogan           VARCHAR(150),
    descripcion      TEXT,
    precio           DECIMAL(10,2) NOT NULL CHECK (precio > 0),
    precio_pack      DECIMAL(10,2),
    stock            INT NOT NULL DEFAULT 0 CHECK (stock >= 0),
    imagen_principal VARCHAR(255),
    color_nombre     VARCHAR(40) NOT NULL,
    color_hex        VARCHAR(10) NOT NULL,
    correo_proveedor VARCHAR(100) NOT NULL,
    activo           BOOLEAN NOT NULL DEFAULT TRUE,
    categoria_id     BIGINT NOT NULL REFERENCES categoria(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- 3. Tabla: rol
CREATE TABLE IF NOT EXISTS rol (
    id          BIGSERIAL PRIMARY KEY,
    nombre      VARCHAR(40) NOT NULL UNIQUE,
    descripcion VARCHAR(150)
);

-- 4. Tabla: usuario
CREATE TABLE IF NOT EXISTS usuario (
    id          BIGSERIAL PRIMARY KEY,
    email       VARCHAR(100) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    nombre      VARCHAR(100) NOT NULL,
    activo      BOOLEAN NOT NULL DEFAULT TRUE,
    rol_id      BIGINT NOT NULL REFERENCES rol(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Índices recomendados
CREATE INDEX IF NOT EXISTS ix_producto_categoria ON producto(categoria_id);
CREATE INDEX IF NOT EXISTS ix_producto_activo ON producto(activo);
CREATE INDEX IF NOT EXISTS ix_usuario_rol ON usuario(rol_id);
CREATE INDEX IF NOT EXISTS ix_usuario_email ON usuario(email);

-- ============================================================
-- Datos iniciales (Semillero OverText)
-- ============================================================

INSERT INTO categoria (nombre, slug, descripcion, activo)
VALUES 
('Shorts Urbanos', 'shorts-urbanos', 'Shorts de streetwear peruano de alta calidad', true)
ON CONFLICT (slug) DO NOTHING;

-- Inserción de los 7 productos representativos con sus colores oficiales
INSERT INTO producto (
    codigo, nombre, slogan, descripcion, precio, precio_pack, stock,
    imagen_principal, color_nombre, color_hex, correo_proveedor, activo, categoria_id
)
VALUES
('PROD-NEG-01', 'Short Negro', 'El clásico infaltable.', 'Short urbano en algodón pesado con corte relajado.', 45.00, 35.00, 25, '/assets/img/catalogo/short-negro-1.webp', 'Negro', '#111111', 'proveedor.lima@overtext.pe', true, 1),
('PROD-BEI-02', 'Short Stone Beige', 'Tonos neutros para el día a día.', 'Short streetwear en tono arena suave y versátil.', 45.00, 35.00, 18, '/assets/img/catalogo/short-stone-beige-1.webp', 'Stone Beige', '#D4C5B9', 'proveedor.norte@overtext.pe', true, 1),
('PROD-GUI-03', 'Short Guinda', 'Intensidad y presencia urbana.', 'Color guinda profundo con costuras reforzadas.', 45.00, 35.00, 12, '/assets/img/catalogo/short-guinda-1.webp', 'Guinda', '#6B1D2F', 'proveedor.lima@overtext.pe', true, 1),
('PROD-GRI-04', 'Short Gris', 'Esencial en cualquier rotación.', 'Gris jaspeado de alta densidad y tacto suave.', 45.00, 35.00, 30, '/assets/img/catalogo/short-gris-1.webp', 'Gris', '#7A7D81', 'proveedor.sur@overtext.pe', true, 1),
('PROD-OLI-05', 'Short Oliva Militar', 'Estilo militar contemporáneo.', 'Verde oliva oscuro perfecto para looks streetwear.', 45.00, 35.00, 8, '/assets/img/catalogo/short-oliva-militar-1.webp', 'Oliva Militar', '#4B5320', 'proveedor.lima@overtext.pe', true, 1),
('PROD-AZU-06', 'Short Azul Marino', 'Sobriedad y versatilidad total.', 'Azul marino clásico con bolsillos laterales profundos.', 45.00, 35.00, 20, '/assets/img/catalogo/short-azul-marino-1.webp', 'Azul Marino', '#1B263B', 'proveedor.norte@overtext.pe', true, 1),
('PROD-MAR-07', 'Short Marrón', 'Tonos tierra de tendencia.', 'Marrón cálido fabricado en tela french terry premium.', 45.00, 35.00, 15, '/assets/img/catalogo/short-marron-1.webp', 'Marrón', '#4A3728', 'proveedor.sur@overtext.pe', true, 1)
ON CONFLICT (codigo) DO NOTHING;

-- Inserción de roles del sistema
INSERT INTO rol (nombre, descripcion)
VALUES
('ADMIN', 'Administrador con acceso total al sistema'),
('CLIENTE', 'Cliente registrado de la tienda OverText')
ON CONFLICT (nombre) DO NOTHING;

-- Inserción de usuarios iniciales (Contraseñas legibles para verificación: Admin123! y Cliente123!)
INSERT INTO usuario (email, password, nombre, activo, rol_id)
VALUES
('admin@overtext.pe', 'Admin123!', 'Administrador OverText', true, 1),
('cliente@overtext.pe', 'Cliente123!', 'Jonathan Lopez', true, 2)
ON CONFLICT (email) DO NOTHING;

