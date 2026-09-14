# spec.md — 002 · Migración a Spring Boot y Spring Web

**Fase SDD:** Specify
**Sprint:** 2 (07-sep → 20-sep-2026)
**Entrega:** — (sin entrega; sienta las bases del ATF2)
**Estado:** ✅ aprobado por el Product Owner (Joaquín) — 2026-09-14

---

## 1. Situación problemática

El ATF1 entregó un sitio **100% estático**: 10 páginas HTML servidas tal cual, CSS y JS
vanilla, datos en `js/productos.json`, y navegación por enlaces `<a href="/x.html">`.
Funciona, pero:

- **No hay servidor de aplicación.** No se puede tener lógica de negocio, ni rutas
  limpias, ni preparar el terreno para plantillas, base de datos o seguridad, que es
  hacia donde va todo el ciclo (`memory.md` §1, "Stack objetivo").
- **El HTML está duplicado ~44%.** El encabezado se repite 31 líneas × 10 páginas, el
  pie 42 × 8 (+2 variantes), y el panel del carrito 41 × 5. Cambiar el navbar hoy
  significa editar 10 archivos a mano.
- **Las páginas no pasan por un controlador.** No hay forma de inyectar datos del
  servidor (usuario autenticado, mensajes de error, listas desde una base de datos)
  sin volver a JS del lado del cliente.

El sitio del ATF1 (`app-estatico/`) se conserva intacto como línea base congelada
(`memory.md` §4); este sprint construye la versión servida por Spring **al lado**, sin
tocarlo.

## 2. Objetivos

### 2.1 General

Levantar el proyecto Spring Boot con Thymeleaf, mover los recursos y las páginas del
ATF1 dentro de su estructura estándar, y verificar que todo sigue sirviéndose sin
romper nada del ATF1.

### 2.2 Específicos

1. Tener un proyecto Spring Boot que compila y arranca en las 6 máquinas del equipo — ATF2
2. Servir la página de inicio desde un controlador, no como archivo estático — ATF2 (1b)
3. Trasladar CSS, JS, imágenes y las 10 páginas a la estructura de Spring sin alterar su
   contenido ni romper ninguna ruta de recurso — ATF2 (base de 1a, 2a)
4. Construir la plantilla base y los fragments reutilizables (cabecera, pie, carrito,
   scripts) — ATF2 (2a)
5. Confirmar que los 6 componentes de Bootstrap del ATF1 y la consola libre de errores
   siguen intactos tras la migración — regresión ATF1

### 2.3 Alcance de este sprint

**Dentro:**
- Crear el proyecto Spring Boot (Maven, Java 17+, `web`, `thymeleaf`).
- Mover CSS/JS/imágenes a `static/` y las 10 páginas a `templates/paginas/`.
- `layout/plantilla.html` con `th:fragment` y los fragments de cabecera, pie, carrito y scripts.
- Un controlador por sección con rutas limpias (`/catalogo`, `/producto/{id}`, etc.) y la
  página de inicio por defecto.
- `application.properties` con variables de entorno, y el `README` de arranque.
- Verificar que los recursos estáticos resuelven tras el traslado.
- Regresión del ATF1 y actualización del informe (introducción, 2.1.2).

**Fuera de alcance, explícitamente** (quedan para el Sprint 3, `sprint-02.md` §3):
- Página 404/500 personalizada.
- Menú activo con `th:classappend`.
- `th:if`/`th:unless` (condicionales de renderizado).
- `th:each` (catálogo, colores del configurador).
- `th:href="@{...}"` / `th:src` en todos los enlaces e imágenes.
- Cualquier base de datos o seguridad (`memory.md` decisión 8: cada sprint usa solo lo
  dictado esas mismas semanas).

## 3. Historias de usuario

| # | Como… | quiero… | para… | Criterio |
|---|---|---|---|---|
| H1 | integrante del equipo | clonar el repo y levantar `overtext/` con un solo comando | empezar a trabajar sin configurar nada a mano | — |
| H2 | visitante | que la portada cargue en `/` | entrar al sitio igual que en el ATF1 | ATF2-1b |
| H3 | desarrollador | que el CSS/JS/imágenes sigan resolviendo en sus mismas rutas (`/css/...`, `/js/...`, `/assets/...`) | no reescribir referencias en las 10 páginas | — (prerrequisito de 1a/2a) |
| H4 | desarrollador | tener una plantilla base con fragments de cabecera, pie y carrito | dejar de mantener el mismo bloque en 10 archivos | ATF2-2a |
| H5 | Product Owner | comprobar que el carrusel, el navbar, los modales, los formularios, el offcanvas y las grillas del ATF1 se ven igual | no perder puntos ya ganados en el TF | regresión ATF1 |

