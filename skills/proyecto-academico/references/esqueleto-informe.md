# Esqueleto del informe

El informe suele valer un criterio entero en **cada** entrega. Con cuatro entregas eso es una quinta parte de la nota del curso, y casi todo su contenido se repite.

La estrategia: **un solo documento vivo que crece por acumulación**, escrito una vez y entregado cuatro veces.

---

## 1. El informe se escribe en Markdown

Un `.docx` en Git es un binario: dos personas editándolo producen un conflicto irresoluble. Con seis integrantes es cuestión de días.

El informe vive en `informes/informe.md` —diff legible, revisable en PR, sin conflictos— y se **exporta** a `.docx` con la plantilla del curso y luego a `.pdf` solo al empaquetar cada entrega.

**El `.docx` se genera, nunca se edita a mano.**

---

## 2. Mapear rúbrica → plantilla

Extrae las secciones que exige cada rúbrica y crúzalas con los encabezados de la plantilla:

| Requisito de la rúbrica | Sección de la plantilla | Entregas |
|---|---|:-:|
| Carátula con proyecto, integrantes, docente, fecha | Portada | todas |
| Situación problemática | 1.1 | todas |
| Objetivos general y específicos | 1.2 | todas |
| Diagrama de la base de datos | 2.3 | todas |
| Descripción de la solución | 2.1.2 | todas |
| Capturas en el navegador | 2.4 Resultados | todas |
| Introducción | INTRODUCCIÓN | E3, E4 |
| Diccionario de datos | **falta** | E4 |
| Recomendaciones | **falta** | E4 |
| Anexos | **falta** | E4 |

**Las filas marcadas «falta» son el hallazgo.** Se añaden a la plantilla en el primer sprint, no en la semana de la entrega final.

Al revés también importa: una sección que la plantilla trae y ninguna rúbrica pide (requisitos funcionales, resumen ejecutivo) se conserva y se llena desde los artefactos SDD, a coste casi nulo.

---

## 3. Vaciar la plantilla

Las plantillas institucionales suelen venir con un trabajo de ejemplo dentro: requisitos de otro sistema, tablas de otro modelo de datos, decenas de referencias sin relación.

**Hay que borrarlo todo.** Dejar una sola referencia ajena se nota en la sustentación.

Deja una nota al pie del archivo diciendo qué se eliminó, para que nadie lo reponga por error.

---

## 4. De dónde sale cada sección

Este mapeo es la razón principal para usar SDD en un curso: **los specs son el informe**.

| Sección del informe | Artefacto SDD |
|---|---|
| Situación problemática | `spec.md` § problema |
| Objetivos general y específicos | `spec.md` § objetivos |
| Requisitos funcionales y no funcionales | `spec.md` § requisitos |
| Descripción de la solución | `plan.md` |
| Diagrama y diccionario de datos | `data-model.md` |
| Resultados | capturas archivadas en cada review |
| Tecnologías usadas | `plan.md` § stack |

Escribir el `spec.md` **es** escribir el capítulo 1 del informe. No es trabajo duplicado.

---

## 5. Estructura del archivo generado

`informes/informe.md` se genera con la estructura de la plantilla, más las secciones faltantes, y **cada sección marcada**:

- `[E1]` `[E2]` `[E3]` `[E4]` — en qué entrega se exige
- `⬜` — por redactar
- Una línea **Fuente:** apuntando al artefacto del que sale su contenido

```markdown
### 1.1 Situación problemática

`[E1]` ⬜ — **Fuente:** `docs/specs/001-<feature>/spec.md` §1. Trasladar y redactar en prosa.
```

Así cualquiera del equipo sabe, abriendo el archivo, qué falta, cuándo hace falta y de dónde sacarlo.

---

## 6. Tabla de acumulación

Al inicio del archivo, qué secciones se exigen en cada entrega:

| Sección | E1 | E2 | E3 | E4 |
|---|:-:|:-:|:-:|:-:|
| Carátula | ✔ | ✔ | ✔ | ✔ |
| Situación problemática | ✔ | ✔ | ✔ | ✔ |
| Introducción | | | ✔ | ✔ |
| Diccionario de datos | | | | ✔ |

**Regla que genera:** conviene adelantar una sección un avance antes de que se exija. La introducción se escribe en el sprint 2 aunque el ATF2 no la pida, porque en la semana de la tercera entrega no habrá tiempo.

---

## 7. Nomenclatura del entregable

Las rúbricas suelen dar puntos por el **nombre del archivo** y penalizar los fallos. Extrae y deja registrado:

- El patrón exacto: `<PREFIJO>_GRUPO_<NN>.pdf` / `.rar`
- Si el número lleva dos dígitos (`01`, no `1`)
- Penalización por comprimido dañado o con contraseña
- Penalización por nombre mal formado

Va al `checklist-entrega.md` que genera `/sdd-scrum`. Es de los puntos más fáciles de conseguir y de perder.
