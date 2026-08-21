# Product Backlog — OverText

**Product Owner:** Joaquín · **Scrum Master:** Jonathan
Artículo 1 de la constitución: toda historia se traza a un criterio de rúbrica o es prerrequisito de uno.

Estados: ⬜ pendiente · 🟨 en curso · ✅ hecho
Marca `[SÍLABO]`: tema que se dicta en clase pero **ninguna rúbrica exige**. Se implementa por el objetivo del proyecto; es lo primero que se recorta si el tiempo aprieta.

Reparto por sprint: ver [`roadmap.md`](roadmap.md) y `sprints/sprint-0N.md`.

---

## Épica 1 — Interfaz con framework front-end · ATF1 · Sprint 1

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E1-01 | Bootstrap 5.3 por CDN y `tema-overtext.css` con la paleta de marca | 1a | UI | ⬜ |
| E1-02 | Header como `navbar navbar-expand-lg` responsivo en las 10 páginas | 1b | UI | ⬜ |
| E1-03 | Envolver todas las páginas en `.container` / `.container-fluid` | 1a | UI | ⬜ |
| E1-04 | Carrusel en la portada: 3+ diapositivas, controles e indicadores | **1e** | UI | ⬜ |
| E1-05 | Carrusel en la galería de la ficha, tolerante a productos sin galería | **1e** | UI | ⬜ |
| E1-06 | Grillas `row`/`col-*` en catálogo, promociones, nosotros y pie | 1f | UI | ⬜ |
| E1-07 | Formularios de contacto, login y compra a `form-control` + `was-validated` | 1c | Datos | ⬜ |
| E1-08 | Modal de confirmación de contacto | 1d | Datos | ⬜ |
| E1-09 | Modal de guía de tallas en la ficha de producto | 1d | Datos | ⬜ |
| E1-10 | Panel del carrito convertido en `offcanvas` | 1b | Datos | ⬜ |
| E1-11 | Bootstrap Icons en lugar de los PNG de 4-5 MB | 1a | Datos | ⬜ |
| E1-12 | Eliminar `css/style.css` (616 líneas de código muerto) | 2b | Doc/QA | ⬜ |
| E1-13 | Extraer el script incrustado de `promotions.html` a `js/promociones.js` | 2a, 2b | Doc/QA | ⬜ |
| E1-14 | Eliminar los 15 estilos en línea | 2b | Doc/QA | ⬜ |
| E1-15 | Quitar los valores de relleno que parpadean al cargar | 2b, 2d | Doc/QA | ⬜ |
| E1-16 | Optimizar `assets/` de 39 MB a menos de 15 MB | — | Doc/QA | ⬜ |
| E1-17 | Actualizar `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` | 2a | Doc/QA | ⬜ |
| E1-18 | Verificar kebab-case archivo por archivo | **2c** | Doc/QA | ⬜ |
| E1-19 | Verificar consola sin errores en las 10 páginas | **2d** | todos | ⬜ |
| E1-20 | Limpiar la plantilla UTP; añadir Docente, Recomendaciones y Anexos | 3 | Doc/QA | ⬜ |
| E1-21 | Redactar 1.1, 1.2, 2.1, 2.2 y 2.3 del informe | **3** | Doc/QA | ⬜ |
| E1-22 | Diagrama físico de la base de datos | **3** | Datos | ⬜ |
| E1-23 | Capturas de las 10 páginas + foto de la estructura | 3 | Doc/QA | ⬜ |
| E1-24 | Empaquetar `ATF1_GRUPO_01` y verificar en otra máquina | **4** | Doc/QA | ⬜ |
| E1-25 | `[SÍLABO]` Estilos de párrafo tipográficos en el tema *(sesión 5-6)* | — | UI | ⬜ |
| E1-26 | `[SÍLABO]` Tabla de tallas con `table table-striped` *(sesión 3-4)* | — | Datos | ⬜ |

## Épica 2 — Spring Boot, Spring Web y Thymeleaf · ATF2 · Sprints 2-3

