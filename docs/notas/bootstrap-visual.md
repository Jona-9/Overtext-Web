# Dónde se ve Bootstrap en OverText

**Autor:** Jonathan · **Fecha:** 2026-09-02
**Para qué sirve:** insumo listo para quien redacte `informes/informe.md`
§2.1.2.1 (Tecnologías usadas, `[TF]`) y §2.1.2.2 (Descripción técnica del
funcionamiento, `[TF]`). No se pegó directo en el informe: esa sección es del
Trabajo Final y `informe.md` tiene un solo escritor de redacción (Jhade,
decisión 18 de `memory.md`); esto queda aparte como referencia.

---

Bootstrap **sí se ve**, pero no se nota a simple vista porque está
**retematizado** — así lo exige `docs/constitution.md` art. 4: *"Bootstrap
primero: úsalo y solo re-temátizalo, no lo reimplementes"*. No es la versión
genérica azul de Bootstrap; es Bootstrap 5.3 real (por CDN, sin reimplementar
ningún componente) con los colores y la tipografía de la marca OverText
encima.

## Dónde está, visualmente

| Lo que ves | Componente de Bootstrap por debajo |
|---|---|
| El menú de arriba (navbar) que se colapsa en celular | `navbar navbar-expand-lg` + `navbar-toggler` |
| El carrito que se desliza desde la derecha | `offcanvas offcanvas-end` |
| El carrusel de fotos en el inicio | `carousel slide` |
| Los modales (login, contáctanos, confirmación, detalle de producto, alta, cerrar sesión) | `modal fade` |
| Los formularios (login, contacto, checkout) con bordes rojos si te equivocas | `form-control` + `was-validated` |
| La cuadrícula de tarjetas del catálogo | `row` / `col-*` |
| Los botones negros ("ENTRAR", "GUARDAR PRODUCTO") | `btn btn-dark` |
| La tabla de productos de la intranet | `table table-striped table-hover` |

## Por qué no se ve "azul Bootstrap"

El archivo `app-estatico/css/tema-overtext.css` reasigna las variables de
Bootstrap (`--bs-primary`, `--bs-btn-bg`, etc.) a los colores de la marca
(negro, rojo vino, beige). El HTML sigue usando las clases originales de
Bootstrap (`btn-dark`, `modal`, `navbar`); esas clases ahora pintan con la
paleta de OverText en vez de la paleta por defecto del framework.

## Cómo comprobarlo

Clic derecho → "Inspeccionar" sobre cualquier botón o modal del sitio: en el
HTML aparecen clases como `class="modal fade"` o `class="btn btn-dark"`, que
son exactamente las clases de la documentación oficial de Bootstrap 5.3, no
nombres inventados por el equipo.
