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

- [x] La portada **no tiene campo Docente** — *añadido (2026-08-28)*
- [x] **No existe sección RECOMENDACIONES** (OBSERVACIONES no es lo mismo; el TF pide las dos por separado) — *añadida (2026-08-28)*
- [x] **No existe sección ANEXOS** (código fuente, capturas, estructura del proyecto) — *añadida con los anexos A, B y C (2026-08-28)*

### Y hay que vaciarla por completo

La plantilla trae contenido de otro proyecto que **hay que borrar entero**:

- [x] Requisitos de un sistema de convivencia escolar (reportar casos e incidencias) — *eliminados*
- [x] Tablas `gender`, `user`, `section`, `level`, `role`, `grade`, `case`, `information`, `incident`, `status` — *eliminadas*
- [x] ~60 referencias bibliográficas sobre Android y acoso escolar — *eliminadas*

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

### 2026-08-28 — cierre del Sprint 1 (mis 4 tareas)

- **Hice:**
  - **E1-20 ✅ — plantilla UTP limpia y con los tres huecos tapados.** `informes/informe.md`
    queda con la estructura completa de 11 secciones: se añadió el campo **Docente** en la
    portada, y las secciones **RECOMENDACIONES** y **ANEXOS** (A código fuente, B capturas,
    C estructura del proyecto), que la plantilla original no traía y el TF exige. Se vació
    **todo** el contenido ajeno: los requisitos del sistema de convivencia escolar, las 10
    tablas de ejemplo (`gender`, `user`, `section`, `level`, `role`, `grade`, `case`,
    `information`, `incident`, `status`) y las ~60 referencias de Android y acoso escolar.
    Queda constancia en la *Nota de limpieza* al pie del archivo.
  - **E1-21 ✅ — redacción de 1.1, 1.2, 2.1, 2.2 y 2.3.** Redactado en mi documento de
    trabajo (ver la nota de abajo). El texto que acompaña a la Figura 1 del diagrama
    físico, que era lo que Jonathan dejó pendiente en E1-22, ya está escrito.
  - **E1-23 ✅ — capturas.** Las 10 páginas del sitio en el navegador, más la foto de la
    estructura del proyecto.
  - **E1-24 ✅ — empaquetado `ATF1_GRUPO_01`** (`.pdf` + `.rar`), sin contraseña, verificado
    descomprimiéndolo en otra máquina antes de enviar.

- **Decidí / aprendí — dónde vive mi redacción.** Trabajo la redacción en **mi propio
  documento**, fuera del repositorio, y de ahí sale el `.pdf` de la entrega. Por eso
  `informes/informe.md` conserva los marcadores `⬜` de las secciones de prosa: **el
  esqueleto y la limpieza sí están en el repo (E1-20), la prosa no.** No es un
  descuido, es el flujo acordado — pero el equipo tiene que saberlo para no leer los `⬜`
  como trabajo sin hacer.

- **Bloqueo:** ninguno. Cierro mi parte del Sprint 1.

- **Archivos tocados:** `informes/informe.md` y `informes/capturas/sprint-01/`.
  La redacción, en mi documento propio.

### 2026-08-20
- Hice: —
- Decidí / aprendí: —
- Bloqueo: —
- Archivos tocados: —

---

## Para consolidar en memory.md

**Sprint 1 — lo que el resto del equipo necesita saber:**

- [x] **Mis 4 tareas del Sprint 1 cerradas:** E1-20 (plantilla), E1-21 (redacción de
      1.1, 1.2, 2.1, 2.2 y 2.3), E1-23 (capturas) y E1-24 (empaquetado `ATF1_GRUPO_01`).
      **Criterio 3 (informe) y criterio 4 (entrega) cubiertos para el ATF1.**
- [x] **Los tres huecos de la plantilla UTP están tapados de forma definitiva:** campo
      **Docente** en la portada, sección **RECOMENDACIONES** y sección **ANEXOS**. No hay
      que volver a hacerlo en diciembre; se hereda a los cuatro informes.
- [x] **La plantilla está vaciada del proyecto ajeno:** cero requisitos de convivencia
      escolar, cero tablas de ejemplo, cero referencias de Android/acoso escolar.
      **Si alguien vuelve a partir de la plantilla original, reintroduce el problema.**
- [ ] **⚠️ Aviso importante sobre `informes/informe.md`.** El archivo del repo es el
      **esqueleto limpio**, con marcadores `⬜` en las secciones de prosa. **La redacción
      la llevo en mi documento propio, fuera del repo**, y de ahí sale el `.pdf` que se
      entrega. Los `⬜` **no** significan trabajo pendiente. Nadie debe "rellenarlos" por
      su cuenta: se duplicaría el texto y se rompería la voz única del documento
      (constitución art. 10, soy la editora).
- [ ] **De cara al Sprint 2 (duo con Jonathan):** me toca la **INTRODUCCIÓN** (E2-15), que
      el ATF2 no exige pero el ATF3 sí. La adelanto ahí porque en la semana 12 no habrá
      tiempo.
- [ ] **Fuentes ya verificadas y estables** para la redacción: `spec.md` §1, §2 y §4,
      `plan.md`, `docs/contexto.md` §01 y §10, y `data-model.md`. La figura del diagrama
      físico es `informes/capturas/sprint-01/diagrama-fisico-bd.png` (el `.svg` está al
      lado y es el que no pixela al imprimir).

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Nomenclatura de entregables: `ATFn_GRUPO_01` — grupo en **dos dígitos**. Un `.rar` dañado o con contraseña cuesta **−3 puntos** en el TF; nombre mal formado, **−1 por archivo**.
- Manual de tono y voz: `docs/contexto.md`. Se tutea siempre, frases cortas, sin exclamaciones de más.

---

## Sprints cerrados

- **Sprint 1 — Bootstrap y sitio estático (20-ago → 04-sep). Cerrado el 28-ago-2026.**
  E1-20 ✅ · E1-21 ✅ · E1-23 ✅ · E1-24 ✅. Entrega **ATF1** empaquetada y verificada.