### Sprint 2 — cimientos

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E2-01 | Crear el proyecto Spring Boot 3.x con Maven, Java 17+, `web` y `thymeleaf` | — | Datos | ⬜ |
| E2-02 | Mover recursos a `static/` y páginas a `templates/paginas/` | — | UI | ⬜ |
| E2-03 | Construir `layout/plantilla.html` con `th:fragment` | **2a** | UI | ⬜ |
| E2-04 | Fragments `cabecera`, `pie`, `carrito` y `scripts` | **2a** | UI | ⬜ |
| E2-05 | `HomeController` — página de inicio por defecto | **1b** | Datos | ⬜ |
| E2-06 | Un `@Controller` por sección con rutas limpias (5+ páginas) | **1a** | Datos | ⬜ |
| E2-13 | `application.properties` con variables de entorno; `README` de arranque | — | Datos | ⬜ |
| E2-14 | Verificar que las rutas de recursos estáticos funcionan tras el traslado | — | UI | ⬜ |
| E2-15 | Redactar la INTRODUCCIÓN del informe (adelantada) | 3 | Doc/QA | ⬜ |
| E2-16 | Actualizar 2.1.2 con Spring Boot y Spring Web | 3 | Doc/QA | ⬜ |
| E2-17 | Verificar consola sin errores tras la migración | ATF1-2d | Doc/QA | ⬜ |
| E2-18 | **Regresión ATF1**: los 6 componentes de Bootstrap siguen funcionando | ATF1-1 | Doc/QA | ⬜ |

### Sprint 3 — Thymeleaf y rutas

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E2-07 | Página **404 personalizada** + `ManejadorErroresGlobal` | **1c** | Datos | ⬜ |
| E2-19 | Página de error 500 | 1c | Datos | ⬜ |
| E2-08 | Menú con `th:classappend` marcando el enlace activo | **1d** | UI | ⬜ |
| E2-09 | `ProductoService` sirviendo los 7 productos en memoria | **2c** | Datos | ⬜ |
| E2-10 | `th:if` / `th:unless` para el badge de stock y el carrito vacío | **2b** | UI | ⬜ |
| E2-20 | `ContactoController` con `@PostMapping` | 1a | Datos | ⬜ |
| E2-21 | `th:each` para las tarjetas de producto del catálogo | **2c** | UI | ⬜ |
| E2-22 | `th:each` para los colores del configurador de packs | 2c | UI | ⬜ |
| E2-23 | `th:href="@{...}"` en todos los enlaces y `th:src` en imágenes | 1a | UI | ⬜ |
| E2-24 | Verificar que las 10 páginas usan **2+ fragments** sin excepción | **2a** | UI | ⬜ |
| E2-11 | Actualizar 2.1.2 con Thymeleaf | 3 | Doc/QA | ⬜ |
| E2-25 | Capturas nuevas + captura del 404 | 3 | Doc/QA | ⬜ |
| E2-26 | Foto de la estructura del proyecto Spring | 3 | Doc/QA | ⬜ |
| E2-12 | Empaquetar `ATF2_GRUPO_01` y verificar en otra máquina | **4** | Doc/QA | ⬜ |
| E2-27 | **Regresión ATF1** | ATF1-1 | Doc/QA | ⬜ |

## Épica 3 — Spring Data, MySQL y CRUD · ATF3 · Sprints 4-5

### Sprint 4 — persistencia

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E3-01 | `data-jpa` + `mysql-connector-j`; crear la base `overtext_db` | 1 | Datos | ⬜ |
| E3-02 | Entidades `Categoria` y `Producto` con su relación | **1** | Datos | ⬜ |
| E3-03 | Repositorios extendiendo `JpaRepository` | **1** | Datos | ⬜ |
| E3-04 | Servicios con interfaz e implementación (`ServiceImpl`) | **1** | Datos | ⬜ |
| E3-05 | `CargaInicial` que siembra categorías y los 7 productos | 2a | Datos | ⬜ |
| E3-06 | Catálogo y ficha leyendo desde MySQL | **2a, 2d** | UI | ⬜ |
| E3-13 | `[SÍLABO]` `ProductoRestController` con `@RestController` *(sesión 19-20)* | — | Datos | ⬜ |
| E3-14 | Badge de stock calculado desde `producto.stock`, no almacenado | 2d | UI | ⬜ |
| E3-15 | Maquetar `/admin/productos` (solo lectura) | 2b | UI | ⬜ |
| E3-16 | Maquetar el panel `/admin` con los KPI | — | UI | ⬜ |
| E3-17 | Actualizar 2.3 con el esquema MySQL real | 4 | Doc/QA | ⬜ |
| E3-18 | Ampliar 2.2 Requisitos con RQF-0010 y RQF-0011 | 4 | Doc/QA | ⬜ |
| E3-19 | `README` con los pasos para crear la base y arrancar | — | Doc/QA | ⬜ |
| E3-20 | **Regresión ATF1 + ATF2** | — | Doc/QA | ⬜ |

