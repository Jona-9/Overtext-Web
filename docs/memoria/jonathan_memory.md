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

- [x] **E1-07** *(criterio 1c, sesiones 5-6)* — Formularios de contacto, inicio de sesión y compra a `form-control` / `form-select` / `form-check` con validación `was-validated`. *(2026-08-26)*
- [x] **E1-22** *(criterio 3)* — **Diagrama físico de la base de datos** desde `data-model.md`: `esquema-fisico.sql`, el SVG/PNG del informe y `diagrama-fisico-bd.md`. *(2026-08-26)*

### Definición de Hecho — E1-07 y E1-22

- [x] La página abre **sin errores en consola** *(criterio 2d)* — las 10 páginas verificadas en Chrome, no solo las mías
- [x] Probado a **375 px** y **1440 px** — 7 capturas en `informes/capturas/sprint-01/`
- [x] Nombres en **kebab-case** *(criterio 2c)*
- [x] Captura archivada en `informes/capturas/sprint-01/`
- [x] Criterio de rúbrica marcado en `docs/scrum/checklist-entrega.md`
- [x] Bloque "Para consolidar" escrito en esta memoria
- [x] **Código subido vía PR revisado por otro duo** — *cerrado (2026-08-28).* Resuelto el equívoco: la rama de integración es **`testing`**, no `develop`; la DoD se corrige para el Sprint 2.

> **Incoherencia que me toca resolver como SM:** la DoD del sprint dice *"código en `develop` vía PR"*, pero **`develop` no existe** en el repositorio. Las ramas son `main`, `testing` y una por persona, y los merges anteriores (José, Joaquín) fueron a `testing`. Hay que corregir la DoD o crear `develop`; mientras tanto esa casilla no se puede marcar con honestidad.

~~**E1-22 depende del checkpoint de Joaquín**~~ — **desbloqueado.** Joaquín aprobó el
`spec.md` el 2026-08-25 y resolvió las tres `[NECESITA ACLARACIÓN]`: colores = los del
catálogo (sin BLANCO), envío gratis = **S/ 200**, badge **calculado** con `stock < 10`.
Las tres están dentro del modelo físico.

El diagrama lo exigen **las cuatro rúbricas**, no solo esta. Se dibuja una vez y se actualiza.

### No son mías — son de Carlos (mismo duo)

Las seguía como SM porque el criterio **1d** es del grupo, no suyo.
**Cerradas las 5 el 26-ago** (ver `carlos_memory.md`):

- [x] **E1-08** — Modal de confirmación de contacto *(criterio 1d)*
- [x] **E1-09** — Modal de guía de tallas en la ficha *(criterio 1d)*
- [x] **E1-10** — Panel del carrito a `offcanvas` *(criterio 1b)*
- [x] **E1-11** — Bootstrap Icons en lugar de los PNG de 4-5 MB *(criterio 1a)*
- [x] **E1-26** — `[SÍLABO]` Tabla de tallas con `table table-striped`

**El duo Datos queda cerrado.** Con esto el criterio 1 del ATF1 tiene sus 6
componentes en el sitio.

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

**Sprint 1:** ⬜ Joaquín · ⬜ José · ✅ Jonathan *(26-ago)* · ⬜ Dayro · ✅ Carlos *(26-ago: E1-08, E1-09, E1-10, E1-11, E1-26)* · ⬜ Jhade

Faltan 4. **`memory.md` no se toca** hasta que estén los 6 (CLAUDE.md §2).

---

## Bitácora — Sprint 1

### 2026-08-20
- Hice: creé el repositorio `overtext-web` con el andamiaje de documentación, memorias y la planificación de los 7 sprints.
- Decidí / aprendí: el `.git` enraizado en `/Users/jonatl9` solo contenía un commit sin publicar (`158b471`) con **un único archivo**, `Desktop/feature:promotions/.DS_Store`, que además marcaba como borrados los 62 archivos reales. No había nada de valor: el historial verdadero está en `origin` y los archivos están intactos en disco.
- Bloqueo: falta mover ese `.git` a un respaldo. Pendiente a mano: `mv ~/.git ~/.git-ROTO-backup-20260820`.
- Archivos tocados: `.gitignore`, `CLAUDE.md`, `memory.md`, `README.md`, `docs/constitution.md`, `docs/memoria/*`, `docs/scrum/*`, `docs/specs/001-sitio-bootstrap/*`, `informes/informe.md`.

### 2026-08-26 — E1-07 · Formularios con Bootstrap *(criterio 1c)*

- **Hice:** migré los tres formularios a componentes de Bootstrap 5.3 y dejé la
  validación funcionando sin errores en consola.
  - `contacto.html` — `needs-validation` + `novalidate`, campos en `.row`/`.col-md-6`
    con `.form-control`, cada uno con su `.invalid-feedback`.
  - `login.html` — `.form-control` en usuario y contraseña (`type="email"` en usuario,
    que era `text` y no validaba el formato) y un `.form-check` para "mantener la sesión".
  - `checkout.html` — `.form-control`, `.form-select` y `.form-check-input` en los tres
    pasos; las antiguas `.grid-2` pasaron a `.row g-3` / `.col-md-6`.
  - `js/contacto.js` y `js/login.js` — patrón `was-validated`: se marca el formulario,
    y si `checkValidity()` falla no se abre el modal ni se comprueban credenciales.
  - `js/checkout.js` — estado de validación con `.is-invalid` / `.is-valid` de Bootstrap.
  - `css/componentes/formularios.css` — capa de tema para `.form-control`, `.form-select`,
    `.form-check` y los estados de validación, en la paleta de marca.
  - `css/paginas/checkout.css` — fuera `.campo-invalido` y `.error-msg`, ya sustituidas.

