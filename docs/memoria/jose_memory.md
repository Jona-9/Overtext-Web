# Memoria de José

> Escritor único: José (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | Documento / QA | Jhade | Limpieza de código y optimización de assets |
| 2-3 | UI / Front | Carlos | Migración de recursos e iteraciones Thymeleaf |
| 4-5 | Datos / Backend | Carlos | Entidades, persistencia y operaciones CRUD |
| 6-7 | Documento / QA | Jhade | Regresión, bibliografía y anexos |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 7 | ATF1 |
| 2 | 07-sep → 20-sep | 2 | — |
| 3 | 21-sep → 01-oct | 3 | ATF2 |
| 4 | 05-oct → 18-oct | 3 | — |
| 5 | 19-oct → 29-oct | 3 | ATF3 |
| 6 | 02-nov → 15-nov | 2 | — |
| 7 | 16-nov → 29-nov | 3 | — |
| Estab. | 30-nov → 11-dic | Empaquetado + sustentación | TF |

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo Documento/QA con Jhade.** Sesiones 3-8. **Entrega ATF1.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E1-12 | Eliminar `css/style.css` — **616 líneas de código muerto** | 2b |
| E1-13 | Extraer el script incrustado de `promotions.html` (líneas 239-311) a `js/promociones.js` | 2a, 2b |
| E1-14 | Eliminar los **15 estilos en línea** (9 están en `promotions.html`) | 2b |
| E1-15 | Quitar los valores de relleno que parpadean al cargar | 2b, 2d |
| E1-16 | **Optimizar `assets/` de 39 MB a menos de 15 MB** | — |
| E1-17 | Actualizar `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` | 2a |
| E1-18 | Verificar **kebab-case** archivo por archivo | **2c** |

### El criterio 2 vale 6 puntos y es casi todo mío

Sus cuatro puntos: **a)** estructurado · **b)** limpio, sin comentarios innecesarios · **c)** kebab-case · **d)** JS sin errores.

**E1-12 — `css/style.css`** es el monolito viejo. Ningún HTML lo enlaza y define un `:root` que **contradice** al de `main.css` (`--negro:#000` vs `--color-negro:#111`). Se borra entero.

**E1-15 — los placeholders que parpadean.** En index, catalogo, detalle, nosotros y login están escritos a mano en el HTML: `.carrito-contador` con "2", "2 PRODUCTOS", "S/ 120", "TE FALTAN S/ 60 PARA ENVÍO GRATIS". Se ven un instante hasta que `carrito.js` los sobrescribe. Además incumplen el artículo 7 (un solo origen de verdad).

**E1-16 — los assets.** Ya se eliminaron 10 MB sin referencias (`reloj.png` y `poloOverText.png`). Quedan:

| Archivo | Peso | Problema |
|---|---|---|
| `icon/carta.png`, `instagram.png`, `ubicacion.png` | 4-5 MB c/u | Se muestran a 24 px → Carlos los reemplaza con Bootstrap Icons (E1-11) |
| `img/productos/*/principal.webp` | ~1,9 MB c/u | El propio `LEEME.txt` pide **< 300 KB** |
| `img/productos/negro/2.webp` | 3,0 MB | — |

Ver los pesados: `find app-estatico/assets -type f -size +500k -exec ls -lh {} \; | sort -k5 -h -r`

**E1-17 — los docs están desactualizados.** Proponen `variables.css`, `reset.css`, `base.css` y `layout/` que **no existen** (se consolidaron en `main.css` y `layout.css`), nombran `detalleProducto.html` y `fc_*.html` que no son los nombres reales, y dicen Bebas Neue cuando `main.css` importa **Oswald**.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo UI con Carlos.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-02 | Mover CSS, JS e imágenes a `src/main/resources/static/` y las páginas a `templates/paginas/` | — | 11-12 |
| E2-14 | Verificar que **todas** las rutas de recursos estáticos funcionan tras el traslado | — | 11-12 |

**E2-14 es el riesgo real del sprint.** El sitio usa rutas absolutas (`/css/...`) y `fetch` de JSON. Al mover los recursos, algo se rompe casi seguro y no se nota hasta que alguien abre esa página. Lo verifico **página por página**, con la consola abierta.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo UI con Carlos.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-21 | `th:each` para las tarjetas de producto del catálogo | **2c** | 13-14 |
| E2-22 | `th:each` para los colores del configurador de packs | 2c | 13-14 |
| E2-24 | **Verificar que las 10 páginas usan 2+ fragments, sin excepción** | **2a** | 15 |

### E2-24 no es un supuesto, es una tarea

El criterio 2a dice *«emplear por lo menos 2 fragmentos **en todas** las páginas»*. **Una sola página que se quede sin fragments baja el criterio de 6 a 3 puntos.**

