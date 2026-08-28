# plan.md — 001 · Sitio estático con Bootstrap 5

**Fase SDD:** Plan
**Sprint:** 1 (20-ago → 04-sep-2026)
**Entrega:** ATF1
**Depende de:** `spec.md`, aprobado por el Product Owner (Joaquín) el 2026-08-25
**Estado:** redactado el 2026-08-28 · pendiente de checkpoint del PO

> **Este documento se escribió después de implementar, y hay que decirlo.**
> El `spec.md` se aprobó el 25-ago y el equipo pasó directo a código, saltando las
> fases Plan y Tasks de CLAUDE.md §4. Eso quedó registrado como deuda **D7**.
> Este `plan.md` cierra esa deuda documentando **el diseño técnico con el que
> efectivamente se construyó** el sitio, verificado contra `app-estatico/`, no una
> intención previa. Donde el plan y el código discrepaban, se corrigió el plan.
> A partir del Sprint 2 el orden vuelve a ser Specify → Plan → Tasks → Implement.

---

## 1. Qué se construye

El objetivo específico 1 del `spec.md`: llevar el sitio estático heredado a un
**framework CSS responsivo**, conservando la identidad de marca, y dejar el código
en condiciones de recibir Spring Boot en el Sprint 2.

No se construye backend, ni base de datos, ni seguridad real. El modelo de datos se
**diseña** pero no se implementa, porque el informe del ATF1 exige el diagrama físico.

## 2. Estrategia: re-tematizar, no reimplementar

La decisión que gobierna todo lo demás.

Bootstrap 5 aporta el comportamiento (colapso del menú, apertura del modal, avance del
carrusel, validación del formulario) y OverText aporta el aspecto. **Donde Bootstrap ya
tiene el componente, se usa el de Bootstrap y solo se le cambian los colores, las
tipografías y los espaciados** (constitution art. 4). No se reescribe ningún componente
que el framework ya resuelva.

Consecuencia práctica: cada componente propio que se migra **se retira**, no se deja
conviviendo con el de Bootstrap. Un panel de carrito propio y un `offcanvas` en la misma
página son dos fuentes de verdad para el mismo elemento.

### La trampa que costó tiempo

**El CSS heredado le gana a Bootstrap por especificidad.** Al migrar un componente, si la
regla vieja sigue viva, la clase de Bootstrap se aplica pero no se ve. La salida correcta
es **retirar la regla antigua**, nunca añadir `!important` — eso solo mueve el problema.
De aquí salen las deudas D8, D9 y D10, que son exactamente reglas viejas que sobrevivieron
a su componente.

## 3. Arquitectura CSS por capas

El orden de carga **es** la arquitectura: cada capa solo puede pisar a la anterior.

| # | Capa | Archivos | Qué le toca |
|:-:|---|---|---|
| 1 | **Framework** | `bootstrap.min.css`, `bootstrap-icons.min.css` (CDN) | Reset, grillas, componentes, utilidades. No se edita. |
| 2 | **Tema** | `css/tema-overtext.css` | Las variables de marca y el reemplazo de los tokens de Bootstrap. **Único sitio donde vive un color.** |
| 3 | **Base y layout** | `css/main.css`, `css/layout.css` | Tipografía base, estilos de párrafo, estructura de página. |
| 4 | **Componentes** | `css/componentes/*.css` (10) | Lo que se repite en varias páginas: navegación, botones, formularios, tarjetas, badges, pie, carrito, carrusel, modal, tablas. |
| 5 | **Páginas** | `css/paginas/*.css` (10) | Solo lo que es exclusivo de una página. Si aparece en dos, sube a la capa 4. |

**Regla de oro de la capa 2:** ningún archivo de las capas 3-5 escribe un color literal.
Todos consumen las variables de `tema-overtext.css`. Un hex suelto en `paginas/` es un bug,
no un atajo — es lo que produjo la deuda D3 (los siete colores del configurador estaban
*aproximados*, no copiados, y pasaron tres revisiones visuales sin que nadie lo notara).

### Por qué CDN y no build

