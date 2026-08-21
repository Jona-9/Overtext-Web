# Matriz de cobertura

Tres tablas que convierten el sílabo y las rúbricas en un plan verificable. Van a `docs/matriz-cobertura.md` y las consume `/sdd-scrum`.

---

## Tabla 1 — Vista general de entregas

Una fila por entrega. Es el esqueleto del calendario.

| Entrega | Semanas | Sesiones | Unidad | Tecnologías que exige | Peso |
|:-:|:-:|:-:|---|---|:-:|
| ATF1 | 2-4 | 3-8 | U1 · Frameworks de front-end | Bootstrap | 20 % |
| ATF2 | 5-8 | 9-16 | U2 · Introducción a Spring | Spring Boot, Thymeleaf | 20 % |
| ATF3 | 9-12 | 17-24 | U3 · Spring con bases de datos | Spring Data, JPA, MySQL | 20 % |
| TF | 13-18 | 25-35 | U4 · Spring Security | Spring Security | 40 % |

Añade debajo la fórmula de la nota final y la nota mínima aprobatoria, tal como las escribe el sílabo.

---

## Tabla 2 — Sesión → tema → entrega → criterio

El corazón de la matriz. Una fila por sesión o par de sesiones.

| Sesión | Tema del sílabo | Entrega | Se aplica en | Criterio |
|:-:|---|:-:|---|---|
| 3-4 | Bootstrap: CDN, contenedores, filas y columnas, navbar, imágenes, tablas, íconos | ATF1 | Navbar, grillas, contenedores | 1a, 1b, 1f |
| 5-6 | Elementos web, ventanas modales, estilos de párrafo, formularios | ATF1 | Modales, formularios validados | 1c, 1d |
| 7 | Integración: GUI con ventanas flotantes y formularios | ATF1 | Carrusel, offcanvas | 1e |
| 8 | **Evaluación** | ATF1 | — | — |

**Reglas para llenarla:**

- Copia el tema **literal** del sílabo, no lo resumas: es lo que el docente dictará.
- La columna «se aplica en» se llena después de elegir el proyecto.
- Marca las sesiones de evaluación en negrita: fijan el límite de cada sprint.
- Si un tema no tiene criterio, deja la celda vacía y anótalo para la tabla 4.

---

## Tabla 3 — Acumulación de requisitos

**La tabla que más problemas evita.** Cada entrega conserva lo que exigía la anterior; romper algo del primer avance cuesta puntos en el último.

| Requisito | E1 | E2 | E3 | E4 |
|---|:-:|:-:|:-:|:-:|
| 5 páginas mínimo | ✔ | ✔ | ✔ | ✔ |
| Formulario de inicio de sesión | ✔ | ✔ | ✔ | ✔ |
| Encabezado, cuerpo y pie en todas | ✔ | ✔ | ✔ | ✔ |
| Diagrama de la base de datos en el informe | ✔ | ✔ | ✔ | ✔ |
| Motor de plantillas con fragments | | ✔ | ✔ | ✔ |
| CRUD completo desde interfaz | | | ✔ | ✔ |
| Seguridad con roles y cifrado | | | | ✔ |

**Cómo se llena:** lee las «consideraciones de la tarea» de cada rúbrica. Suelen repetir las mismas restricciones entrega tras entrega — eso es exactamente lo que hay que capturar.

**Regla que genera:** cada sprint a partir del segundo lleva una tarea de **regresión con dueño asignado**. `/sdd-scrum` la crea automáticamente a partir de esta tabla.

---

## Tabla 4 — Temas sin rúbrica

Los que se dictan y ninguna rúbrica califica.

| Tema | Sesión | Cómo se cubriría | Coste |
|---|:-:|---|---|
| JWT | 29-30 | API REST protegida con token | Alto — dos clases completas |
| Controladores REST | 19-20 | Un `@RestController` sobre una entidad | Bajo |
| Tablas e íconos del framework | 3-4 | Tabla de datos + set de íconos por CDN | Bajo |

Se marcan `[SÍLABO]` en el backlog, **con la regla explícita de que son lo primero que se recorta** si el tiempo aprieta: no cuestan nota, pero cuentan para cubrir el curso y dan material para la sustentación.

---

## Tabla 5 — Criterios con su puntaje

Detalle por entrega. Es lo que `/sdd-scrum` usa para trazar cada historia.

| Criterio | Pts | Qué exige literalmente | Cómo se pierde |
|---|:-:|---|---|
| 1 Framework front-end | 6 | Los 6 componentes: contenedores, menús responsivos, formularios, modales, carrusel, grillas | Con 4 de 6 baja a 4 pts |
| 2 Estructura del código | 6 | Estructurado, limpio, kebab-case, JS sin errores | Con 3 de 4 baja a 4 pts |

**La columna «cómo se pierde» es la más útil.** Casi todas las rúbricas son escalonadas: cumplir 3 de 4 puntos no da el 75 % de la nota, sino un salto discreto que suele ser mucho menor. Deja explícito ese salto.