Cuento los fragments de cada una de las 10 páginas y dejo la lista en la review.

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo Datos con Carlos.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-01 | `spring-boot-starter-data-jpa` + `mysql-connector-j`; crear la base `overtext_db` | 1 | 17-18 |
| E3-02 | Entidades `Categoria` y `Producto` con `@Entity`, `@OneToMany` / `@ManyToOne` | **1** | 17-18 |
| E3-05 | `CargaInicial` (`CommandLineRunner`) que siembra las categorías y los 7 productos | 2a | 19-20 |

**E3-01 bloquea a todo el equipo.** Los días 1-3 son para que **las 6 máquinas** conecten a MySQL; una configuración distinta bloquea a esa persona dos semanas enteras.

Dos trampas:
- **Nunca** commitear la contraseña de MySQL (constitución art. 6). Va por variables de entorno.
- `ddl-auto=create-drop` **borra los datos en cada arranque**. Usar `update` en desarrollo y documentarlo.

Datos semilla: los 7 productos con sus códigos, colores y hex están en `data-model.md` §3.

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo Datos con Carlos.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-08 | Alta y edición con `th:object` / `th:field` y patrón **POST-Redirect-GET** | **3a, 3b** | 21-22 |
| E3-09 | Baja con confirmación, desde la fila del listado | **3c** | 21-22 |
| E3-23 | Impedir borrar una categoría con productos asociados (integridad referencial) | 3c | 23 |

El criterio 3c pide explícitamente *«eliminación de los registros desde la página que muestra los registros»*: el botón va **en la fila del listado**, no en una pantalla aparte.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo Documento/QA con Jhade.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E4-24 | Capturas: inicio de sesión, error de credenciales, 403, panel con sesión iniciada | 5 |
| E4-25 | **Regresión ATF1 + ATF2 + ATF3** | todos |

### E4-25 es la tarea más delicada del sprint

**Activar Spring Security enciende CSRF y rompe todos los formularios** que no usen `th:action`. Es el fallo clásico. Reviso uno por uno:

- [ ] Formulario de contacto
- [ ] Formulario de inicio de sesión
- [ ] Proceso de compra (los 3 pasos)
- [ ] Alta de producto
- [ ] Edición de producto
- [ ] Borrado de producto
- [ ] Alta y edición de categoría

Y además:

- [ ] CSS, JS e imágenes cargan (si falta `permitAll()` a `/css/**`, el sitio se ve destruido)
- [ ] Los 6 componentes de Bootstrap del ATF1 siguen vivos
- [ ] Fragments, 404 y menú activo del ATF2 intactos
- [ ] CRUD y validaciones del ATF3 intactos

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo Documento/QA con Jhade.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E4-37 | **BIBLIOGRAFÍA** real: Spring, Bootstrap, Thymeleaf, MySQL y la bibliografía base del sílabo | 5 |
| E4-38 | **ANEXOS**: código fuente, capturas del funcionamiento, imágenes de la estructura | 5 |
| E4-39 | Regresión completa de los cuatro hitos | todos |

**E4-37** parte de cero: la plantilla UTP traía ~60 referencias sobre Android y acoso escolar que Jhade vació en el Sprint 1. Solo van las fuentes realmente consultadas.

La bibliografía base del sílabo, por si sirve:
- López Quijado, José. *Domine JavaScript* (3ª ed.). RA-MA Editorial.
- Eslava Muñoz, Vicente Javier. *El nuevo PHP: conceptos avanzados*. Bubok Publishing.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-01 auditoría de los 20 criterios *(30-nov)*
- [ ] E5-03 cierre del informe con Jhade *(02-dic)*
- [ ] E5-10 empaquetar `TF_GRUPO_01` con Jhade *(07-dic)*

**Penalizaciones del TF que dependen de este empaquetado:**
- `.rar` dañado o con contraseña → **−3 puntos**
- Nombre mal formado (`GRUPO_1` en vez de `GRUPO_01`) → **−1 punto por archivo**

### Mi bloque en la sustentación — 4 minutos, con Carlos

**Modelo de datos y CRUD.** Yo abro con el modelo:

> La base tiene nueve tablas relacionadas. Categoría agrupa productos; el pedido guarda sus líneas de detalle; el usuario tiene un rol asignado. El precio se copia en el detalle al momento de comprar, así que cambiar el precio de un producto no altera los pedidos históricos.

Carlos sigue con la demostración del CRUD.

---

## Bitácora — Sprint 1

### 2026-08-28 — cierre del Sprint 1

