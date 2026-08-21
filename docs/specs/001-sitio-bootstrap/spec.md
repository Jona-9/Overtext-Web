# spec.md — 001 · Sitio estático con Bootstrap 5

**Fase SDD:** Specify
**Sprint:** 1 (20-ago → 04-sep-2026)
**Entrega:** ATF1
**Estado:** ⬜ borrador — pendiente del checkpoint del Product Owner (Joaquín)

---

## 1. Situación problemática

> *Alimenta la sección 1.1 del informe.*

OverText es una empresa peruana de streetwear masculino que fabrica directamente y vende sin intermediarios, con su submarca Overcoming (shorts de hombre). Hoy su canal de venta es **Facebook y WhatsApp**: el catálogo son publicaciones dispersas, los precios se repiten en cada conversación y cada pedido se arma a mano por chat.

Esto le cuesta a la empresa:

- **No hay catálogo consultable.** El cliente pregunta por colores y tallas que ya se agotaron, y alguien tiene que responder uno por uno.
- **El pedido se arma en el chat.** No queda registro estructurado: ni qué se pidió, ni a qué dirección, ni con qué método de pago.
- **No hay control de inventario.** El badge "últimas unidades" se pone a ojo, sin stock real detrás.
- **La atención no escala.** Todo depende de que una persona conteste. Fuera de horario, la venta se pierde.
- **La marca no controla su vitrina.** La identidad visual trabajada (paleta, tipografías, tono) se diluye en el formato de una red social.

El sitio estático existente cubre la vitrina, pero no resuelve el fondo: los datos viven en archivos JSON, el carrito en `localStorage` del navegador (se pierde al cambiar de dispositivo), el inicio de sesión compara credenciales en el cliente y el panel de administración muestra cifras escritas a mano.

**El problema a resolver:** OverText no tiene una plataforma propia que le permita publicar su catálogo, recibir pedidos con registro persistente y administrar productos e inventario sin depender de la atención manual por chat.

## 2. Objetivos

> *Alimenta la sección 1.2 del informe.*

### 2.1 General

Desarrollar una aplicación web para el e-commerce OverText que permita publicar el catálogo de productos, gestionar pedidos y administrar el inventario mediante un panel privado, aplicando frameworks de desarrollo web de front-end y back-end.

### 2.2 Específicos

1. Implementar la interfaz del sitio con un framework CSS responsivo que garantice una experiencia coherente en móvil y escritorio. *(ATF1)*
2. Estructurar el sitio con un motor de plantillas y un sistema de rutas en el servidor que elimine la duplicación de código entre páginas. *(ATF2)*
3. Persistir el catálogo en una base de datos relacional y proveer operaciones de mantenimiento sobre productos y categorías. *(ATF3)*
4. Implementar control de acceso con autenticación y autorización por roles, separando páginas públicas de privadas. *(TF)*
5. Registrar los pedidos y los mensajes de contacto de forma persistente, reemplazando el almacenamiento en el navegador. *(TF)*

### 2.3 Alcance de este sprint

Solo el objetivo específico 1, más el **diseño** (no la implementación) del modelo de datos, porque el informe del ATF1 exige el diagrama físico de la base de datos.

**Fuera de alcance, explícitamente:** backend, base de datos, seguridad real. El checkout, el ubigeo y el configurador de packs se re-maquetan pero **no se profundizan** (constitution art. 8).

---

## 3. Historias de usuario

| # | Como… | quiero… | para… | Criterio de rúbrica |
|---|---|---|---|---|
| H1 | visitante en el móvil | navegar el sitio con un menú que se adapte a mi pantalla | encontrar el catálogo sin hacer zoom | ATF1-1b |
| H2 | visitante | ver los productos destacados en un carrusel en la portada | descubrir la colección de un vistazo | ATF1-1e |
| H3 | visitante en la ficha de producto | recorrer las fotos del producto | ver el short desde varios ángulos antes de comprar | ATF1-1e |
| H4 | visitante | consultar la guía de tallas sin salir de la ficha | elegir mi talla con confianza | ATF1-1d |
| H5 | visitante | escribir a la marca desde un formulario y recibir confirmación | saber que mi mensaje llegó | ATF1-1c, 1d |
| H6 | visitante | ver el catálogo en una grilla que se reordene según mi pantalla | comparar productos cómodamente | ATF1-1f |
| H7 | cliente | abrir mi carrito como panel lateral sin perder la página | seguir comprando sin interrupciones | ATF1-1b |
| H8 | administrador | entrar por un formulario de inicio de sesión | acceder al panel de gestión | ATF1-1c |

### Criterios de aceptación

**H1** — El menú es una `navbar navbar-expand-lg`. Bajo 992 px colapsa en un botón; sobre 992 px se muestra horizontal. El enlace de la página actual queda marcado. Funciona en las 10 páginas.

**H2** — La portada tiene un `carousel` de Bootstrap con al menos 3 diapositivas, controles de anterior/siguiente e indicadores. Avanza solo y se detiene al pasar el cursor.

**H3** — La ficha de producto muestra la galería como `carousel`. Los productos sin galería (5 de 7 hoy) muestran solo la imagen principal, sin controles rotos.

**H4** — Un botón "Guía de tallas" abre un `modal` con la tabla S/M/L/XL (cintura, cadera, largo). Cierra con la X, con Esc y al hacer clic fuera.

**H5** — El formulario de contacto usa `form-control` y validación `was-validated`: los campos vacíos o el correo mal formado muestran mensaje de error y no envían. Al enviar correctamente aparece un `modal` de confirmación.

**H6** — Catálogo, promociones y "nosotros" usan `row`/`col-*`: 1 columna en móvil, 2 en tablet, 3-4 en escritorio.

