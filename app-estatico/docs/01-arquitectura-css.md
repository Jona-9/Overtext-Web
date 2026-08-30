# Arquitectura CSS — OverText E-Commerce

## Metodología: capas tipo ITCSS + Bootstrap 5

El CSS se organiza en **capas de especificidad creciente**: primero el framework
(Bootstrap 5 por CDN), luego los **tokens** y el tema propio, después el layout, los
**componentes** (un archivo por tipo de elemento) y por último lo **específico de cada
página**. Bootstrap aporta los componentes (navbar, carrusel, modal, offcanvas, grilla);
el CSS propio existe para **tematizar**, no para reimplementarlos (constitución art. 4).

**Regla central:** si un estilo aparece en 2+ páginas → va a `componentes/`.
Si solo se usa en una página → va a `paginas/`.

---

## Estructura real de `css/`

```
css/
├── main.css               ← Tokens (:root), @import de Google Fonts (Oswald + Inter) y reglas base
├── tema-overtext.css      ← Capa de tema sobre Bootstrap (re-tematiza sus componentes)
├── layout.css             ← Contenedor, grillas y estructuras de sección
│
├── componentes/           ← UN archivo por tipo de elemento (10)
│   ├── navegacion.css     ← Header, navbar, ícono y contador del carrito
│   ├── footer.css         ← Pie de página
│   ├── botones.css        ← Botones del sitio
│   ├── formularios.css    ← inputs, labels, textarea, selects
│   ├── tablas.css         ← table, thead, tbody, th, td
│   ├── tarjetas.css       ← cards de producto y de contacto
│   ├── badges.css         ← etiquetas, tags, contadores
│   ├── modal.css          ← modales (guía de tallas, confirmación)
│   ├── carrusel.css       ← carrusel de portada y de galería
│   └── carrito.css        ← panel lateral (offcanvas) del carrito
│
└── paginas/               ← Solo lo ESPECÍFICO de cada página (10)
    ├── inicio.css
    ├── catalogo.css
    ├── producto.css
    ├── promociones.css
    ├── checkout.css
    ├── confirmacion.css
    ├── login.css
    ├── intranet.css
    ├── nosotros.css
    └── contacto.css
```

> **Nota:** el antiguo `css/style.css` (monolito de 616 líneas, código muerto con un `:root`
> en conflicto) se **eliminó** en el Sprint 1 (tarea E1-12). No existen `variables.css`,
> `reset.css`, `base.css` ni la carpeta `layout/`: sus responsabilidades viven en
> `main.css`, `tema-overtext.css` y `layout.css`.

---

## Cómo enlazar CSS en cada página

Bootstrap y sus iconos por CDN primero; luego el CSS propio en orden de capa:

```html
<!-- 1. Framework -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<!-- 2. Tokens + tema + layout -->
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/tema-overtext.css">
<link rel="stylesheet" href="/css/layout.css">

<!-- 3. Componentes (solo los que usa esta página) -->
<link rel="stylesheet" href="/css/componentes/navegacion.css">
<link rel="stylesheet" href="/css/componentes/footer.css">
<!-- + botones, formularios, tarjetas, badges, carrito… según página -->

<!-- 4. Página específica (siempre al final) -->
<link rel="stylesheet" href="/css/paginas/inicio.css">
```

---

## Qué archivo de página usa cada HTML

| Página | Archivo de página |
|--------|-------------------|
| index.html | inicio.css |
| catalogo.html | catalogo.css |
| detalle-producto.html | producto.css |
| promociones.html | promociones.css |
| nosotros.html | nosotros.css |
| contacto.html | contacto.css |
| login.html | login.css |
| checkout.html | checkout.css |
| confirmacion.html | confirmacion.css |
| intranet.html | intranet.css |

---

## Limpieza aplicada en el Sprint 1 (criterio 2b)

| Problema anterior | Solución |
|---|---|
| `style.css` de 616 líneas mezclando todo, con `:root` en conflicto | Eliminado por completo (E1-12) |
| Script del configurador de packs incrustado en `promociones.html` | Extraído a `js/promociones.js` (E1-13) |
| Estilos en línea en `catalogo.html`, `index.html` y `promociones.html` | Movidos a sus archivos de página / componente (E1-14) |
| Valores de carrito escritos a mano que parpadeaban al cargar | Vaciados; los llena `js/carrito.js` (E1-15) |
| `promotions.html` en inglés | Renombrado a `promociones.html`, kebab-case en español (E1-18) |

---

*Documento actualizado el 26 de agosto de 2026 (Sprint 1, José · QA).*
