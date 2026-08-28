# Checklist de entrega

Lo ejecuta el **duo Documento/QA** antes de subir cualquier avance. Nada se envía con una casilla sin marcar.

Grupo **01**. Reemplaza `n` por el número de avance.

---

## A. Funcionamiento

- [ ] **(desde ATF2)** `mvn clean package` termina sin errores.
- [ ] **(desde ATF2)** `java -jar target/overtext.jar` levanta y responde en `http://localhost:8080`.
- [x] Las 10 páginas abren **sin errores ni advertencias en la consola** del navegador. *(ATF1-2d)* — 27-ago: reverificadas las 10 servidas por HTTP; 0 errores, 0 imágenes rotas. El 404 de `/favicon.ico` del 26-ago ya está resuelto.
- [x] Todas las páginas tienen encabezado, cuerpo y pie. — 27-ago: las 10 tienen `<header>`/`navbar`, `<main>` y `.pie-pagina`.
- [x] El menú navega correctamente a todas las secciones, sin enlaces muertos. — 27-ago: barrido de las 10 páginas. Corregidos `ENVÍOS` del pie (era `href="#"`) y la flecha del boletín (era un `<button>` sin handler); ambos van ahora a `/contacto.html`. **Excepción consciente:** `login.html` conserva 2 marcadores (`¿La olvidaste?`, `Crea tu cuenta`); registro y recuperación están fuera del alcance del ATF1 y se declaran en Recomendaciones del informe.
- [ ] Probado a **375 px** y **1440 px**.
- [ ] **(desde ATF2)** Una URL inexistente muestra el **404 personalizado**. *(ATF2-1c)*
- [ ] **(desde ATF3)** Crear, editar y borrar un producto desde `/admin/productos` funciona de punta a punta.
- [ ] **(desde ATF3)** Enviar el formulario vacío muestra los mensajes de validación en cada campo. *(ATF3-3d)*
- [ ] **(TF)** `/admin/productos` sin sesión redirige al inicio de sesión.
- [ ] **(TF)** Un usuario con rol CLIENTE recibe 403 al entrar al panel.
- [ ] **(TF)** En MySQL, `usuario.password` empieza por `$2a$` (hash BCrypt). *(TF-2b)*
- [ ] **(TF)** El botón de cerrar sesión funciona y devuelve al inicio. *(TF-2d)*

## B. Componentes de rúbrica visibles

**ATF1** — marcar dónde se demuestra cada uno:

- [x] Contenedores → `.container` / `.container-fluid` en las **10** páginas (8 en `index.html`, 6 en `catalogo.html`, 8 en `nosotros.html`) *(E1-03)*
- [x] Menú responsivo → `navbar navbar-expand-lg` con `navbar-toggler` en las **10** páginas *(E1-02)*
- [x] Formularios → `contacto.html` · `login.html` · `checkout.html` *(E1-07, Jonathan)*
- [x] Ventanas modales → `contacto.html` (confirmación) · `detalle-producto.html` (guía de tallas) *(E1-08, E1-09, Carlos)*
- [x] Carrusel de imágenes → `index.html` `#carrusel-portada` (3 diapositivas, controles, indicadores, `data-bs-ride`) · `detalle-producto.html` `#carrusel-galeria` *(E1-04, E1-05)*
- [x] Sistema de grillas → `row` / `col-*` en las **10** páginas; ejemplos: `catalogo.html` `.productos-grid.row.g-4` y el pie `.container.row.g-4` *(E1-06)*

**ATF2**:

- [ ] Al menos 2 fragments en **todas** las páginas
- [ ] Al menos un `th:if`
- [ ] Al menos un `th:each`
- [ ] CSS del framework aplicado

## C. Informe

- [ ] `informes/informe.md` actualizado y exportado a `.docx` con la Plantilla UTP, y de ahí a `.pdf`.
- [ ] La portada lleva **nombre del proyecto, integrantes, docente y fecha**.
- [ ] Situación problemática · Objetivos general y específicos · Diagrama físico de la BD · Descripción de la solución · Capturas del sitio en el navegador.
- [ ] Se ve la **foto de la estructura del proyecto**.
- [ ] **(desde ATF3)** Lleva introducción.
- [ ] **(TF)** Tecnologías usadas · descripción técnica con UML · diccionario de datos · conclusiones · recomendaciones · bibliografía · anexos.
- [ ] Cero contenido heredado de la plantilla original (nada de bullying escolar, tablas `case`/`incident` ni referencias de Android).
- [ ] Capturas archivadas en `informes/capturas/sprint-0N/`.

## D. Empaquetado *(vale 4 puntos completos)*

- [ ] El informe se llama exactamente **`ATFn_GRUPO_01.pdf`** (o `TF_GRUPO_01.pdf`).
- [ ] El proyecto se llama exactamente **`ATFn_GRUPO_01.rar`** (o `.zip`).
- [ ] Grupo en **dos dígitos**: `01`, no `1`. *(−1 punto por archivo si falla)*
- [ ] El comprimido **no tiene contraseña**. *(−3 puntos en el TF)*
- [ ] El comprimido **no está dañado**: descomprimido y abierto **en otra máquina**.
- [ ] Todo va dentro de un único archivo de envío.
- [ ] **(desde ATF2)** El `.rar` no incluye `target/` ni `node_modules/`.

## E. Cierre

- [ ] Rama etiquetada en `main` (`atf1`, `atf2`, `atf3`, `tf`).
- [ ] Los 6 integrantes marcaron su sprint como cerrado → habilita consolidar `memory.md`.
- [ ] Tabla de cobertura de rúbrica actualizada en `memory.md`.