No hay Node, ni bundler, ni paso de compilación. Es deliberado: el Sprint 2 mete el sitio
dentro de `src/main/resources/static/` de Spring Boot, y unos `<link>` a CDN más CSS plano
se mudan sin tocar nada. Un pipeline de build habría que desmontarlo. Además el art. 8
prohíbe añadir capas que ninguna rúbrica pide.

## 4. Los seis componentes del criterio 1

Uno por criterio de la rúbrica ATF1, con la decisión técnica de cada uno.

| Criterio | Componente | Enfoque | Riesgo previsto |
|---|---|---|---|
| 1a | `.container` / `.container-fluid` | Sustituye al `.contenedor` propio en las 10 páginas. El hero va a ancho completo. | Doble contenedor anidado → márgenes duplicados. |
| 1b | `navbar navbar-expand-lg` | Reemplaza el menú propio **y** a `js/nav.js`, que se elimina: el colapso lo hace Bootstrap. Punto de quiebre 992 px. | Dejar el JS viejo escuchando el botón → doble apertura. |
| 1c | `form-control` / `form-select` / `form-check` + `was-validated` | Validación nativa del navegador; el JS solo añade la clase al enviar. | Ver §7, T5. |
| 1d | `modal` | Dos: confirmación de contacto (migra un modal propio de 102 líneas) y guía de tallas. | Restos del modal propio interceptando el cierre. |
| 1e | `carousel` | Dos: portada (3+ diapositivas, autoavance con pausa al pasar el cursor) y galería de la ficha. | **5 de los 7 productos no tienen galería:** deben mostrar la imagen principal sin controles rotos. |
| 1f | `row` / `col-*` | 1 columna en móvil, 2 en tablet, 3-4 en escritorio. Reemplaza la `.grid-2` propia. | `.grid-2` sobrevive en `style.css` y alguien la "rescata". |

**El carrusel es lo más crítico del sprint:** no existía en el sitio heredado y vale un
sexto del criterio 1. Es lo único que se construye desde cero.

## 5. Orden de ejecución

Hay una dependencia dura y conviene respetarla:

```
E1-01 tema  →  E1-02 navbar  →  todo lo demás
```

El tema y el navbar tocan el `<head>` y el encabezado de **las 10 páginas**. Si alguien
maqueta encima de una base que aún va a cambiar, el trabajo se pierde. Por eso ambos se
hacen primero y se integran **el mismo día**.

A partir de ahí los tres duos trabajan en paralelo sobre archivos distintos, que es lo que
hace viable el art. 9 (un archivo, un escritor):

| Duo | Territorio | Tareas |
|---|---|---|
| UI / Front — Joaquín · Dayro | tema, navbar, contenedores, carruseles, grillas | E1-01…06, E1-25 |
| Datos / Backend — Jonathan · Carlos | formularios, modales, carrito, iconos, modelo de datos | E1-07…11, E1-22, E1-26 |
| Documento / QA — José · Jhade | limpieza, docs, informe, empaquetado | E1-12…18, E1-20, E1-21, E1-23, E1-24 |
| Todos | consola sin errores en las 10 páginas | E1-19 |

`E1-19` va al final a propósito: es una verificación, y verificar antes de que todo esté
integrado no demuestra nada.

## 6. Limpieza — el criterio 2, que no es opcional

El criterio 2 vale tanto como el 1 y se pierde por descuido, no por dificultad.

- **`css/style.css` se elimina entero** (616 líneas). Es código muerto con un `:root`
  que compite con el del tema. Mientras exista, cualquiera puede "rescatar" de ahí una
  regla ya retirada y romper una migración.
- **Cero estilos en línea** (había 15) y **cero scripts incrustados**: el del configurador
  de packs sale a `js/promociones.js`.
- **Cero valores de relleno** en el HTML. Los importes y contadores que el JS calcula
  arrancan vacíos; si se dejan escritos, parpadean al cargar y además duplican un dato
  que ya vive en el JS (art. 7).
- **kebab-case en español**, archivo por archivo. Incluye renombrar `promotions.html`.
- **`assets/` de 39 MB a menos de 15 MB**, ninguna imagen sobre 300 KB. Se consigue
  pasando a `.webp` y cambiando los PNG de iconos de 4-5 MB por Bootstrap Icons.
