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
- [ ] **Siguen abiertas para otros duos:** D3 (quitar el color BLANCO inexistente del configurador — el swatch se conserva, solo se des-inlineó) y D4 (`UMBRAL_ENVIO_GRATIS = 180` → 200 en `carrito.js`, no lo toqué por art. 9).

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Assets pesados: `find app-estatico/assets -type f -size +500k -exec ls -lh {} \; | sort -k5 -h -r`
- Ya eliminados por no tener referencias: `icon/reloj.png` (4,3 MB) e `img/sitio/poloOverText.png` (5,7 MB). El original intacto está en `../../../proyectoAnterior/`.

---

## Sprints cerrados

*(vacío)*
