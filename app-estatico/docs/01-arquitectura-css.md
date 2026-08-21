# Arquitectura CSS — OverText E-Commerce

## Metodología: CSS Modular por Responsabilidad

El profesor indicó que el CSS debe estar dividido de forma que cada archivo afecte **solo a un tipo de elemento**. Este enfoque se llama CSS Modular o arquitectura por capas.

**Regla central:** Si un estilo aparece en 2+ páginas → va a `componentes/`. Si solo se usa en una página → va a `paginas/`.

---

## Estructura de Carpetas

```
css/
├── variables.css          ← Tokens de diseño (colores, fuentes, espaciados)
├── reset.css              ← Reset/normalize compartido
├── base.css               ← body, fuentes (Google Fonts import)
│
├── componentes/           ← UN archivo por tipo de elemento
│   ├── navegacion.css     ← Header, logo, menú, ícono de carrito
│   ├── footer.css         ← Pie de página
│   ├── botones.css        ← TODOS los botones del sitio
│   ├── formularios.css    ← inputs, labels, textarea, selects
│   ├── tablas.css         ← table, thead, tbody, th, td
│   ├── tarjetas.css       ← cards de producto y de contacto
│   └── badges.css         ← etiquetas, tags, contadores
│
├── layout/
│   ├── contenedor.css     ← .contenedor, grids reutilizables
│   └── secciones.css      ← portada, proceso, detalle, hero-strip
│
└── paginas/               ← Solo lo ESPECÍFICO de cada página
    ├── inicio.css
    ├── catalogo.css
    ├── producto.css
    ├── promociones.css
    ├── checkout.css
    ├── login.css
    ├── nosotros.css
    └── contacto.css
```

---

## Cómo Enlazar CSS en Cada Página

```html
<!-- 1. Variables (siempre primero) -->
<link rel="stylesheet" href="/css/variables.css">
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/base.css">

<!-- 2. Layout -->
<link rel="stylesheet" href="/css/layout/contenedor.css">
<link rel="stylesheet" href="/css/layout/secciones.css">

<!-- 3. Componentes (solo los que usa esta página) -->
<link rel="stylesheet" href="/css/componentes/navegacion.css">
<link rel="stylesheet" href="/css/componentes/footer.css">
<link rel="stylesheet" href="/css/componentes/botones.css">
<!-- + formularios, tablas, tarjetas, badges según página -->

<!-- 4. Página específica (siempre último) -->
<link rel="stylesheet" href="/css/paginas/inicio.css">
```

---

## Qué Archivos Usa Cada Página

| Página | Componentes adicionales | Archivo de página |
|--------|------------------------|-------------------|
| index.html | formularios, badges | inicio.css |
| catalogo.html | tarjetas, badges | catalogo.css |
| detalleProducto.html | formularios, tablas, badges | producto.css |
| promotions.html | badges | promociones.css |
| nosotros.html | formularios | nosotros.css |
| contacto.html | tarjetas, tablas, badges | contacto.css |
| login.html | formularios | login.css |
| fc_*.html | formularios, tarjetas | checkout.css |

---

## Problemas Resueltos

| Problema anterior | Solución |
|---|---|
| Variables CSS en 5 archivos con valores distintos | `variables.css` única fuente de verdad |
| Navegación copiada en 4+ archivos | `componentes/navegacion.css` compartido |
| `--rojo-acent` con 3 valores distintos | Un solo `--color-rojo: #8B1A1A` |
| `style.css` de 600+ líneas mezclando todo | 15 archivos con una responsabilidad cada uno |
| Clases en inglés en contacto vs español en el resto | Nomenclatura unificada en español |
| Inline styles en HTML | Movidos a los archivos CSS correspondientes |

---

*Documento generado el 2 de mayo de 2026*
