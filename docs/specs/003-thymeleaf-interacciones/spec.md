# spec.md — 003 · Thymeleaf: menú activo, condicionales, iteraciones y enlaces

**Fase SDD:** Specify
**Sprint:** 3 (21-sep → 01-oct-2026) · **Entrega:** ATF2
**Backlog de origen:** `docs/scrum/sprints/sprint-03.md` §4, "Duo UI / Front — José · Carlos"
**Estado:** ✅ aprobado por el Product Owner (Joaquín) — 2026-09-22

> Este spec faltaba. `docs/specs/002-migracion-thymeleaf/spec.md` §2.3 excluye
> explícitamente este trabajo ("Fuera de alcance, para el Sprint 3") y no hay ninguna
> carpeta `003-*` hasta ahora. `sprint-03.md` es el backlog operativo (tareas, sesiones,
> riesgos), pero no resuelve las decisiones de diseño que exige CLAUDE.md §4 antes de
> tocar código. **A diferencia de las deudas D7 (Sprint 1) y D16 (Sprint 2), esta vez el
> checkpoint se pidió antes de implementar, no después.** José escribió este documento;
> Joaquín lo revisó y lo aprobó el mismo día, sin ajustes — ver su bitácora
> (`docs/memoria/joaquin_memory.md`, Sprint 3).

---

## 1. Situación problemática

El catálogo y el configurador de packs, aunque ya se sirven desde Spring/Thymeleaf
(spec 002), siguen pintando su contenido del lado del cliente:

- `catalogo.html` tiene el grid de tarjetas **vacío** en el HTML; lo rellena
  `static/js/tienda.js` con `fetch('/js/productos.json')` + `innerHTML`.
- `promociones.html` tiene los **7 colores del configurador escritos a mano**, uno por
  cada producto del catálogo, con su hex duplicado en `static/css/paginas/promociones.css`.
- El menú de navegación, el badge de stock/carrito vacío y los enlaces internos tienen
  piezas sueltas: el enlace activo ya usa `th:classappend` (E2-08, cerrado), pero los
  condicionales (`th:if`) y los `th:href="@{...}"` en todos los enlaces siguen pendientes.

El criterio ATF2-2 (Thymeleaf, 6 pts) exige un **bloque repetitivo** (`th:each`) en
tarjetas o listas y un **condicional** de renderizado — ninguno de los dos existe todavía
con Thymeleaf; hoy ambos se resuelven en JavaScript o a mano.

## 2. Objetivos

### 2.1 General

Reemplazar el renderizado manual/por-JS del catálogo y del configurador de packs por
`th:each` sobre los datos que ya expone el `@Controller`, y dejar verificado que las 10
páginas cumplen el mínimo de 2 fragments que exige el criterio 2a.

### 2.2 Específicos

1. El catálogo pinta sus tarjetas con `th:each` sobre el modelo del controlador, no con
   `fetch`/`innerHTML` — ATF2 (2c)
2. El configurador de packs pinta sus 7 colores con `th:each` sobre la misma fuente de
   datos que ya usa el catálogo (`ProductoService`), sin duplicar el hex en CSS — ATF2 (2c)
3. Verificación formal de que las 10 páginas usan 2+ fragments, sin excepción — ATF2 (2a)

### 2.3 Alcance de este spec

**Dentro (dueño: José):**
- `E2-21` — `th:each` para las tarjetas de producto del catálogo.
- `E2-22` — `th:each` para los colores del configurador de packs.
- `E2-24` — verificación de fragments en las 10 páginas.

**Documentado pero fuera de esta implementación (dueño: Carlos — no se prescribe su
solución aquí, solo se deja trazado el criterio que debe cumplir):**
- `E2-08` — menú con `th:classappend` marcando el enlace activo. **Ya implementado**: el
  fragment `cabecera(paginaActiva, mostrarCarrito)` en `layout/plantilla.html` (líneas
  30-34) ya calcula `th:classappend` por página. No requiere trabajo nuevo.
