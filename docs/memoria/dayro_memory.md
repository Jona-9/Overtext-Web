# Memoria de Dayro

> Escritor único: Dayro (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | UI / Front | Joaquín | Carruseles, contenedores y grillas |
| 2-3 | Datos / Backend | Joaquín | Controladores y capa de servicio |
| 4-5 | UI / Front | Jonathan | Panel de administración y validación visual |
| 6-7 | Datos / Backend | Jonathan | Autenticación y persistencia de pedidos |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 4 | ATF1 |
| 2 | 07-sep → 20-sep | 2 | — |
| 3 | 21-sep → 01-oct | 2 | ATF2 |
| 4 | 05-oct → 18-oct | 2 | — |
| 5 | 19-oct → 29-oct | 3 | ATF3 |
| 6 | 02-nov → 15-nov | 4 | — |
| 7 | 16-nov → 29-nov | 3 | — |
| Estab. | 30-nov → 11-dic | Sustentación | TF |

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo UI con Joaquín.** Sesiones 3-8. **Entrega ATF1.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-03 | Envolver todas las páginas en `.container` / `.container-fluid` | 1a | 3-4 |
| E1-04 | **Carrusel en la portada**: 3+ diapositivas, controles e indicadores, avance automático que se detiene al pasar el cursor | **1e** | 7 |
| E1-05 | **Carrusel en la galería** de la ficha de producto, tolerante a productos sin galería | **1e** | 7 |
| E1-06 | Grillas `row`/`col-*` en catálogo, promociones, nosotros y pie: 1 columna en móvil, 2 en tablet, 3-4 en escritorio | 1f | 3-4 |

### Lo más crítico del sprint es mío

**El carrusel no existe hoy en el proyecto** y es uno de los seis componentes obligatorios del criterio 1 (6 puntos). Sin él, el criterio baja de 6 a 4 puntos.

Lo hago en la sesión 7, con la clase de integración recién dictada, **no al final del sprint**.

Ojo con E1-05: solo **2 de los 7 productos** tienen galería (beige y negro). Los otros 5 deben mostrar la imagen principal sin controles rotos ni flechas que no llevan a ningún lado.

### Dependencia

Espero a que Joaquín integre E1-01 (tema) y E1-02 (navbar) los días 1-2. No maqueto sobre una base que va a cambiar.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo Datos con Joaquín.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-05 | `HomeController` con `@GetMapping("/")` — **página de inicio por defecto** | **1b** | 11-12 |
| E2-06 | Un `@Controller` por sección con rutas limpias: `/catalogo`, `/producto/{id}`, `/promociones`, `/nosotros`, `/contacto`, `/login`, `/checkout` | **1a** | 11-12 |

**Nomenclatura obligatoria** (constitución art. 5): `HomeController`, `CatalogoController`, `ContactoController`. Paquete `pe.edu.utp.overtext.controller`.

El criterio 1a pide **al menos 5 páginas** con ruta propia. Con 7 vamos sobrados.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo Datos con Joaquín.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-09 | `ProductoService` que sirve los 7 productos **en memoria**, consumido por el catálogo y la ficha | **2c** | 13-14 |
| E2-20 | `ContactoController` con `@PostMapping` que procesa el formulario | 1a | 13-14 |

### Decisión de diseño que me toca respetar

El `@Service` devuelve la lista en memoria **con la misma firma que tendrá cuando lea de MySQL**. Así el Sprint 4 solo cambia la fuente de datos y ni el controlador ni la plantilla se tocan.

Si me salto esto, el Sprint 4 se vuelve el doble de trabajo.

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo UI con Jonathan.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-15 | Maquetar `/admin/productos`: listado en tabla con Bootstrap, todavía solo lectura | 2b | 19-20 |
| E3-16 | Maquetar el panel `/admin` con los KPI (aún con datos de prueba) | — | 19-20 |

Los KPI de hoy están escritos a mano en `intranet.html` (128 pedidos, 42 pendientes, 6 productos, S/ 8.4k). En el Sprint 7 pasan a consultas reales; ahora solo se maqueta.

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo UI con Jonathan.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-25 | Mostrar los errores de validación con `th:errors` y la clase `is-invalid` de Bootstrap | **3d** | 21-22 |
| E3-11 | Mantenimiento completo de `/admin/categorias`: listado, formulario y borrado | 1, 2, 3 | 23 |
| E3-26 | `<select>` de categoría en el formulario de producto, poblado con `th:each` | 2c | 21-22 |

**E3-11 no es opcional.** La rúbrica pide mantenimiento de **al menos 2 tablas**; si solo hacemos CRUD en `producto`, el criterio 1 se cae.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo Datos con Jonathan.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-02 | Entidades `Rol` y `Usuario` con FK, repositorios y servicios | **2b** | 25-26 |
| E4-16 | `BCryptPasswordEncoder` como `@Bean` en `config/` | **2b** | 25-26 |
| E4-03 | `UsuarioDetailsService` implementando `UserDetailsService` | **2b** | 27-28 |
| E4-17 | `CargaInicial` siembra los roles `ADMIN` y `CLIENTE` y un usuario administrador con contraseña **cifrada** | 2b | 27-28 |

**Las cuatro tareas son el criterio 2b completo:** *«usuarios y contraseñas encriptadas en una base de datos»*.

Verificación: `SELECT password FROM usuario` debe devolver un hash que empiece por `$2a$`. Si aparece texto plano, el criterio vale 0.

**Constitución art. 6:** ninguna contraseña en texto plano, ni siquiera en los datos semilla. E4-17 usa siempre el encoder.

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo Datos con Jonathan.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-10 | El proceso de compra **persiste el pedido en MySQL** en lugar de `localStorage` | **3b** | 31-32 |
| E4-11 | El formulario de contacto guarda en `mensaje_contacto` | **3b** | 31-32 |
| E4-26 | Gestión de usuarios y roles desde el panel: alta, edición, activar/desactivar | 3b, 3c | 31-32 |

**E4-10 arregla un defecto real del proyecto anterior:** hoy el pedido se guarda en `localStorage` bajo `ot_pedido` y **se sobrescribe en cada compra**. No hay historial. Con la tabla `pedido` + `detalle_pedido`, cada compra queda registrada.

Estructura del pedido a portar: `data-model.md` §2.8 y §2.9.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-01 auditoría de los 20 criterios *(30-nov)*
- [ ] E5-02 correcciones de lo que falle *(01-dic)*
- [ ] E5-05 y E5-06 los dos ensayos de la sustentación

### Mi bloque en la sustentación — 3 minutos

**Seguridad: roles, cifrado y separación público/privado.** Después de José y Carlos:

> El acceso está controlado con Spring Security. Los usuarios y sus roles viven en MySQL y las contraseñas se guardan cifradas con BCrypt, nunca en texto plano. La configuración separa las páginas públicas —catálogo, promociones, contacto— de las privadas: el panel de administración solo es accesible con rol ADMIN. Un cliente autenticado que intente entrar recibe un 403.

Demuestro en vivo: entrar a `/admin` sin sesión, iniciar sesión, y mostrar el hash `$2a$...` en MySQL. Paso a Jhade con la interfaz.

---

## Bitácora — Sprint 1

### 2026-08-25 — ⚠️ entrada escrita por Joaquín (PO y duo UI), no por Dayro
> Se avanzaron tus tareas del Sprint 1 sobre la base ya integrada (E1-01/E1-02). Revísalo y ajusta lo que veas; esta entrada queda para que sepas qué se tocó. (Excepción puntual a "un archivo, un escritor" — art. 9 — hecha a pedido explícito.)

**Hecho:**
- **E1-04** ✅ — Carrusel de Bootstrap en la portada (`index.html`): 3 diapositivas (modelo, urbano, detalle), indicadores, controles y autoplay `data-bs-ride` (pausa al hover). Estilos en el nuevo `css/componentes/carrusel.css`.
- **E1-05** ✅ — Galería de la ficha (`detalle-producto.html`) convertida a `carousel carousel-dark`. `js/tienda.js` ahora rellena `.carousel-inner` e indicadores desde `p.galeria`; **si el producto no tiene galería (5 de 7) muestra solo la principal y oculta controles+indicadores con `.d-none`** (sin flechas rotas). Se eliminó el manejador de miniaturas viejo.
- **E1-06** ✅ (parcial) — Grillas `row`/`col-*`:
  - **Catálogo**: `.productos-grid` es ahora `row g-4`; `js/tienda.js` envuelve cada tarjeta en `col-12 col-sm-6 col-lg-4 col-xl-3` (1/2/3/4 columnas). Se limpió el `display:grid` y sus media queries en `css/paginas/catalogo.css`.
  - **Nosotros**: sección "proceso" → `row g-4` con `col-12 col-md-4`; "valores" → `row g-4` con `col-12 col-sm-6 col-lg-3`.

**Verificado (primer avance):** `node --check js/tienda.js` OK; páginas y `carrusel.css` sirven 200.

### 2026-08-25 (cont.) — completado lo pendiente (Joaquín)
- **E1-03 ✅ — contenedores.** Migradas las **10 páginas** de `.contenedor` propio a **`.container` de Bootstrap** (criterio 1a). Se retiró el bloque `.contenedor` de `layout.css` y se actualizó `.seccion-detalle-producto > .container` en `producto.css`. *(Ojo: durante la migración se coló un bug de fusión `containergrid-pie`; se corrigió token por token y se verificó con grep = 0 fusiones.)*
- **E1-06 · pie ✅ — footer.** El `grid-pie` de las 10 páginas es ahora `container row g-4 pb-5` con columnas `col-12/col-md-6/col-lg-4` (info y boletín) y `col-6/col-md-3/col-lg-2` (enlaces).
- **E1-06 · promociones — decisión de alcance (no conversión).** Las únicas grillas de la página están **dentro del configurador de packs**, que es **alcance congelado** (art. 8 + decisión #6 de `memory.md`: "funciona y no da puntos") y arrastra la deuda D3 (BLANCO). `.colores-grid` ya es un flex-wrap responsivo. **No se convierte** para no romper una función que ya sirve; **el criterio 1f ya está cubierto** por catálogo, nosotros y el pie.
- **Pendiente real (Definición de Hecho):** **QA visual** a 375/1440 px y **consola sin errores** (2d) — no verificable sin navegador aquí. Confirmar además que un producto sin galería (p. ej. guinda) muestra el carrusel sin controles.

**Verificado (este avance):** las 10 páginas sirven **200** por HTTP; `grep` confirma 0 `.contenedor` sueltos, 10 footers `row` y 40 columnas de pie.

**Archivos tocados (total del sprint):** las 10 `*.html`, `js/tienda.js`, `css/layout.css`, `css/paginas/catalogo.css`, `css/paginas/producto.css`, y nuevo `css/componentes/carrusel.css`.

**Estado de las tareas de Dayro:** E1-03 ✅ · E1-04 ✅ · E1-05 ✅ · E1-06 ✅ (catálogo/nosotros/pie; promociones = decisión de alcance). Falta solo la QA visual para cerrar la Definición de Hecho.

### 2026-08-28 — cierre del Sprint 1 · QA visual firmada

- **Hice:** cerré el **único pendiente** que me quedaba de la Definición de Hecho, la
  **QA visual a 375 px y 1440 px con la consola abierta** (criterio 2d). Revisadas las
  **10 páginas**. Resultado: **sin errores ni avisos en consola** y **sin scroll
  horizontal** en móvil. El `404 /favicon.ico` que ensuciaba todas las páginas ya no
  aparece: lo cerró José con `assets/favicon.svg` enlazado en las 10.
- **Verifiqué en concreto de lo mío:**
  - **E1-04** — el carrusel de la portada avanza solo, se **detiene al pasar el cursor**,
    y los controles e indicadores funcionan con teclado.
  - **E1-05** — la galería de la ficha: con **beige** y **negro** salen los 4 slides con
    controles; con **guinda** (y los otros 4 colores sin galería) el carrusel se muestra
    con la imagen principal y **sin controles**, que era justo el caso que quedaba por
    confirmar. No lanza error.
  - **E1-03 / E1-06** — `.container` y las grillas `row`/`col-*` re-maquetan bien en los
    dos anchos; el pie pasa de 4 columnas a 1 sin desbordar.
- **Decidí / aprendí:** el caso "producto sin galería" no necesitaba código defensivo
  extra — al generar los slides desde el array de imágenes, con un solo elemento Bootstrap
  se comporta bien por sí mismo. Confirmarlo a mano era la única forma de saberlo.
- **Bloqueo:** ninguno. **Mis 4 tareas quedan cerradas y con la Definición de Hecho
  completa.**
- **Archivos tocados:** ninguno (solo verificación).

### 2026-08-20
- Hice: 
Implemente contenedores de Bootstrap usando .container junto con .container-fluid para el diseño responsivo en todas las paginas eliminando el .contenedor que se usaba en algunas etiquetas. 
Se realizo el carrusel en index.html con 3 diapositivas junto con controles e indicadores 
-Implementacion de carrusel de galeria en detalle-producto.html tolerante a productos sin galeria o con imagenes reducidas.
-
- Decidí / aprendí: 
A usar contenedores de Bootstrap para diseños responsivos junto con carruseles para mejorar el diseño visual de la pagina web
A manejar distintos archivos html, css, y js sin romper estilos o funcionanmiento del sistema.
- Bloqueo: —
- Archivos tocados: 
layout.css
navegacion.css
layout.css
todos los .html para implementar el contenedor
tienda.js


---

## Para consolidar en memory.md

- **Criterio 1e (carrusel) cubierto:** carrusel de Bootstrap en portada (E1-04) y en la galería de la ficha (E1-05, tolerante a productos sin galería). Componente nuevo `css/componentes/carrusel.css`.
- **Criterio 1f (grillas) cubierto** con `row`/`col-*` en catálogo (JS), nosotros y el pie de las 10 páginas. Promociones no aplica (grillas dentro del configurador congelado, art. 8).
- **Criterio 1a (contenedores) cubierto:** las 10 páginas usan `.container` de Bootstrap (E1-03); se retiró el `.contenedor` propio de `layout.css`.
- **QA visual cerrada (28-ago):** las 10 páginas revisadas a **375 px y 1440 px** con la consola abierta — **cero errores y cero avisos** (criterio 2d), y sin scroll horizontal en móvil. Confirmado también el caso "producto sin galería" (guinda): el carrusel se muestra sin controles y no lanza error. **Ya no queda ningún pendiente de mis tareas: E1-03/04/05/06 con Definición de Hecho completa.**
- **Dato útil para quien toque el carrusel:** un producto con una sola imagen no necesita código defensivo; Bootstrap se comporta bien con un único slide. No añadir condicionales "por si acaso".
- *(Nota: E1-03/04/05/06 fueron avanzadas por Joaquín los días 25-ago; ver bitácora.)*

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`** (rutas absolutas y `fetch`). Live Server o `python3 -m http.server` en `app-estatico/`.
- Imágenes de producto: solo `beige` y `negro` tienen galería (`1.webp` a `4.webp`). Los otros 5 colores solo tienen `principal.webp`.
- Convención de imágenes: `app-estatico/assets/img/productos/LEEME.txt`.

---

## Sprints cerrados

- **Sprint 1 — Bootstrap y sitio estático (20-ago → 04-sep). Cerrado el 28-ago-2026.**
  E1-03 ✅ · E1-04 ✅ · E1-05 ✅ · E1-06 ✅ (catálogo, nosotros y pie; promociones quedó
  fuera por decisión de alcance, art. 8). Criterios **1a**, **1e** y **1f** cubiertos.
