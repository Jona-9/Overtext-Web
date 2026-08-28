# tasks.md — 001 · Sitio estático con Bootstrap 5

**Fase SDD:** Tasks
**Sprint:** 1 (20-ago → 04-sep-2026) — **cerrado el 28-ago-2026**
**Entrega:** ATF1 — entregada
**Depende de:** `spec.md` (aprobado 2026-08-25) y `plan.md`
**Estado:** redactado el 2026-08-28 · pendiente de checkpoint del PO

> **Igual que `plan.md`, este documento es retroactivo (deuda D7).**
> Las 26 tareas se ejecutaron sin haberse escrito antes en un `tasks.md`. Lo que
> sigue es el desglose real, reconstruido desde `docs/scrum/sprints/sprint-01.md`,
> las memorias de los 6 integrantes y el código de `app-estatico/`. Sirve como
> registro de trazabilidad y como plantilla para el `tasks.md` del Sprint 2, que
> **sí** se escribirá antes de implementar.

**Leyenda:** ✅ hecho y verificado · 🟨 en curso · ⬜ pendiente

---

## Duo UI / Front — Joaquín · Dayro

| # | Tarea | Criterio | Entregable | Estado |
|---|---|:-:|---|:-:|
| E1-01 | Bootstrap 5.3.3 por CDN + `tema-overtext.css` con la paleta de marca | 1a | `css/tema-overtext.css` | ✅ |
| E1-02 | Header como `navbar navbar-expand-lg` en las 10 páginas; se elimina `js/nav.js` | 1b | `css/componentes/navegacion.css` | ✅ |
| E1-03 | Envolver todas las páginas en `.container` / `.container-fluid` | 1a | las 10 `.html` | ✅ |
| E1-04 | Carrusel de portada: 3 diapositivas, controles, indicadores, autoavance con pausa | **1e** | `#carrusel-portada` | ✅ |
| E1-05 | Carrusel de galería en la ficha, tolerante a los 5 productos sin galería | **1e** | `#carrusel-galeria` | ✅ |
| E1-06 | Grillas `row`/`col-*` en catálogo, promociones, nosotros y pie | 1f | `css/paginas/*` | ✅ |
| E1-25 | `[SÍLABO]` Estilos de párrafo tipográficos en el tema | — | `.texto-guia`, `.parrafo-marca`, `.texto-apoyo`, `.antetitulo`, `.enfasis-marca` | ✅ |

## Duo Datos / Backend — Jonathan · Carlos

| # | Tarea | Criterio | Entregable | Estado |
|---|---|:-:|---|:-:|
| E1-07 | Contacto, login y compra a `form-control`/`form-select`/`form-check` + `was-validated` | 1c | `css/componentes/formularios.css` | ✅ |
| E1-08 | Modal de confirmación de contacto (migra el modal propio de 102 líneas) | 1d | `contacto.html`, `js/contacto.js` | ✅ |
| E1-09 | Modal de guía de tallas en la ficha de producto | 1d | `detalle-producto.html` | ✅ |
| E1-10 | Panel del carrito convertido en `offcanvas`, conservando `abrirPanel`/`cerrarPanel` | 1b | `js/carrito.js`, `css/componentes/carrito.css` | ✅ |
| E1-11 | Bootstrap Icons 1.11.3 en lugar de los PNG de 4-5 MB | 1a | las 10 `.html` | ✅ |
| E1-22 | Diagrama físico de la base de datos, generado desde el modelo | **3** | `diagrama-fisico-bd.svg` / `.png` | ✅ |
| E1-26 | `[SÍLABO]` Guía de tallas con `table table-striped table-hover` | — | `css/componentes/tablas.css` | ✅ |

## Duo Documento / QA — José · Jhade