- **Mis 7 tareas cerradas** (E1-12 a E1-18). El criterio 2 completo, sus cuatro puntos:
  **2a** estructurado (script del configurador fuera del HTML, docs al día), **2b** limpio
  (`style.css` borrado, 0 estilos en línea, 0 placeholders de relleno), **2c** kebab-case
  auditado archivo por archivo, **2d** JS sin errores.
- **El pendiente humano de E1-19 quedó firmado.** Lo que dejé abierto era abrir DevTools
  página por página, cosa que no podía hacer con verificación estática. Lo firmaron
  Jonathan, Carlos y Dayro sobre las 10 páginas, a 375 y 1440 px: **cero errores y cero
  avisos**. Con el favicon que añadí ya no queda ni el `404 /favicon.ico`.
- **Las dos deudas que dejé abiertas por el art. 9 ya están cerradas.** Jonathan aplicó
  D3 y D4 el 28-ago:
  - **D3** — el configurador ofrece los **7 colores del catálogo**. El swatch **BLANCO**,
    que yo solo había des-inlineado (`.color-muestra--blanco`), **desapareció**, y entró
    **Marrón**, que faltaba. También se renombró `--borgona` → `--guinda` y `--olivo` →
    `--oliva` para que los nombres coincidan con `productos.json`. **Los hex ahora salen
    del catálogo**, no de un valor aproximado.
  - **D4** — `UMBRAL_ENVIO_GRATIS = 200`.
- **Confirmé que mi cambio de E1-13 aguanta el cambio de D3.** `promociones.js` lee el
  color con `getComputedStyle` y el nombre desde el DOM (`.nombre-color`), así que
  **no tiene ninguna lista de colores quemada**: quitar el blanco y añadir el marrón fue
  editar HTML y CSS, sin tocar el JS. Ese fue el motivo de hacerlo así.
- **Deuda menor que dejo apuntada (no es mía, no la toqué):** quedan dos reglas CSS
  muertas que nombran colores inexistentes — `.color-borgona` en
  `css/paginas/catalogo.css:47` y `.swatch--blanco` en `css/paginas/producto.css:202`.
  Los swatches reales se generan con el hex en línea desde `productos.json`
  (`tienda.js`), así que **ninguna de las dos se usa**. Es limpieza, no un fallo.
- **Bloqueo:** ninguno.
- **Archivos tocados:** ninguno.

### 2026-08-20
- Hice: —
- Decidí / aprendí: —
- Bloqueo: —
- Archivos tocados: —

### 2026-08-26
- **Hice (6 de mis 7 tareas del Sprint 1):**
  - **E1-12** — borré `css/style.css` (616 líneas de código muerto, `:root` con `--negro:#000` en conflicto con `main.css`). Ningún HTML lo enlazaba.
  - **E1-13** — extraje el configurador de packs incrustado en `promociones.html` a `js/promociones.js` nuevo; el HTML ahora lo carga con `<script src>` después de `carrito.js`.
  - **E1-14** — eliminé **todos** los estilos en línea: 2 en `catalogo.html` (→ `.catalogo-titulo`/`.catalogo-intro` en `paginas/catalogo.css`), 2 en `index.html` (→ `.hero-acciones`/`.detalle-cta` en `paginas/inicio.css` nuevo), 8 en `promociones.html` (7 swatches → clases `.color-muestra--<color>` + el padding del contenedor → `.seccion-configurador`, en `paginas/promociones.css`). `grep style= *.html` = 0.
  - **E1-15** — vacié los placeholders que parpadeaban (`.carrito-contador`, `.carrito-conteo`, `.envio-gratis-texto`, subtotal y `.total-monto`) en las 10 páginas; los llena `carrito.js`. Añadí `.carrito-contador:empty{display:none}` en `navegacion.css` para que el badge vacío no parpadee.
  - **E1-17** — reescribí `docs/01-arquitectura-css.md` y `docs/02-sistema-diseno.md` con la estructura REAL (main.css/tema-overtext.css/layout.css + 10 componentes + 10 páginas; fuentes **Oswald+Inter**, no Bebas; nombres reales de archivo; header con `navbar` + Bootstrap Icons).
  - **E1-18** — renombré `promotions.html` → `promociones.html` y actualicé los enlaces en las 10 páginas. Auditoría kebab-case: además corregí `.oferta_shorts` → `.oferta-shorts` y el asset `pack_Short.webp` → `pack-short.webp` (con sus 2 referencias). `LEEME.txt` se deja en mayúsculas (convención de readme).
- **Decidí / aprendí:**
  - **Gotcha `getComputedStyle`:** al pasar el color de los swatches de `style=` a una clase CSS, el configurador leía `.style.backgroundColor` (inline) y devolvía `""` → los slots quedaban sin color. En `promociones.js` lo cambié a `getComputedStyle(...).backgroundColor`. El `style="background-color:…"` que el JS **genera** por slot es dinámico y se queda.
  - Verifiqué con `node --check` los dos JS, `grep` de inline styles / refs a `promotions`, y que **todas** las refs locales `/css /js /assets` resuelven (sin 404).
