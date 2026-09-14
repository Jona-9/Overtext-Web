# Memoria general — OverText

> **Escritor único: Scrum Master (Jonathan).** Nadie más edita este archivo.
> Se consolida **solo cuando los 6 integrantes cerraron el sprint**. Si falta alguien, este archivo no se toca.
> Es la última foto **estable**: puede estar desactualizada respecto al sprint en curso. Si contradice el código, gana el código.

**Última consolidación:** **Sprint 1 — 28-ago-2026.** Sprint cerrado, entrega **ATF1** hecha.
**Enmienda del 28-ago (SM):** cierre de deuda previo al Sprint 2 — **D6, D8, D9, D10, D11, D13 y D14 cerradas**; D7 reformulada (falta el visto del PO); **D15 abierta**. D13 y D14 se detectaron y se arreglaron en el mismo barrido. Se corrigió además la evidencia de E1-25 en la §5. Solo se tocaron la §5, la §6 y la tabla de trampas.
**Estado de la puerta:** ✅ Joaquín · ✅ José · ✅ Jonathan · ✅ Dayro · ✅ Carlos · ✅ Jhade
**Sprint en curso:** ninguno. El **Sprint 2** (Spring Boot y Spring Web) arranca el 07-sep.

---

## 1. Estado actual

**Sprint 1 cerrado. ATF1 entregado.** El sitio estático está migrado a Bootstrap 5.3 con
una capa de tema propia, el código quedó limpio y el modelo de datos está diseñado.

- **Línea base:** `app-estatico/` — 10 páginas HTML, **Bootstrap 5.3 por CDN** +
  `css/tema-overtext.css`, CSS propio modular (`main.css` / `layout.css` +
  `componentes/` + `paginas/`), JS vanilla, carrito en `localStorage`.
- **Los 6 componentes de Bootstrap están en producción:** contenedores, navbar
  responsivo, formularios validados, modales, carrusel y sistema de grillas.
- **Modelo de datos diseñado, no implementado.**
  `docs/specs/001-sitio-bootstrap/esquema-fisico.sql` define las **10 tablas** y es la
  **fuente autoritativa**; `data-model.md` es la vista lógica y el diccionario. Si
  discrepan, gana el `.sql`. El diagrama del informe se **genera** desde ahí.
- **Stack objetivo:** Bootstrap 5.3 → Spring Boot 3.x + Thymeleaf → Spring Data JPA + MySQL → Spring Security.
- **Stack actual:** HTML + Bootstrap 5.3 + CSS propio + JS vanilla. Sin backend ni base de datos todavía.
- **`assets/` pesa 3,8 MB** (venía de 39 MB) y ninguna imagen supera 300 KB.

## 2. Decisiones vigentes

| # | Decisión | Motivo | Sprint |
|---|---|---|---|
| 1 | Partir del proyecto OverText anterior, no empezar de cero | Ahorra el diseño, el copy y la identidad de marca ya trabajados | 1 |
| 2 | Bootstrap 5 + capa de tema propia (`tema-overtext.css`) | La rúbrica exige framework CSS; el tema conserva la identidad | 1 |
| 3 | El informe se escribe en Markdown, no en `.docx` | Un binario en Git con 6 personas es conflicto garantizado | 1 |
| 4 | `memory.md` se consolida solo con los 6 sprints cerrados | La memoria general solo describe estado completo y verificado | 1 |
| 5 | Repositorio nuevo en `overtext-web/` | Había un `.git` enraizado en el *home* que exponía `.ssh` y `.khipu-secrets` | 1 |
| 6 | No profundizar checkout, ubigeo ni configurador de packs | Funcionan y no dan puntos de rúbrica | 1 |
| 7 | 7 sprints: 1 para el ATF1 y 2 para cada avance siguiente | El ciclo ya va por la semana 2; el ATF1 no da para dos sprints | 1 |
| 8 | Cada sprint usa solo lo dictado esas mismas semanas | Ningún sprint pide una tecnología antes de que se enseñe | 1 |
| 9 | Implementar también los temas del sílabo sin rúbrica (tablas e íconos, REST, **JWT**) | El objetivo es cubrir todo el curso; la rúbrica es el piso, no el techo | 1 |
| 10 | Cada Sprint Review verifica también los criterios de los avances anteriores | Una regresión en el ATF1 cuesta puntos en el TF | 1 |
| 11 | Congelación de funcionalidad el 29-nov | Las semanas 17-18 son para estabilizar y sustentar, no para programar | 1 |
| 12 | Los 7 colores válidos son los de `js/productos.json`: negro, stone beige, guinda, gris, oliva militar, azul marino y marrón | **El BLANCO nunca existió como producto.** Decisión I1 del PO | 1 |
| 13 | Envío gratis desde **S/ 200** | Decisión I2 del PO; coincide con el copy "desde 2 packs" | 1 |
| 14 | El badge de stock bajo se calcula con `stock < 10`, no se guarda | Decisión I3 del PO; un dato calculado no se duplica (art. 7) | 1 |
| 15 | `esquema-fisico.sql` es la fuente autoritativa del modelo de datos | `data-model.md` es la vista lógica; el diagrama se genera, no se dibuja | 1 |
| 16 | Se escribió el DDL de las 10 tablas ya en el Sprint 1, aunque el ATF3 solo use 3 | Las cuatro rúbricas piden el diagrama físico, y a medias no demuestra nada | 1 |
| 17 | **La rama de integración es `testing`.** `develop` no existe ni se va a crear | La DoD la nombraba por inercia de la plantilla; los PR ya entran a `testing` | 1 |
| 18 | Jhade lleva la redacción del informe en un documento propio, fuera del repo | Es la editora y custodia la voz única (art. 10). `informes/informe.md` es el esqueleto limpio: **sus `⬜` no son trabajo pendiente** | 1 |
| 19 | Toda deuda o decisión de PO que toque código sale del Planning con **dueño y número de tarea** | D3 y D4 las detectaron 3 personas y esperaron 3 días a un "duo dueño" que no existía. El art. 9 protege el código, no reparte el trabajo | 1 |