- **Consola limpia en las 10 páginas**, a 375 y a 1440 px. Un 404 de favicon cuenta como
  error, así que el `<link rel="icon">` entra en el mismo barrido.

## 7. Riesgos técnicos conocidos

Los que ya se manifestaron, para que el Sprint 2 no los repita:

| # | Riesgo | Mitigación |
|:-:|---|---|
| T1 | Rutas absolutas (`/css/…`) y `fetch` de JSON: **no funciona con `file://`** | Servir siempre por HTTP. Al pasar a Spring, las rutas ya son las correctas. |
| T4 | El CSS heredado gana por especificidad y el estilo de Bootstrap no se ve | Retirar la regla vieja. Nunca `!important`. |
| T5 | `.d-block` de Bootstrap lleva `!important` y gana al atributo `hidden` | Para mostrar u ocultar un `.invalid-feedback` desde JS, añadir y quitar `.d-block`. |
| T6 | Un icono de fuente **no se dimensiona con `width`** | Al pasar de `<img>` a Bootstrap Icons, cambiar el CSS a `font-size`. No da error: simplemente sale del tamaño del texto. |
| T7 | Las capturas móviles engañan: `--window-size=375` **recorta** en vez de re-maquetar | Fijar el ancho con emulación de viewport y comparar `scrollWidth` con `clientWidth`. |
| T9 | `abrirPanel`/`cerrarPanel` de `carrito.js` son **API pública**, no código interno | Se conservan tras migrar a `offcanvas`; por dentro llaman a Bootstrap. Borrarlas rompe "añadir al carrito". |

## 8. Modelo de datos: se diseña, no se implementa

El informe del ATF1 exige el diagrama físico, así que el DDL se escribe ya, completo
(**las 10 tablas**), aunque el ATF3 solo vaya a usar tres. Un diagrama a medias no
demuestra el diseño, y las cuatro rúbricas del curso lo piden.

- `esquema-fisico.sql` es la **fuente autoritativa**.
- `data-model.md` es la vista lógica y el diccionario de datos.
- Si discrepan, **gana el `.sql`**.
- El diagrama del informe se **genera** desde ahí, no se dibuja a mano.

## 9. Qué queda preparado para el Sprint 2

El plan es que la migración a Spring Boot sea una mudanza, no una reescritura:

- El HTML ya está limpio y sin scripts incrustados → se corta en fragmentos Thymeleaf
  (`cabecera`, `pie`) sin desenredar nada primero.
- Las rutas ya son absolutas → `src/main/resources/static/` las sirve igual.
- El CSS ya está por capas → se copia tal cual.
- `js/productos.json` tiene la forma que tendrá la tabla `producto` → el `th:each` del
  catálogo sustituye al `fetch` sin cambiar el modelo mental.

**Lo que este plan deliberadamente no resuelve** y el Sprint 2 tendrá que abrir: la página
404 y el sistema de rutas por controladores, que son del criterio 1 del ATF2 y aquí no
tienen sitio.

## 10. Trazabilidad con el informe

| Sección del informe | Sale de |
|---|---|
| 1.1 Situación problemática | `spec.md` §1 |
| 1.2 Objetivos | `spec.md` §2 |
| 2.1.2 Descripción de la solución | **Este documento**, §1 y §2 |
| 2.1.2.1 Tecnologías usadas | **Este documento**, §3 |
| 2.1.2.2 Descripción técnica del funcionamiento | **Este documento**, §4 y §5 |
| 2.2 Requisitos | `spec.md` §4 |
| 2.3 Diseño de la base de datos | `data-model.md` + `esquema-fisico.sql` |
| 2.4 Resultados | `informes/capturas/sprint-01/` |

## 11. Lista de verificación del plan

- [x] Toda decisión técnica se traza a una historia del `spec.md`
- [x] El orden de ejecución respeta la dependencia tema → navbar → resto
- [x] Ningún duo escribe en el archivo de otro (art. 9)
- [x] No se añade ninguna capa que la rúbrica no pida (art. 8)
- [x] Los riesgos conocidos están escritos con su mitigación
- [x] Verificado contra `app-estatico/` a 2026-08-28
- [ ] **Checkpoint: aprobación del Product Owner** → habilita `tasks.md`
