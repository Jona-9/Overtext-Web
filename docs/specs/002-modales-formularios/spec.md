# spec.md — Ventanas modales y formularios

**Estado:** implementado, **pendiente del visto del PO (Joaquín)** — igual que D7,
esta spec es retroactiva: se escribe después del código porque el encargo llegó
directo del profesor a mitad de sprint, sin pasar por Planning. El PO confirma o
pide ajustes en el próximo Sprint Review.

**Origen:** cuatro requisitos del profesor + dos proyectos de ejemplo:
- `HTML5Application` («Gos d'atura») — navbar, formularios, un modal suelto en login.
- `ejemplo/index.html` («Gestión de Proyectos de Obra») — el que fija los dos
  arquetipos de modal que se copian aquí (ver §2).

## 1. Los 4 requisitos y su estado

| # | Requisito | Estado antes | Estado después |
|---|---|---|---|
| 1 | Login como ventana modal (obligatorio) | ❌ solo página | ✅ `#modal-login` en las 10 páginas + página intacta |
| 2 | Contáctanos (como ejemplo) | 🟨 solo página | ✅ `#modal-contactanos` en las 10 páginas + página intacta |
| 3 | Al menos un modal (obligatorio) | ✅ ya cubierto | ✅ (ahora son 6) |
| 4 | Diagrama físico de BD (obligatorio) | ✅ ya cubierto | ✅ sin cambios — ver `docs/specs/001-sitio-bootstrap/diagrama-fisico-bd.md` |

## 2. Los dos arquetipos del ejemplo, y dónde se usan

| Arquetipo | Cómo se abre | Dónde se usa en OverText |
|---|---|---|
| **Detalle** (solo lectura, `modal-lg`, pares etiqueta/valor) | botón **Ver** en una fila de tabla | `#modal-detalle-producto` en `intranet.html` |
| **Alta** (formulario, `mb-3` + `form-label`) | botón **+ Nuevo …** | `#modal-nuevo-producto` en `intranet.html` |

## 3. Las 6 ventanas modales

| Modal | Páginas | Contenido |
|---|---|---|
| `#modal-login` | Las 10 (icono de cuenta) | Mismo formulario que `login.html`, sufijo `-modal` en los `id` de campo, mismo `name` para que `login.js` valide ambos con un solo selector `.formulario-sesion` |
| `#modal-contactanos` | Las 10 (pie, botón «ESCRÍBENOS») | Mismo formulario que `contacto.html`, sufijo `-modal` en los `id`, misma clase `.form-contacto` |
| `#modal-contacto` | Las 10 (antes solo `contacto.html`) | Confirmación de envío; `contacto.js` lo abre encadenado tras cerrar el formulario que se usó, sin apilar backdrops |
| `#modal-detalle-producto` | `intranet.html` | Arquetipo "detalle": lee `event.relatedTarget.dataset.id` para saber qué producto mostrar |
| `#modal-nuevo-producto` | `intranet.html` | Arquetipo "alta": valida con Bootstrap, sin persistencia (el CRUD real es del ATF3) |
| `#modal-cerrar-sesion` | `intranet.html` | Reemplaza el `confirm()` nativo que tenía `js/intranet.js` |

## 4. Decisiones de esta spec

1. **`login.html` y `contacto.html` se conservan** como páginas completas. El
   modal no las reemplaza — el pie de `#modal-login` enlaza a `/login.html`
   («Abrir en página completa»). Así no se invalida la evidencia del ATF1
   (capturas `formulario-inicio-sesion-*.png`, `modal-contacto-*.png`).
2. **Un solo modal de confirmación** (`#modal-contacto`) para la página y para
   `#modal-contactanos`: no se duplica el componente (constitución art. 7).
3. **Sufijo `-modal` en los `id` de campo** que se repiten entre página y modal
   (`usuario-modal`, `contacto-nombre-modal`, …); el `name` se mantiene igual
   para que el JS los lea por `querySelector('[name="…"]')` sin duplicar lógica.
4. **Tema propio, no los headers de color del ejemplo.** El profesor usa
   `modal-header bg-primary`/`bg-success` con `btn-close-white`; se mantiene la
   caja de esquinas rectas y el título en la fuente display de la marca
   (constitución art. 2) — el ejemplo enseña el componente, no la paleta.
5. **Sin persistencia en el alta de producto.** `#modal-nuevo-producto` valida y
   cierra, pero no escribe en `productos.json`: el CRUD con backend es del ATF3
   (art. 8, no se amplía el alcance).
6. **El badge de "Estado"** en la tabla de productos reutiliza el campo `badge`
   que ya trae `productos.json` — no se agrega una columna de stock nueva
   (decisión 14: es un dato calculado, no se guarda).

## 5. Deuda que esta spec cerró de paso

`paginas/login.css` duplicaba y le ganaba por orden de carga a
`componentes/botones.css` y `componentes/formularios.css` en tres selectores
(`.ot-boton-ingresar`, `.ot-olvide-contrasena`, `.ot-campo`/`.ot-campo-fila`) —
misma familia que D15. Se resolvió dejando una sola definición por selector: el
detalle está en `docs/memoria/jonathan_memory.md`.

## 6. Fuera de alcance

- El informe (`informes/informe.md`) y la parte del `.docx` del profesor sobre
  «describir qué harán las ventanas» y «colores de referencia»: se hacen aparte,
  por decisión explícita del usuario en esta tarea.
- Cualquier persistencia real (backend, base de datos): llega con el ATF3/TF.