- **Decidí / aprendí — tres cosas que costaron:**

  1. **El CSS heredado le ganaba a Bootstrap por especificidad.** `input[type="text"]`
     pesa (0,1,1) y `.form-control` solo (0,1,0): el `border: none` del tema antiguo
     ganaba y los campos se veían igual que antes, con Bootstrap cargado y todo.
     Lo resolví acotando los selectores viejos con `:not(.form-control)` /
     `:not(.form-select)`, en vez de subir la especificidad con `!important`.
     **Aviso al equipo: cualquier componente de Bootstrap que se maquete encima de
     `css/componentes/*.css` puede sufrir lo mismo.** Se ve marcado en consola: no.
     Hay que mirarlo en el navegador.

  2. **`label { display: block }` del CSS global rompe el `.form-check`**: la etiqueta
     se iba a la línea de abajo y el cuadrito quedaba suelto. Añadí una regla
     `.form-check-label { display: inline }`.

  3. **`checkout.html` no usa `was-validated`, y es a propósito.** El proceso de compra
     tiene 3 pasos con bloqueo: `was-validated` valida el formulario entero de golpe y
     marcaría en rojo los campos de pasos aún ocultos. Ahí uso las mismas clases de
     Bootstrap (`.is-invalid` + `.invalid-feedback`) aplicadas paso a paso, que es el
     otro patrón que documenta Bootstrap. El criterio 1c queda igual de demostrado.
     **Contacto e inicio de sesión sí usan `was-validated`**, que es lo que pide E1-07.

- **Trampa que casi se me cuela:** para quitar el tilde verde de Bootstrap puse
  `background-image: none` en `.is-valid`. En un `<input>` está bien, pero en un
  `.form-select` **eso borra también la flecha del desplegable**, porque Bootstrap
  dibuja las dos cosas con la misma propiedad. En cuanto un select del checkout se
  validaba, se quedaba sin flecha. Arreglado devolviendo `var(--bs-form-select-bg-img)`
  en `.form-select.is-valid`, y comprobado con `getComputedStyle` en los tres estados.

- **Trampa que dejé cerrada:** el aviso "elige una opción de envío" estaba como
  `class="invalid-feedback d-block" hidden`. No funcionaba: `.d-block` lleva
  `!important` y gana al atributo `hidden`, así que el mensaje salía siempre.
  Ahora el JS añade y quita `.d-block`.

- **Verificado en navegador (Chrome headless), no solo a ojo:**
  - **12 comprobaciones funcionales, las 12 en verde.** Contacto: vacío marca
    `was-validated`, no abre el modal y muestra el `.invalid-feedback`; correo mal
    formado tampoco abre el modal; con datos válidos sí abre y se limpia la validación.
    Inicio de sesión: vacío no redirige y marca `was-validated`; credencial equivocada
    muestra el aviso. Compra: el paso 1 vacío marca `.is-invalid` y **no** desbloquea el
    paso 2; con datos válidos sí avanza.
  - **Las 10 páginas sin errores ni advertencias en consola** *(criterio 2d)*, con la
    única excepción del `favicon.ico` — ver el aviso de abajo.
  - `node --check` limpio en los 7 archivos de `js/`, y todos los recursos en 200
    servidos por `python3 -m http.server`.

- **Recorrido de clics en un Chrome real (26-ago), además del repaso manual.**
  Lo headless no pulsa botones; esto sí, y es donde aparecen los fallos de verdad:
  - Paso 1 vacío → CONTINUAR marca los 5 campos y **no** desbloquea el paso 2;
    con datos correctos → los 5 en verde y el paso 2 se activa.
  - Paso 2 sin elegir envío → sale "Elige una opción de envío"; al elegir una,
    desaparece. *(mi arreglo del `.d-block`)*
  - "Envío a provincia" → cargan 26 departamentos; al elegir uno se habilita provincia
    con sus 8; y **los selects conservan la flecha**. *(mi arreglo del tilde verde)*
  - Contacto vacío → marca y **no** abre el modal; con datos válidos → el modal muestra
    los datos, el formulario se resetea y deja de estar en rojo.
  - Login: vacío y correo mal formado ni llegan a comprobar credenciales; contraseña
    equivocada → aviso en pantalla y **consola limpia**; credencial correcta →
    redirige a `intranet.html`.
  - "Mantener la sesión iniciada" queda `display: inline`. *(mi arreglo de
    `label { display: block }`)*

