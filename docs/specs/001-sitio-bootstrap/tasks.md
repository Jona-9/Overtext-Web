# tasks.md — 001 · Sitio estático con Bootstrap 5

**Fase SDD:** Tasks
**Sprint:** 1 (20-ago → 04-sep-2026) · **Entrega:** ATF1
**Plan de origen:** [`plan.md`](plan.md)
**Estado:** ✅ todas ejecutadas. Escrito **a posteriori** el 28-ago-2026 (deuda D7).

> Igual que `plan.md`, este archivo faltaba y se reconstruye desde
> `docs/scrum/sprints/sprint-01.md`, desde el historial de Git y desde el código
> entregado. **Toda tarea lleva su criterio de rúbrica entre paréntesis**, como
> exige el artículo 1 de la constitución.
>
> Leyenda: ✅ hecha y verificada · 🟨 hecha con deuda abierta

---

## Orden de ejecución

`E1-01` (tema) y `E1-02` (navbar) **desbloquean todo lo demás**: nadie maqueta
sobre una base que va a cambiar. Se hicieron y se integraron el día 1.

```
Día 1-2   E1-01 tema → E1-02 navbar → parten los tres duos
Día 3-6   UI: contenedores, grillas, carruseles
          Datos: formularios, modales, offcanvas, modelo de datos
          Doc/QA: limpieza, assets, plantilla del informe
Día 7-9   Integración, redacción, capturas
Día 10    Verificación con checklist y empaquetado
```

---

## Duo UI / Front — Joaquín · Dayro

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E1-01 | Cargar Bootstrap 5.3 por CDN y crear `tema-overtext.css` con la paleta de marca | ATF1-1a | ✅ | `css/tema-overtext.css`, `<link>` en las 10 páginas |
| E1-02 | Header como `navbar navbar-expand-lg` responsivo, con `navbar-toggler` y `collapse` | ATF1-1b | ✅ | las 10 páginas + `componentes/navegacion.css` |
| E1-03 | Envolver cada página en `.container` / `.container-fluid`, retirando el `.contenedor` propio | ATF1-1a | ✅ | las 10 páginas + `layout.css` |
| E1-04 | Carrusel de portada: 3+ diapositivas, controles, indicadores y autoavance con pausa al pasar el cursor | **ATF1-1e** | ✅ | `index.html#carrusel-portada` |
| E1-05 | Carrusel de la galería de la ficha, tolerante a los 5 productos sin galería | **ATF1-1e** | ✅ | `detalle-producto.html#carrusel-galeria` |
| E1-06 | Grillas `row`/`col-*` en catálogo, promociones, nosotros y el pie | ATF1-1f | ✅ | `col-12/col-sm-6/col-lg-4/col-xl-3` |
| E1-25 | `[SÍLABO]` Estilos de párrafo tipográficos en el tema | — | ✅ | `.texto-guia`, `.parrafo-marca`, `.texto-apoyo`, `.antetitulo`, `.enfasis-marca` |

## Duo Datos / Backend — Jonathan · Carlos

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E1-07 | Formularios de contacto, login y compra a `form-control`/`form-select`/`form-check` con `was-validated` | ATF1-1c | ✅ | `contacto.html`, `login.html`, `checkout.html` |
| E1-08 | Modal de confirmación de contacto, sustituyendo el modal propio de 102 líneas | ATF1-1d | ✅ | `contacto.html` + `componentes/modal.css` |
| E1-09 | Modal de guía de tallas en la ficha de producto | ATF1-1d | ✅ | `detalle-producto.html` |
| E1-10 | Panel del carrito convertido en `offcanvas offcanvas-end` | ATF1-1b | ✅ | 6 páginas + `componentes/carrito.css` |
| E1-11 | Bootstrap Icons en lugar de los PNG de 4-5 MB | ATF1-1a | ✅ | header, WhatsApp flotante y login |
| E1-22 | Diagrama físico de la base de datos y su DDL | **ATF1-3** | ✅ | `esquema-fisico.sql` (10 tablas) + `diagrama-fisico-bd.svg` |
| E1-26 | `[SÍLABO]` Tabla de tallas con `table table-striped table-hover` | — | ✅ | modal de guía de tallas + `componentes/tablas.css` |

