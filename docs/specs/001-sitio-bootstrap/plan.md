# plan.md — 001 · Sitio estático con Bootstrap 5

**Fase SDD:** Plan
**Sprint:** 1 (20-ago → 04-sep-2026)
**Entrega:** ATF1
**Spec de origen:** [`spec.md`](spec.md) — aprobado por el Product Owner (Joaquín) el 2026-08-25
**Estado:** ✅ ejecutado. Escrito **a posteriori** el 28-ago-2026 (deuda D7).

> **Nota de honestidad.** Este documento faltaba: el `spec.md` se aprobó el 25-ago
> y se pasó directo a implementar, saltando las fases *Plan* y *Tasks* de
> `CLAUDE.md` §4. Se redacta ahora reconstruyéndolo desde el código entregado y
> desde `docs/scrum/sprints/sprint-01.md`. **No describe intenciones, describe lo
> que quedó construido**, verificado archivo por archivo. Sirve de fuente para la
> sección **2.1.2 del informe** y de línea base para el Sprint 2.

---

## 1. Qué se construyó

La solución planteada fue crear una aplicación web para el e-commerce OverText.
En este primer avance se resolvió únicamente el **objetivo específico 1** del
spec —la interfaz con un framework CSS responsivo— más el **diseño** del modelo
de datos, que el informe del ATF1 exige como diagrama físico.

El sitio estático heredado del proyecto anterior se **migró** a Bootstrap 5.3
conservando la identidad de marca. No se reescribió desde cero: se retiró el CSS
que competía con el framework y se re-tematizó lo que Bootstrap ya resolvía.

**Resultado:** 10 páginas HTML, sin backend, con el carrito en `localStorage`.

| Página | Rol |
|---|---|
| `index.html` | Portada, con carrusel de 3 diapositivas |
| `catalogo.html` | Grilla de los 7 productos, leída de `js/productos.json` |
| `detalle-producto.html` | Ficha con galería en carrusel y modal de guía de tallas |
| `promociones.html` | Configurador de packs de 6 prendas |
| `nosotros.html` | Marca e historia |
| `contacto.html` | Formulario validado + modal de confirmación |
| `login.html` | Formulario de inicio de sesión |
| `checkout.html` | Proceso de compra en 3 pasos |
| `confirmacion.html` | Comprobante del pedido |
| `intranet.html` | Panel de administración (cifras aún estáticas) |

## 2. Decisión de arquitectura: cuatro capas de CSS

El problema real del proyecto heredado no era la falta de framework, sino que su
CSS propio **le ganaba a Bootstrap por especificidad** (trampa T1 de `memory.md`).
Añadir Bootstrap encima sin retirar lo viejo habría dado un sitio donde las
clases del framework se aplican pero no se ven.

Por eso el CSS se ordenó en cuatro capas, y **se cargan en este orden**:

```
1. Bootstrap 5.3 (CDN)      → el componente
2. css/tema-overtext.css    → variables de marca que re-tematizan Bootstrap
3. css/main.css + layout.css→ reset, tipografía y rejilla propia
4. css/componentes/*.css    → capa de tema por componente (10 archivos)
5. css/paginas/*.css        → ajustes de una sola página (10 archivos)
```

La regla que gobierna el reparto es el **artículo 4** de la constitución: si
Bootstrap tiene el componente, se usa el suyo y solo se re-tematiza. El CSS
propio **tematiza, no sustituye**. Cuando un estilo heredado estorbaba, se
retiró la regla; nunca se añadió `!important` encima.

**Consecuencia práctica:** `css/style.css` (616 líneas) se eliminó entero en vez
de arreglarlo, porque su `:root` competía con el del tema.

## 3. Cómo se cubre cada componente de la rúbrica

Los seis componentes del criterio 1 son **de Bootstrap**, no reimplementados
(artículo 4). Lo propio es la capa de tema.

| Criterio | Componente de Bootstrap | Dónde vive | Capa de tema |
|---|---|---|---|
| 1a Contenedores | `.container` / `.container-fluid` | las 10 páginas | `layout.css` |
| 1b Menú responsivo | `navbar navbar-expand-lg` + `navbar-toggler` + `collapse` | las 10 páginas | `componentes/navegacion.css` |
| 1b Panel del carrito | `offcanvas offcanvas-end` | 6 páginas con carrito | `componentes/carrito.css` |
| 1c Formularios | `form-control` / `form-select` / `form-check` + `was-validated` | contacto, login, checkout | `componentes/formularios.css` |
| 1d Modales | `modal` | contacto (confirmación), detalle-producto (guía de tallas) | `componentes/modal.css` |
| 1e Carrusel | `carousel` | `#carrusel-portada` (index), `#carrusel-galeria` (detalle) | `componentes/carrusel.css` |
| 1f Grillas | `row` / `col-*` | catálogo, promociones, nosotros y el pie de las 10 | `layout.css` |

**Extras del sílabo sin rúbrica** (decisión 9 de `memory.md`): tabla de tallas con
`table table-striped table-hover` (`componentes/tablas.css`), Bootstrap Icons en
lugar de los PNG de 4-5 MB, y los estilos de párrafo del tema.

## 4. Cómo se organizó el JavaScript

JS vanilla, un archivo por responsabilidad, sin framework ni bundler: el sílabo
no los ha dictado y el artículo 8 prohíbe añadir lo que ninguna rúbrica pide.