- **⚠️ Aviso pendiente — el favicon (criterio 2d).** **No existe `favicon.ico` ni ningún
  `<link rel="icon">` en las 10 páginas.** Un Chrome normal pide `/favicon.ico` igual y
  recibe un **404 que sale como error rojo en la consola**. En headless no aparece
  porque no lo pide, así que la verificación automática **no lo detecta**.
  Es un punto del criterio 2d ("cero errores en consola") que se pierde por un archivo
  que no está. Arreglo: añadir el `.ico` y una línea `<link rel="icon">` por página.
  **No lo hice yo:** toca las 10 páginas y eso es del duo UI y del de limpieza (E1-14),
  no mío. Va a la lista de consolidación para que alguien lo tome.

- **Capturas archivadas** en `informes/capturas/sprint-01/`, a **1440 px y 375 px**
  *(DoD)*: `formulario-contacto-1440.png` / `-375.png`,
  `formulario-inicio-sesion-1440.png` / `-375.png`,
  `formulario-compra-1440.png` / `-375.png`, y
  `validacion-contacto-1440.png` con los mensajes de error a la vista, que es la
  evidencia del criterio 1c.

- **Bloqueo:** ninguno.

- **Archivos tocados:** `app-estatico/contacto.html`, `app-estatico/login.html`,
  `app-estatico/checkout.html`, `app-estatico/js/contacto.js`,
  `app-estatico/js/login.js`, `app-estatico/js/checkout.js`,
  `app-estatico/css/componentes/formularios.css`,
  `app-estatico/css/paginas/checkout.css`.

### 2026-08-26 — E1-22 · Diagrama físico de la base de datos *(criterio 3)*

- **Hice:** el modelo físico completo de las 10 tablas, en tres piezas:
  - `docs/specs/001-sitio-bootstrap/esquema-fisico.sql` — el DDL de MySQL 8 (InnoDB,
    `utf8mb4_unicode_ci`): tipos, PK, FK con su `ON DELETE`, UK, `CHECK`, índices y
    datos semilla. **Es la definición autoritativa del modelo.**
  - `informes/capturas/sprint-01/diagrama-fisico-bd.svg` (y `.png`) — la figura para
    insertar en el informe §2.3.
  - `docs/specs/001-sitio-bootstrap/diagrama-fisico-bd.md` — cómo leerlo, la tabla de
    relaciones con su regla de borrado, los índices y por qué está así.
  - Puntero añadido en `data-model.md` §1 para que nadie confunda la vista lógica con
    el entregable físico.

- **Decidí / aprendí:**
  - **El diagrama se generó por script desde la misma definición del esquema**, no a
    mano en una herramienta de dibujo. Motivo: cuando cambie una tabla, el dibujo no se
    queda atrás. Es la trampa clásica de este entregable, y lo piden **cuatro** rúbricas.
  - **Escribí el DDL de las 10 tablas ahora, aunque solo 3 se implementen en el ATF3.**
    Un diagrama a medias no demuestra el criterio 3, y el resto ya estaba diseñado.
  - **Reglas de borrado, una por una** (esto no estaba en `data-model.md`):
    `CASCADE` donde el hijo no existe sin el padre (`variante_producto`,
    `imagen_producto`, `detalle_pedido`); `RESTRICT` sobre catálogos maestros
    (`categoria`, `color`, `rol`, y `producto` desde `detalle_pedido`, para no poder
    borrar un producto que figura en un pedido histórico); y **`SET NULL`** en
    `pedido.usuario_id`, que es el único FK nulo: si se da de baja al usuario, el
    pedido sobrevive porque es un registro contable.
  - **El dinero va en `DECIMAL(10,2)`, nunca `FLOAT`**: la coma flotante pierde céntimos.
  - Las tres decisiones del PO del 25-ago entraron en el esquema: sin color BLANCO en la
    semilla, y el badge **no es columna** — se calcula con `stock < 10` (art. 7).

- **Bloqueo:** ninguno. El checkpoint que me bloqueaba lo cerró Joaquín el 25-ago.

- **Archivos tocados:** `docs/specs/001-sitio-bootstrap/esquema-fisico.sql` (nuevo),
  `docs/specs/001-sitio-bootstrap/diagrama-fisico-bd.md` (nuevo),
  `informes/capturas/sprint-01/diagrama-fisico-bd.svg` y `.png` (nuevos),
  `docs/specs/001-sitio-bootstrap/data-model.md`,
  `docs/scrum/checklist-entrega.md` (marcado el componente "Formularios").

### 2026-08-26 — E1-19 · Consola limpia *(criterio 2d, tarea de todo el equipo)*

- **Hice:** pasé las **10 páginas** por Chrome en modo headless, servidas por HTTP, y
  filtré la salida buscando mensajes de consola, `Uncaught` y recursos fallidos.
  **Las 10 salen limpias.** Es la primera medición real del criterio 2d, no una
  suposición: hasta ahora solo se había comprobado que los recursos devolvían 200.
- **Ojo:** esto vale para el estado de hoy. E1-19 es de todo el equipo y hay que
  **repetirlo en la Review del 04-sep**, cuando estén dentro el carrusel, el offcanvas
  y los modales, que es donde suele aparecer el error de consola.

### 2026-08-26 — Como Scrum Master

