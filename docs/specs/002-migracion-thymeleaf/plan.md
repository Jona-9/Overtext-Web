# plan.md — 002 · Migración a Spring Boot y Spring Web

**Fase SDD:** Plan
**Sprint:** 2 (07-sep → 20-sep-2026)
**Entrega:** — (sin entrega; sienta las bases del ATF2)
**Spec de origen:** [`spec.md`](spec.md) — aprobado por el Product Owner (Joaquín) el 2026-09-14
**Estado:** ✅ ejecutado. Escrito **a posteriori** el 20-sep-2026 (misma deuda D7 del Sprint 1, repetida).

> **Nota de honestidad.** Este documento faltaba: el `spec.md` se aprobó el 14-sep
> y se pasó directo a implementar, saltando las fases *Plan* y *Tasks* de
> `CLAUDE.md` §4 — exactamente lo mismo que pasó con la spec 001 en el Sprint 1.
> Se redacta ahora reconstruyéndolo desde el código entregado, el historial de Git
> y las memorias personales de Joaquín, José, Carlos y Dayro. **No describe
> intenciones, describe lo que quedó construido**, verificado archivo por archivo.
> Sirve de fuente para la sección **2.1.2 del informe** (E2-16).

---

## 1. Qué se construyó

Se levantó el proyecto `overtext/` con Spring Boot y Thymeleaf, y se trasladó
dentro el sitio íntegro del ATF1 (`app-estatico/`), sin tocar su contenido visual
ni su copy. `app-estatico/` sigue viva como línea base congelada; `overtext/` es
la versión servida por el framework.

**Resultado:** las mismas 10 páginas, ahora renderizadas por Thymeleaf desde
`templates/paginas/`, con una plantilla base (`layout/plantilla.html`) que
elimina la duplicación de cabecera, pie, carrito y scripts, y con rutas limpias
por sección en vez de archivos `.html` sueltos.

| Bloque | Qué resolvió | Dueño(s) |
|---|---|---|
| Proyecto base (E2-01) | `overtext/` con Maven, Java 17, Spring Boot **4.0.8** (ver §3), `web` + `thymeleaf` | Joaquín (adelantado por Jonathan el 14-sep) |
| Traslado de recursos (E2-02, E2-14) | CSS/JS/imágenes → `static/`; las 10 páginas → `templates/paginas/`; los 42 recursos verificados por HTTP 200 | José |
| Plantilla y fragments (E2-03, E2-04) | `layout/plantilla.html` con 4 `th:fragment`: `cabecera`, `carrito`, `pie`, `scripts` | Carlos |
| Controllers y rutas (E2-05, E2-06) | 9 controllers en `pe.edu.utp.overtext.controller`, 10 rutas limpias | Dayro (E2-05 adelantado por Jonathan) |
| `application.properties` (E2-13) | 3 variables de entorno con valor por defecto; `README.md` de arranque | Joaquín |

## 2. Cómo se resolvió cada objetivo específico del spec

1. **Proyecto que compila y arranca en las 6 máquinas** — `./mvnw` incluido, sin
   depender de Maven instalado; `pom.xml` fija Java 17. Verificado con
   `mvnw clean package` → `BUILD SUCCESS`.
2. **Página de inicio por controlador** — `HomeController.inicio()` → `GET /` →
   vista `paginas/index`. No hay archivo estático `index.html` alcanzable
   directamente; pasa siempre por Spring MVC.
3. **Traslado sin alterar contenido ni romper rutas de recurso** — verificado con
   `diff -r` entre `app-estatico/{css,assets}` y `overtext/src/main/resources/static/{css,assets}`:
   **idénticos**. Los 5 JS que sí difieren (`checkout.js`, `confirmacion.js`,
   `contacto.js`, `login.js`, `tienda.js`) cambian **solo** los enlaces internos
   de `.html` a ruta limpia (`/catalogo.html` → `/catalogo`) y la forma de leer
   el id de producto (`?id=` de la query string → `data-producto-id` que pone
   `ProductoController`, sin duplicar el dato entre HTML y JS — art. 7).
4. **Plantilla base y fragments** — los 4 fragments cubren cabecera (con
   `paginaActiva` y `mostrarCarrito` como parámetros), el offcanvas del carrito,
   el pie con el botón de WhatsApp, y el bloque de scripts comunes. Reducción
   medida por Carlos: **1.086 líneas eliminadas, 39 añadidas** en las 10 páginas.
5. **Regresión del ATF1** — pendiente de firma humana al momento de escribir
   este `plan.md` (E2-17/E2-18, parte 6 del sprint, a cargo de Jonathan). El
   resto de este documento no la da por hecha.

## 3. Decisión no registrada, ahora trazada: Spring Boot 4.0.8

`spec.md` §2.3 y `sprint-02.md` (E2-01) pedían Spring Boot **3.x**. El proyecto
real usa **4.0.8** porque `start.spring.io` había retirado la línea 3.x el día
que Joaquín/Jonathan generaron el proyecto (14-sep). La decisión está ahora
trazada en tres lugares: aquí, en `spec.md` §7 (ambigüedad A2) y en
`overtext/README.md`. No cambió ningún requisito del sprint — Spring Web y
Thymeleaf funcionan igual en ambas líneas — pero conviene confirmar con el
docente que la línea 4 no choca con lo que se dicta o califica antes del ATF2.

## 4. Qué quedó fuera, tal como el spec lo trazó

Todo lo de `spec.md` §2.3 "Fuera de alcance": página 404, menú activo con
`th:classappend` (aunque Carlos ya dejó el parámetro `paginaActiva` listo para
eso, ver su memoria del 16-sep), `th:if`/`th:unless`, `th:each`,
`th:href="@{...}"` en todos los enlaces, y cualquier base de datos o seguridad.
Todo eso es Sprint 3 en adelante.

## 5. Trazabilidad al informe

Este `plan.md` es la fuente de la sección **2.1.2** del informe (E2-16): la
tabla de la §2 de arriba lista las tecnologías y quién las trajo. La
introducción (E2-15) la escribe Jhade en su documento propio, fuera del repo
(constitución art. 10).
