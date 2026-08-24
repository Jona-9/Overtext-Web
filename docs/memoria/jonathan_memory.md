# Memoria de Jonathan

> Escritor único: Jonathan (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

**Rol permanente:** **Scrum Master e integrador de memoria** — facilito ceremonias, desbloqueo y **soy el único que escribe `memory.md`**, solo cuando los 6 cerramos el sprint.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | Datos / Backend | Carlos | Formularios y modelo de datos |
| 2-3 | Documento / QA | Jhade | Regresión y empaquetado |
| 4-5 | UI / Front | Dayro | Catálogo desde MySQL y listados CRUD |
| 6-7 | Datos / Backend | Dayro | Spring Security y JWT |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 2 + SM | ATF1 |
| 2 | 07-sep → 20-sep | 2 + SM | — |
| 3 | 21-sep → 01-oct | 3 + SM | ATF2 |
| 4 | 05-oct → 18-oct | 2 + SM | — |
| 5 | 19-oct → 29-oct | 3 + SM | ATF3 |
| 6 | 02-nov → 15-nov | 3 + SM | — |
| 7 | 16-nov → 29-nov | 3 + SM | — |
| Estab. | 30-nov → 11-dic | Plan B + sustentación | TF |

## Como Scrum Master, en todos los sprints

- [ ] Facilitar Planning, Review y Retrospectiva
- [ ] Verificar la **puerta de consolidación**: los 6 marcados antes de tocar `memory.md`
- [ ] Consolidar `memory.md` en un único commit `chore(memoria): consolidación sprint N`
- [ ] Actualizar la tabla de cobertura de rúbrica en `memory.md`

> **Si falta aunque sea una persona, `memory.md` no se toca.** La ceremonia se corre; si el sprint ya venció, se cancela y se consolida junto con el siguiente. Nunca a medias.

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo Datos con Carlos.** Sesiones 3-8.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-07 | Formularios de contacto, inicio de sesión y compra a `form-control` / `form-select` / `form-check` + validación `was-validated` | 1c | 5-6 |
| E1-22 | **Diagrama físico de la base de datos** desde `data-model.md` | **3** | — |

**E1-22 depende del checkpoint de Joaquín:** las tres `[NECESITA ACLARACIÓN]` (colores válidos, umbral de envío gratis, cálculo del badge) condicionan el modelo. Hasta que las resuelva, queda a la espera.

El diagrama lo exigen **las cuatro rúbricas**, no solo esta. Se dibuja una vez y se actualiza.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo Documento/QA con Jhade.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E2-17 | Verificar que las 10 páginas siguen sin errores en consola tras la migración | ATF1-2d |
| E2-18 | **Regresión ATF1**: los 6 componentes de Bootstrap siguen funcionando tras mover los recursos | ATF1-1 |

> El riesgo real de este sprint es que al mover CSS, JS e imágenes a `static/` se rompan las rutas absolutas (`/css/...`) y el sitio se vea destruido sin que nadie lo note hasta la review.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo Documento/QA con Jhade.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E2-26 | **Foto de la estructura del proyecto Spring** — la rúbrica la pide dentro del informe | 3 |
| E2-27 | Regresión ATF1 completa | ATF1-1 |
| E2-12 | Empaquetar `ATF2_GRUPO_01.pdf` y `.rar`, y **verificarlo en otra máquina** | **4** |

**El criterio 4 vale 4 puntos completos** y se pierde por un nombre mal escrito o un `.rar` dañado. No lo dejo para el último día:

- [ ] Nombre exacto: `ATF2_GRUPO_01` — grupo en **dos dígitos**
- [ ] Sin contraseña
- [ ] **Sin `target/`**
- [ ] Descomprimido y abierto en otra máquina

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo UI con Dayro.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-06 | Catálogo y ficha leyendo desde MySQL — **el `th:each` del Sprint 3 no cambia** | **2a, 2d** | 19-20 |
| E3-14 | Badge de stock **calculado** desde `producto.stock`, no almacenado (art. 7) | 2d | 19-20 |

> Si el Sprint 3 dejó bien el `@Service`, E3-06 es solo sustituir la fuente de datos: ni el controlador ni la plantilla se tocan. Ese fue el motivo de diseñarlo así.

### Como SM

Los días 1-3 son para que **las 6 máquinas** conecten a MySQL. Es el mayor riesgo del sprint: una configuración distinta bloquea a esa persona dos semanas.

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo UI con Dayro.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-07 | `/admin/productos`: listado en tabla con `th:each`, con botones de editar y borrar | **2a, 2b** | 21-22 |
| E3-24 | El formulario de edición **carga todos los datos** del registro seleccionado | **2c** | 21-22 |
| E3-27 | Mensajes de éxito y error con `RedirectAttributes` y alertas de Bootstrap | 2d | 23 |

**E3-24 es el fallo más común de esta rúbrica:** se abre el formulario de edición y algún campo llega vacío. Lo verifico campo por campo, incluida la categoría en el `<select>`.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo Datos con Dayro.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-01 | Añadir `spring-boot-starter-security` | 2a | 25-26 |
| E4-04 | `config/SecurityConfig` con `SecurityFilterChain`: públicas vs. privadas | **2a** | 27-28 |
| E4-08 | **Eliminar `js/login.js`** y todo rastro de credenciales en el cliente | 2b | 27-28 |

Separación de rutas que exige el criterio 2a:

```java
.requestMatchers("/", "/catalogo", "/producto/**", "/promociones",
                 "/nosotros", "/contacto", "/css/**", "/js/**", "/img/**").permitAll()
.requestMatchers("/admin/**").hasRole("ADMIN")
.requestMatchers("/mi-cuenta/**").hasRole("CLIENTE")
.anyRequest().authenticated()
```

**Cuidado con dos cosas:**
- Si no pongo `permitAll()` explícito a `/css/**`, `/js/**` e `/img/**`, el sitio se ve completamente roto.
- Activar Security enciende CSRF y **rompe todos los formularios** que no usen `th:action`. José revisa cada uno en E4-25.

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo Datos con Dayro.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-27 | `[SÍLABO]` **JWT**: `JwtUtil` en `util/`, filtro de autenticación y endpoint `/api/auth/login` que emite el token | — | 29-30 |
| E4-28 | `[SÍLABO]` Proteger `/api/**` con JWT, dejando la web con sesión de formulario | — | 29-30 |
| E4-09 | Entidades restantes con sus 4 capas: `Pedido`, `DetallePedido`, `MensajeContacto`, `Color`, `VarianteProducto` | **1, 3a** | 31-32 |

**JWT no lo pide ninguna rúbrica**, pero sí el sílabo (sesiones 29-30) y el objetivo del equipo. Lo hago los días 1-4, y es lo primero que se recorta si algo se retrasa.

Cadenas de filtros **separadas**: `/api/**` con JWT, el resto con formulario. Mezclarlas rompe el inicio de sesión web.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-07 **Plan B de la demo**: capturas o video de respaldo por si falla la conexión, el proyector o MySQL
- [ ] **08-dic:** verificar el `.rar` en otra máquina — descomprimir, compilar y levantar desde cero
- [ ] Consolidación final de `memory.md` y cierre del ciclo

### Mi bloque en la sustentación — 3 minutos

**Arquitectura y tecnologías.** Después de Joaquín:

> Arquitectura por capas: entidad, repositorio, servicio, controlador. Spring Boot 3 con Spring Web y Thymeleaf en el front, Spring Data JPA con Hibernate sobre MySQL, Spring Security para el control de acceso y Bootstrap 5 en la interfaz.

Muestro la estructura de paquetes *(criterio 1)* y paso a José y Carlos con el modelo de datos.

---

## Checklist de la puerta de consolidación

Marco a cada quien cuando cierre **todas** sus tareas según la DoD.

**Sprint 1:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Bitácora — Sprint 1

### 2026-08-20
- Hice: creé el repositorio `overtext-web` con el andamiaje de documentación, memorias y la planificación de los 7 sprints.
- Decidí / aprendí: el `.git` enraizado en `/Users/jonatl9` solo contenía un commit sin publicar (`158b471`) con **un único archivo**, `Desktop/feature:promotions/.DS_Store`, que además marcaba como borrados los 62 archivos reales. No había nada de valor: el historial verdadero está en `origin` y los archivos están intactos en disco.
- Bloqueo: falta mover ese `.git` a un respaldo. Pendiente a mano: `mv ~/.git ~/.git-ROTO-backup-20260820`.
- Archivos tocados: `.gitignore`, `CLAUDE.md`, `memory.md`, `README.md`, `docs/constitution.md`, `docs/memoria/*`, `docs/scrum/*`, `docs/specs/001-sitio-bootstrap/*`, `informes/informe.md`.

### 2026-08-24
- Hice: **E1-07** — migré los tres formularios (contacto, inicio de sesión y proceso de compra) a `form-control` / `form-select` / `form-check` con validación `was-validated`. Script propio `js/validacion-formularios.js` para los formularios marcados con `.needs-validation`, y re-tematización de los controles de Bootstrap en `formularios.css` usando solo variables de `main.css`.
- Hice: **E1-22** — el diagrama físico y el diccionario de datos ya estaban completos en `data-model.md`; añadí la sección 6 con los tres supuestos de trabajo declarados, para que el diagrama se pueda usar en el informe mientras Joaquín ratifica el checkpoint.
- Hice: **4 correcciones de integración sobre el trabajo de Dayro** (avisado; no toqué su memoria):
  1. `index.html` enlazaba `carrucel.css` en vez de `carrusel.css` → 404 en consola y el CSS del carrusel de portada no se aplicaba.
  2. `index.html` tenía un `<button>` sin cerrar en el primer indicador del carrusel.
  3. IDs `carruselPortada` y `carruselProducto` en camelCase → renombrados a `carrusel-portada` y `carrusel-producto` en HTML, CSS y JS (criterio 2c).
  4. `nosotros.html:137` tenía `<div">` en lugar de `<div class="container">`, del commit `0bdcab4`. Apareció al verificar el balance de etiquetas, no a simple vista.
- Decidí / aprendí:
  - El proceso de compra **no** lleva `was-validated` global: es un formulario de 3 pasos con campos ocultos condicionales, y Bootstrap marcaría en rojo campos invisibles. Se enganchó `is-invalid` a la validación por pasos que ya existía en `checkout.js` (art. 8: no se profundiza el checkout).
  - Quité el `console.error` de `js/login.js` en el intento fallido: el aviso ya está en la interfaz y la consola debe quedar limpia (art. 3, criterio 2d).
  - Las tareas que tocan zona compartida (encabezado, pie, hoja base) necesitan turno; las locales van en paralelo. **E1-02 (navbar, Joaquín), E1-10 (carrito a offcanvas, Carlos) y E1-11 (íconos, Carlos) tocan las tres la misma zona de las 10 páginas.** Hay que secuenciarlas o se pisan.
- Bloqueo: E1-22 no se puede cerrar hasta el checkpoint del PO. `tema-overtext.css` (E1-01) sigue sin existir y `bootstrap.bundle.min.js` solo está en `index.html` y `detalle-producto.html`: faltando en las otras 8, los modales de E1-08/E1-09 y el offcanvas de E1-10 no van a funcionar.
- Archivos tocados: `app-estatico/contacto.html`, `login.html`, `checkout.html`, `index.html`, `nosotros.html`, `detalle-producto.html`, `js/validacion-formularios.js` (nuevo), `js/login.js`, `js/checkout.js`, `js/tienda.js`, `css/componentes/formularios.css`, `css/componentes/carrusel.css`, `docs/specs/001-sitio-bootstrap/data-model.md`.
- Verificado: las 10 páginas servidas por HTTP responden 200 y **ningún recurso referenciado devuelve 404**; las 10 páginas tienen las etiquetas balanceadas; los 9 archivos JS pasan `node --check`.

---

## Para consolidar en memory.md

- [ ] (ya volcado en la versión inicial: decisiones 1-11, deudas D1-D6, trampas T1-T3)
- [ ] **Nueva trampa T4:** tres historias del Sprint 1 tocan la misma zona (encabezado de las 10 páginas): E1-02, E1-10 y E1-11, de dos personas distintas. Necesitan turno, no paralelo.
- [ ] **Decisión 12:** las historias que tocan zona compartida se secuencian; las locales van en paralelo. El orden se escribe en el archivo del sprint, no se acuerda de palabra.
- [ ] **Deuda D7:** `bootstrap.bundle.min.js` solo está en 2 de las 10 páginas. Bloquea modales y offcanvas.
- [ ] **Deuda D8:** E1-06 quedó incompleta: el grid del catálogo sigue siendo CSS propio y el pie solo se migró en `catalogo.html`.
- [ ] El proceso de compra usa `is-invalid` sobre su validación por pasos, no `was-validated` global. Quien lo toque después, que no lo "corrija".

---

## Contexto propio

- Servir el sitio estático: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Antes de cualquier `git add`: `git rev-parse --show-toplevel` debe devolver `.../overtext-web`.
- Repo anterior en GitHub: `git@github.com:Jona-9/E-commerce-OverText.git` (referencia histórica, no es el del curso).

---

## Sprints cerrados

*(vacío)*