- **Bloqueo:** ninguno.
- **Archivos tocados:** borré `css/style.css`; creé `js/promociones.js`, `css/paginas/inicio.css` y `assets/favicon.svg`; renombré `promotions.html`→`promociones.html` y `pack_Short.webp`→`pack-short.webp`; edité las 10 páginas HTML, `navegacion.css`, `paginas/catalogo.css`, `paginas/promociones.css` y los 2 docs.

### 2026-08-26 (cierre del sprint)
- **E1-16 completado:** comprimí las imágenes; `assets/` 26 MB → **3,8 MB**, **0 imágenes > 300 KB**.
- **Favicon** `assets/favicon.svg` en las 10 páginas → se va el `404 /favicon.ico`.
- **QA estática OK:** servido con `python -m http.server`, todas las páginas y recursos responden **200**. Verifiqué además: 0 inline styles, 0 refs a `promotions`, `node --check` en los JS, 0 refs locales rotas, kebab-case sin hallazgos nuevos.
- **Pendiente humano del Sprint Review:** abrir DevTools (F12 → Console) página por página para firmar el criterio 2d (cero errores/warnings). El código no tiene causas estructurales de error.

---

## Para consolidar en memory.md

- [x] **`promotions.html` → `promociones.html`** (renombrado): afecta a todo el equipo, los enlaces internos de las 10 páginas ya apuntan al nuevo nombre. Ojo si alguien tiene ramas en curso que enlacen `/promotions.html`.
- [x] **`css/style.css` eliminado** (deuda D2 cerrada).
- [x] **Docs `01-arquitectura-css.md` y `02-sistema-diseno.md` corregidos** (deuda D5 cerrada): la estructura real es `main.css`/`tema-overtext.css`/`layout.css` + `componentes/` + `paginas/`; fuentes Oswald + Inter (no Bebas Neue).
- [x] **Estilos en línea eliminados** y **placeholders del carrito vaciados** (incumplían art. 7): nuevas clases `.color-muestra--<color>`, `.seccion-configurador`, `.hero-acciones`, `.detalle-cta`, `.catalogo-titulo`, `.catalogo-intro`; regla `.carrito-contador:empty` en `navegacion.css`.
- [x] **E1-16 (assets < 15 MB) — HECHO:** comprimí las imágenes manualmente. `assets/` bajó de 26 MB → **3,8 MB** y **ninguna imagen supera 300 KB** (cumple RNF-0005 y el `LEEME`). Deuda D1 cerrada.
- [x] **Favicon de marca** (`assets/favicon.svg`) enlazado en las 10 páginas: elimina el único `404 /favicon.ico` del servidor. No es de mis 7 tareas, pero cierra el criterio de "cero errores/404".
- [x] ~~Siguen abiertas para otros duos: D3 y D4.~~ **Cerradas el 28-ago por Jonathan.**
      **D3** — fuera el BLANCO, dentro Marrón, y `--borgona`/`--olivo` renombradas a
      `--guinda`/`--oliva`; los 7 hex salen ahora de `productos.json`. **D4** —
      `UMBRAL_ENVIO_GRATIS = 200`.
- [x] **`promociones.js` no tiene lista de colores quemada, y es a propósito:** lee el
      nombre del DOM (`.nombre-color`) y el color con `getComputedStyle`. Por eso cambiar
      la paleta del configurador (D3) fue editar HTML y CSS **sin tocar el JS**.
      Quien vaya a "mejorarlo" metiendo un array de colores, rompe esa propiedad.
- [ ] **Limpieza pendiente, menor:** dos reglas CSS muertas que nombran colores que no
      existen — `.color-borgona` (`css/paginas/catalogo.css:47`) y `.swatch--blanco`
      (`css/paginas/producto.css:202`). Los swatches reales se pintan con el hex en línea
      desde `productos.json` vía `tienda.js`, así que ninguna se usa. Va con la limpieza
      del Sprint 2, no es un fallo del ATF1.

---

## Bitácora — Sprint 2

### 2026-09-14

- **Spec 002 escrito y aprobado.** `sprint-02.md` nombraba
  `docs/specs/002-migracion-thymeleaf/spec.md`, pero no existía (incumplía CLAUDE.md §4).
  Lo escribí con el formato de `skills/sdd-scrum/references/formato-spec.md` y **Joaquín
  (PO) lo aprobó en la misma sesión** — checkpoint dado, ya habilita implementar.
  Ambigüedades resueltas ahí: A1 se **copia** `app-estatico/` (no se mueve, sigue
  congelado como línea base del ATF1), A2 se mantiene Spring Boot 4.0.8 (ya decidido en
  E2-01), A3 los enlaces `/x.html` quedan para E2-06/E2-23, A4 `app-estatico/docs/` no es
  un recurso y no se migra.