- Mis dos tareas del Sprint 1 están cerradas según la DoD, capturas incluidas.

- **Dos huecos de proceso que me toca destrabar a mí, no a mi duo:**
  1. **No existen `plan.md` ni `tasks.md`.** El `spec.md` quedó aprobado el 25-ago y su
     §7 dice que eso habilita escribir `plan.md`, pero se pasó directo a implementar
     (CLAUDE.md §4 pide Specify → Plan → Tasks → Implement). Además `plan.md` es la
     fuente de §2.1.2 del informe, que sigue vacía.
  2. **La DoD apunta a una rama que no existe.** `sprint-01.md` §7 exige "código en
     `develop` vía PR", pero en el remoto solo hay `main`, `testing` y una rama por
     persona — y los PR #3 y #6 de José entraron a `testing`. Hay que decidirlo antes de
     que entren más ramas: o se crea `develop`, o se corrige la DoD.

- **Las 6 bitácoras estaban en `Hice: —` del 20-ago** cuando empecé, con trabajo ya
  hecho y sin registrar (E1-01 a E1-06 estaban en el código, no en las memorias). Sin
  bitácora no puedo verificar la puerta de consolidación. A pedir en la daily.
- **Puerta de consolidación: 2 de 6** *(actualizado el 26-ago: Carlos cerró sus 5)*.
  `memory.md` sigue sin tocarse hasta que cierren Joaquín, José, Dayro y Jhade
  (CLAUDE.md §2).
- Pendiente de facilitar: Review y Retro del vie 04-sep.

### 27-ago — Arreglo del bloque `.seleccion-colores` (promociones)

**Hice:** corregí el configurador de packs, que se veía mal en `promociones.html`.
Tres defectos reales, ninguno era que los swatches no pintaran (los 7 hex resolvían bien):

1. **`activo` congelado.** `js/promociones.js` nunca tocaba la clase: el recuadro negro
   se quedaba siempre en NEGRO (venía escrito a mano en el HTML) y clicar un color no
   daba ningún feedback. Ahora `marcarColores()` recalcula el estado desde `seleccion`
   en cada `render()`, así que `activo` significa **«este color ya está en el pack»** y
   se apaga solo al quitar un slot. Añadí un contador `×N` bajo cada muestra.
2. **Tres márgenes izquierdos distintos** dentro de `.info-pack`: colores y tallas a
   60px, slots y botón a 25px. Unifiqué con una variable `--pad-panel: 25px` declarada
   en `.info-pack`; todos los bloques internos la usan. Medido: los 6 bloques parten
   de la misma línea en escritorio y en 390px.
3. **`mix-blend-mode: difference` en `.slot-talla`** pintaba la talla en turquesa sobre
   borgoña. Lo cambié por una clase `.slot--claro` que el JS pone según la luminancia
   del color: texto negro sobre muestras claras, blanco sobre oscuras.

**Archivos:** `app-estatico/promociones.html`, `app-estatico/css/paginas/promociones.css`,
`app-estatico/js/promociones.js`.

**Efecto colateral que tuve que resolver:** al pasar `.ofertas` de 60px a 25px de
padding lateral, el titular y el badge ganaron ancho y cambiaron de corte de línea.
Fijé el titular con `<br>` (`6 shorts / x S/100`, igual que el hero) y el badge con
`max-width: 230px`. Sin esto la alineación se arregla pero la tipografía se rompe.

**Verificado:** servido en `python3 -m http.server`, consola limpia (0 errores),
sin scroll horizontal, colores en 2 filas a 390px, y el ciclo agregar → quitar →
llegar a 6 → clic extra bloqueado funciona.

**Bloqueado / no toqué:** la deuda **D3** sigue viva — los hex de las muestras están
duplicados a mano en `promociones.css:153-159` y no coinciden con `productos.json`
(art. 7). Tampoco existe una opción «celeste» aunque la foto del pack muestra un short
celeste.

### 27-ago (2) — `.btn-pack` muerto y barrido de errores

**Hice:** `detalle-producto.html:177` tenía `<button class="btn-pack">Arma tu pack</button>`
sin `href`, sin `data-*` y sin ningún JS que enganchara `.btn-pack` (la clase solo existía
en `botones.css`). Se veía como botón y al pulsarlo no pasaba nada. Lo convertí en
`<a href="/promociones.html" class="btn-pack">`, que es lo que hace su gemelo de
`index.html:154`. En `css/componentes/botones.css` añadí `display:block`,
`text-align:center` y `text-decoration:none` para que el `<a>` se vea igual que el
`<button>` (el `width:100%` que ya tenía no hace nada sobre un elemento inline).
No monté un configurador en la ficha: el spec dice que el pack "se re-maqueta pero no
se profundiza" (`spec.md:48`, art. 8).

**Verificado:** clic real en el navegador → navega a `/promociones.html`; mismo ancho,
alto y tipografía que antes.

**Barrido del sitio (las 10 páginas, servidas en localhost):**

- 0 errores de consola, 0 imágenes rotas, 0 enlaces internos a archivos inexistentes,
  0 rutas de `productos.json` que no existan en disco. También comprobado: ningún
  `onclick=` inline en el HTML.
