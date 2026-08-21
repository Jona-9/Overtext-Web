# Sistema de Diseño — OverText

Basado en el Manual de Tono y Estilo (contexto.md).
Todos los tokens viven en `css/variables.css`.

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

| Variable | Familia | Uso |
|----------|---------|-----|
| `--fuente-display` | Bebas Neue | Títulos grandes, hero, cifras |
| `--fuente-principal` | Inter | Cuerpo, etiquetas, botones, navegación |

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

---

## Convenciones de Clases

- Variables CSS: `--color-*`, `--fuente-*`, `--espacio-*`, `--ancho-*`
- Componentes: kebab-case en español: `.barra-navegacion`, `.pie-pagina`, `.tarjeta`
- Estados: `.activo`, `.lleno`, `.vacio`
- Modificadores BEM-like: `.btn-talla--activa`, `.swatch--activa`

---

## Estructura HTML Estandarizada

### Header (todas las páginas):
```html
<header class="barra-navegacion">
  <div class="contenedor navegacion-interior">
    <div class="marca-logo">OVERTEXT</div>
    <nav class="menu-principal">
      <ul class="lista-enlaces">
        <li><a href="..." class="enlace activo">INICIO</a></li>
      </ul>
    </nav>
    <div class="contenedor-carrito">
      <button class="boton-carrito">
        <img src="/assets/icon/carrito-de-compras.png" alt="Carrito">
      </button>
    </div>
  </div>
</header>
```

### Footer completo:
```html
<footer class="pie-pagina">
  <div class="contenedor grid-pie">
    <div class="pie-info">
      <h2 class="pie-logo">OVERTEXT</h2>
      <p class="pie-lema">...</p>
    </div>
    <div class="pie-enlaces"><h3>SITIO</h3><ul>...</ul></div>
    <div class="pie-enlaces"><h3>AYUDA</h3><ul>...</ul></div>
    <div class="pie-boletin">
      <h3>NEWSLETTER</h3>
      <div class="formulario-minimal">
        <input type="email" placeholder="TU EMAIL">
        <button class="btn-flecha">→</button>
      </div>
    </div>
  </div>
  <div class="contenedor pie-legal">
    <hr class="divisor">
    <div class="legal-flex"><p>© 2026 OVERTEXT</p></div>
  </div>
</footer>
```

### Tabla (contacto, detalle producto):
```html
<div class="tabla-envolvente">
  <table>
    <thead><tr><th>Canal</th></tr></thead>
    <tbody><tr><td>Dato</td></tr></tbody>
  </table>
</div>
```

### Tarjeta informativa (contacto):
```html
<div class="tarjetas-grid">
  <div class="tarjeta">
    <div class="tarjeta-icono"><img src="..." alt=""></div>
    <h3>WhatsApp</h3>
    <a href="...">+51 904 501 440</a>
    <span class="badge-24">Atención 24 h</span>
  </div>
</div>
```

---

*Documento generado el 2 de mayo de 2026*