## 3. Convenciones activas

Ver `docs/constitution.md`. No se duplican aquí.

## 4. Mapa del código

| Ruta | Qué contiene |
|---|---|
| `app-estatico/` | Sitio del ATF1. Se congela tras la entrega. |
| `overtext/` | Proyecto Spring Boot. **Aún no existe** — se crea en el Sprint 2. |
| `docs/specs/` | Specs SDD por feature. |
| `docs/scrum/roadmap.md` | **Planificación de las 18 semanas**: sílabo → sprint → rúbrica. |
| `docs/scrum/sprints/` | Los 7 sprints, uno por archivo, + la estabilización. |
| `docs/memoria/` | Una memoria por integrante. |
| `informes/informe.md` | El informe, documento vivo. |
| `informes/capturas/` | Evidencia por sprint. |

## 5. Cobertura de rúbrica

Leyenda: ⬜ pendiente · 🟨 en curso · ✅ cubierto y con evidencia

### ATF1 — 20 pts

| Criterio | Estado | Evidencia | Quién |
|---|---|---|---|
| 1a Contenedores | ✅ | `.container` de Bootstrap en las 10 páginas (se retiró el `.contenedor` propio) + Bootstrap Icons | Dayro, Carlos |
| 1b Menú responsivo | ✅ | `navbar navbar-expand-lg` con `navbar-toggler` en las 10; carrito en `offcanvas` | Joaquín, Carlos |
| 1c Formularios | ✅ | `form-control` / `form-select` / `form-check` con `was-validated` en contacto, login y checkout | Jonathan |
| 1d Ventanas modales | ✅ | Modal de confirmación de contacto y modal de guía de tallas | Carlos |
| 1e Carrusel de imágenes | ✅ | `#carrusel-portada` (3 diapositivas, autoavance con pausa al pasar el cursor) y `#carrusel-galeria` | Dayro |
| 1f Sistema de grillas | ✅ | `row` / `col-*` en catálogo, nosotros y el pie de las 10 páginas | Dayro |
| 2a Código estructurado | ✅ | Script del configurador extraído a `js/promociones.js`; docs de arquitectura CSS al día | José |
| 2b Código limpio | ✅ | `css/style.css` (616 líneas) eliminado, **0** estilos en línea, **0** placeholders de relleno | José |
| 2c kebab-case | ✅ | Auditoría archivo por archivo; `promotions.html` → `promociones.html` | José |
| 2d JS sin errores en consola | ✅ | Las 10 páginas a 375 y 1440 px: **0 errores, 0 avisos**. `favicon.svg` cierra el último 404 | Todos (E1-19) |
| 3 Informe (5 secciones) | ✅ | Plantilla UTP limpia + Docente/Recomendaciones/Anexos + diagrama físico (Figura 1) | Jhade, Jonathan |
| 4 Nomenclatura del entregable | ✅ | `ATF1_GRUPO_01` (`.pdf` + `.rar`), sin contraseña, verificado en otra máquina | Jhade, José |

**ATF1: los 12 criterios cubiertos y con evidencia.**

*(Las tablas de ATF2, ATF3 y TF se añaden al llegar a cada avance.)*

### Extras del sílabo sin rúbrica (decisión 9)

