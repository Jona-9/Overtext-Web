# Memoria de Jhade

> Escritor único: Jhade (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

**Rol permanente:** **Editora del informe** — custodio la voz única del documento durante todo el ciclo. Soy la única persona que está en el duo del documento en los 7 sprints; mi compañero rota cada avance.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | Documento / QA | José | Limpiar la plantilla y redactar los capítulos 1 y 2 |
| 2-3 | Documento / QA | Jonathan | Introducción y capturas del proyecto Spring |
| 4-5 | Documento / QA | Joaquín | Diagrama físico definitivo y capturas del CRUD |
| 6-7 | Documento / QA | José | Tecnologías, UML, diccionario y conclusiones |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 4 | ATF1 |
| 2 | 07-sep → 20-sep | 2 | — |
| 3 | 21-sep → 01-oct | 2 | ATF2 |
| 4 | 05-oct → 18-oct | 2 | — |
| 5 | 19-oct → 29-oct | 3 | ATF3 |
| 6 | 02-nov → 15-nov | 3 | — |
| 7 | 16-nov → 29-nov | 3 | — |
| Estab. | 30-nov → 11-dic | Exportar + sustentación | TF |

## Regla que gobierna mi trabajo

**Constitución art. 10:** el informe se escribe **durante** el sprint, no la noche antes. Cierro mi sección en cada Sprint Review, con las capturas ya archivadas.

**El informe vive en `informes/informe.md`, en Markdown. El `.docx` se genera, nunca se edita a mano** — un binario en Git con 6 personas es conflicto garantizado.

En la segunda semana de cada sprint, una vez cerrada mi sección del informe, tomo tareas de código con mi duo.

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo Documento/QA con José.** Sesiones 3-8. **Entrega ATF1.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E1-20 | Limpiar la plantilla UTP y añadir **Docente**, **Recomendaciones** y **Anexos** | 3 |
| E1-21 | Redactar 1.1, 1.2, 2.1, 2.2 y 2.3 del informe | **3** |
| E1-23 | Capturas de las 10 páginas + foto de la estructura del proyecto | 3 |
| E1-24 | Empaquetar `ATF1_GRUPO_01.pdf` y `.rar`, y verificarlo en otra máquina | **4** |

### Los tres huecos de la plantilla UTP

El Trabajo Final los exige literalmente y la plantilla **no los trae**. Se arreglan ahora, no en diciembre:

- [ ] La portada **no tiene campo Docente**
- [ ] **No existe sección RECOMENDACIONES** (OBSERVACIONES no es lo mismo; el TF pide las dos por separado)
- [ ] **No existe sección ANEXOS** (código fuente, capturas, estructura del proyecto)

### Y hay que vaciarla por completo

La plantilla trae contenido de otro proyecto que **hay que borrar entero**:

- [ ] Requisitos de un sistema de convivencia escolar (reportar casos e incidencias)
- [ ] Tablas `gender`, `user`, `section`, `level`, `role`, `grade`, `case`, `information`, `incident`, `status`
- [ ] ~60 referencias bibliográficas sobre Android y acoso escolar

> Dejar una sola referencia ajena se nota en la sustentación.

### De dónde sale cada sección

| Sección del informe | Fuente |
|---|---|
| 1.1 Situación problemática | `docs/specs/001-sitio-bootstrap/spec.md` §1 |
| 1.2 Objetivos | `spec.md` §2 |
| 2.1.1 Reseña | `docs/contexto.md` §01 y §10 |
| 2.1.2 Descripción de la solución | `plan.md` |
| 2.2 Requisitos (RQF / RNF) | `spec.md` §4 — las dos tablas ya están escritas |
| 2.3 Diseño de la base de datos | `data-model.md` |
| 2.4 Resultados | `informes/capturas/sprint-0N/` |
| Tono y voz de marca | `docs/contexto.md` |

**Lo que redacto en el Sprint 1 se reutiliza en los cuatro informes.** Se escribe una vez y se cobra cuatro veces: son 16 de los 80 puntos del ciclo.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo Documento/QA con Jonathan.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E2-15 | Redactar la **INTRODUCCIÓN** del informe | 3 |
| E2-16 | Actualizar 2.1.2 con Spring Boot y Spring Web como tecnologías | 3 |

**La introducción la adelanto aquí aunque el ATF2 no la exija:** el ATF3 sí, y en la semana 12 no habrá tiempo.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo Documento/QA con Jonathan.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E2-11 | Actualizar 2.1.2 con Thymeleaf | 3 |
| E2-25 | Capturas nuevas de las 10 páginas + **captura del 404** | 3 |

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo Documento/QA con Joaquín.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E3-17 | Actualizar **2.3 Diseño de la base de datos** con el esquema MySQL real ya creado | 4 |
| E3-18 | Ampliar 2.2 Requisitos con RQF-0010 y RQF-0011 (gestión de productos y categorías) | 4 |

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo Documento/QA con Joaquín.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E3-28 | **INTRODUCCIÓN** — el ATF3 ya la exige; verificar que quedó bien desde el Sprint 2 | **4** |
| E3-29 | Diagrama físico definitivo con todas las relaciones | 4 |
| E3-30 | Capturas del CRUD completo: listado, alta, edición, borrado y **errores de validación** | 4 |

La captura de los **errores de validación** es la evidencia del criterio 3d, que vale 6 puntos. No se olvida.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo Documento/QA con José.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E4-21 | Redactar **2.1.2.1 Tecnologías usadas**: lenguajes, bibliotecas, programas y herramientas | 5 |
| E4-22 | Empezar **2.1.2.2 Descripción técnica** con los diagramas UML (clases y casos de uso) | 5 |
| E4-23 | Actualizar el diagrama físico con `usuario` y `rol` | 5 |

La sección 2.1.2.2 **debe invocar a los anexos** — lo dice la rúbrica del TF.

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo Documento/QA con José.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E4-34 | **Diccionario de datos** completo, tabla por tabla | 5 |
| E4-35 | Terminar los diagramas UML de 2.1.2.2 | 5 |
| E4-36 | Redactar OBSERVACIONES, CONCLUSIONES y **RECOMENDACIONES** | 5 |

El diccionario de datos ya está escrito campo por campo en `data-model.md` §2: se traslada, no se inventa.

**Este es mi sprint más cargado del ciclo.** Son tres secciones grandes del informe y todas son obligatorias para el criterio 5d.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-03 cierre y revisión final de las **11 secciones** del informe
- [ ] E5-09 exportar `informe.md` → `.docx` con la Plantilla UTP → `.pdf` *(06-dic)*
- [ ] E5-10 empaquetar `TF_GRUPO_01` con José *(07-dic)*
- [ ] Entrega final *(11-dic)*

### Verificación de las 11 secciones — criterio 5d

- [ ] Carátula con proyecto, integrantes, **docente** y fecha
- [ ] Introducción
- [ ] Descripción del problema a resolver
- [ ] Objetivos del proyecto
- [ ] Descripción de la solución, con: tecnologías usadas · descripción técnica con UML **invocando a los anexos** · **diccionario de datos**
- [ ] Conclusiones
- [ ] **Recomendaciones**
- [ ] Referencias o bibliografía
- [ ] **Anexos**: código fuente · capturas · estructura del proyecto

### Mi bloque en la sustentación — 3 minutos

**Interfaz, Bootstrap y Thymeleaf.** Después de Dayro:

> La interfaz usa Bootstrap 5 con una capa de tema propia que conserva la identidad de OverText: fondo blanco, texto negro y rojo vino en las llamadas a la acción. Los seis componentes del framework están en producción: contenedores, navbar responsivo, formularios validados, modales, carrusel y sistema de grillas. Thymeleaf elimina la duplicación: encabezado, pie y carrito son fragments reutilizados en todas las páginas.

Cierro y pasamos a las conclusiones entre todos.

---

## Bitácora — Sprint 1

### 2026-08-20
- Hice: —
- Decidí / aprendí: —
- Bloqueo: —
- Archivos tocados: —

---

## Para consolidar en memory.md

- [ ]

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Nomenclatura de entregables: `ATFn_GRUPO_01` — grupo en **dos dígitos**. Un `.rar` dañado o con contraseña cuesta **−3 puntos** en el TF; nombre mal formado, **−1 por archivo**.
- Manual de tono y voz: `docs/contexto.md`. Se tutea siempre, frases cortas, sin exclamaciones de más.

---

## Sprints cerrados

*(vacío)*