- **E1-19 (mío, Sprint 1):** `overtext/` existe desde el 14-sep (Jonathan adelantó E2-01,
  ver su bitácora), con Spring Boot **4.0.8** y un placeholder de `HomeController`.
- **E2-02 — recursos y páginas trasladados a `overtext/`:**
  - Copié (no moví) `app-estatico/{css,js,assets}` → `overtext/src/main/resources/static/`,
    misma estructura de carpetas, así las rutas absolutas `/css/...`, `/js/...`,
    `/assets/...` que ya usaban las 10 páginas siguen resolviendo igual.
  - Copié las 10 páginas `app-estatico/*.html` → `overtext/src/main/resources/templates/paginas/`,
    **sin tocar su contenido** — los fragments (`layout/plantilla.html`) son de Carlos, E2-03/E2-04.
  - Verifiqué con `diff -r` que las tres carpetas copiadas y las 10 páginas son
    **idénticas** al original en `app-estatico/`.
  - Sustituí el placeholder que dejó Jonathan: borré
    `templates/index.html` y cambié `HomeController.inicio()` para que devuelva
    `"paginas/index"` (la portada real), como pedía el `README.md` del proyecto.
    Actualicé esa nota del `README.md`.
- **E2-14 — verificación de rutas de recursos:**
  - `./mvnw.cmd clean package` → **BUILD SUCCESS**, test de contexto en verde.
  - Levanté el server en el puerto **8081** (el 8080 puede estar ocupado, según la nota
    de Jonathan) y armé la lista completa de rutas absolutas que usan las 10 plantillas
    (`href`/`src`) más los `fetch()` de los JS.
  - **Los 42 recursos** (CSS, JS, imágenes, los dos JSON) responden **HTTP 200**. Cero
    fallos.
  - `GET /` sirve la portada real (título `OVERTEXT`, `id="carrusel-portada"` presente),
    confirmando que pasa por el controlador y no por el placeholder.
  - **Bloqueo esperado, no un fallo:** los 7 enlaces internos `/x.html` que aparecen en
    las plantillas (`/catalogo.html`, `/checkout.html`, `/contacto.html`, `/index.html`,
    `/login.html`, `/nosotros.html`, `/promociones.html`) dan **404**, porque las rutas
    por sección (`/catalogo`, `/producto/{id}`, etc.) son **E2-06, de Dayro**, y no
    existen todavía. Lo dejo anotado en vez de resolverlo — no es mi tarea y el spec 002
    (ambigüedad A3) ya lo traza así.
  - Verificación de consola en navegador (375/1440 px) queda como **pendiente humano**
    de la review, igual que E1-19 en el Sprint 1: no la puedo firmar con verificación
    estática/HTTP.
  - Detuve el servidor al terminar.
- **Decidí / aprendí:** copiar en vez de mover fue clave para no romper la línea base
  congelada del ATF1 (`memory.md` §4) mientras `overtext/` toma forma en paralelo.
- **Bloqueo:** las 9 páginas restantes (todo menos `/`) no se pueden abrir todavía desde
  Spring — dependen de los controladores por sección de Dayro (E2-06).
- **Archivos tocados:** nuevo `docs/specs/002-migracion-thymeleaf/spec.md`; copiados
  `overtext/src/main/resources/static/{css,js,assets}/**` y
  `overtext/src/main/resources/templates/paginas/*.html`; borrado
  `overtext/src/main/resources/templates/index.html`; editados
  `overtext/src/main/java/pe/edu/utp/overtext/controller/HomeController.java` y
  `overtext/README.md`; esta memoria.

### Para consolidar en memory.md

- [ ] **Spec 002 creado y aprobado** por el PO — `docs/specs/002-migracion-thymeleaf/spec.md`.
- [ ] **A partir de ahora el CSS y el JS se editan en `overtext/src/main/resources/static/`,
      no en `app-estatico/`.** `app-estatico/` sigue viva solo como línea base congelada
      del ATF1 (no se borra ni se edita).
- [ ] Las 10 páginas viven además en `overtext/src/main/resources/templates/paginas/`.
- [ ] Los enlaces `/x.html` dan 404 en `overtext/` hasta que Dayro cierre E2-06 (rutas
      por sección) y yo/Carlos cerremos E2-23 (`th:href="@{...}"`) en el Sprint 3.