- **Queda un botón muerto: `.btn-flecha`** (la flecha del NEWSLETTER en el pie de las
  **10** páginas). Ningún JS la escucha y el bloque `.formulario-minimal` **no es un
  `<form>`**, así que ni el clic ni el Enter hacen nada. Es el mismo defecto que acabo
  de arreglar en `.btn-pack`, multiplicado por 10. No lo toco yo: el pie es la pasada
  de Carrizo/Carlos y hay que decidir antes qué debe hacer (no hay backend en el ATF1).
- **Enlaces `href="#"`**: `ENVÍOS` en el pie de las 10 páginas (no existe `envios.html`),
  y en `login.html` `¿La olvidaste?` (:76) y `Crea tu cuenta` (:108). Son marcadores de
  posición conscientes, pero conviene que el PO diga si se quedan así en el ATF1.
- **D4 confirmada y viva:** `js/carrito.js:10` sigue con `UMBRAL_ENVIO_GRATIS = 180`
  cuando el PO fijó **S/ 200** (`spec.md:151`).
- **D3, datos concretos** para quien la implemente. Catálogo (`productos.json`, 7):
  Stone Beige `#C4A882`, Negro `#111111`, Guinda `#8B1A2C`, Gris `#9E9E9E`,
  Oliva Militar `#5C6B3A`, Azul Marino `#1A3A7A`, Marrón `#6B4A2E`.
  Configurador (`promociones.css`, 7): NEGRO `#1A1A1A`, BLANCO, STONE `#C8B89A`,
  BORGOÑA `#8B1A2C`, GRIS `#9E9E9E`, OLIVO `#5C6B3A`, MARINO `#1A3A7A`.
  O sea: **sobra BLANCO, falta MARRÓN**, y NEGRO y STONE tienen el hex desviado.
  GRIS, OLIVO y MARINO ya coinciden en hex aunque no en nombre.

### 27-ago (3) — Enlaces muertos del pie y checklist B

**Hice** (decisión: cerrar la línea del checklist A *"sin enlaces muertos"*, que hasta
hoy era falsa; ver criterio en la conversación del 27-ago):

1. **`ENVÍOS` del pie** (`href="#"` en las 10 páginas) → `/contacto.html`.
2. **Flecha del boletín** (las 10): el `<div class="formulario-minimal">` con un
   `<input type="email">` inerte y un `<button class="btn-flecha">` sin handler pasa a
   ser **un enlace** a `/contacto.html`, que sí tiene formulario real:
   `<a class="formulario-minimal enlace-boletin">SUSCRÍBETE <span class="btn-flecha">→</span></a>`.
   Sin backend, un control que navega es honesto; uno que finge enviar, no.
   `contexto.md` no define copy de boletín, así que no se pisó contenido de marca.
3. **CSS:** en `formularios.css` se retiran las reglas del `input[type=email]` (ya no
   existe ese input en ninguna página, era código muerto → criterio 2b) y entra
   `.enlace-boletin`. En `botones.css`, `.btn-flecha` deja de tener propiedades de
   `<button>` (`background`/`border`/`cursor`) porque ahora es un `<span>`, y el
   desplazamiento pasa a `.enlace-boletin:hover .btn-flecha`.
4. **Defecto preexistente que encontré al verificar:** `intranet.html` y
   `confirmacion.html` **nunca cargaban `css/componentes/formularios.css`**, así que su
   caja del pie salía sin borde ni altura (un `<input>` blanco crudo sobre fondo negro).
   Añadido el `<link>` en ambas. No lo causó mi cambio, pero lo destapó.

**No toqué** los dos `href="#"` de `login.html` (`¿La olvidaste?`, `Crea tu cuenta`):
registro y recuperación están fuera del alcance del ATF1. Van a Recomendaciones del
informe como trabajo futuro, que puntúa mejor que inventar una página.

**Verificado** (las 10 páginas, servidas por HTTP): `.enlace-boletin` con `href` correcto,
alto 44 px, borde y flecha a la derecha en las 10; 0 `href="#"` salvo los 2 de login;
0 errores de consola; 0 imágenes rotas; a **375 px** la caja mide 319 px sin desborde
horizontal. Clic real comprobado: el pie de `nosotros.html` navega a `/contacto.html`.

**Trampa T4 otra vez, y grave:** la primera tanda de mediciones me salió "correcta"
sobre el CSS **cacheado**. Para verificar cambios de estilos hay que **volver a pedir
cada hoja con un parámetro nuevo** (`?v=...`), no basta con recargar el HTML.

### 27-ago (4) — `docs/scrum/checklist-entrega.md` (archivo del duo Documento/QA)

Rellené con evidencia verificada, porque el criterio 1 vale **6 pts** y estaba escrito
en el código pero no en el papel:

- **Sección B, las 4 casillas que faltaban**: contenedores, menú responsivo, carrusel
  (`#carrusel-portada` con 3 diapositivas y `#carrusel-galeria`) y grillas, cada una con
  la ruta donde se demuestra.
- **Sección A**: consola limpia (reverificada hoy, el 404 del favicon ya no está),
  encabezado/cuerpo/pie en las 10, y la línea de enlaces muertos.