- `E2-10` — `th:if`/`th:unless` para el badge de stock y el carrito vacío (criterio 2b).
- `E2-23` — `th:href="@{...}"` y `th:src` en todos los enlaces e imágenes (criterio 1a).

**Fuera de alcance, explícitamente:**
- Cualquier cambio a `detalle-producto.html` o a `renderDetalle()` de `tienda.js` (ese
  renderizado por JS sigue vivo, no es parte de E2-21/E2-22).
- Base de datos: `ProductoService` sigue leyendo `productos.json` en memoria (decisión ya
  tomada en E2-09, Sprint 3, Dayro); esto no cambia con este spec.
- Cualquier tabla, colores nuevos o campo de stock: los 7 colores/productos y sus datos
  son los mismos de `productos.json`; no se añade nada (constitución art. 8).

## 3. Historias de usuario

| # | Como… | quiero… | para… | Criterio |
|---|---|---|---|---|
| H1 | desarrollador | que el catálogo pinte sus tarjetas desde el modelo del controlador con `th:each` | dejar de mantener la misma tarjeta en dos sitios (HTML generado por JS y la futura versión Thymeleaf) | ATF2-2c |
| H2 | desarrollador | que el configurador de packs lea sus 7 colores de la misma fuente que el catálogo | no tener el hex de cada color escrito dos veces (`productos.json` y `promociones.css`) | ATF2-2c, art. 7 |
| H3 | Product Owner | una lista verificada de cuántos fragments usa cada una de las 10 páginas | firmar el criterio 2a sin adivinar | ATF2-2a |
| H4 | visitante | seguir viendo el catálogo y el configurador exactamente igual que hoy (mismas tarjetas, mismos 7 colores, mismo comportamiento de `promociones.js` y de "añadir al carrito") | no perder puntos ya ganados en el ATF1/ATF2 por una regresión | regresión ATF1 |

### Criterios de aceptación

- H1: `GET /catalogo` muestra las 7 tarjetas con los mismos datos (nombre, precio,
  precio de pack, badge, imagen, color, enlace a `/producto/{id}`) que hoy pinta
  `tienda.js`, generadas por `th:each` en el HTML devuelto por el servidor (verificable con
  "ver código fuente", sin esperar a que corra JS).
- H2: `GET /promociones` muestra los mismos 7 `div.color-opcion` con el mismo nombre y el
  mismo color visual (verificado con `getComputedStyle`, igual que hoy), generados por
  `th:each`; `promociones.js` sigue funcionando sin ninguna edición.
- H3: existe una tabla (en `docs/memoria/jose_memory.md`) con las 10 páginas y su conteo
  de fragments, y ninguna tiene menos de 2.
- H4: cero errores de consola en `/catalogo` y `/promociones` a 375 px y 1440 px; "añadir
  al carrito" sigue funcionando desde las tarjetas del catálogo.

## 4. Requisitos

### 4.1 Funcionales

| Código | Nombre | Entrega |
|---|---|---|
| RQF-0010 | `CatalogoController` expone `productos` al modelo (ya existe, E2-09) y `catalogo.html` los recorre con `th:each` | Sprint 3 |
| RQF-0011 | El controlador de `/promociones` expone `productos` al modelo (mismo patrón, nuevo) y `promociones.html` recorre sus colores con `th:each` | Sprint 3 |
| RQF-0012 | Tabla de verificación de fragments de las 10 páginas | Sprint 3 |

### 4.2 No funcionales

| Código | Nombre | Descripción |
|---|---|---|
| RNF-0008 | Cero errores en consola | art. 3 de la constitución, verificado en `/catalogo` y `/promociones` |
| RNF-0009 | Un solo origen de verdad para el color de cada producto | art. 7: el hex vive solo en `productos.json`/`ProductoService`, no también en `promociones.css` |

## 5. Decisiones de diseño de esta spec

Resueltas aquí mismo (mismo patrón que `002-migracion-thymeleaf` resolvió sus ambigüedades
A1-A4 sin bloquear la implementación) — Joaquín puede pedir ajustes en la review, pero no
son un `[NECESITA ACLARACIÓN]` que detenga el arranque:

