# spec.md — Páginas de error y procesamiento del formulario de contacto

**Estado:** aprobado por el PO (Joaquín) el 2026-09-27, antes de escribir código —
mismo checkpoint que el spec 003, no retroactivo.

**Origen:** tareas E2-07, E2-19 y E2-20 del duo Datos/Backend (Joaquín · Dayro),
`docs/scrum/sprints/sprint-03.md` §4, sesión 15. `docs/specs/002-migracion-thymeleaf/spec.md`
las excluyó explícitamente de su alcance (§2, "Fuera de alcance").

## 1. Alcance

**Dentro:**
- Página 404 personalizada, con el diseño del sitio (cabecera + pie).
- Página 500 personalizada, mismo tratamiento.
- `ContactoController` con `@PostMapping("/contacto")` que recibe y valida el
  formulario existente.

**Fuera de alcance, explícitamente:**
- Persistencia del mensaje de contacto en base de datos (`mensaje_contacto` es
  Sprint 7, E4-11 — `memory.md` decisión 8).
- Tocar el `th:classappend` del menú activo (E2-08, José/Carlos) ni el `th:if`
  del carrito/stock (E2-10, José/Carlos).

## 2. Decisiones de diseño

| # | Decisión | Motivo |
|---|---|---|
| A | **Sin `@ControllerAdvice`.** Spring Boot resuelve automáticamente `templates/error/404.html` y `templates/error/500.html` vía `BasicErrorController` cuando existen, por código de estado. Un `@ControllerAdvice` (`ManejadorErroresGlobal`) sería una capa redundante sobre un mecanismo que el framework ya da (art. 8 — simplicidad; ponytail rung 3, feature nativa de la plataforma). El literal del ticket lo nombraba, pero el objetivo ("página 404/500 con el diseño del sitio") se cumple igual y con menos código. |
| B | **Las páginas de error reutilizan `layout/plantilla.html` (`cabecera`, `pie`)**, igual que las 10 páginas del sitio, para que no se note el salto de diseño. No cuentan para el criterio 2a (no son de las "10 páginas"), pero es gratis mantener la consistencia. |
| C | **El `@PostMapping` de contacto no deshace el flujo cliente ya aceptado** (E1-07/E1-08: `contacto.js` intercepta el submit y abre `#modal-contacto` con los datos). En vez de reescribir esa UX, `contacto.js` suma un `fetch` asíncrono al nuevo endpoint, sin bloquear el modal. El controller valida los 4 campos (no vacíos) y por ahora solo registra el mensaje por log — no hay tabla todavía (ver "fuera de alcance"). |
| D | **Sin DTO nuevo.** Cuatro `@RequestParam` de texto no justifican un `record` propio (art. 8). Si Sprint 7 necesita más campos o persistencia, ahí se decide si hace falta. |

## 3. Criterios de aceptación

- H1: entrar a una URL inexistente (`/pagina-que-no-existe`) devuelve **HTTP 404**
  con el diseño del sitio (cabecera + pie), no el whitelabel de Spring.
- H2: forzar un error 500 (p. ej. una excepción no controlada) devuelve la página
  500 con el mismo tratamiento visual.
- H3: enviar el formulario de `/contacto` con los 4 campos completos sigue
  mostrando el modal de confirmación **igual que antes** (regresión de E1-07/E1-08),
  y además llega al servidor por `POST /contacto` (verificable en la pestaña Red
  del navegador o en el log de la aplicación).
- H4: enviar el formulario con un campo vacío no llega al servidor (la validación
  de Bootstrap ya lo bloquea en cliente, sin cambios) — el servidor no necesita
  repetir esa validación con una respuesta visible, porque no hay forma de que un
  campo vacío se envíe desde la página; si el body llega vacío igual (cliente sin
  JS), el controller responde 400 sin romper.

## 4. Cobertura de rúbrica

Cierra ATF2-1c (404) por completo. E2-20 aporta a ATF2-1a (ya cubierto por las
rutas existentes; esto es la parte de "procesar", no de "servir").
