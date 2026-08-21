# Sprint 3 — Thymeleaf, rutas y 404

**Semanas 7-8 del ciclo · 21-sep → 01-oct-2026 · Sesiones 13 a 16 · Unidad 2**
**Entrega: ATF2** (~02-oct) · **Spec:** `docs/specs/002-migracion-thymeleaf/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 13-14 | Thymeleaf: definiciones, usos, ventajas y aplicaciones |
| 15 | Integración: implementar Spring Web junto con el generador de plantillas Thymeleaf |
| 16 | **Evaluación — ATF2** |

## 2. Objetivo del sprint

> Cerrar el sistema de rutas con página de error 404 y menú activo, y dejar todas las páginas renderizadas con Thymeleaf usando fragments, condicionales e iteraciones.

## 3. Qué pide la rúbrica ATF2 (20 pts)

| Criterio | Pts | Qué exige |
|---|:-:|---|
| 1 Navegación y sistema de rutas | 6 | a) rutas de **5+ páginas** · b) **página de inicio por defecto** · c) **página 404** · d) **menú de navegación** |
| 2 Thymeleaf | 6 | a) **2+ fragments en todas** las páginas · b) un **condicional** de renderizado · c) un **bloque repetitivo** en tablas, tarjetas o listas · d) estilo CSS propio o de framework |
| 3 Informe | 4 | Situación problemática · objetivos · diagrama físico de la BD · descripción de la solución · capturas |
| 4 Nomenclatura | 4 | `ATF2_GRUPO_01.pdf` + `ATF2_GRUPO_01.rar` |

**Indicación de la tarea:** *«convertir su presentación previa con las tecnologías Thymeleaf y Spring Boot»*. Se permite rediseñar contenido y estilo.

**Estado al empezar:** 1a y 1b ya vienen del Sprint 2. Faltan 1c, 1d y todo el criterio 2 salvo 2a y 2d.

## 4. Alcance

### Duo Datos / Backend — Joaquín · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-07 | **Página 404 personalizada**: `error/404.html` + `ManejadorErroresGlobal` con `@ControllerAdvice` | **1c** | 15 |
| E2-19 | Página de error 500 | 1c | 15 |
| E2-09 | `ProductoService` que sirve los 7 productos **en memoria** (aún sin BD), consumido por el catálogo y la ficha | **2c** | 13-14 |
| E2-20 | `ContactoController` con `@PostMapping` que procesa el formulario | 1a | 13-14 |

> **Decisión de diseño clave:** el `@Service` devuelve la lista en memoria, con la misma firma que tendrá cuando lea de MySQL. Así el Sprint 4 solo cambia la fuente de datos y ni el controlador ni la plantilla se tocan.

### Duo UI / Front — José · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-08 | Menú de navegación con `th:classappend` marcando el enlace activo | **1d** | 13-14 |
| E2-21 | `th:each` para las tarjetas de producto del catálogo | **2c** | 13-14 |
| E2-22 | `th:each` para los colores del configurador de packs | 2c | 13-14 |
| E2-10 | `th:if` / `th:unless` para el badge de stock y el carrito vacío | **2b** | 13-14 |
| E2-23 | `th:href="@{...}"` en **todos** los enlaces y `th:src` en las imágenes | 1a | 13-14 |
| E2-24 | Verificar que las 10 páginas usan **2+ fragments** sin excepción | **2a** | 15 |

**Criterio 2a: "en todas las páginas".** Una sola página que se quede sin fragments baja el criterio de 6 a 3 puntos. E2-24 se verifica página por página.

### Duo Documento / QA — Jonathan · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E2-11 | Actualizar 2.1.2 del informe: Spring Boot, Spring Web y Thymeleaf | 3 |
| E2-25 | Capturas nuevas de las 10 páginas + **captura del 404** | 3 |
| E2-26 | **Foto de la estructura del proyecto Spring** (la rúbrica la pide dentro del informe) | 3 |
| E2-12 | Empaquetar `ATF2_GRUPO_01` y verificar en otra máquina | **4** |
| E2-27 | Regresión ATF1: los 6 componentes de Bootstrap siguen funcionando | ATF1-1 |

## 5. Orden de trabajo

```
Día 1-4   Thymeleaf recién dictado: fragments, th:each, th:if
Día 5-6   404, menú activo, enlaces con @{...}
Día 7-8   E2-24 verificación de fragments página por página
Día 9-10  Informe, capturas, checklist y empaquetado
```

**El empaquetado no se deja para el último día.** El criterio 4 vale 4 puntos completos y se pierde por un nombre mal escrito o un `.rar` dañado.

## 6. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] La página usa **al menos 2 fragments**
- [ ] Sin errores en consola
- [ ] Probado a 375 px y 1440 px
- [ ] Una URL inexistente muestra el **404 personalizado**
- [ ] El enlace del menú de la página actual aparece marcado
- [ ] Captura en `informes/capturas/sprint-03/`
- [ ] Criterio marcado en el checklist
- [ ] Bloque "Para consolidar" escrito

## 7. Verificación antes de entregar

Además del checklist general:

- [ ] Contar los fragments de **cada una** de las 10 páginas: mínimo 2
- [ ] Señalar en qué página está el `th:if` y en cuál el `th:each`
- [ ] Entrar a `/pagina-que-no-existe` y ver el 404 con el diseño del sitio
- [ ] `http://localhost:8080/` carga la portada sin ruta adicional
- [ ] El `.rar` **no incluye `target/`**

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| Alguna página se queda sin 2 fragments y el criterio cae a la mitad | E2-24 es una tarea propia de verificación, no un supuesto |
| El 404 se olvida: es invisible en el uso normal | Tarea E2-07 con dueño y sesión asignada |
| Se rompe algo del ATF1 al thymeleafizar | E2-27 regresión obligatoria |
| El `.rar` incluye `target/` y pesa de más | En el `.gitignore` y en el checklist §D |
| Semana 8 concentra evaluación y entrega | El informe se cierra en el día 8, no el 10 |

## 9. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 21-sep |
| Daily asíncrono | cada día, en la memoria personal |
| Review | mié 30-sep |
| Retro + consolidación | mié 30-sep, tras la review |
| **Entrega ATF2** | ~02-oct (confirmar en UTP+class) |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 30-sep

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| ATF2-1a rutas 5+ páginas | | |
| ATF2-1b inicio por defecto | | |
| ATF2-1c página 404 | | |
| ATF2-1d menú de navegación | | |
| ATF2-2a 2+ fragments en todas | | |
| ATF2-2b condicional | | |
| ATF2-2c bloque repetitivo | | |
| ATF2-2d estilo CSS aplicado | | |

## Retrospectiva — 30-sep

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 4**