## Duo Documento / QA — José · Jhade

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E1-12 | Eliminar `css/style.css` (616 líneas muertas, `:root` en conflicto) | ATF1-2b | ✅ | archivo borrado |
| E1-13 | Extraer el script incrustado de `promotions.html` a `js/promociones.js` | ATF1-2a, 2b | ✅ | `js/promociones.js` |
| E1-14 | Eliminar los 15 estilos en línea | ATF1-2b | ✅ | 0 `style=` de maquetación |
| E1-15 | Quitar los valores de relleno que parpadean al cargar | ATF1-2b, 2d | ✅ | badge del carrito con `:empty { display: none }` |
| E1-16 | Optimizar `assets/` de 39 MB a menos de 15 MB | — | ✅ | **3,7 MB**, ninguna imagen sobre 300 KB |
| E1-17 | Actualizar `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` a la estructura real | ATF1-2a | ✅ | cerró la deuda D5 |
| E1-18 | Verificar kebab-case archivo por archivo | **ATF1-2c** | ✅ | `promotions.html` → `promociones.html` |
| E1-20 | Limpiar la plantilla UTP; añadir Docente, Recomendaciones y Anexos | ATF1-3 | ✅ | `informes/informe.md` |
| E1-21 | Redactar 1.1, 1.2, 2.1, 2.2 y 2.3 del informe | **ATF1-3** | ✅ | documento propio de Jhade (decisión 18) |
| E1-23 | Capturas de las 10 páginas + foto de la estructura | ATF1-3 | ✅ | `informes/capturas/sprint-01/` |
| E1-24 | Empaquetar `ATF1_GRUPO_01` y verificarlo en otra máquina | **ATF1-4** | ✅ | `.pdf` + `.rar`, sin contraseña |

## Todo el equipo

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E1-19 | Verificar consola sin errores en las 10 páginas, a 375 y 1440 px | **ATF1-2d** | ✅ | 0 errores, 0 avisos. `favicon.svg` cerró el último 404 |
| — | Crear y mantener la memoria personal | — | ✅ | `docs/memoria/<nombre>_memory.md` |

---

## Tareas nacidas de las decisiones del Product Owner

El `spec.md` §6 dejó tres incoherencias heredadas. El PO las resolvió el 25-ago,
pero **no se convirtieron en tareas con dueño**, y esperaron tres días a un "duo
dueño" que no existía. De ahí sale la decisión 19 de `memory.md`.

| # | Tarea | Decisión | Criterio | Estado |
|---|---|:-:|:-:|:-:|
| D3 | Alinear los 7 colores del configurador con `productos.json`: fuera BLANCO, dentro MARRÓN, BORGOÑA→GUINDA, OLIVO→OLIVA, y los hex copiados del catálogo | I1 | ATF1-2b (art. 7) | ✅ |
| D4 | `UMBRAL_ENVIO_GRATIS = 200` en `js/carrito.js` y en la barra del carrito | I2 | ATF1-2b (art. 7) | ✅ |
| — | Badge de stock bajo calculado con `stock < 10`, no almacenado | I3 | — | ✅ diseñado en `data-model.md` (M4/RN5); se implementa en el ATF3 |

## Limpieza de cierre — 28-ago-2026

Deudas del Sprint 1 saldadas antes de arrancar el Sprint 2.

| # | Tarea | Criterio | Estado | Cómo se cerró |
|---|---|:-:|:-:|---|
| D6 | Borrar el `.git` roto del *home* | art. 6 | ✅ | `~/.git-ROTO-backup-20260820` ya no existe; `git rev-parse` desde el *home* falla, como debe |
| D7 | Escribir `plan.md` y `tasks.md` | ATF1-3 (art. 4 de CLAUDE.md) | ✅ | este archivo y [`plan.md`](plan.md) |
| D8 | Retirar el CSS muerto que nombra colores inexistentes | ATF1-2b | ✅ | fuera `.swatch--blanco` y **las 9** reglas `.color-*` del catálogo: ninguna estaba en el HTML, los swatches se pintan con el hex de `productos.json` |
| D9 | Dejar una sola definición de `.ot-icono-whatsapp` | ATF1-2b | ✅ | consolidada en `paginas/login.css`, su única página de uso. **`.ot-boton-whatsapp` también estaba duplicada** y se consolidó igual |
| D10 | Retirar el CSS muerto de `componentes/navegacion.css` | ATF1-2b | ✅ | fuera el navbar pre-Bootstrap completo: `.btn-hamburger*`, `.menu-principal*`, `.lista-enlaces`, `.enlace*`, `.marca-logo`, `.navegacion-interior`, `.boton-usuario*`, `.boton-carrito*`. **262 → 88 líneas** |
| D11 | Rehacer las capturas del offcanvas | ATF1-3 | ✅ | `carrito-offcanvas-1440.png` regenerada. La de 375 ya era correcta |
| D13 | La línea ENVÍO del carrito decía `GRATIS` quemado en el HTML | ATF1-2b (art. 7) | ✅ | destapada al revisar D11: contradecía a la barra "te faltan S/ 140". Ahora se deriva de `UMBRAL_ENVIO_GRATIS` |

---

## Lista de verificación de tareas

- [x] Toda tarea lleva su criterio de rúbrica (artículo 1)
- [x] Toda tarea tiene dueño (artículo 9 · decisión 19)
- [x] Las deudas del sprint tienen tarea propia, no quedan como nota suelta
- [x] Cada tarea dice **dónde quedó** en el código, no solo qué se pretendía