- [ ] **Discrepancia con `memory.md` §4:** dice *"`overtext/` — Proyecto Spring Boot.
      **Aún no existe** — se crea en el Sprint 2"*, pero ya existe desde el 14-sep
      (Jonathan adelantó E2-01) y ahora ya tiene recursos y páginas (E2-02). Gana el
      código (CLAUDE.md §3); se corrige en la próxima consolidación.
- [ ] `joaquin_memory.md` tiene sin marcar *"Aprobar `docs/specs/002-migracion-thymeleaf/spec.md`"*
      en su lista de Sprint 2 — ya lo aprobó en esta sesión, pero el checkbox de su propia
      memoria le corresponde marcarlo a él (art. 9).

---

## Bitácora — Sprint 3

### 2026-09-22

- **Hice (análisis, sin tocar código de `overtext/` todavía):**
  - Repasé `sprint-03.md` §4 y confirmé mi reparto: **E2-21** (`th:each` tarjetas del
    catálogo), **E2-22** (`th:each` colores del configurador) y **E2-24** (verificar
    2+ fragments en las 10 páginas). E2-08/E2-10/E2-23 son de Carlos.
  - **Verifiqué que el backend de E2-21 ya está listo**: Dayro cerró E2-09 el 20-sep
    (`ProductoService`, `model/Producto.java`) y `CatalogoController` ya expone
    `productos` al modelo. No falta nada en Java para mi tarea.
  - **`catalogo.html` (líneas 47-54): el grid está vacío**, no tiene 7 tarjetas escritas
    a mano como yo suponía — hoy las pinta `static/js/tienda.js` (`renderCatalogo()`,
    líneas 30-52) por `fetch`/`innerHTML` sobre `.productos-grid`. Si dejo `tienda.js`
    activo en esa página después de meter el `th:each`, hay doble renderizado (mismo
    resultado visual, pero código muerto — contradice el 2b, que es mi especialidad).
  - **`promociones.html` (líneas 58-92): sí hay 7 `div.color-opcion` a mano**, uno por
    color. Comparé los 7 hex de `promociones.css` (~líneas 180-186) contra los 7
    `producto.color.hex` de `productos.json`: **coinciden 1:1**. Es el mismo dato
    duplicado en dos archivos (deuda menor de art. 7).
  - Leí `promociones.js` completo: no tiene colores quemados, lee `.nombre-color` (texto)
    y `getComputedStyle(.color-muestra)` (color ya resuelto). Confirmé que da igual si el
    color llega por clase CSS o por `style` inline — el `getComputedStyle` resuelve los
    dos casos igual.
  - **E2-24 ya se cumple hoy.** Conté los `th:replace` de las 10 páginas de
    `templates/paginas/`: todas usan `cabecera` + `pie` + `scripts` como mínimo (3), y
    las 6 que muestran el carrito (`index`, `catalogo`, `detalle-producto`, `nosotros`,
    `contacto`, `promociones`) usan además `carrito` (4). Ninguna tiene menos de 2.

    | Página | Fragments | Total |
    |---|---|:-:|
    | `index.html` | cabecera, carrito, pie, scripts | 4 |
    | `catalogo.html` | cabecera, carrito, pie, scripts | 4 |
    | `detalle-producto.html` | cabecera, carrito, pie, scripts | 4 |
    | `nosotros.html` | cabecera, carrito, pie, scripts | 4 |
    | `contacto.html` | cabecera, carrito, pie, scripts | 4 |
    | `promociones.html` | cabecera, carrito, pie, scripts | 4 |
    | `checkout.html` | cabecera, pie, scripts | 3 |
    | `confirmacion.html` | cabecera, pie, scripts | 3 |
    | `login.html` | cabecera, pie, scripts | 3 |
    | `intranet.html` | cabecera, pie, scripts | 3 |

  - Confirmé de paso que **E2-08 (Carlos) ya está resuelto**: el fragment `cabecera` en
    `layout/plantilla.html` (líneas 30-34) ya usa `th:classappend` con `paginaActiva`
    para el enlace activo. No es mío, pero queda anotado para que nadie lo repita.
- **Bloqueo de proceso encontrado — CLAUDE.md §4:** no existe ningún `spec.md` para este
  trabajo. `docs/specs/002-migracion-thymeleaf/spec.md` §2.3 lo excluye explícitamente
  ("fuera de alcance, para el Sprint 3") y no hay ninguna carpeta `003-*`. `sprint-03.md`
  es backlog, no spec SDD. **A diferencia de D7 y D16, esta vez no implementé nada sin
  spec.** Escribí `docs/specs/003-thymeleaf-interacciones/spec.md` con las decisiones de
  diseño resueltas (retirar el renderizado de catálogo de `tienda.js`; pintar el color del
  configurador con `th:style` del hex del modelo en vez de una clase `color-muestra--*`,
  cerrando la duplicación de hex) y **lo dejé sin marcar el checkpoint** — pendiente de que
  Joaquín (PO) lo apruebe antes de tocar ningún archivo de `overtext/`.
