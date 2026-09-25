# Memoria de Carlos

> Escritor único: Carlos (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | Datos / Backend | Jonathan | Modales, offcanvas e íconos |
| 2-3 | UI / Front | José | Layout, fragments y Thymeleaf |
| 4-5 | Datos / Backend | José | Repositorios, servicios y validación |
| 6-7 | UI / Front | Joaquín | Cierre de sesión, roles en la vista y panel |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 5 | ATF1 |
| 2 | 07-sep → 20-sep | 2 | — |
| 3 | 21-sep → 01-oct | 3 | ATF2 |
| 4 | 05-oct → 18-oct | 3 | — |
| 5 | 19-oct → 29-oct | 3 | ATF3 |
| 6 | 02-nov → 15-nov | 3 | — |
| 7 | 16-nov → 29-nov | 4 | — |
| Estab. | 30-nov → 11-dic | Sustentación | TF |

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo Datos con Jonathan.** Sesiones 3-8. **Entrega ATF1.**

### Mis tareas

- [x] **E1-08** *(criterio 1d, sesiones 5-6)* — **Modal de confirmación de contacto**: el modal propio de 102 líneas pasa al `modal` de Bootstrap. *(2026-08-26)*
- [x] **E1-09** *(criterio 1d, sesiones 5-6)* — **Modal de guía de tallas** en la ficha de producto. *(2026-08-26)*
- [x] **E1-10** *(criterio 1b, sesión 7)* — Panel del carrito convertido en **`offcanvas`** de Bootstrap en las 6 páginas. *(2026-08-26)*
- [x] **E1-11** *(criterio 1a, sesiones 3-4)* — **Bootstrap Icons** en lugar de los PNG de 4-5 MB. *(2026-08-26)*
- [x] **E1-26** *(`[SÍLABO]`, sesiones 3-4)* — Tabla de tallas con `table table-striped`. *(2026-08-26)*

### Definición de Hecho — mis 5 historias

- [x] La página abre **sin errores en consola** *(criterio 2d)* — las 10 verificadas en Chrome
- [x] Probado a **375 px** y **1440 px** — el offcanvas ocupa el ancho completo en móvil
- [x] Nombres en **kebab-case** *(criterio 2c)*
- [x] Capturas archivadas en `informes/capturas/sprint-01/`
- [x] Criterios de rúbrica marcados en `docs/scrum/checklist-entrega.md`
- [x] Bloque "Para consolidar" escrito en esta memoria
- [ ] **Código subido vía PR revisado por otro duo** — pendiente. Va junto con lo de Jonathan, en el PR del duo Datos.

> Como en la memoria de Jonathan: la DoD dice *"código en `develop` vía PR"* y **`develop` no existe**. El equipo mergea contra `testing`. Que lo decida el SM.

### Por qué mis tareas rinden doble

- **E1-10** elimina 243 líneas duplicadas: el panel del carrito está copiado en 6 páginas. El `offcanvas` de Bootstrap lo resuelve y de paso cubre el criterio 1b.
- **E1-11** ataca la deuda D1: `carta.png`, `instagram.png` y `ubicacion.png` pesan **4-5 MB cada uno** para mostrarse a 24 px. Bootstrap Icons los reemplaza por CDN y el `.rar` adelgaza de golpe.
- **E1-09 y E1-26** son la misma pantalla: la tabla de tallas (S/M/L/XL con cintura, cadera y largo) vive dentro del modal. Cubro el criterio 1d y el tema de tablas del sílabo a la vez.

**Constitución art. 4:** no reimplemento nada a mano. Si Bootstrap ya tiene el componente, uso el suyo y solo lo re-tematizo.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo UI con José.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-03 | Construir `layout/plantilla.html` con `th:fragment` | **2a** | 11-12 |
| E2-04 | Fragments `cabecera`, `pie`, `carrito` y `scripts` | **2a** | 11-12 |

### La tarea de mayor retorno de todo el ATF2

El sitio tiene hoy **~1.000 de sus 2.270 líneas de HTML repetidas** (44 %):

| Bloque | Duplicación |
|---|---|
| Encabezado | 31 líneas × 10 páginas |
| Pie | 42 líneas × 8 páginas + 2 variantes |
| Panel del carrito | 41 líneas × 5 páginas |

Los fragments las eliminan de golpe: el HTML se reduce a menos de la mitad y el criterio 2a queda cubierto.

**Soy el dueño único del layout durante este sprint** (constitución art. 9). Nadie más lo toca hasta que esté en `develop`; con 6 personas editando `plantilla.html` a la vez, el conflicto es seguro.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo UI con José.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-08 | Menú de navegación con `th:classappend` marcando el **enlace activo** | **1d** | 13-14 |
| E2-10 | `th:if` / `th:unless` para el badge de stock y el carrito vacío | **2b** | 13-14 |
| E2-23 | `th:href="@{...}"` en **todos** los enlaces y `th:src` en las imágenes | 1a | 13-14 |

**E2-10 es el criterio 2b entero** (*«un condicional para renderizado»*). Con un solo `th:if` bien puesto basta, pero tiene que ser visible y demostrable en la review.

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo Datos con José.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-03 | `CategoriaRepository` y `ProductoRepository` extendiendo `JpaRepository` | **1** | 17-18 |
| E3-04 | `CategoriaService`/`CategoriaServiceImpl` y `ProductoService`/`ProductoServiceImpl` | **1** | 19-20 |
| E3-13 | `[SÍLABO]` `ProductoRestController` con `@RestController` | — | 19-20 |

### Cuidado con el criterio 1

El descriptor "Completo" exige **las cuatro capas para cada tabla, con su nomenclatura de sufijos y rutas**. Si me salto la capa de servicio "para ir más rápido", el criterio baja de **5 puntos a 2**.

```
entity/Producto.java              repository/ProductoRepository.java
service/ProductoService.java      service/impl/ProductoServiceImpl.java
controller/ProductoController.java
```

Interfaz **y** implementación. Siempre.

**E3-13** cubre el *«proyectos web y REST»* de la sesión 19-20 del sílabo. Ninguna rúbrica lo pide, pero es la base sobre la que Jonathan monta JWT en el Sprint 7.

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo Datos con José.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-10 | **Bean Validation en todos los campos** de `Producto` y `Categoria` | **3d** | 21-22 |
| E3-21 | `@Valid` + `BindingResult` en los controladores; el formulario se reabre con los errores | **3d** | 21-22 |
| E3-22 | Restricciones en la BD que acompañen a las validaciones: `UNIQUE`, `NOT NULL`, FK | 3d | 21-22 |

### El criterio 3d dice "todos los campos", no "algunos"

Vale **6 puntos**; con validaciones parciales cae a 3. Las anotaciones ya están escritas campo por campo en `data-model.md` §2.1 y §2.2 — **las copio tal cual, no las invento**:

```java
@NotBlank @Size(min=3, max=100)  private String nombre;
@NotNull  @DecimalMin("0.01")    private BigDecimal precio;
@NotNull  @Min(0)                private Integer stock;
@NotNull                         private Categoria categoria;
```

Prueba de aceptación: enviar el formulario **vacío** debe mostrar un mensaje de error **por cada campo** y no guardar nada.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo UI con Joaquín.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-06 | **Botón de cerrar sesión** personalizado conectado a `logout`, con CSRF | **2d** | 27-28 |
| E4-07 | `sec:authorize` en el fragment de cabecera: el menú de administración solo se ve con rol ADMIN | 2a | 27-28 |
| E4-19 | Página **403** con el diseño del sitio | 2a | 27-28 |

**El botón ya existe** en `intranet.html` desde el ATF1: solo lo conecto a `logout`. Es un punto del criterio 2 casi gratis.

Requiere `thymeleaf-extras-springsecurity6` para usar `sec:authorize`. Lo añado al `pom.xml` en el día 1.

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo UI con Joaquín.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-30 | Detalle de pedido: cabecera + líneas, con `th:each` | 3a | 31-32 |
| E4-12 | **KPI del panel calculados con consultas reales** | 3a | 31-32 |
| E4-31 | Marcar un mensaje de contacto como atendido | 3c | 31-32 |
| E4-32 | Cambiar el estado de un pedido: pendiente → pagado → enviado → entregado | 3c | 31-32 |

**E4-12** reemplaza los números escritos a mano en `intranet.html` (128 pedidos del mes, 42 pendientes, 6 productos activos, S/ 8.4k en ventas) por `COUNT` y `SUM` reales. En la sustentación se nota mucho la diferencia.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-01 auditoría de los 20 criterios *(30-nov)*
- [ ] E5-02 correcciones de lo que falle *(01-dic)*
- [ ] E5-05 y E5-06 los dos ensayos

### Mi bloque en la sustentación — 4 minutos, con José

**Modelo de datos y CRUD.** Después de Jonathan:

> La base tiene tablas relacionadas: categoría agrupa productos, el pedido tiene sus líneas de detalle, el usuario tiene un rol. Sobre productos y categorías hay mantenimiento completo desde el panel: crear, consultar, editar y eliminar, todo con formularios Thymeleaf y validación en cada campo.

Demuestro en vivo: crear un producto, editarlo, enviar el formulario vacío para mostrar los errores de validación, y borrarlo. Paso a Dayro con la seguridad.

---

## Bitácora — Sprint 1

### 2026-08-20
- Hice: —
- Decidí / aprendí: —
- Bloqueo: —
- Archivos tocados: —

### 2026-08-26 — E1-11 · Bootstrap Icons *(criterio 1a)*

Lo hice **primero**, aunque en el sprint figure junto a los modales: los tres PNG
estaban en las páginas que iba a tocar después, y no quería editarlas dos veces.

- **Hice:** los 5 PNG de `assets/icon/` salen del proyecto y entran Bootstrap Icons
  por CDN, en las **10 páginas**.
  - `carta.png` → `bi-envelope` · `instagram.png` → `bi-instagram` ·
    `ubicacion.png` → `bi-geo-alt` · `wsp.png` → `bi-whatsapp` ·
    `carrito-de-compras.png` → `bi-cart3`.
  - CDN añadido justo detrás del CSS de Bootstrap, respetando la sangría de cada página.
  - CSS re-tematizado: los iconos ya no se dimensionan con `width`/`height` de imagen
    sino con `font-size` (`navegacion.css`, `contacto.css`, `botones.css`, `login.css`).

- **Lo que rinde de verdad:** `carta.png` pesaba 4,2 MB, `instagram.png` 4,2 MB y
  `ubicacion.png` 5,0 MB — **13,4 MB para dibujar tres iconos de 26 px**.
  `assets/` baja de **39 MB a 26 MB** con solo borrar esos tres. Es la mitad del
  camino de la deuda **D1** (objetivo < 15 MB) sin tocar una sola foto de producto.

- **Decidí / aprendí:**
  - Un icono de Bootstrap es un glifo de fuente, no una imagen: se le da tamaño con
    `font-size` y color con `color`. Dejar el `width: 26px` del `<img>` antiguo no
    da error, simplemente **no hace nada**, y el icono sale del tamaño del texto.
  - `.ot-icono-whatsapp` estaba **definido dos veces**, en `botones.css` y en
    `login.css`. Ajusté las dos: si solo cambias una, el icono se descoloca según
    qué hoja gane. Lo dejo anotado como duplicación a resolver (va con E1-12/E1-14).
  - `login.html` usaba el mismo PNG con **otra clase** (`ot-icono-whatsapp` en vez de
    la del resto), así que mi primera pasada lo dejó fuera. Lo cacé con un
    `grep "assets/icon/"` final, no a ojo. **Esa comprobación es obligatoria** al
    sustituir recursos en 10 páginas.

- **Bloqueo:** ninguno.

- **Archivos tocados:** las 10 `app-estatico/*.html`,
  `css/componentes/navegacion.css`, `css/componentes/botones.css`,
  `css/paginas/contacto.css`, `css/paginas/login.css`, y **eliminados**
  `assets/icon/carta.png`, `instagram.png`, `ubicacion.png`, `wsp.png`,
  `carrito-de-compras.png`.

### 2026-08-26 — E1-08 y E1-09 · Las dos ventanas modales *(criterio 1d)*

- **Hice:**
  - **E1-08** — el modal propio de `contacto.html` (overlay, caja, botón de cerrar y
    102 líneas de CSS) pasa al `modal` de Bootstrap: `modal-dialog-centered`,
    `modal-header` / `modal-body` / `modal-footer` y `btn-close`.
    `js/contacto.js` ya no maneja clases ni `body.style.overflow`: usa
    `bootstrap.Modal.getOrCreateInstance(...).show()`. **Se fueron 3 escuchadores**
    (X, clic fuera y Esc), que ahora los pone el framework.
  - **E1-09** — la ficha de producto estrena modal de guía de tallas. El enlace
    "Guía de tallas" era un `<a href="#acordeon-tallas">` que hacía saltar la página;
    ahora es un `<button data-bs-toggle="modal">`.
  - `css/componentes/modal.css` deja de reimplementar el componente y pasa a ser
    **capa de tema** sobre el modal de Bootstrap (constitución art. 4).

- **Decidí / aprendí:**
  - **La tabla de tallas estaba a punto de quedar duplicada.** El plan decía "modal de
    guía de tallas", pero la tabla ya existía dentro de un `<details>` del acordeón.
    Si añadía el modal sin más, quedaban **dos copias de las mismas medidas** y a la
    primera corrección se despegan. Retiré el `<details>` y dejé la tabla **solo en el
    modal**: artículo 7, un único origen de verdad.
  - Conservé `aria-labelledby` y el rol de diálogo, como decía mi nota de contexto.
    Bootstrap pone `role="dialog"` y `aria-modal` por su cuenta al abrir, así que
    escribirlos a mano en el HTML sobra.
  - Al convertir el enlace en `<button>` hay que devolverle `padding: 0` y la
    tipografía: el reset de `main.css` deja el botón desnudo pero no le quita el
    relleno propio del navegador.

- **Bloqueo:** ninguno.

- **Archivos tocados:** `app-estatico/contacto.html`,
  `app-estatico/detalle-producto.html`, `app-estatico/js/contacto.js`,
  `app-estatico/css/componentes/modal.css`, `app-estatico/css/paginas/producto.css`.

### 2026-08-26 — E1-26 · Tabla de tallas con `table table-striped` *(sílabo)*

- **Hice:** la tabla del modal usa `table table-striped table-hover align-middle` de
  Bootstrap. La talla es `<th scope="row">` y las cabeceras `<th scope="col">`, con un
  `<caption class="visually-hidden">` para lectores de pantalla. Envuelta en
  `.table-responsive` para que no rompa el modal en móvil.
- **Decidí / aprendí:** `.tabla-tallas-detalle` (35 líneas en `tablas.css`) quedó
  muerta al mudar la tabla, así que la retiré en el mismo cambio. Una hoja que
  describe algo que ya no existe es exactamente la deuda **D5** que arrastramos.
- **Archivos tocados:** `app-estatico/detalle-producto.html`,
  `app-estatico/css/componentes/tablas.css`, `app-estatico/css/componentes/modal.css`.

### 2026-08-26 — E1-10 · Carrito como `offcanvas` *(criterio 1b)*

La tarea de mayor retorno de las mías, y la más delicada.

- **Hice:** el `<aside id="carrito-lateral">` de **6 páginas** es ahora un
  `offcanvas offcanvas-end` de Bootstrap.
  - Fuera el `.overlay-carrito` propio de las 6: el offcanvas trae su backdrop.
  - Cabecera → `.offcanvas-header` con `btn-close`; cuerpo → `.offcanvas-body`;
    "seguir comprando" cierra con `data-bs-dismiss="offcanvas"`.
  - `js/carrito.js`: `abrirPanel`/`cerrarPanel` se conservan **porque son API
    pública** — "añadir al carrito" llama a `abrirPanel()` — pero por dentro usan
    `bootstrap.Offcanvas.getOrCreateInstance`. Se fueron 3 escuchadores de cierre.
  - `carrito.css`: fuera `position`, `right: -460px`, `transition` y `z-index`.
    El ancho de marca se conserva con `--bs-offcanvas-width: 460px`, y a 480 px
    con `100vw`.

- **Decidí / aprendí:**
  - **Casi rompo la API sin darme cuenta.** Mi primer impulso fue borrar
    `abrirPanel`/`cerrarPanel` y dejarlo todo declarativo con `data-bs-toggle`.
    Pero `abrirPanel()` se llama **desde el propio JS** al agregar un producto: el
    panel se abre solo, y eso no se puede hacer por atributos. Las conservé con la
    implementación cambiada por dentro. Comprobado: al añadir al carrito el panel
    sigue abriéndose solo.
  - **No puse `data-bs-toggle` en el icono del header**, aunque sea lo más idiomático.
    Ese icono existe en páginas donde el offcanvas **no** está, y un `data-bs-target`
    apuntando a un id inexistente falla al pulsar. Con la apertura por JS, si no hay
    panel simplemente no pasa nada. *(Verificado: las 6 páginas que tienen el icono
    son exactamente las 6 que tienen el panel, pero prefiero que no dependa de eso.)*
  - **La primera migración me dejó el HTML sangrado a mano y hecho un desastre.** Como
    los 6 paneles eran idénticos, los regeneré desde una plantilla única respetando la
    sangría de cada página. El criterio 2a es "código estructurado": un `<div>` mal
    indentado se ve en la revisión.

- **Bloqueo:** ninguno.

- **Archivos tocados:** `app-estatico/index.html`, `catalogo.html`, `contacto.html`,
  `detalle-producto.html`, `nosotros.html`, `promotions.html`,
  `app-estatico/js/carrito.js`, `app-estatico/css/componentes/carrito.css`.

### 2026-08-26 — Verificación

Recorrido de clics en Chrome real, no solo carga de páginas:

- **E1-08** — vacío no abre el modal; con datos válidos abre el `modal` de Bootstrap
  con su backdrop y los 4 datos pintados. Cero restos de `.modal-overlay`,
  `.modal-caja` y `.modal-cerrar` en el DOM.
- **E1-09 / E1-26** — el disparador es un `<button>`, el modal abre, la tabla lleva
  `table table-striped table-hover align-middle` con sus 4 filas, y
  **`#acordeon-tallas` ya no existe**: no hay tabla duplicada.
- **E1-10** — abre desde el icono, ancho 460 px, backdrop de Bootstrap, el overlay
  propio eliminado. Cierra con la **X**, con **Esc** y con "seguir comprando".
  Al añadir un producto se abre solo y pinta los ítems, el conteo y el badge.
  A **375 px ocupa el ancho completo** de la pantalla.
- **E1-11** — cero `<img>` de `assets/icon` en el DOM, 6 iconos `.bi` renderizando
  glifo en contacto, y el tamaño aplicado por `font-size`.
- **Las 10 páginas sin errores ni advertencias en consola** *(criterio 2d)* y
  `node --check` limpio en los 7 archivos de `js/`.
- **Capturas:** `carrito-offcanvas-1440.png`, `carrito-offcanvas-375.png`,
  `modal-contacto-1440.png` y `modal-guia-tallas-1440.png` en
  `informes/capturas/sprint-01/`.

**Un aviso sobre las capturas a 375 px:** mi primer intento con Chrome headless salió
**cortado por la derecha** y parecía que la página desbordaba en móvil. **No desborda.**
Lo medí metiendo cada página en un `iframe` de 375 px y comparando `scrollWidth` con
`clientWidth`: las 6 dan cero desbordamiento. Era el `--window-size` de headless, que
recorta en vez de re-maquetar. Si alguien ve una captura móvil "rota", que mida antes
de arreglar nada.

---

## Para consolidar en memory.md

**Sprint 1 — lo que el resto del equipo necesita saber:**

- [ ] **Cobertura de rúbrica ATF1:** marcar **1d Ventanas modales** ✅ (modal de contacto
      y modal de guía de tallas), **1b** ✅ también por el `offcanvas` del carrito, y
      **1a** ✅ en su parte de iconos.
- [ ] **Deuda D1 a la mitad: `assets/` pasa de 39 MB a 26 MB.** Solo con borrar
      `carta.png`, `instagram.png` y `ubicacion.png` (13,4 MB entre los tres, para
      dibujar iconos de 26 px). El objetivo sigue siendo < 15 MB: **lo que queda son
      fotos de producto**, y eso es E1-16, no mío.
- [ ] **`abrirPanel`/`cerrarPanel` de `carrito.js` son API pública**, no código interno:
      "añadir al carrito" abre el panel por JS. Siguen existiendo tras pasar a
      `offcanvas`, pero por dentro llaman a Bootstrap. **Quien las borre por "ya no
      hacen falta" rompe el flujo de añadir al carrito.**
- [ ] **Nueva trampa — un icono de fuente no se dimensiona con `width`.** Al pasar de
      `<img>` a Bootstrap Icons hay que cambiar el CSS a `font-size`. Dejar el `width`
      antiguo **no da ningún error**: el icono simplemente sale del tamaño del texto.
- [ ] **Nueva trampa — las capturas móviles de Chrome headless engañan.**
      `--window-size=375` **recorta** en lugar de re-maquetar, y la página parece rota.
      Para comprobar el responsive de verdad: `iframe` de 375 px y comparar
      `scrollWidth` con `clientWidth`. Medido así, las 6 páginas están limpias.
- [ ] **Duplicación pendiente:** `.ot-icono-whatsapp` está definida **dos veces**, en
      `css/componentes/botones.css` y en `css/paginas/login.css`. Ajusté ambas, pero
      hay que dejar una sola (va con E1-12/E1-14).
- [ ] **CSS muerto que encontré y no me toca:** `.btn-hamburger.abierto` y
      `.menu-principal.abierto` siguen en `navegacion.css` desde que Joaquín eliminó
      `js/nav.js` en E1-02. Nadie las usa. Para el duo de limpieza.
- [ ] **La barra del carrito sigue diciendo "TE FALTAN S/ … PARA ENVÍO GRATIS" sobre
      S/ 180**, cuando el PO fijó **S/ 200** el 25-ago. Es la deuda **D4** y sigue
      abierta: se ve en mis capturas del offcanvas.

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Fuentes de datos para el modelo: `app-estatico/js/productos.json` (7 productos), `app-estatico/js/checkout.js` (costos de envío), `app-estatico/detalle-producto.html` (tabla de tallas).
- ~~El modal de contacto actual está en `contacto.html` con `role="dialog"` y `aria-modal`~~
  **Resuelto (E1-08).** Ya es un `modal` de Bootstrap: el framework pone `role` y
  `aria-modal` al abrir, así que en el HTML basta con `aria-labelledby`.

---

## Sprints cerrados

*(vacío)*

---

## Bitácora — Sprint 2

### 2026-09-16 — E2-03/E2-04 · Fragments de Thymeleaf (criterio 2a)

**Duo UI con José.** Analicé las 10 páginas que José trasladó a
`templates/paginas/` (E2-02/E2-14, `28cad04`) antes de tocar nada: confirmé que
los 42 recursos estáticos que él verificó siguen resolviendo, y mapeé byte a
byte dónde eran idénticos la cabecera, el pie, el carrito y los scripts, y
dónde no.

- **Hice:** creé `overtext/src/main/resources/templates/layout/plantilla.html`
  con 4 `th:fragment`: `cabecera(paginaActiva, mostrarCarrito)`, `pie`,
  `carrito`, `scripts`. Reemplacé el bloque duplicado por su `th:replace` en
  las 10 páginas de `templates/paginas/`. **No toqué ningún controlador ni
  creé rutas** — fue condición explícita de esta tarea; la verificación de las
  9 páginas que aún no tienen ruta (E2-06, Dayro) queda pendiente.
- **Decisiones de diseño:**
  - **No expandí el carrito a las 4 páginas que hoy no lo tienen**
    (checkout, confirmacion, intranet, login). `id="abrir-carrito"` en la
    cabecera y la inclusión del fragment `carrito` viajan siempre juntos vía
    el parámetro `mostrarCarrito` — si no, se reintroduce el bug que la
    trampa **T9** ya documentó evitar (el botón con id pero sin panel).
  - **Parametricé `cabecera` con `paginaActiva`** para no perder el enlace
    activo de cada página. Esto se solapa con **E2-08** (Sprint 3, "menú con
    `th:classappend` marcando el activo") — no es trabajo de más, era el
    mínimo para que el fragment no fuera una regresión, pero anoto el
    solapamiento para que nadie lo repita en el Sprint 3.
  - El botón flotante de WhatsApp (100% duplicado, pegado al footer en las
    10 páginas) se plegó **dentro** del fragment `pie`, sin fragment propio.
  - `scripts` no lleva parámetro: emite los 4 tags comunes en orden fijo:
    Bootstrap bundle CDN + `carrito.js` + `login.js` + `contacto.js`. Cada
    página conserva su script propio (si lo tiene) justo debajo.
- **Dos arreglos "gratis" de la unificación, documentados para que no
  parezcan cambios sueltos en la review:**
  - `login.html` tenía `contacto.js` antes que `login.js` (único caso
    invertido de las 10); ahora sigue el orden común.
  - `detalle-producto.html` le faltaba `target="_blank" rel="noopener"` en
    los dos enlaces sociales del pie; el resto de páginas sí lo tenían. Al
    unificar en un solo `pie`, quedó igual que las demás.
- **Verificación:** `mvnw clean package` → BUILD SUCCESS. Corrí el `.jar`
  empaquetado en un puerto suelto (8099, fuera del repo, sin tocar
  controladores) solo para confirmar que Thymeleaf resuelve los 4 fragments
  sin error en `/` (la única ruta que existe hoy): `id="abrir-carrito"`,
  `active` en INICIO, `#carrito-lateral`, el pie y el WhatsApp aparecen una
  sola vez cada uno. Las otras 9 páginas no se pudieron abrir por navegador
  porque no tienen ruta todavía — **queda pendiente coordinarlo con Dayro**
  cuando cierre E2-06.
  - Reducción medida: **1.086 líneas eliminadas, 39 añadidas** en las 10
    páginas (`git diff --stat`), en línea con el ~44% que estimaba
    `memory.md`.
- **Bloqueo:** ninguno propio. La verificación visual completa de 9/10
  páginas depende de E2-06.
- **Archivos tocados:** nuevo
  `overtext/src/main/resources/templates/layout/plantilla.html`; editadas las
  10 `overtext/src/main/resources/templates/paginas/*.html`.

### Para consolidar en memory.md

- [ ] **E2-03/E2-04 cerradas.** `layout/plantilla.html` existe con los 4
      fragments (`cabecera`, `pie`, `carrito`, `scripts`); las 10 páginas los
      usan. Criterio 2a (fragments) cubierto en su parte estructural.
- [ ] **`memory.md` §4 sigue diciendo que `overtext/` "aún no existe"** —
      discrepancia ya anotada por José el 14-sep, sigue sin corregirse. Gana
      el código (CLAUDE.md §3).
- [ ] **Aviso para el Sprint 3 (José/quien tome E2-08):** el enlace activo del
      menú ya se resuelve con `th:classappend` dentro de `cabecera`, vía el
      parámetro `paginaActiva`. No hace falta rehacerlo — al llegar a E2-08,
      revisar si esto ya lo satisface antes de tocar el fragment de nuevo.
- [ ] **Verificación pendiente de 9/10 páginas** (todas menos `/`): no tienen
      ruta hasta que Dayro cierre E2-06. Cuando exista, falta abrir cada una a
      375/1440 px y confirmar consola limpia (art. 3), igual que E1-19 en el
      Sprint 1.

---

## Bitácora — Sprint 3

### 2026-09-22 — E2-08 confirmado y E2-23 · `th:href`/`th:src` en enlaces e imágenes internas (criterio 1a)

**Duo UI con José.**

- **E2-08 — sin trabajo nuevo.** Confirmé que `cabecera(paginaActiva, mostrarCarrito)`
  en `layout/plantilla.html` (líneas 30-34) ya resuelve el enlace activo con
  `th:classappend` desde el Sprint 2 (mi propia nota de esa bitácora ya lo avisaba).
  El spec `003-thymeleaf-interacciones` (aprobado por Joaquín, 2026-09-22) lo confirma
  igual en su §2.3. No toqué el fragment por esto.

- **E2-23 — hecho, con alcance acotado.** Convertí a `th:href="@{...}"` /
  `th:src="@{...}"` todos los enlaces internos (`<a>`) e imágenes internas (`<img>`)
  que aún usaban `href`/`src` literal, en `layout/plantilla.html` y en las 8 páginas
  de `templates/paginas/` que me correspondían (todas menos `detalle-producto.html`,
  ver más abajo).
  - **Decisión de alcance:** no toqué `<link rel="stylesheet">` ni `<script src="...">`
    de recursos estáticos (CSS/JS propios, CDN de Bootstrap). El criterio ATF2-1a
    (`docs/scrum/roadmap.md` línea 42) es sobre **controladores y sistema de rutas**,
    no sobre referencias a archivos estáticos; y el propio fragment `scripts` (E2-04,
    Sprint 2) ya dejaba esos `<script src="/js/...">` sin `th:src` como precedente.
    Extenderlo a `<link>`/`<script>` habría tocado ~90 líneas más sin que ningún
    criterio lo pida (art. 8, "gana la solución más corta"). Si el PO quiere que
    también se conviertan, es una ampliación de criterio, no algo que decidí solo.
  - **No toqué `detalle-producto.html`.** El spec 003 §5.1 lo excluye
    explícitamente ("Cualquier cambio a `detalle-producto.html`... fuera de alcance"),
    sin excepción para E2-23. Ese archivo se queda con `href="/promociones"`,
    `src="/assets/img/productos/beige/principal.webp"` y el `href="/login"` del
    modal sin convertir. **Queda pendiente para cuando alguien abra un spec que sí
    cubra esa página.**
  - Dejé sin tocar, a propósito: los `href="#"` de "¿La olvidaste?" y "Crea tu
    cuenta" (no tienen ruta destino — no son parte de esta tarea, son placeholders de
    un flujo que no existe todavía) y todos los enlaces externos (`wa.me`,
    Instagram, TikTok, `mailto:`).
  - Verificación: `./mvnw clean package -DskipTests` → **BUILD SUCCESS**. No corrí
    el servidor con navegador esta vez (cambio puramente de sintaxis de atributo,
    sin cambio de URL resultante en un despliegue sin `context-path`); si alguien
    quiere el visual, las 9 páginas tocadas siguen sirviendo las mismas rutas.

- **E2-10 — NO implementado. Me detuve por CLAUDE.md §4.** El spec 003 §2.3 deja
  este criterio "documentado pero fuera de esta implementación: no se prescribe su
  solución aquí". Al revisar el código encontré que la solución no es mecánica:
  - **"Badge de stock":** `memory.md` decisión 14 dice que el badge de bajo stock se
    calcula con `stock < 10`. Pero `Producto` (record, `model/Producto.java`) **no
    tiene campo `stock`**, y `productos.json` trae el mismo texto fijo
    `"badge": "ÚLTIMAS UNIDADES"` en los 7 productos — no hay ningún dato que un
    `th:if` pueda condicionar. Hacerlo bien exige decidir **una** de estas dos cosas,
    y las dos son decisiones de diseño, no sintaxis:
    1. añadir un campo `stock` (numérico) a `Producto`/`productos.json` y calcular
       el badge con `th:if="${producto.stock < 10}"` — pero la constitución art. 8
       prohíbe añadir un campo que ninguna rúbrica pide, y el criterio 2b solo pide
       *un* condicional, no un dato nuevo;
    2. reinterpretar el criterio como "ocultar el `<span>` del badge cuando venga
       vacío" (`th:if="${!#strings.isEmpty(producto.badge)}"`), que no exige tocar
       el modelo pero **tampoco es "el badge de stock"** tal como lo nombra la tarea.
  - **"Carrito vacío":** el offcanvas (`carrito` fragment) no tiene ningún dato de
    carrito en el modelo del controlador — lo pinta enteramente `carrito.js` del
    lado del cliente (`localStorage`, sin sesión de servidor). Un `th:if`/`th:unless`
    real sobre "carrito vacío" necesitaría que el servidor supiera el estado del
    carrito, lo que hoy no existe en ninguna capa (ni sesión, ni `CarritoService`).
    Sin ese dato, la única forma de cumplir el criterio con Thymeleaf sería escribir
    un bloque estático que JS alterna por clase — que no es un condicional de
    **renderizado** en el sentido que pide el criterio 2b.
  - No adiviné ninguna de las dos. Anoto esto como `[NECESITA ACLARACIÓN]` para que
    Joaquín (PO) decida antes de que alguien implemente E2-10, y lo dejo trazado
    aquí en vez de en un spec nuevo porque el spec 003 ya es el documento vigente de
    este sprint y solo le faltaría esta resolución en una próxima revisión.

- **Restricción del encargo de hoy:** no toqué controladores ni lógica de servidor
  (ninguna de las dos tareas hechas lo necesitaba), y no hice `git commit` ni
  `git push` — los cambios quedan en el árbol de trabajo para que yo los revise y
  suba.

- **Bloqueo:** **E2-10 sin resolver**, ver arriba — necesita una decisión del PO
  sobre si "stock" se convierte en dato real o si el criterio se reinterpreta sin
  tocar el modelo. Sin eso, no hay `th:if` que escribir sin adivinar.

- **Archivos tocados:** `overtext/src/main/resources/templates/layout/plantilla.html`
  y `overtext/src/main/resources/templates/paginas/{index,catalogo,promociones,
  checkout,intranet,nosotros,contacto,confirmacion,login}.html`. **No tocado:**
  `detalle-producto.html` (fuera de alcance del spec 003) ni ningún controlador.

### Para consolidar en memory.md

- [ ] **E2-08 confirmado sin cambios** (ya estaba resuelto desde Sprint 2) y
      **E2-23 cerrada** para `<a>`/`<img>` internos en 9/10 páginas + layout.
      `detalle-producto.html` queda pendiente de un spec que cubra esa página.
- [ ] **E2-10 bloqueada, necesita decisión del PO.** No hay campo `stock` en
      `Producto`/`productos.json` (todos los productos comparten el mismo texto de
      badge) ni estado de carrito en el servidor (todo vive en `carrito.js`/
      `localStorage`). Implementar el criterio 2b con estos datos exige o bien
      añadir un dato nuevo al modelo (tensiona con el art. 8) o reinterpretar el
      criterio. Alguien con autoridad de PO debe elegir antes de que se escriba
      código para E2-10.
- [ ] **Decisión de alcance sin escalar (documentada, no bloqueante):** `<link>` y
      `<script>` de recursos estáticos no se convirtieron a `th:href`/`th:src` en
      E2-23 — el criterio ATF2-1a es de rutas/controladores, no de assets estáticos,
      y el fragment `scripts` (Sprint 2) ya sentaba ese precedente.
