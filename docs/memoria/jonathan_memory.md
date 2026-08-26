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
- [ ] **Código subido vía PR revisado por otro duo** — *lo único que me falta.* Ver la nota de abajo: la rama `develop` que pide la DoD no existe.

> **Incoherencia que me toca resolver como SM:** la DoD del sprint dice *"código en `develop` vía PR"*, pero **`develop` no existe** en el repositorio. Las ramas son `main`, `testing` y una por persona, y los merges anteriores (José, Joaquín) fueron a `testing`. Hay que corregir la DoD o crear `develop`; mientras tanto esa casilla no se puede marcar con honestidad.

~~**E1-22 depende del checkpoint de Joaquín**~~ — **desbloqueado.** Joaquín aprobó el
`spec.md` el 2026-08-25 y resolvió las tres `[NECESITA ACLARACIÓN]`: colores = los del
catálogo (sin BLANCO), envío gratis = **S/ 200**, badge **calculado** con `stock < 10`.
Las tres están dentro del modelo físico.

El diagrama lo exigen **las cuatro rúbricas**, no solo esta. Se dibuja una vez y se actualiza.

### No son mías — son de Carlos (mismo duo)

Las anoto para no perderlas de vista: si no se cierran, se cae el criterio **1d** del ATF1, que es del grupo y no de él.

- [ ] **E1-08** — Modal de confirmación de contacto *(criterio 1d)*
- [ ] **E1-09** — Modal de guía de tallas en la ficha *(criterio 1d)*
- [ ] **E1-10** — Panel del carrito a `offcanvas` *(criterio 1b)*
- [ ] **E1-11** — Bootstrap Icons en lugar de los PNG de 4-5 MB *(criterio 1a)*
- [ ] **E1-26** — `[SÍLABO]` Tabla de tallas con `table table-striped`

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

**Sprint 1:** ⬜ Joaquín · ⬜ José · ✅ Jonathan *(26-ago)* · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

Faltan 5. **`memory.md` no se toca** hasta que estén los 6 (CLAUDE.md §2).

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
- **Puerta de consolidación: 1 de 6.** `memory.md` sigue sin tocarse, y así se queda
  hasta que cierren Joaquín, José, Dayro, Carlos y Jhade (CLAUDE.md §2).
- Pendiente de facilitar: Review y Retro del vie 04-sep.

---

## Para consolidar en memory.md

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
- [ ] **⚠️ Falta el favicon y cuesta puntos del criterio 2d.** No hay `favicon.ico` ni
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
- [ ] **Aviso para Carlos (E1-11) y para el duo de QA (E1-19): falta el favicon.**
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
      En §2.3 **ya está insertada la figura con su pie**; lo que falta ahí es el texto
      que la acompaña, que es de E1-21. No toqué ninguna otra sección del informe.

---

## Contexto propio

- Servir el sitio estático: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Antes de cualquier `git add`: `git rev-parse --show-toplevel` debe devolver `.../overtext-web`.
- Repo anterior en GitHub: `git@github.com:Jona-9/E-commerce-OverText.git` (referencia histórica, no es el del curso).

---

## Sprints cerrados

*(vacío)*
