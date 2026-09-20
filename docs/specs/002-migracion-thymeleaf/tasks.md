# tasks.md — 002 · Migración a Spring Boot y Spring Web

**Fase SDD:** Tasks
**Sprint:** 2 (07-sep → 20-sep-2026) · **Entrega:** — (sin entrega)
**Plan de origen:** [`plan.md`](plan.md)
**Estado:** 🟨 partes 1-5 ejecutadas y verificadas · parte 6 (E2-17/E2-18) en curso. Escrito **a posteriori** el 20-sep-2026 (deuda D7 repetida).

> Igual que `plan.md`, este archivo faltaba y se reconstruye desde
> `docs/scrum/sprints/sprint-02.md`, el historial de Git y las memorias
> personales de cada dueño. **Toda tarea lleva su criterio de rúbrica entre
> paréntesis**, como exige el artículo 1 de la constitución.
>
> Leyenda: ✅ hecha y verificada · 🟨 hecha con verificación pendiente

---

## Orden de ejecución

`E2-01` (proyecto base) desbloquea todo lo demás — nadie puede tocar recursos,
plantilla o controllers sin `overtext/` compilando. Se adelantó el 14-sep.

```
Día 1-2   E2-01 crear el proyecto  →  todos clonan y compilan
Día 3-5   E2-02 mover recursos     →  E2-03/E2-04 layout y fragments
Día 6-8   E2-05/E2-06 controladores y rutas
Día 9-10  Regresión ATF1, informe, cierre
```

---

## Duo Datos / Backend — Joaquín · Dayro

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E2-01 | Crear el proyecto Spring Boot con Maven, Java 17+, `web` y `thymeleaf` | — | ✅ | `overtext/pom.xml`, `overtext/mvnw`. Adelantada por Jonathan el 14-sep en nombre de Joaquín (ver `joaquin_memory.md`) |
| E2-05 | `HomeController` con `@GetMapping("/")` — página de inicio por defecto | **ATF2-1b** | ✅ | `controller/HomeController.java` → vista `paginas/index` |
| E2-06 | Un `@Controller` por sección con rutas limpias | **ATF2-1a** | ✅ | 8 controllers adicionales, 10 rutas en total (`/catalogo`, `/producto/{id}`, `/promociones`, `/nosotros`, `/contacto`, `/login`, `/checkout`, `/confirmacion`, `/admin`) |
| E2-13 | `application.properties` con variables de entorno; `README` de arranque | — | ✅ | `OVERTEXT_PORT`, `OVERTEXT_THYMELEAF_CACHE`, `OVERTEXT_LOG_LEVEL`, todas con valor por defecto |

## Duo UI / Front — José · Carlos

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E2-02 | Mover CSS, JS e imágenes a `static/` y las páginas a `templates/paginas/` | — | ✅ | `diff -r` contra `app-estatico/`: CSS y assets idénticos |
| E2-03 | Construir `layout/plantilla.html` con `th:fragment` | **ATF2-2a** | ✅ | 4 fragments: `cabecera(paginaActiva, mostrarCarrito)`, `carrito`, `pie`, `scripts` |
| E2-04 | Fragments `cabecera`, `pie`, `carrito` y `scripts` | **ATF2-2a** | ✅ | mismas 10 páginas reducidas de 3.820 a 2.924 líneas totales |
| E2-14 | Verificar que las rutas de recursos estáticos funcionan tras el traslado | — | ✅ | José: los 42 recursos responden HTTP 200 |

## Duo Documento / QA — Jonathan · Jhade

| # | Tarea | Criterio | Estado | Dónde quedó |
|---|---|:-:|:-:|---|
| E2-15 | Redactar la INTRODUCCIÓN del informe (adelantada del ATF3) | 3 | 🟨 | fuera del repo, en el documento propio de Jhade (art. 10). Confirmar estado al cierre del sprint |
| E2-16 | Actualizar 2.1.2 con Spring Boot y Spring Web como tecnologías | 3 | 🟨 | `informes/informe.md:94` ya dice "Spring Boot 4.0.8" (corregido el 20-sep); falta que Jhade integre la tabla de §2 de `plan.md` en su documento |
| E2-17 | Verificar que las 10 páginas siguen sin errores en consola tras la migración | ATF1-2d | 🟨 | Consola limpia confirmada a 1440 px en las 10 rutas (20-sep); **falta la pasada a 375 px** |
| E2-18 | Regresión del ATF1: los 6 componentes de Bootstrap siguen funcionando | ATF1-1 | 🟨 | Verificado por HTTP y DOM (menú activo, carrito presente/ausente según página, `data-producto-id` correcto); **falta la verificación visual completa a 375 px** |

---

## Deuda que abre esta reconstrucción

- **D7 se repite en el Sprint 2** — igual que en la spec 001, se saltaron las
  fases Plan y Tasks. Este documento la cierra retroactivamente para la 002,
  pero la causa raíz (pasar de Specify a Implement sin checkpoint) sigue sin
  resolverse como hábito de equipo. Anotado para la Retrospectiva del Sprint 2.
- **E2-17/E2-18 no se pueden marcar ✅** hasta que exista evidencia visual a
  375 px (capturas en `informes/capturas/sprint-02/*-375.jpg`), siguiendo la
  regla T13 (E1-19 no basta con consola limpia; el criterio 1b se juzga
  mirando la pantalla a 375 px).