### Sprint 5 — CRUD y validación

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E3-07 | `/admin/productos`: listado con `th:each` y botones de editar y borrar | **2a, 2b** | UI | ⬜ |
| E3-08 | Alta y edición con `th:object` / `th:field` y POST-Redirect-GET | **3a, 3b** | Datos | ⬜ |
| E3-09 | Baja con confirmación desde la fila del listado | **3c** | Datos | ⬜ |
| E3-10 | Bean Validation en **todos** los campos de ambas entidades | **3d** | Datos | ⬜ |
| E3-21 | `@Valid` + `BindingResult`; el formulario se reabre con los errores | **3d** | Datos | ⬜ |
| E3-22 | Restricciones en la BD: `UNIQUE`, `NOT NULL`, FK | 3d | Datos | ⬜ |
| E3-23 | Impedir borrar una categoría con productos asociados | 3c | Datos | ⬜ |
| E3-24 | El formulario de edición carga **todos** los datos del registro | **2c** | UI | ⬜ |
| E3-25 | Errores con `th:errors` y `is-invalid` de Bootstrap | **3d** | UI | ⬜ |
| E3-11 | Mantenimiento completo de categorías | 1, 2, 3 | UI | ⬜ |
| E3-26 | `<select>` de categoría poblado con `th:each` | 2c | UI | ⬜ |
| E3-27 | Mensajes de éxito y error con `RedirectAttributes` | 2d | UI | ⬜ |
| E3-28 | INTRODUCCIÓN del informe (ya exigida por el ATF3) | **4** | Doc/QA | ⬜ |
| E3-29 | Diagrama físico definitivo con las relaciones | 4 | Doc/QA | ⬜ |
| E3-30 | Capturas del CRUD completo y de los errores de validación | 4 | Doc/QA | ⬜ |
| E3-12 | Empaquetar `ATF3_GRUPO_01` y verificar en otra máquina | **4** | Doc/QA | ⬜ |
| E3-31 | **Regresión ATF1 + ATF2** | — | Doc/QA | ⬜ |

## Épica 4 — Spring Security e integración final · TF · Sprints 6-7

### Sprint 6 — seguridad

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E4-01 | Añadir `spring-boot-starter-security` | 2a | Datos | ⬜ |
| E4-02 | Entidades `Rol` y `Usuario` con FK, repositorio y servicio | **2b** | Datos | ⬜ |
| E4-16 | `BCryptPasswordEncoder` como `@Bean` en `config/` | **2b** | Datos | ⬜ |
| E4-03 | `UsuarioDetailsService` implementando `UserDetailsService` | **2b** | Datos | ⬜ |
| E4-04 | `config/SecurityConfig` con `SecurityFilterChain`: públicas vs. privadas | **2a** | Datos | ⬜ |
| E4-17 | Datos semilla: roles `ADMIN` y `CLIENTE` + usuario con contraseña cifrada | 2b | Datos | ⬜ |
| E4-08 | Eliminar `js/login.js` y todo rastro de credenciales en el cliente | 2b | Datos | ⬜ |
| E4-05 | Conectar el `login.html` existente a `formLogin` | **2c** | UI | ⬜ |
| E4-18 | Mensaje de error de credenciales inválidas | 2c | UI | ⬜ |
| E4-06 | Botón de cerrar sesión conectado a `logout`, con CSRF | **2d** | UI | ⬜ |
| E4-07 | `sec:authorize` en la cabecera: menú de admin solo para ADMIN | 2a | UI | ⬜ |
| E4-19 | Página 403 con el diseño del sitio | 2a | UI | ⬜ |
| E4-20 | Mostrar el nombre de la persona autenticada | 2c | UI | ⬜ |
| E4-21 | Redactar 2.1.2.1 Tecnologías usadas | 5 | Doc/QA | ⬜ |
| E4-22 | Empezar los diagramas UML de 2.1.2.2 | 5 | Doc/QA | ⬜ |
| E4-23 | Actualizar el diagrama físico con `usuario` y `rol` | 5 | Doc/QA | ⬜ |
| E4-24 | Capturas: login, error, 403, panel con sesión | 5 | Doc/QA | ⬜ |
| E4-25 | **Regresión ATF1 + ATF2 + ATF3** (atención al CSRF en los formularios) | — | Doc/QA | ⬜ |