1. **`tienda.js` deja de renderizar el catálogo.** Hoy `tienda.js` sirve **dos** páginas
   con la misma condición de guarda (`if (grid) ... if (detalle) ...`): el catálogo
   (`renderCatalogo`) y la ficha de producto (`renderDetalle`). Si Thymeleaf pinta las
   tarjetas del catálogo y `tienda.js` sigue cargado ahí, el `fetch` vuelve a pintar las
   mismas tarjetas por JS encima (doble renderizado, mismo resultado visual, pero código
   muerto — contradice el criterio 2b). **Decisión:** quitar
   `<script src="/js/tienda.js"></script>` de `catalogo.html` y eliminar `renderCatalogo`
   y la variable `grid` de `tienda.js`. `renderDetalle` y su uso en `detalle-producto.html`
   **no se tocan** — esa página no es parte de este spec.
2. **El color del configurador se pinta con el hex del modelo (`th:style`), no con una
   clase CSS `color-muestra--<slug>`.** Derivar un slug sin tildes desde el nombre del
   color ("Marrón" → `marron`) añadiría una utilidad nueva sin necesidad (art. 8). Como
   `promociones.js` ya lee el color con `getComputedStyle()` (no con la clase), es
   indiferente para el JS si el color llega por clase o por `style` inline — ambos se
   resuelven al mismo valor computado. Al usar `th:style="'background-color: ' + ${producto.color.hex}"`,
   las 7 reglas `.color-muestra--*` de `promociones.css` quedan sin uso y se retiran en el
   mismo cambio (limpieza, criterio 2b), y el hex deja de estar duplicado entre
   `productos.json` y el CSS (cierra una deuda menor del art. 7).
3. **El controlador de `/promociones` reutiliza `ProductoService.listarTodos()`** con el
   mismo nombre de atributo de modelo que `CatalogoController` (`productos`), en vez de
   crear una colección derivada de "colores únicos". Como cada producto de
   `productos.json` es de un solo color y hay exactamente 7 productos, iterar `productos`
   y leer `producto.color` da los mismos 7 colores que hoy están a mano — sin introducir
   un método ni una lista nueva (art. 8).
4. **Los enlaces de las tarjetas nuevas del catálogo ya llevarán `th:href="@{...}"`.** No
   es opcional: el `href` de cada tarjeta depende del `id` del producto en la iteración,
   así que tiene que ser un atributo de Thymeleaf sí o sí. Esto **no es una invasión de
   E2-23** (que es de Carlos) — simplemente esas líneas nuevas nacen ya resueltas, y a
   Carlos le queda un bloque menos por convertir cuando llegue a esa tarea. Se anota en
   "Para consolidar" para que no se dupliquen esfuerzos.

## 6. Cobertura

| Criterio ATF2 | Cómo se cubre |
|---|---|
| 2a Fragments (verificación) | Tabla de conteo por página en `jose_memory.md` (E2-24) |
| 2c Bloque repetitivo (`th:each`) | Tarjetas del catálogo (E2-21) y colores del configurador (E2-22) |
| 1d Menú activo | Ya cubierto por E2-08 (Carlos, cerrado) — solo se confirma aquí, no se repite |

## 7. Ambigüedades — `[NECESITA ACLARACIÓN]`

Ninguna bloqueante. Las cuatro decisiones de diseño (§5) quedan resueltas con su
justificación en el propio documento, siguiendo el precedente de `002-migracion-thymeleaf`.

## 8. Lista de verificación

- [x] Toda historia se traza a un criterio u objetivo
- [x] Los criterios de aceptación son verificables
- [x] Lo que queda fuera de alcance está dicho
- [x] Las decisiones de diseño están resueltas y justificadas, no dejadas como incógnita
- [x] **Checkpoint: aprobado por Joaquín (PO) — 2026-09-22** → habilita implementar
      E2-21, E2-22 y E2-24.