### Criterios de aceptación

- H1: `mvnw spring-boot:run` levanta sin editar nada, en Windows y en las demás máquinas del equipo, y responde en `http://localhost:8080` (o el puerto que se indique si está ocupado).
- H2: abrir `http://localhost:<puerto>/` muestra la portada del ATF1 servida por un `@Controller`, no un archivo estático.
- H3: cada `<link>`/`<script>`/`<img>` con ruta absoluta que ya existía en el ATF1 responde HTTP 200 dentro de `overtext/`.
- H4: existe `layout/plantilla.html` y al menos 2 páginas usan 2+ fragments (el resto se completa en el Sprint 3, E2-24).
- H5: la portada, servida por Spring, no muestra errores ni advertencias en la consola del navegador a 375 px y 1440 px, y los 6 componentes de Bootstrap del ATF1 responden igual que en `app-estatico/`.

## 4. Requisitos

### 4.1 Funcionales

| Código | Nombre | Entrega |
|---|---|---|
| RQF-0006 | El proyecto Spring Boot compila y arranca con Maven Wrapper | Sprint 2 |
| RQF-0007 | La página de inicio se sirve desde un controlador (`HomeController`) | ATF2 |
| RQF-0008 | Los recursos estáticos (CSS, JS, imágenes) se sirven desde `static/` sin romper ninguna referencia existente | ATF2 |
| RQF-0009 | Existe una plantilla base con fragments reutilizables de cabecera, pie, carrito y scripts | ATF2 |

### 4.2 No funcionales

| Código | Nombre | Descripción |
|---|---|---|
| RNF-0006 | Cero errores en consola | Igual que el art. 3 de la constitución: se verifica en la portada servida por Spring |
| RNF-0007 | Sin secretos en `application.properties` | Cualquier credencial futura va por variable de entorno (art. 6) |

## 5. Cobertura

| Criterio ATF2 | Cómo se cubre |
|---|---|
| 1a Rutas de 5+ páginas | Un `@Controller` por sección (Dayro/Joaquín, E2-06) — este spec deja los recursos listos para que esas rutas sirvan las páginas |
| 1b Página de inicio por defecto | `HomeController` con `@GetMapping("/")` (E2-05) |
| 2a Fragments (parte estructural) | `layout/plantilla.html` + fragments (Carlos, E2-03/E2-04) |
| ATF1-1, ATF1-2d | Regresión de los 6 componentes de Bootstrap y consola limpia (E2-17/E2-18) |

## 6. Ambigüedades — `[NECESITA ACLARACIÓN]`

| # | Ambigüedad | Decisión |
|---|---|---|
| A1 | ¿Se **mueve** `app-estatico/` (se borra el original) o se **copia** dentro de `overtext/`? | **Se copia.** `memory.md` §4 declara `app-estatico/` como la línea base congelada del ATF1; no se borra. |
| A2 | `sprint-02.md` pide Spring Boot 3.x; el proyecto ya existe en 4.0.8 | Se mantiene **4.0.8** — decisión ya tomada en E2-01 (`start.spring.io` retiró la línea 3.x el mismo día). Se documenta aquí para que quede trazada en un spec, no solo en una bitácora. |
| A3 | Los enlaces internos (`href="/catalogo.html"`, etc.) no van a resolver como rutas de Spring hasta que existan los `@Controller` por sección | Queda **fuera de esta tarea**: es E2-06 (rutas) y E2-23 (`th:href="@{...}"`, Sprint 3). E2-14 lo deja como bloqueo explícito, no lo resuelve. |
| A4 | `app-estatico/docs/` (arquitectura CSS, sistema de diseño) — ¿se migra como recurso? | **No.** Es documentación del proyecto, no un asset que el navegador solicite; se queda en `app-estatico/docs/`. |

## 7. Lista de verificación

- [x] Toda historia se traza a un criterio u objetivo
- [x] Los criterios de aceptación son verificables
- [x] Lo que queda fuera de alcance está dicho
- [x] Las ambigüedades están marcadas y resueltas
- [x] **Checkpoint: aprobado** → habilita implementar E2-02 y E2-14