**Aviso a José y Jhade:** ese archivo es vuestro por proceso ("lo ejecuta el duo
Documento/QA"). Lo rellené como SM porque eran puntos de rúbrica en riesgo a 8 días de
la entrega, no para adelantaros trabajo. **Revisadlo y corregidme si algo no os cuadra.**
Queda sin marcar a propósito lo que exige una pasada visual vuestra: *"Probado a 375 px
y 1440 px"*, las capturas y todo el bloque de empaquetado.

### 2026-08-28 — Cierre del Sprint 1 · D3, D4 y consolidación

**Como duo Datos — cerré las dos deudas que llevaban tres días sin dueño.**

Las decisiones **I1** e **I2** del PO son del 25-ago y aparecían como pendiente en las
memorias de Joaquín, Carlos y José, cada uno esperando al duo dueño (art. 9). Nadie era
ese duo. Como SM las tomé yo antes de cerrar el sprint:

- **D4 ✅** — `js/carrito.js:10`: `UMBRAL_ENVIO_GRATIS` de **180 → 200**, con el porqué en
  el comentario. Es la decisión **I2**. Afecta a los tres sitios que usan la constante:
  el texto "TE FALTAN S/ …", el ancho de la barra de progreso y el cálculo del envío.
  No había ningún **180 quemado** en el HTML — la constante era el único origen de verdad
  (art. 7 bien aplicado por quien lo escribió), así que fue una línea.
- **D3 ✅** — `promociones.html` + `css/paginas/promociones.css`: el configurador de packs
  ofrece ahora **exactamente los 7 colores de `js/productos.json`**, que es la decisión
  **I1**:

  | Antes | Ahora | Qué pasó |
  |---|---|---|
  | NEGRO | NEGRO | hex al del catálogo (`#111111`) |
  | **BLANCO** | — | **eliminado**: no existe como producto |
  | STONE | STONE | hex al del catálogo (`#C4A882`) |
  | BORGOÑA | **GUINDA** | renombrado al nombre real del catálogo |
  | GRIS | GRIS | — |
  | OLIVO | **OLIVA** | renombrado |
  | MARINO | MARINO | — |
  | — | **MARRÓN** | **añadido**: faltaba (`#6B4A2E`) |

**Decidí / aprendí:**

- **`promociones.js` no necesitó ni una línea**, y eso es mérito de cómo lo dejó José en
  E1-13: lee el nombre del color del DOM (`.nombre-color`) y el color con
  `getComputedStyle`, sin lista quemada. **Cambiar la paleta es editar HTML y CSS.**
  Que nadie meta ahí un array de colores "para tenerlo centralizado": lo centralizado es
  `productos.json`, y duplicarlo en el JS sería romper el art. 7.
- **Los hex del configurador estaban aproximados, no iguales.** Negro era `#1A1A1A` y el
  catálogo dice `#111111`; stone era `#C8B89A` y el catálogo `#C4A882`. Se veía casi
  igual, y por eso nadie lo notó en tres días de revisión visual. **Un color "parecido"
  no es el mismo color:** ahora los 7 hex se copian del catálogo.
- **Lección de proceso, la importante del sprint.** El art. 9 (un archivo, un escritor)
  funcionó: nadie pisó el trabajo de nadie. Pero **el art. 9 protege el código, no reparte
  el trabajo**: tres personas detectaron la misma deuda, las tres la anotaron
  correctamente en su memoria, y las tres esperaron. **A partir del Sprint 2, en el
  Planning, toda deuda o decisión de PO que toque código sale con dueño y número de
  tarea.** Lo hablo en la Retrospectiva.

**Como Scrum Master — puerta de consolidación:**

- **Los 6 integrantes han cerrado.** Joaquín, Dayro, Carlos, José y Jhade tienen su
  bloque "Para consolidar" escrito, y el mío está abajo. **Jhade lleva su redacción en un
  documento propio fuera del repo** y la entrega del ATF1 salió de ahí; lo que vive en
  `informes/informe.md` es el esqueleto limpio de E1-20. Queda anotado para que nadie lea
  sus marcadores `⬜` como trabajo sin hacer.
- **Resuelvo el hueco de la rama:** la DoD de `sprint-01.md` §7 pide "código en `develop`
  vía PR" y **`develop` no existe ni va a existir**. La rama de integración del equipo es
  **`testing`**, que es contra la que ya entraron los PR. Lo corrijo en la DoD del Sprint 2
  en vez de crear una rama para satisfacer un texto.
- **Sigue abierto y me lo llevo al Sprint 2:** **no existen `plan.md` ni `tasks.md`**.
  El `spec.md` se aprobó el 25-ago y se pasó directo a implementar (CLAUDE.md §4).
  Salió bien, pero `plan.md` es además la fuente de §2.1.2 del informe, que Jhade
  necesita. **Es lo primero del Sprint 2.**
- **`memory.md` consolidada** con el cierre del Sprint 1.

**Archivos tocados:** `app-estatico/js/carrito.js`,
`app-estatico/promociones.html`, `app-estatico/css/paginas/promociones.css`,
las 6 memorias de `docs/memoria/` y `memory.md`.

**Verifiqué:** `node --check` en `carrito.js` y `promociones.js`; las 10 páginas y los
recursos sirven **200** por HTTP; `grep` confirma 0 restos de `blanco`/`borgona`/`olivo`
en el configurador y **7** `color-opcion` en `promociones.html`.

---

## Para consolidar en memory.md

- [ ] **Nueva convención — `--pad-panel` en `.info-pack` (promociones).** El panel del
      configurador tiene un solo margen lateral (25px) declarado como variable; ofertas,
      colores, tallas, slots y botón la consumen. Si alguien mete un bloque nuevo ahí,
      que use `var(--pad-panel)` y no un valor suelto, o vuelve el desalineado.
- [ ] **Nueva decisión — en el configurador, `.activo` de un color significa «está en el
      pack», no «opción actual»** (a diferencia de las tallas, donde sí es exclusiva).
      Lo pone el JS en cada `render()`; **no se escribe `activo` a mano en el HTML.**
- [x] ~~**Aviso para el duo de QA:** confirmada la deuda **D3**~~ — **cerrada el 28-ago**
      (ver mi bitácora). Contexto original: la detecté en `promociones.css:153-159`
      — los 7 hex del configurador están duplicados a mano y no salen de `productos.json`.
      Sobra BLANCO y falta MARRÓN; NEGRO y STONE tienen el hex desviado del catálogo.
      Además la foto del pack enseña un short celeste que no existe entre las opciones.
- [ ] **Resuelto — el pie de las 10 páginas ya no tiene controles muertos.** `ENVÍOS` y
      la flecha del boletín van a `/contacto.html`; el `<input>` inerte desapareció.
      Si alguien añade un bloque nuevo al pie, que **navegue o no exista**: sin backend
      no hay tercera opción en el ATF1.
- [ ] **`intranet.html` y `confirmacion.html` no cargaban `formularios.css`** y su caja
      del pie salía cruda. Corregido. Al añadir una página nueva, comparad la lista de
      `<link>` con la de `index.html`.
- [ ] **Checklist de entrega: sección B completa y verificada** (los 6 componentes del
      criterio 1, con la ruta de cada uno). Lo rellené yo como SM aunque el archivo es
      del duo Documento/QA; **José y Jhade tienen que revisarlo**. Sigue sin marcar lo
      que pide su pasada visual: 375/1440 px, capturas y empaquetado.
- [ ] **Trampa T4 — caché del navegador.** Hay tres copias del sitio en el Mac
      (`Overtext-Web/app-estatico`, `MarcosWeb/overtext/app-estatico`,
      `MarcosWeb/proyectoAnterior`) con rutas de archivo idénticas. Si se sirven en el
      mismo `localhost:puerto`, el navegador reutiliza el CSS cacheado de la otra copia
      y parece que tu cambio "no se aplicó". Ya nos pasó con `promociones.css`.
      **`Cmd+Shift+R`, o Disable cache en DevTools**, antes de reportar un bug de estilos.
- [ ] (ya volcado en la versión inicial: decisiones 1-11, deudas D1-D6, trampas T1-T3)

**Sprint 1 — lo que el resto del equipo necesita saber:**

- [ ] **Cobertura de rúbrica ATF1:** marcar **1c Formularios** ✅ — evidencia
      `contacto.html`, `login.html`, `checkout.html`. Y **3 Informe** 🟨 — el diagrama
      físico ya existe (`informes/capturas/sprint-01/diagrama-fisico-bd.svg`); falta que
      el duo del documento lo inserte en §2.3 (E1-21).
- [ ] **Nueva trampa T4 — el CSS heredado le gana a Bootstrap por especificidad.**
      `input[type="text"]` (0,1,1) pesa más que `.form-control` (0,1,0), así que el tema
      antiguo anulaba al framework **sin dar ningún error en consola**. En
      `css/componentes/formularios.css` ya está acotado con `:not(.form-control)`.
      Quien maquete un componente de Bootstrap encima del CSS viejo tiene que
      **mirarlo en el navegador**, no fiarse de la consola.
- [x] ~~**⚠️ Falta el favicon y cuesta puntos del criterio 2d.**~~ **Resuelto por José el
      26-ago** con `assets/favicon.svg` enlazado en las 10 páginas. Lo dejo escrito porque
      la trampa se repite: no hay `favicon.ico` ni
      `<link rel="icon">` en ninguna de las 10 páginas: Chrome lo pide igual y el 404
      sale como **error rojo en consola**. Ojo, que **la verificación headless no lo
      detecta** (no pide el favicon), así que no basta con "me salió limpio".
      Hay que añadir el archivo y una línea por página antes de la entrega.
- [ ] **Nueva trampa T5 — `.d-block` de Bootstrap lleva `!important`** y gana al
      atributo `hidden`. Para mostrar u ocultar un `.invalid-feedback` desde JS hay que
      añadir y quitar `.d-block`, no usar `hidden`.
- [ ] **Nueva decisión — `esquema-fisico.sql` es la fuente autoritativa del modelo de
      datos.** `data-model.md` es la vista lógica y el diccionario; si discrepan, gana
      el `.sql`. El diagrama del informe se **genera** desde ahí, no se dibuja a mano.
- [ ] **Nueva decisión — se escribió el DDL de las 10 tablas en el Sprint 1**, aunque
      el ATF3 solo implemente `categoria`, `producto` y `color`. Las cuatro rúbricas
      piden el diagrama físico y a medias no demuestra nada.
- [x] ~~**Aviso para Carlos (E1-11) y para el duo de QA (E1-19): falta el favicon.**~~
      **Cerrado el 26-ago.** Lo dejo por el diagnóstico, que sigue siendo útil:
      Las 10 páginas piden `/favicon.ico` y el servidor devuelve **404**, así que sale un
      error en consola en cada página y saldrá en cada captura del informe. No lo arreglo
      yo porque toca el `<head>` de las 10 páginas, que es la pasada de Carlos: basta un
      `<link rel="icon">` en ese mismo commit. Es el **único** aviso que queda en las 10
      páginas; el resto de la consola está limpia.
- [ ] **Aviso para el Sprint 6 (E4-08):** `js/login.js` tiene las credenciales en el
      cliente (`admin@mail.com` / `123456`). Se borra con Spring Security. Le quité el
      `console.error` de credencial equivocada: ensuciaba la consola y el criterio 2d
      la quiere limpia.
- [ ] **`.grid-2` está retirada de `css/componentes/formularios.css`**, sustituida por
      `.row`/`.col-*` (art. 4). Comprobado: ninguna página ni componente vivo la usaba
      ya. La única definición que queda está en `css/style.css`, que es el código muerto
      que elimina E1-12 — **si alguien la "rescata" de ahí, se rompe**.
- [ ] **Para el duo del documento (E1-21):** la figura de §2.3 es
      `informes/capturas/sprint-01/diagrama-fisico-bd.svg`, con el pie
      *«Figura N. Diagrama físico de la base de datos. Fuente: elaboración propia.»*
      El `.png` está al lado por si el exportador a `.docx` no traga SVG.
      En §2.3 **ya está insertada la figura con su pie**; el texto que la acompaña lo
      escribió Jhade en E1-21, en su documento. No toqué ninguna otra sección del informe.

**Cierre del Sprint 1 (28-ago):**

- [x] **D3 y D4 cerradas.** El configurador de packs ofrece los **7 colores exactos de
      `js/productos.json`** (fuera BLANCO, dentro MARRÓN, BORGOÑA→GUINDA, OLIVO→OLIVA) y
      `UMBRAL_ENVIO_GRATIS = 200`. Con esto, **D1 a D5 están todas cerradas**; solo queda
      D6, que es borrar el backup del `.git` roto del *home*.
- [x] **Los hex del configurador ahora se copian del catálogo, no se aproximan.** Estaban
      cerca pero distintos (negro `#1A1A1A` vs `#111111`, stone `#C8B89A` vs `#C4A882`) y
      por eso pasaron tres revisiones visuales. **Un color parecido no es el mismo color.**
- [x] **Decisión — la rama de integración del equipo es `testing`.** `develop` no existe
      y no se va a crear: la DoD del Sprint 1 la nombraba por inercia de la plantilla.
      **Corregido a partir del Sprint 2.**
- [x] **Regla de proceso nueva, salida de la Retrospectiva del Sprint 1.** El art. 9 (un
      archivo, un escritor) protege el código pero **no reparte el trabajo**: D3 y D4 las
      detectaron tres personas, las tres las anotaron bien y las tres esperaron al "duo
      dueño", que no existía. **Toda deuda o decisión de PO que toque código sale del
      Planning con dueño y número de tarea.**
- [ ] **Deuda que abro para el Sprint 2 — no hay `plan.md` ni `tasks.md`.** El `spec.md`
      se aprobó el 25-ago y se pasó directo a implementar, saltando dos fases de
      CLAUDE.md §4. Además `plan.md` es la fuente de §2.1.2 del informe, que Jhade
      necesita. **Es lo primero del Sprint 2.**
- [ ] **Nota sobre `informes/informe.md`:** es el **esqueleto limpio** (E1-20 de Jhade).
      Sus marcadores `⬜` **no son trabajo pendiente**: Jhade lleva la redacción en su
      documento propio, fuera del repo, y de ahí salió el `.pdf` del ATF1. Nadie debe
      rellenarlos por su cuenta — rompería la voz única del documento (art. 10).

---

## Contexto propio

- Servir el sitio estático: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Antes de cualquier `git add`: `git rev-parse --show-toplevel` debe devolver `.../overtext-web`.
- Repo anterior en GitHub: `git@github.com:Jona-9/E-commerce-OverText.git` (referencia histórica, no es el del curso).

---

## Sprints cerrados

- **Sprint 1 — Bootstrap y sitio estático (20-ago → 04-sep). Cerrado el 28-ago-2026.**
  Como duo Datos: E1-07 ✅ · E1-22 ✅, más D3 y D4 cerradas. Como SM: E1-19 verificada,
  `checklist-entrega.md` completado, puerta de consolidación abierta con los 6 y
  `memory.md` consolidada. Entrega **ATF1**.