### Sprint 7 — cierre funcional

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E4-09 | Entidades restantes con sus 4 capas: `Pedido`, `DetallePedido`, `MensajeContacto`, `Color`, `VarianteProducto` | **1, 3a** | Datos | ⬜ |
| E4-10 | El proceso de compra persiste el pedido en MySQL | **3b** | Datos | ⬜ |
| E4-11 | El formulario de contacto guarda en `mensaje_contacto` | **3b** | Datos | ⬜ |
| E4-26 | Gestión de usuarios y roles desde el panel | 3b, 3c | Datos | ⬜ |
| E4-27 | `[SÍLABO]` **JWT**: `JwtUtil`, filtro y `/api/auth/login` *(sesión 29-30)* | — | Datos | ⬜ |
| E4-28 | `[SÍLABO]` Proteger `/api/**` con JWT, sin tocar la sesión web | — | Datos | ⬜ |
| E4-29 | Listados en el panel para **cada** tabla de la base | **3a** | UI | ⬜ |
| E4-30 | Detalle de pedido: cabecera + líneas con `th:each` | 3a | UI | ⬜ |
| E4-12 | KPI del panel calculados con consultas reales | 3a | UI | ⬜ |
| E4-31 | Marcar un mensaje de contacto como atendido | 3c | UI | ⬜ |
| E4-32 | Cambiar el estado de un pedido | 3c | UI | ⬜ |
| E4-33 | Repaso de coherencia gráfica en todas las páginas | **4d** | UI | ⬜ |
| E4-34 | Diccionario de datos completo | 5 | Doc/QA | ⬜ |
| E4-35 | Terminar los diagramas UML | 5 | Doc/QA | ⬜ |
| E4-36 | OBSERVACIONES, CONCLUSIONES y RECOMENDACIONES | 5 | Doc/QA | ⬜ |
| E4-37 | BIBLIOGRAFÍA real | 5 | Doc/QA | ⬜ |
| E4-38 | ANEXOS: código fuente, capturas, estructura | 5 | Doc/QA | ⬜ |
| E4-39 | **Regresión completa** de los cuatro hitos | — | Doc/QA | ⬜ |

## Épica 5 — Estabilización y sustentación · TF · Semanas 17-18

| # | Historia | Criterio | Quién | Estado |
|---|---|:-:|---|:-:|
| E5-01 | Auditoría de los 20 criterios con `checklist-entrega.md` | todos | todos | ⬜ |
| E5-02 | Corregir lo que falle en la auditoría (solo correcciones) | todos | duos | ⬜ |
| E5-03 | Cierre y revisión final de las 11 secciones del informe | 5d | Jhade · José | ⬜ |
| E5-04 | Guion de la sustentación con reparto por integrante | 5b | todos | ⬜ |
| E5-05 | Ensayo 1 cronometrado | 5c | todos | ⬜ |
| E5-06 | Ensayo 2 con demo en vivo desde una máquina limpia | 5c | todos | ⬜ |
| E5-07 | Plan B de la demo: capturas o video de respaldo | 5c | Jonathan | ⬜ |
| E5-08 | Acordar la vestimenta formal-casual | **5a** | todos | ⬜ |
| E5-09 | Exportar el informe a `.docx` y a `.pdf` | 5d | Jhade | ⬜ |
| E5-10 | Empaquetar `TF_GRUPO_01` y verificar en otra máquina | 5d | José · Jhade | ⬜ |

---

## Resumen

| Épica | Historias | Sprints | Entrega |
|---|:-:|:-:|---|
| 1 · Front-end con Bootstrap | 26 | 1 | ATF1 |
| 2 · Spring Boot y Thymeleaf | 27 | 2-3 | ATF2 |
| 3 · Spring Data y CRUD | 31 | 4-5 | ATF3 |
| 4 · Security e integración | 36 | 6-7 | TF |
| 5 · Estabilización | 10 | — | TF |
| **Total** | **130** | **7** | **4 entregas** |

De ellas, **7 son `[SÍLABO]`**: temas que se dictan pero que ninguna rúbrica califica (tablas e íconos de Bootstrap, estilos de párrafo, controladores REST y JWT).