**H7** — El carrito es un `offcanvas` de Bootstrap. Se abre desde el icono del header, muestra los ítems y el total, y el badge del contador refleja la cantidad real.

**H8** — La página de inicio de sesión usa `form-control` con validación de campos obligatorios.

---

## 4. Requisitos

> *Alimenta la sección 2.2 del informe.*

### 4.1 Funcionales

| Código | Nombre | Hito |
|---|---|---|
| RQF-0001 | Navegar por el catálogo de productos | ATF1 |
| RQF-0002 | Consultar el detalle de un producto | ATF1 |
| RQF-0003 | Configurar un pack de 6 prendas | ATF1 |
| RQF-0004 | Gestionar el carrito de compras | ATF1 |
| RQF-0005 | Registrar un pedido mediante el proceso de compra | ATF1 |
| RQF-0006 | Enviar un mensaje de contacto | ATF1 |
| RQF-0007 | Iniciar sesión | ATF1 / TF |
| RQF-0008 | Cerrar sesión | TF |
| RQF-0009 | Consultar el panel de administración | ATF1 / TF |
| RQF-0010 | Gestionar productos (alta, consulta, edición, baja) | ATF3 |
| RQF-0011 | Gestionar categorías | ATF3 |
| RQF-0012 | Consultar los pedidos registrados | TF |
| RQF-0013 | Consultar los mensajes de contacto recibidos | TF |
| RQF-0014 | Administrar usuarios y roles | TF |

*Fuente: elaboración propia.*

### 4.2 No funcionales

| Código | Nombre | Descripción |
|---|---|---|
| RNF-0001 | Usabilidad | Interfaz responsiva, verificada a 375 px y 1440 px |
| RNF-0002 | Compatibilidad | Funciona en las versiones vigentes de Chrome, Firefox y Safari |
| RNF-0003 | Mantenibilidad | Estructura por capas, nomenclatura kebab-case en español, sin código duplicado |
| RNF-0004 | Confidencialidad | Contraseñas cifradas con BCrypt; separación de páginas públicas y privadas |
| RNF-0005 | Rendimiento | Ninguna imagen supera los 300 KB; el peso total de recursos estáticos se mantiene bajo 15 MB |
| RNF-0006 | Identidad visual | Toda página respeta la paleta y tipografías de `docs/contexto.md` |

*Fuente: elaboración propia.*

---

## 5. Cobertura de la rúbrica ATF1

| Criterio | Cómo se cubre |
|---|---|
| 1a Contenedores | `.container` en las 10 páginas; `.container-fluid` en el hero |
| 1b Menús responsivos | `navbar navbar-expand-lg` + `navbar-toggler` (reemplaza `js/nav.js`) |
| 1c Formularios | `form-control` / `form-select` / `form-check` en contacto, inicio de sesión y proceso de compra |
| 1d Ventanas modales | `modal` de confirmación de contacto + `modal` de guía de tallas |
| 1e Carrusel de imágenes | `carousel` en la portada **y** en la galería de la ficha de producto |
| 1f Sistema de grillas | `row`/`col-*` en catálogo, promociones, nosotros y pie de página |
| 2a Estructurado | CSS por capas: framework → tema → componentes → páginas |
| 2b Limpio | Se elimina `css/style.css` (código muerto), los estilos en línea y el script incrustado |
| 2c kebab-case | Ya se cumple; se verifica archivo por archivo |
| 2d JS sin errores | Verificación página por página en la Sprint Review |
| 3 Informe | Este `spec.md` + `plan.md` + `data-model.md` alimentan las 5 secciones |
| 4 Nomenclatura | `ATF1_GRUPO_01.pdf` + `ATF1_GRUPO_01.rar` |

---

## 6. Incoherencias heredadas que hay que decidir

Vienen del proyecto anterior y contradicen el artículo 7 de la constitución (un solo origen de verdad).

| # | Incoherencia | Decisión |
|---|---|---|
| I1 | Los 7 colores del configurador de packs (NEGRO, BLANCO, STONE, BORGOÑA, GRIS, OLIVO, MARINO) no coinciden con los 7 de `productos.json` (beige, negro, guinda, gris, oliva, azul, marrón). Hay un BLANCO que no existe como producto. | `[NECESITA ACLARACIÓN]` |
| I2 | Envío gratis: `UMBRAL_ENVIO_GRATIS = 180` en `js/carrito.js` vs "envío incluido desde 2 packs" (S/ 200) en el copy. | `[NECESITA ACLARACIÓN]` |
| I3 | Los 7 productos llevan el mismo badge "ÚLTIMAS UNIDADES" sin stock real detrás. | `[NECESITA ACLARACIÓN]` |
| I4 | El pedido se guarda en `localStorage` bajo `ot_pedido` y **se sobrescribe en cada compra**: no hay historial. | Se resuelve en el TF con la tabla `pedido`. |

**Preguntas para el Product Owner:**

1. ¿La lista de colores válida es la del catálogo (7 con beige/guinda/azul/marrón) o la del configurador? ¿Existe o no el short blanco?
2. ¿Cuál es el umbral real de envío gratis: S/ 180 o S/ 200?
3. ¿El badge de stock se calcula desde un umbral (p. ej. stock < 10 → "últimas unidades") o se asigna a mano por producto?

---

## 7. Lista de verificación del spec

- [x] Toda historia se traza a un criterio de rúbrica (art. 1)
- [x] Los criterios de aceptación son verificables en el navegador
- [x] Lo que queda fuera de alcance está dicho explícitamente
- [x] Las ambigüedades están marcadas `[NECESITA ACLARACIÓN]`
- [ ] **Checkpoint: aprobado por el Product Owner** → habilita escribir `plan.md`