| Tema | Estado | Evidencia |
|---|---|---|
| Tablas | ✅ | Guía de tallas con `table table-striped table-hover` (E1-26) |
| Íconos | ✅ | Bootstrap Icons en lugar de los PNG de 4-5 MB (E1-11) |
| Estilos de párrafo | ✅ | `.enfasis-marca`, aplicada en el banner de packs del catálogo (E1-25). **Las otras cuatro se retiraron**: `.antetitulo` duplicaba `.subtitulo-superior`, y `.texto-guia`/`.parrafo-marca`/`.texto-apoyo` duplicaban la tipografía que cada página ya define y que gana por especificidad (art. 7, T4) |
| REST, JWT | ⬜ | Sprints 6-7 |

## 6. Deuda y pendientes

### Abiertas

| # | Pendiente | Origen | Dueño |
|---|---|---|---|
| **D7** | **`plan.md` y `tasks.md` ya existen** en `docs/specs/001-sitio-bootstrap/` (28-ago), pero la fase Plan **no se cierra con el archivo escrito sino con el checkpoint del PO**. Ambos son retroactivos y lo declaran en su cabecera. `plan.md` §10 traza qué sección del informe sale de dónde | Sprint 1 | **Joaquín — aprobar. Lo primero del Sprint 2** |
| D12 | `js/login.js` tiene las credenciales en el cliente (`admin@mail.com` / `123456`) | Sprint 1 | Se borra con Spring Security (Sprint 6, E4-08) |
| D15 | **Quedan ~18 clases CSS que ninguna página usa** (`tarjetas-grid`, `grid-pie`, `miniaturas-grid`, `banner-titulo`, `tag-disponible`, `select-campo`…), ~180 líneas. Misma familia que D8 y D10: restos de la migración. Ninguna rompe nada ni cuesta rúbrica. Va con la decisión de **en qué capa vive la tipografía de párrafo**, que es lo que dejó a E1-25 sin sitio | Sprint 1 (detectada 28-ago) | **Sin dueño — Planning del Sprint 2 (regla 19)** |

### Cerradas en el Sprint 1

| # | Pendiente | Cómo se cerró |
|---|---|---|
| D1 | `assets/` pesaba ~39 MB; objetivo < 15 MB | ✅ **3,8 MB**, ninguna imagen sobre 300 KB (E1-11 + E1-16) |
| D2 | `css/style.css` (616 líneas), código muerto con `:root` conflictivo | ✅ Eliminado (E1-12) |
| D3 | Colores del configurador ≠ colores del catálogo (BLANCO inexistente) | ✅ Los **7 del catálogo**: fuera BLANCO, dentro MARRÓN, BORGOÑA→GUINDA, OLIVO→OLIVA, y los hex copiados de `productos.json` |
| D4 | Envío gratis: S/ 180 en el JS vs S/ 200 en el copy | ✅ `UMBRAL_ENVIO_GRATIS = 200` en `js/carrito.js` |
| D5 | Los docs de CSS describían archivos que no existen | ✅ `01-arquitectura-css.md` y `02-sistema-diseno.md` reescritos con la estructura real (E1-17) |
| D6 | Borrar `~/.git-ROTO-backup-20260820`, el `.git` roto del *home* | ✅ **No requirió trabajo**: ni el backup ni `~/.git` existen ya. Verificado el 28-ago |
| D8 | `.color-borgona` (`paginas/catalogo.css`) y `.swatch--blanco` (`paginas/producto.css`) nombran colores inexistentes | ✅ Ambas retiradas (28-ago, `083d594`) |
| D9 | `.ot-icono-whatsapp` definida dos veces, en `componentes/botones.css` y en `paginas/login.css` | ✅ Una sola definición, en `paginas/login.css`, junto a `.ot-boton-whatsapp`: solo las usa `login.html`, así que viven con su página (28-ago, `083d594`) |
| D10 | CSS muerto en `componentes/navegacion.css`, huérfano desde que se eliminó `js/nav.js` | ✅ Retirado el menú anterior completo: **183 líneas eliminadas**, 8 de comentario que explica por qué (28-ago, `083d594`) |
| D11 | Las capturas del offcanvas mostraban el umbral viejo de S/ 180 | ✅ Retomadas a 1440 y 375 px: ahora dicen **S/ 140** (umbral 200). Cero errores de consola y sin desborde horizontal (28-ago, `5e6cafc`) |
| D13 | El pie del carrito decía «ENVÍO — GRATIS» siempre, contradiciendo a la barra de progreso | ✅ `renderizarCarrito()` lo deriva del mismo umbral: **POR DEFINIR** bajo S/ 200 y **GRATIS** al alcanzarlo. El verde pasa a `.es-gratis`, siguiendo el precedente de `envio-gratis-tag` en el checkout (28-ago) |
| D14 | El menú móvil desplegado no tenía fondo y caía ilegible sobre el carrusel | ✅ Bajo 992 px la barra crece con el menú (`height: auto` + `min-height: 70px`) y el `collapse` recibe fondo sólido y línea separadora. Escritorio intacto: **70 px** a 1440 y a 992. Solo capa de tema, no se tocó el componente (28-ago) |