- **Decidí / aprendí:**
  - Mi supuesto inicial (que el catálogo tenía 7 tarjetas hardcodeadas, igual que
    `promociones.html`) era incorrecto — solo `promociones.html` las tiene a mano. El
    catálogo depende de JS, no de HTML repetido. Bueno anotarlo para no repetir el mismo
    supuesto en otra tarea.
  - `tienda.js` hace **dos** cosas con una sola guarda de existencia de elemento
    (`renderCatalogo` si existe `.productos-grid`, `renderDetalle` si existe
    `.info-detalle-producto`): al "apagar" el catálogo hay que tocar solo la mitad del
    archivo, sin afectar la ficha de producto.
- **Bloqueo:** ninguno — resuelto el mismo día, ver siguiente entrada.
- **Archivos tocados:** nuevo `docs/specs/003-thymeleaf-interacciones/spec.md`; esta
  memoria.

### 2026-09-22 (continuación) — Joaquín aprobó el spec 003; implementé E2-21, E2-22 y E2-24

- **Joaquín (PO) aprobó `docs/specs/003-thymeleaf-interacciones/spec.md`** el mismo día
  (ver su bitácora, `joaquin_memory.md`), sin pedir ajustes a las cuatro decisiones de
  diseño de la §5. Recién ahí empecé a tocar `overtext/`.
- **Hice — E2-21 (`th:each` del catálogo):**
  - `catalogo.html` (antes líneas 47-54, grid vacío): reemplacé el comentario por
    `th:each="producto : ${productos}"` sobre el mismo bloque que hoy construye
    `tienda.js:renderCatalogo` (badge, imagen+enlace, nombre, descripción, precio con
    `[[${...}]]` inline, punto de color con `th:style` del hex, botón "añadir al carrito"
    con los `data-*` que ya lee `carrito.js` por delegación).
  - Quité `<script src="/js/tienda.js"></script>` de `catalogo.html`.
  - En `tienda.js`: eliminé `renderCatalogo()` y la variable `grid`; `renderDetalle()` y
    su uso en `detalle-producto.html` quedaron intactos — no son parte de esta tarea.
  - Actualicé el Javadoc de `CatalogoController` (ya no dice "hasta que E2-21 se cierre").
- **Hice — E2-22 (`th:each` del configurador):**
  - `PromocionesController` ahora inyecta `ProductoService` y expone `productos` al
    modelo (mismo patrón que `CatalogoController`).
  - `promociones.html` (antes líneas 58-92, 7 `div.color-opcion` a mano): un solo bloque
    con `th:each="producto : ${productos}"`, pintando `.color-muestra` con
    `th:style="'background-color:' + ${producto.color.hex}"` y `.nombre-color` con
    `th:text="${producto.color.nombre}"`.
  - Retiré las 7 reglas `.color-muestra--*` de `promociones.css` (quedaban sin uso).
  - **No toqué `promociones.js`**: confirmé que sigue leyendo `.nombre-color` y
    `getComputedStyle(.color-muestra)`, sin importarle si el color venía de una clase o
    de un `style` inline.
- **Verifiqué (con el servidor local, puerto 8098, y sin editar nada más):**
  - `mvnw clean compile` → sin errores.
  - `GET /catalogo` → **200**, 7 `article.producto-card` en el HTML devuelto por el
    servidor (visible en "ver código fuente", sin esperar a que corra JS) — confirmé una
    tarjeta completa (`short-beige`): nombre, precio "S/ 20 / pack 6 x S/ 100", color
    "Stone Beige" con su hex, enlace `/producto/short-beige`, los 5 `data-*` del botón de
    carrito.
  - `GET /promociones` → **200**, 7 `div.color-opcion` con su hex en `style` y su nombre.
  - `GET /producto/short-beige` → **200** y sigue usando `tienda.js` (`renderDetalle`
    intacto); `GET /producto/no-existe` → **404** (la de Dayro, E2-09, sin regresión).
  - `node --check` en `tienda.js` y `promociones.js`: sin errores de sintaxis.
  - `grep -r "renderCatalogo"` en `src/`: cero resultados — no quedó código muerto.
  - **Pendiente humano, igual que E1-19/E2-17 en sprints anteriores:** no pude abrir
    Chrome con la extensión conectada en esta sesión, así que **la verificación visual a
    375/1440 px y la consola del navegador quedan sin firmar**. El HTML generado por el
    servidor y los `node --check` no reemplazan esa verificación.
