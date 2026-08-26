# Sistema de Diseño — OverText

Basado en el Manual de Tono y Estilo (`contexto.md`).
Todos los tokens viven en el `:root` de `css/main.css` (colores, tipografías, espaciados y layout).
`tema-overtext.css` los usa para re-tematizar los componentes de Bootstrap.

---

## Paleta de Colores

| Variable | Valor | Uso |
|----------|-------|-----|
| `--color-fondo` | `#FFFFFF` | Fondo principal del sitio |
| `--color-fondo-alt` | `#F5F5F5` | Secciones alternas, fondos de tarjetas |
| `--color-negro` | `#111111` | Texto principal, headings |
| `--color-rojo` | `#8B1A1A` | CTAs, badges de precio, borde activo en nav |
| `--color-beige` | `#C8B89A` | Neutro secundario, detalles |
| `--color-borde` | `#E5E5E5` | Líneas divisoras, bordes |
| `--color-texto-suave` | `#777777` | Texto secundario, labels |
| `--color-placeholder` | `#BDBDBD` | Placeholders de inputs |

**Regla de marca:** Blanco base, negro para texto, rojo vino (#8B1A1A) para acentos.

---

## Tipografía

Ambas familias se importan con un único `@import` de Google Fonts al inicio de `main.css`.

| Variable | Familia | Uso |
|----------|---------|-----|
| `--fuente-display` | **Oswald** | Títulos grandes, hero, cifras |
| `--fuente-principal` | **Inter** | Cuerpo, etiquetas, botones, navegación |

---

## Espaciados

| Variable | Valor | Uso |
|----------|-------|-----|
| `--espacio-xs` | `8px` | Gap interno, padding pequeño |
| `--espacio-sm` | `16px` | Gap entre elementos relacionados |
| `--espacio-md` | `24px` | Margen entre componentes |
| `--espacio-lg` | `40px` | Padding de sección compacta, gap de grid |
| `--espacio-xl` | `80px` | Padding de sección normal |
| `--espacio-xxl` | `128px` | Padding de sección prominente |

## Layout

| Variable | Valor | Uso |
|----------|-------|-----|
| `--ancho-maximo` | `1300px` | Ancho máximo del contenido |
| `--padding-contenedor` | `0 25px` | Padding lateral del contenedor |

---

## Convenciones de Clases

- Tokens CSS: `--color-*`, `--fuente-*`, `--espacio-*`, `--ancho-*` (constitución art. 2).
- Componentes: kebab-case en español: `.barra-navegacion`, `.pie-pagina`, `.tarjeta`.
- Estados: `.activo`, `.lleno`, `.vacio`.
- Modificadores tipo BEM: `.btn-talla--activa`, `.swatch--activa`, `.color-muestra--negro`.
- Las clases de Bootstrap (`navbar`, `carousel`, `offcanvas`, `row`, `col-*`) se usan tal cual.

---

## Estructura HTML estandarizada

### Header (todas las páginas) — `navbar` de Bootstrap + Bootstrap Icons:
```html
<nav class="navbar navbar-expand-lg barra-navegacion">
  <div class="container">
    <a class="navbar-brand" href="/index.html">OVERTEXT</a>
    <div class="d-flex align-items-center order-lg-last nav-acciones">
      <a href="/login.html" class="accion-navegacion" aria-label="Mi cuenta"><!-- ícono --></a>
      <button class="accion-navegacion" id="abrir-carrito" type="button" aria-label="Carrito">
        <i class="bi bi-cart3" aria-hidden="true"></i>
        <span class="carrito-contador"></span> <!-- lo llena js/carrito.js -->
      </button>
      <button class="navbar-toggler ms-2" type="button" data-bs-toggle="collapse"
              data-bs-target="#menu-principal" aria-label="Menú">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="menu-principal">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/index.html">INICIO</a></li>
        <!-- … -->
      </ul>
    </div>
  </div>
</nav>
```

### Carrito — `offcanvas` de Bootstrap:
```html
<aside class="offcanvas offcanvas-end" tabindex="-1" id="carrito-lateral">
  <div class="offcanvas-header carrito-header"> … <span class="carrito-conteo"></span> … </div>
  <div class="offcanvas-body carrito-cuerpo"> … </div>
  <div class="carrito-footer"> … <span class="total-monto"></span> … </div>
</aside>
```

### Footer (grilla Bootstrap `row`/`col-*`):
```html
<footer class="pie-pagina">
  <div class="container row g-4 pb-5">
    <div class="col-12 col-md-6 col-lg-4 pie-info"> … </div>
    <div class="col-6 col-md-3 col-lg-2 pie-enlaces"><h3>SITIO</h3><ul>…</ul></div>
    <!-- … -->
  </div>
</footer>
```

---

*Documento actualizado el 26 de agosto de 2026 (Sprint 1, José · QA).*
