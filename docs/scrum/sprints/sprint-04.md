# Sprint 4 — Spring Data, JPA y MySQL

**Semanas 9-10 del ciclo · 05-oct → 18-oct-2026 · Sesiones 17 a 20 · Unidad 3**
**Sin entrega** — primer sprint del ATF3 · **Spec:** `docs/specs/003-crud-catalogo/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 17-18 | ORM: definiciones, Hibernate, Spring Data y configuración de Spring Data con MySQL |
| 19-20 | JPA: definición, usos y construcción de proyectos web **y REST** con Spring para operaciones CRUD a una base de datos MySQL |

## 2. Objetivo del sprint

> Conectar la aplicación a MySQL y hacer que el catálogo y la ficha de producto lean desde la base de datos en lugar de una lista en memoria, con la estructura de capas que exige la rúbrica.

## 3. Hacia qué criterio del ATF3 apunta

| Criterio | Pts | Qué se adelanta aquí |
|---|:-:|---|
| 1 Estructura del proyecto | 5 | **Completo**: entidad, repositorio, servicio y controlador por tabla, con sufijos y rutas |
| 2 Operaciones de lectura | 5 | 2a mostrar todos los registros · 2d renderizado con Thymeleaf |

Los criterios 2b, 2c y todo el 3 (insertar, actualizar, eliminar, validaciones) se cierran en el Sprint 5.

## 4. Alcance

### Duo Datos / Backend — José · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-01 | `spring-boot-starter-data-jpa` + `mysql-connector-j`; crear la base `overtext_db` | 1 | 17-18 |
| E3-02 | Entidades `Categoria` y `Producto` con `@Entity`, `@OneToMany` / `@ManyToOne` | **1** | 17-18 |
| E3-03 | `CategoriaRepository` y `ProductoRepository` extendiendo `JpaRepository` | **1** | 17-18 |
| E3-04 | `CategoriaService`/`CategoriaServiceImpl` y `ProductoService`/`ProductoServiceImpl` | **1** | 19-20 |
| E3-05 | `CargaInicial` (`CommandLineRunner`) que siembra las categorías y los 7 productos | 2a | 19-20 |
| E3-13 | `[SÍLABO]` `ProductoRestController` con `@RestController` — el sílabo pide *«proyectos web y REST»* | — | 19-20 |

**Nomenclatura obligatoria** (constitución art. 5, criterio 1 de la rúbrica). El descriptor "Completo" exige **las cuatro capas para cada tabla, con su respectiva nomenclatura de sufijos y rutas**. Sin `ServiceImpl` el criterio baja de 5 a 2 puntos.

```
entity/Producto.java              repository/ProductoRepository.java
service/ProductoService.java      service/impl/ProductoServiceImpl.java
controller/ProductoController.java
```

### Duo UI / Front — Jonathan · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-06 | Catálogo y ficha leyendo desde MySQL; el `th:each` del Sprint 3 **no cambia** | **2a, 2d** | 19-20 |
| E3-14 | Badge de stock **calculado** desde `producto.stock`, no almacenado (art. 7) | 2d | 19-20 |
| E3-15 | Maquetar `/admin/productos`: listado en tabla con Bootstrap, aún solo lectura | 2b | 19-20 |
| E3-16 | Maquetar el panel `/admin` con los KPI (todavía con datos de prueba) | — | 19-20 |

> Si el Sprint 3 dejó bien el `@Service`, este cambio es solo sustituir la fuente de datos. La plantilla no se toca.

### Duo Documento / QA — Joaquín · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E3-17 | Actualizar **2.3 Diseño de la base de datos** con el esquema MySQL real ya creado | 4 |
| E3-18 | Ampliar 2.2 Requisitos con RQF-0010 y RQF-0011 (gestión de productos y categorías) | 4 |
| E3-19 | `README` con los pasos para crear la base y arrancar en una máquina nueva | — |
| E3-20 | Regresión ATF1 y ATF2: 6 componentes Bootstrap, fragments, 404, menú activo | ATF1, ATF2 |

## 5. Modelo de datos de este sprint

Solo dos tablas, y bastan para toda la rúbrica del ATF3:

| Tabla | Campos | Relación |
|---|:-:|---|
| `categoria` | 5 | — |
| `producto` | 11 | FK → `categoria(id)` |

Cumple las restricciones de la tarea: al menos una tabla con **clave foránea** a otra, ninguna con **menos de 3 campos**, y `producto` tendrá **CRUD completo** en el Sprint 5.

Detalle campo por campo, tipos y validaciones: `docs/specs/001-sitio-bootstrap/data-model.md` §2.1 y §2.2.

## 6. Orden de trabajo

```
Día 1-3   E3-01 conexión a MySQL  →  todos conectan en su máquina
Día 4-6   E3-02/E3-03 entidades y repositorios
Día 7-8   E3-04 servicios  →  E3-05 datos semilla
Día 9-10  E3-06 catálogo desde BD, maquetado del panel, regresión
```

Igual que en el Sprint 2: nadie escribe entidades hasta que **las 6 máquinas** conecten a MySQL.

## 7. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] La aplicación arranca y crea o encuentra las tablas
- [ ] Las cuatro capas existen con la **nomenclatura de sufijos correcta**
- [ ] Cada clase en su paquete
- [ ] El dato se ve en pantalla leído desde MySQL, no desde JSON
- [ ] Sin errores en consola
- [ ] Captura en `informes/capturas/sprint-04/`
- [ ] Bloque "Para consolidar" escrito

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| **MySQL configurado distinto en cada máquina** — el riesgo mayor del sprint | Día 1-3 dedicado a que las 6 conecten. `application.properties` con variables de entorno y `README` (E3-19) |
| Se salta la capa de servicio "para ir más rápido" | Sin `ServiceImpl` el criterio 1 cae de 5 a 2 puntos. Está en la DoD. |
| Contraseña de MySQL commiteada | Constitución art. 6. Nunca en el `.properties` versionado. |
| `ddl-auto=create-drop` borra los datos en cada arranque | Usar `update` en desarrollo; documentarlo en el `README` |
| Se rompe el ATF2 al cambiar la fuente de datos | E3-20 regresión obligatoria |

## 9. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 05-oct |
| Daily asíncrono | cada día, en la memoria personal |
| Review | vie 16-oct |
| Retro + consolidación | vie 16-oct, tras la review |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 16-oct

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| | | |

## Retrospectiva — 16-oct

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 5**
