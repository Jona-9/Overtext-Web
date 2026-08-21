---
name: proyecto-academico
description: Analiza el sílabo, las rúbricas y la plantilla de informe de un curso, y propone proyectos viables con el stack que ese curso exige. Úsala cuando haya que decidir qué proyecto presentar en un curso con entregas calificadas por rúbrica, o cuando ya exista un proyecto previo y haya que decidir qué conservar y qué añadir para cumplir la rúbrica.
user-invocable: true
allowed-tools:
  - Read
  - Write
  - Edit
  - Glob
  - Grep
  - AskUserQuestion
  - Bash(ls *)
  - Bash(mkdir *)
  - Bash(find *)
  - Bash(diff *)
  - Bash(wc *)
  - Bash(md5 *)
  - Bash(shasum *)
---

# /proyecto-academico

Convierte los documentos de un curso en una decisión de proyecto fundamentada y en los artefactos que la sostienen.

**No asume ninguna universidad, curso ni tecnología.** Todo sale de los archivos que se le pasen.

## Entradas

Archivos **`.md`**. Si el usuario tiene PDF o DOCX, se le pide que los convierta antes; esta skill no los lee.

| Documento | Qué aporta |
|---|---|
| Sílabo | Unidades, temas por sesión, calendario, sistema de evaluación, stack obligatorio |
| Rúbricas (una por entrega) | Criterios, puntajes, restricciones, entregables y nomenclatura |
| Plantilla del informe | Estructura del documento que hay que entregar |
| Proyecto previo *(opcional)* | Punto de partida a diagnosticar |

## Flujo

Ocho pasos. **No saltes el 2 ni el 6.**

### 1. Descubrir las entradas

Si el usuario pasó rutas, úsalas. Si no, busca en el directorio actual y en sus subdirectorios patrones como `silabo*`, `silabus*`, `rubrica*`, `avance*`, `plantilla*`, `estructura*`, `formato*`.

Muestra lo que encontraste y pide confirmación antes de leer. Si falta alguno de los tres documentos base, **pregunta**; no continúes suponiendo.

### 2. Auditar — paso bloqueante

Lee `references/auditoria-entradas.md` y ejecútalo entero.

Resumen: compara las rúbricas entre sí; **si dos son idénticas o casi idénticas, detente y avisa**. Compara su número contra las evaluaciones que anuncia el sílabo; si faltan, pregunta.

Nada de lo que sigue es fiable si este paso no pasa.

### 3. Extraer los hechos

Del sílabo y las rúbricas, sin interpretar todavía:

- **Stack obligatorio** — las tecnologías que las rúbricas nombran explícitamente
- **Calendario** — semana y sesión de cada entrega
- **Peso de cada entrega** en la nota final, y nota mínima aprobatoria
- **Criterios con su puntaje**, entrega por entrega
- **Restricciones** de cada tarea (número de páginas, formularios obligatorios, relaciones entre tablas…)
- **Nomenclatura de entregables** y penalizaciones por incumplirla

### 4. Construir la matriz de cobertura

Lee `references/matriz-cobertura.md` y produce las tres tablas: sesión→tema→entrega→criterio, peso en la nota, y acumulación de requisitos entre entregas.

Aquí es donde aparecen los **temas que se dictan pero ninguna rúbrica califica**. Anótalos; se reportan en el paso 8.

### 5. Diagnosticar el proyecto previo *(solo si existe)*

Lee `references/diagnostico-proyecto-previo.md`. El resultado clasifica cada pieza en **conservar · adaptar · no tocar**.

«No tocar» es tan importante como el resto: identifica lo que funciona y **no da puntos**, para no gastar sprints en ello.

### 6. Proponer — checkpoint humano

Lee `references/formato-propuestas.md` y presenta **3 o 4 propuestas**, cada una con su tabla de cobertura por criterio.

Si hay proyecto previo, una de las propuestas debe ser **adaptarlo**, con su coste y su riesgo comparados con empezar de cero.

**Detente aquí.** No escribas ningún artefacto hasta que el usuario elija.

### 7. Producir los artefactos

| Archivo | Referencia |
|---|---|
| `docs/propuesta-proyecto.md` | `references/formato-propuestas.md` |
| `docs/matriz-cobertura.md` | `references/matriz-cobertura.md` |
| `docs/diagnostico-previo.md` *(si aplica)* | `references/diagnostico-proyecto-previo.md` |
| `informes/informe.md` | `references/esqueleto-informe.md` |

### 8. Reportar avisos y encadenar

Reporta los hallazgos **no bloqueantes** encontrados en el camino, cada uno con su consecuencia concreta:

- Temas del sílabo que ninguna rúbrica califica → ¿se implementan igual?
- Secciones que las rúbricas exigen y la plantilla no trae
- Fechas de las rúbricas que no encajan con el ciclo en curso

Cierra sugiriendo `/sdd-scrum`, que lee `docs/propuesta-proyecto.md` y `docs/matriz-cobertura.md` como entrada.

## Reglas

1. **El stack lo manda el sílabo.** Toda propuesta usa las tecnologías que las rúbricas califican. Los añadidos (Docker, tests, CI) van en una lista aparte, marcados **fuera de rúbrica**.
2. **Nunca inventes una fecha, un criterio ni un puntaje.** Si no está en los documentos, pregunta.
3. **Cita siempre la fuente.** Cada afirmación sobre lo que exige el curso debe poder rastrearse a un archivo y una sección.
4. **Tres o cuatro propuestas, no una.** Elegir es del usuario.
5. **Ambición calibrada.** Una propuesta que cubre la rúbrica y se termina vale más que una brillante a medio hacer. Di cuál es la más segura y cuál la más ambiciosa.
6. **La rúbrica es el piso, no el techo.** Si el usuario quiere cubrir todo el sílabo, los temas sin rúbrica entran marcados como opcionales y recortables.