| Archivo | Responsabilidad |
|---|---|
| `js/carrito.js` | **Fuente única del carrito.** Estado en `localStorage['ot_carrito']`, expone `window.Carrito` |
| `js/tienda.js` | Pinta el catálogo y la ficha leyendo `js/productos.json` |
| `js/contacto.js` | Validación del formulario y disparo del modal |
| `js/checkout.js` | Los 3 pasos, el ubigeo y el resumen del pedido |
| `js/confirmacion.js` | Comprobante a partir del pedido guardado |
| `js/login.js` | Inicio de sesión simulado *(credenciales en el cliente — deuda D12)* |
| `js/intranet.js` | Panel de administración |
| `js/promociones.js` | Configurador de packs *(extraído del HTML incrustado, E1-13)* |

**Regla que atraviesa todo el JS: un dato, un origen** (artículo 7).

- Los colores y precios se leen de `js/productos.json`; **ningún array de colores
  vive en el JS**. `promociones.js` lee el nombre del DOM y el color con
  `getComputedStyle` a propósito (trampa T10).
- El umbral de envío gratis existe una sola vez, en
  `carrito.js` → `UMBRAL_ENVIO_GRATIS`. La barra de progreso, el texto
  "te faltan S/ …" y la línea ENVÍO del pie del carrito se **derivan** de él.
- El badge "últimas unidades" se **calcula** desde `stock < 10`, no se guarda.

## 5. Modelo de datos: se diseña ahora, se implementa después

El ATF1 no pide base de datos, pero **sí pide su diagrama físico en el informe**.
Se decidió escribir el DDL de las **10 tablas completas** ya en este sprint, y no
solo las 3 que usará el ATF3, porque las cuatro rúbricas del curso piden el
diagrama y uno a medias no demuestra nada (decisión 16).

| Artefacto | Qué es |
|---|---|
| `esquema-fisico.sql` | **Fuente autoritativa.** Tipos, PK/FK/UK, `ON DELETE`, `CHECK`, índices |
| `data-model.md` | Vista lógica y diccionario de datos |
| `diagrama-fisico-bd.md` | Cómo leer el diagrama |
| `informes/capturas/sprint-01/diagrama-fisico-bd.svg` | La Figura 1 del informe |

Las 10 tablas: `categoria`, `producto`, `color`, `variante_producto`,
`imagen_producto`, `rol`, `usuario`, `pedido`, `detalle_pedido`,
`mensaje_contacto`.

**Si `data-model.md` y el `.sql` discrepan, gana el `.sql`** (decisión 15). El
diagrama del informe se **genera** desde ahí, no se dibuja a mano.

## 6. Qué quedó deliberadamente fuera

| Fuera de alcance | Por qué |
|---|---|
| Backend, base de datos, seguridad real | Spring Boot se dicta desde la semana 5 (decisión 8) |
| Profundizar el checkout, el ubigeo y el configurador de packs | Funcionan y no dan puntos de rúbrica (decisión 6, artículo 8) |
| Historial de pedidos | `localStorage['ot_pedido']` se sobrescribe. Se resuelve en el TF con la tabla `pedido` (I4 del spec) |
| Credenciales reales | `js/login.js` compara en el cliente. Se borra con Spring Security (deuda D12) |

## 7. Riesgos que se materializaron, y cómo se resolvieron

| Riesgo previsto | Qué pasó |
|---|---|
| El CSS heredado le gana a Bootstrap por especificidad | Ocurrió. Se resolvió **retirando** la regla vieja, nunca con `!important` (T4) |
| El carrusel no existía y vale un sexto del criterio 1 | Se hizo en la sesión 7 como estaba planeado. Tolera productos sin galería |
| 39 MB de `assets/` inflan el `.rar` | Bajó a **3,7 MB**, ninguna imagen sobre 300 KB (E1-11 + E1-16) |
| Incoherencias heredadas entre HTML, JS y copy | Las tres decisiones del PO (I1, I2, I3) se cerraron como deudas D3 y D4 |

**Riesgos que aparecieron y no estaban previstos:**

- `.d-block` de Bootstrap lleva `!important` y gana al atributo `hidden`, así que
  mostrar un `.invalid-feedback` desde JS obliga a añadir y quitar `.d-block` (T5).
- Un icono de fuente no se dimensiona con `width`; al pasar de `<img>` a Bootstrap
  Icons hay que cambiar el CSS a `font-size`, **y dejarlo mal no da ningún error** (T6).
- Las capturas móviles de Chrome headless **recortan** en vez de re-maquetar (T7).

## 8. Verificación

La condición de entrega es el **artículo 3: cero errores en consola**, en las 10
páginas, a 375 px y a 1440 px. Se verificó en la Sprint Review (E1-19), y el
`favicon.svg` cerró el último 404.

El sitio usa rutas absolutas (`/css/…`) y `fetch` de JSON: **no funciona con
`file://`**. Toda verificación se hace sirviendo por HTTP (T1).

## 9. Lista de verificación del plan

- [x] Cada componente de la rúbrica se traza a un componente de Bootstrap real
- [x] Ninguna capa ni dependencia que la rúbrica no pida (artículo 8)
- [x] Ningún dato duplicado entre HTML, JS y copy (artículo 7)
- [x] El modelo de datos tiene una fuente autoritativa única
- [x] Lo que queda fuera de alcance está dicho explícitamente
- [x] **Siguiente fase:** [`tasks.md`](tasks.md)