- **Decidí / aprendí — dos diferencias visuales menores que no anticipé en el spec:**
  - **El orden de los 7 colores cambia.** El HTML a mano tenía Negro primero; `productos.json`
    (y por tanto `${productos}`) tiene Stone Beige primero. Nuevo orden: Stone Beige,
    Negro, Guinda, Gris, Oliva Militar, Azul Marino, Marrón. No metí un comparador para
    forzar el orden viejo — sería una regla nueva que nadie pidió (art. 8) y el criterio
    2c no exige un orden específico. Si en la Review alguien prefiere el orden anterior,
    se resuelve con un `Comparator` de una línea en `ProductoServiceImpl`, no aquí.
  - **Tres nombres de color salen más largos que antes.** El HTML a mano decía "STONE",
    "OLIVA" y "MARINO"; `producto.color.nombre` da "Stone Beige", "Oliva Militar" y
    "Azul Marino" (el CSS ya los pone en mayúsculas con `text-transform`, así que la
    diferencia es de contenido, no de estilo). Elegí el nombre completo del modelo en vez
    de acortarlo a mano porque acortar reintroduce un texto que no viene de
    `productos.json` — exactamente la duplicación que E2-22 buscaba cerrar. No hay
    `max-width`/`white-space:nowrap` en `.color-opcion span` que lo rompa, pero si en la
    Review se ve apretado, es un ajuste de CSS, no de datos.
- **Bloqueo:** ninguno. **E2-21, E2-22 cerradas** (con el pendiente humano de arriba);
  **E2-24 confirmada** (tabla de la entrada anterior).
- **Archivos tocados:** `overtext/src/main/resources/templates/paginas/catalogo.html`,
  `overtext/src/main/resources/templates/paginas/promociones.html`,
  `overtext/src/main/resources/static/js/tienda.js`,
  `overtext/src/main/resources/static/css/paginas/promociones.css`,
  `overtext/src/main/java/pe/edu/utp/overtext/controller/CatalogoController.java`,
  `overtext/src/main/java/pe/edu/utp/overtext/controller/PromocionesController.java`;
  esta memoria.

### Para consolidar en memory.md

- [x] **Spec 003 escrito y aprobado por el PO el mismo día** —
      `docs/specs/003-thymeleaf-interacciones/spec.md`. Primera vez que el equipo pide el
      checkpoint antes de implementar en vez de después (no repite D7/D16).
- [x] **E2-21 y E2-22 cerradas.** Catálogo y configurador ya se pintan con `th:each` desde
      `ProductoService`; `tienda.js` dejó de renderizar el catálogo (solo le queda la
      ficha de producto) y el hex de los 7 colores ya no está duplicado en
      `promociones.css`.
- [x] **E2-24 confirmada:** las 10 páginas tienen 3 o 4 fragments, ninguna menos de 2
      (tabla en la entrada anterior). Falta el `[x]` formal en `sprint-03.md` en la Review
      del 30-sep.
- [ ] **Aviso para Carlos (E2-23):** las tarjetas nuevas del catálogo ya usan
      `th:href="@{...}"` en sus 3 enlaces por tarjeta — un bloque menos que convertir.
- [ ] **Pendiente humano de la Review:** abrir `/catalogo` y `/promociones` en un
      navegador real a 375 px y 1440 px y confirmar consola sin errores (art. 3) — no se
      pudo firmar en esta sesión porque la extensión de Chrome no estaba conectada.
- [ ] **Nota para la Retrospectiva:** el orden de los 7 colores del configurador cambió
      (ahora sigue el orden de `productos.json`, antes era a mano) y tres nombres de color
      salen más largos ("Stone Beige", "Oliva Militar", "Azul Marino" en vez de "STONE",
      "OLIVA", "MARINO"). Es intencional (una sola fuente de verdad, art. 7), pero
      cualquiera que compare capturas de antes/después de este cambio lo va a notar.

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Assets pesados: `find app-estatico/assets -type f -size +500k -exec ls -lh {} \; | sort -k5 -h -r`
- Ya eliminados por no tener referencias: `icon/reloj.png` (4,3 MB) e `img/sitio/poloOverText.png` (5,7 MB). El original intacto está en `../../../proyectoAnterior/`.

---

## Sprints cerrados

- **Sprint 1 — Bootstrap y sitio estático (20-ago → 04-sep). Cerrado el 28-ago-2026.**
  E1-12 ✅ · E1-13 ✅ · E1-14 ✅ · E1-15 ✅ · E1-16 ✅ · E1-17 ✅ · E1-18 ✅.
  **Criterio 2 completo (2a, 2b, 2c, 2d).** Deudas D1, D2 y D5 cerradas.