> **Cierre de deuda del 28-ago.** D6, D8, D9, D10 y D11 se cerraron después de la
> consolidación del Sprint 1, en un barrido previo al Sprint 2. **D8, D9 y D10 ya
> estaban arregladas en el *working tree* pero sin commitear** — un `git checkout .`
> las habría revivido. Antes de dar por bueno el borrado se cruzaron los **33
> selectores** eliminados contra todo el HTML y el JS; ver T12.
>
> **D13 y D14 no venían en la lista: salieron de verificar.** D13 la delató la propia
> captura de D11 (la barra decía «te faltan S/ 140» y el pie «GRATIS»). D14 apareció al
> mirar el menú a 375 px. **Ninguna de las dos da error de consola**, así que E1-19 las
> dio por buenas; ver T13.


## 7. Trampas conocidas

| # | Trampa |
|---|---|
| T1 | El sitio usa rutas absolutas (`/css/...`) y `fetch` de JSON: **no funciona con `file://`**. Hay que servirlo por HTTP (Live Server o Spring). |
| T2 | Había un repositorio Git enraizado en `/Users/jonatl9`. Antes de cualquier `git add`, confirma con `git rev-parse --show-toplevel` que estás dentro de `overtext-web`. |
| T3 | El `.rar` de entrega no debe llevar contraseña ni estar dañado: cuesta −3 puntos en el TF. Ábrelo en otra máquina antes de enviar. |
| T4 | **El CSS heredado le gana a Bootstrap por especificidad.** Al migrar un componente, si el estilo viejo sigue vivo, la clase de Bootstrap se aplica pero no se ve. Hay que retirar la regla antigua, no añadir `!important`. |
| T5 | **`.d-block` de Bootstrap lleva `!important`** y gana al atributo `hidden`. Para mostrar u ocultar un `.invalid-feedback` desde JS hay que añadir y quitar `.d-block`, no usar `hidden`. |
| T6 | **Un icono de fuente no se dimensiona con `width`.** Al pasar de `<img>` a Bootstrap Icons hay que cambiar el CSS a `font-size`. Dejar el `width` antiguo **no da ningún error**: el icono sale del tamaño del texto. |
| T7 | **Las capturas móviles de Chrome headless engañan.** `--window-size=375` **recorta** en vez de re-maquetar, y la página parece rota. Para medir el responsive de verdad: `iframe` de 375 px y comparar `scrollWidth` con `clientWidth`. |
| T8 | **Caché del navegador.** Hay varias copias del sitio en la máquina; antes de dar por bueno un arreglo visual, recarga con caché desactivada y confirma que estás sirviendo `app-estatico/` de este repo. |
| T9 | **`abrirPanel` / `cerrarPanel` de `carrito.js` son API pública**, no código interno: "añadir al carrito" abre el panel por JS. Siguen existiendo tras pasar a `offcanvas`, pero por dentro llaman a Bootstrap. **Quien las borre por "ya no hacen falta" rompe el flujo de añadir al carrito.** |
| T10 | **`promociones.js` no tiene lista de colores quemada, y es a propósito:** lee el nombre del DOM (`.nombre-color`) y el color con `getComputedStyle`. Por eso cambiar la paleta es editar HTML y CSS. Meter ahí un array de colores duplicaría `productos.json` (art. 7). |
| T11 | **Un color "parecido" no es el mismo color.** Los hex del configurador estaban aproximados (negro `#1A1A1A` vs `#111111`) y pasaron tres revisiones visuales sin que nadie lo notara. Los hex se copian del catálogo, no se estiman a ojo. |
| T12 | **Un `grep` de la clase pelada no basta para borrar CSS.** Da falsos positivos por substring: `.enlace` aparece en `.enlace-boletin` y `.pie-enlaces`, `.boton-carrito` en `.boton-carrito-pack`, `.activo` en `.color-opcion.activo`. Hay que mirar cada coincidencia. Y ojo con `#menu-principal`: la **regla** `.menu-principal` era CSS muerto, pero el **id** lo necesita el `collapse` de Bootstrap en las 10 páginas. |
| T13 | **Consola limpia no es sitio correcto.** D13 (un texto de negocio quemado que contradecía al JS) y D14 (el menú móvil ilegible sobre el carrusel) convivían con **0 errores y 0 avisos** en las 10 páginas. E1-19 verifica el log; el criterio 1b se juzga mirando la pantalla a 375 px. Las dos verificaciones son distintas y hacen falta las dos. |