| # | Tarea | Criterio | Entregable | Estado |
|---|---|:-:|---|:-:|
| E1-12 | Eliminar `css/style.css` (616 líneas de código muerto, `:root` en conflicto) | 2b | — | ✅ |
| E1-13 | Extraer el script incrustado de `promotions.html` a `js/promociones.js` | 2a, 2b | `js/promociones.js` | ✅ |
| E1-14 | Eliminar los 15 estilos en línea | 2b | las 10 `.html` | ✅ |
| E1-15 | Quitar los valores de relleno que parpadean al cargar | 2b, 2d | las 10 `.html` | ✅ |
| E1-16 | Optimizar `assets/` de 39 MB a menos de 15 MB | — | **3,7 MB**, ninguna imagen sobre 300 KB | ✅ |
| E1-17 | Reescribir `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` con la estructura real | 2a | `app-estatico/docs/` | ✅ |
| E1-18 | Verificar kebab-case archivo por archivo | **2c** | `promotions.html` → `promociones.html` | ✅ |
| E1-20 | Limpiar la plantilla UTP; añadir Docente, Recomendaciones y Anexos | 3 | `informes/informe.md` | ✅ |
| E1-21 | Redactar 1.1, 1.2, 2.1, 2.2 y 2.3 del informe | **3** | documento propio de Jhade | ✅ |
| E1-23 | Capturas de las 10 páginas + foto de la estructura del proyecto | 3 | `informes/capturas/sprint-01/` | ✅ |
| E1-24 | Empaquetar `ATF1_GRUPO_01` y verificar en otra máquina | **4** | `.pdf` + `.rar`, sin contraseña | ✅ |

## Todo el equipo

| # | Tarea | Criterio | Entregable | Estado |
|---|---|:-:|---|:-:|
| E1-19 | Consola sin errores en las 10 páginas, a 375 y 1440 px | **2d** | 0 errores, 0 avisos; `favicon.svg` cierra el último 404 | ✅ |
| — | Crear y mantener `docs/memoria/<nombre>_memory.md` | — | 6 memorias | ✅ |

---

## Bloqueo previo: checkpoint del Product Owner

El `spec.md` traía tres `[NECESITA ACLARACIÓN]` que condicionaban el modelo de datos y el
contenido. Joaquín las resolvió el **2026-08-25**, y de ahí salieron dos tareas de
corrección que **no estaban en el plan original**:

| Decisión | Resultado | Tarea que generó |
|---|---|---|
| I1 · Lista de colores válida | La del catálogo (`productos.json`): 7 colores, **el BLANCO nunca existió** | **D3** |
| I2 · Umbral de envío gratis | **S/ 200** (el copy de marca manda sobre el JS) | **D4** |
| I3 · Badge de stock bajo | Se **calcula** con `stock < 10`, no se guarda | E1-22 (modelo) |

## Deudas cerradas después del sprint

Tareas que no estaban en el desglose inicial y salieron de la ejecución.

| # | Tarea | Cerrada |
|:-:|---|---|
| D1 | `assets/` de ~39 MB a menos de 15 MB | ✅ 3,7 MB (E1-11 + E1-16) |
| D2 | Eliminar `css/style.css` y su `:root` en conflicto | ✅ E1-12 |
| D3 | Alinear los 7 colores del configurador con `productos.json` | ✅ 28-ago · hex copiados, no aproximados |
| D4 | `UMBRAL_ENVIO_GRATIS = 200` en `js/carrito.js` | ✅ 28-ago |
| D5 | Reescribir los docs de CSS, que describían archivos inexistentes | ✅ E1-17 |
| D6 | Borrar el backup del `.git` roto del *home* | ✅ 28-ago · ya no existe |
| D8 | Retirar `.color-borgona` y `.swatch--blanco` (colores inexistentes) | ✅ 28-ago |
| D9 | Dejar una sola definición de `.ot-icono-whatsapp` | ✅ 28-ago · vive en `paginas/login.css` |
| D10 | Retirar el CSS del menú anterior en `componentes/navegacion.css` | ✅ 28-ago · −191 líneas |
| D11 | Retomar las capturas del offcanvas con el umbral de S/ 200 | ✅ 28-ago · S/ 140 restantes |

## Lo que sigue abierto

| # | Pendiente | Destino |
|:-:|---|---|
| **D7** | Este `tasks.md` y `plan.md` existen, pero **falta la aprobación del PO** | Sprint 2, lo primero |
| D12 | `js/login.js` tiene las credenciales en el cliente | Sprint 6, E4-08 (Spring Security) |
| **D13** | El pie del carrito dice **"ENVÍO — GRATIS"** siempre, esté o no alcanzado el umbral | Sprint 2 · **necesita dueño** |

---

## Lista de verificación de tasks

- [x] Toda tarea se traza a una historia del `spec.md` y a un criterio de rúbrica
- [x] Toda tarea tiene duo responsable y entregable identificable
- [x] Las decisiones del PO están registradas con fecha
- [x] Las deudas abiertas tienen destino explícito
- [ ] **Checkpoint: aprobación del Product Owner**
