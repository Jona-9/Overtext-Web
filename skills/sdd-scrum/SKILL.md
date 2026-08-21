---
name: sdd-scrum
description: Monta el andamiaje completo de un proyecto en equipo con Spec-Driven Development y Scrum — constitución, specs, backlog trazado, roadmap, sprints detallados y una memoria por integrante que permite trabajo híbrido persona+agente sin conflictos de edición. Úsala al arrancar un proyecto grupal, tras decidir qué se va a construir, o cuando un equipo necesite organizar sprints y repartir el trabajo por persona.
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
  - Bash(wc *)
  - Bash(grep *)
  - Bash(comm *)
  - Bash(sort *)
---

# /sdd-scrum

Convierte «vamos a construir X entre N personas» en un repositorio donde cada quien sabe qué hace cada día y los agentes no se pisan entre sí.

Funciona **con o sin rúbricas**: en un curso traza cada historia a un criterio calificado; en un proyecto de trabajo, a un objetivo o requisito.

## Entradas

Si existen `docs/propuesta-proyecto.md` y `docs/matriz-cobertura.md` (los produce `/proyecto-academico`), léelos primero: contienen el stack, el calendario y los criterios, y evitan repetir preguntas.

## Flujo

### 1. Preguntar lo que falte

Omite lo que ya sepas por los documentos de entrada.

1. **Arquitectura y stack objetivo** — qué se construye y con qué
2. **Nombres de los integrantes**
3. **Sprints por entrega** — p. ej. «1 para el primero, 2 para los demás»
4. **En qué semana del ciclo están hoy** — sin esto las fechas salen mal
5. **¿Hay rúbricas?** Si no, contra qué se trazan las historias: objetivos o requisitos
6. **¿Hay temas que se dictan en fechas concretas?** Si sí, ningún sprint puede pedirlos antes

### 2. Calcular el calendario

Sprint ↔ semanas ↔ sesiones ↔ entrega. Parte de la **semana actual**, no de la semana 1: si el ciclo ya avanzó, el primer sprint es más corto y hay que decirlo.

Deja explícito que las fechas de las rúbricas pueden ser de un ciclo anterior y hay que confirmarlas.

### 3. Proponer roles y duos

Lee `references/roles-y-rotacion.md`.

Propón Product Owner, Scrum Master y —si hay informe— editor del documento, **con la razón de cada asignación**, y márcalo todo como ajustable. Forma duos y rótalos para que todos pasen por cada capa.

### 4. Mostrar el plan — checkpoint humano

Antes de escribir nada, muestra:

- La lista completa de archivos que vas a crear
- El calendario de sprints con sus fechas
- Los roles y la rotación propuestos
- Cuántas historias tendrá el backlog y cómo se reparten

**Espera confirmación.** Es el mismo checkpoint que SDD exige entre fases.

### 5. Escribir el andamiaje

| Archivo | Referencia |
|---|---|
| `CLAUDE.md` | `references/sistema-memorias.md` |
| `memory.md` | `references/sistema-memorias.md` |
| `docs/memoria/<nombre>_memory.md` × integrantes | `references/sistema-memorias.md` |
| `docs/constitution.md` | `references/constitution.md` |
| `docs/specs/001-<feature>/{spec,plan,tasks,data-model}.md` | `references/formato-spec.md` |
| `docs/scrum/roadmap.md` | `references/formato-sprint.md` |
| `docs/scrum/sprints/sprint-0N.md` × N | `references/formato-sprint.md` |
| `docs/scrum/product-backlog.md` | `references/formato-backlog.md` |
| `docs/scrum/checklist-entrega.md` | `references/formato-sprint.md` |
| `README.md` | — |

Escribe `spec.md` pero **no** `plan.md` ni `tasks.md`: esos esperan el checkpoint del Product Owner. Deja el `spec.md` en estado borrador con sus `[NECESITA ACLARACIÓN]` visibles.

### 6. Autoverificar

Antes de reportar, comprueba y **muestra el resultado**:

```bash
# historias sin dueño
comm -23 <(grep -ohE '^\| E[0-9]-[0-9]{2} ' docs/scrum/product-backlog.md | tr -d '| ' | sort -u) \
         <(grep -ohE '\| E[0-9]-[0-9]{2} \|' docs/memoria/*_memory.md | tr -d '| ' | sort -u)

# historias asignadas a dos personas
grep -ohE '\| E[0-9]-[0-9]{2} \|' docs/memoria/*_memory.md | tr -d '| ' | sort | uniq -d
```

Además: cada sprint cubre al menos un criterio, todo criterio está cubierto por algún sprint, y los enlaces entre `roadmap.md` y `sprints/` resuelven.

## Las ocho reglas invariantes

No se negocian por proyecto. Van a `constitution.md` y a `CLAUDE.md`.

1. **Un archivo, un escritor.** `memory.md` tiene un único escritor y está congelado durante el sprint.
2. **La memoria general se consolida solo cuando *todos* cierran su sprint.** Nunca parcialmente: si falta alguien, se aplaza o se funde con la consolidación siguiente.
3. **`memory.md` es la última foto estable.** Puede estar desactualizada, y **si contradice el código, gana el código**.
4. **No se implementa sin `spec.md` aprobado** por el Product Owner.
5. **Toda historia se traza** a un criterio de rúbrica, o a un objetivo si no hay rúbricas.
6. **Ningún sprint pide una tecnología antes de que se haya enseñado** — solo aplica si hay calendario de temas.
7. **Los requisitos se acumulan entre entregas.** Cada sprint a partir del segundo lleva una tarea de **regresión con dueño**.
8. **Cada integrante recibe su plan completo del ciclo** en su memoria personal, sprint por sprint, no solo el sprint actual.

## Errores que esta skill existe para evitar

| Error | Cómo lo evita |
|---|---|
| Seis personas editando el mismo archivo de contexto | Regla 1: una memoria por persona |
| Contexto contradictorio entre agentes | Reglas 2 y 3: consolidación completa y precedencia del código |
| Trabajo que no suma a ninguna entrega | Regla 5: trazabilidad obligatoria |
| Pedir en el sprint 2 algo que se enseña en el 5 | Regla 6 |
| Romper lo ya entregado al avanzar | Regla 7: regresión con dueño |
| «¿Y yo qué hago esta semana?» | Regla 8: plan personal completo |
| Sprints planificados desde la semana 1 cuando el ciclo ya avanzó | Paso 2: se parte de la semana actual |
