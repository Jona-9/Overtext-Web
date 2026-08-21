# Artefactos SDD

**Specify → Plan → Tasks → Implement**, con checkpoint humano entre fases.

La especificación es el artefacto primario; el código es su expresión. Mantener el software significa hacer evolucionar la especificación, no reescribir el código.

| Artefacto | Fase | Cuándo |
|---|---|---|
| `constitution.md` | — | Una vez, al arrancar |
| `spec.md` | Specify | Inicio de cada feature |
| `plan.md` | Plan | Tras aprobar el spec |
| `data-model.md` | Plan | Con el plan, o antes si un entregable lo exige |
| `tasks.md` | Tasks | Tras aprobar el plan |

**`plan.md` y `tasks.md` no se escriben junto con el spec.** Esperan el checkpoint. Un `spec.md` recién generado se entrega en estado borrador, con sus `[NECESITA ACLARACIÓN]` visibles.

---

## `spec.md`

Nivel de negocio. **Sin decisiones técnicas**: qué y por qué, nunca cómo.

```markdown
# spec.md — NNN · <Feature>

**Fase SDD:** Specify
**Sprint:** N
**Entrega:** <si aplica>
**Estado:** ⬜ borrador — pendiente del checkpoint del Product Owner

## 1. Situación problemática
Qué se hace hoy y por qué no funciona. Concreto y verificable.
→ Alimenta la sección de problema del informe.

## 2. Objetivos
### 2.1 General
### 2.2 Específicos
Numerados, cada uno etiquetado con la entrega que lo cubre.
### 2.3 Alcance de este sprint
Y **fuera de alcance, explícitamente**.

## 3. Historias de usuario
| # | Como… | quiero… | para… | Criterio |

### Criterios de aceptación
Uno por historia. **Verificables**: se comprueban abriendo la aplicación,
no leyendo el código.

## 4. Requisitos
### 4.1 Funcionales
| Código | Nombre | Entrega |
| RQF-0001 | ... | ... |

### 4.2 No funcionales
| Código | Nombre | Descripción |
| RNF-0001 | ... | ... |

## 5. Cobertura
| Criterio | Cómo se cubre |

## 6. Ambigüedades — `[NECESITA ACLARACIÓN]`
| # | Ambigüedad | Decisión |
Con las preguntas concretas para quien deba resolverlas.

## 7. Lista de verificación
- [x] Toda historia se traza a un criterio u objetivo
- [x] Los criterios de aceptación son verificables
- [x] Lo que queda fuera de alcance está dicho
- [x] Las ambigüedades están marcadas
- [ ] **Checkpoint: aprobado** → habilita escribir `plan.md`
```

### Sobre `[NECESITA ACLARACIÓN]`

Marca toda ambigüedad en vez de resolverla por tu cuenta. Cada una lleva **la pregunta concreta**, no la duda vaga:

> ✔ «¿El umbral de envío gratis es S/ 180, como dice el código, o S/ 200, como dice el texto de la página?»
> ✘ «Revisar la lógica de envíos.»

---

## `plan.md`

Traducción técnica. Aquí sí van las decisiones de implementación, **cada una con su razón**.

```markdown
# plan.md — NNN · <Feature>

**Fase SDD:** Plan · **Estado:** ⬜ pendiente de aprobación

## 1. Decisiones técnicas
| # | Decisión | Alternativa descartada | Motivo |

## 2. Arquitectura
Capas, paquetes, dónde vive cada cosa.

## 3. Contratos
Rutas, firmas, formatos de intercambio.

## 4. Modelo de datos
→ `data-model.md`

## 5. Riesgos técnicos
| Riesgo | Mitigación |

## 6. Verificación
Cómo se comprueba de punta a punta que el feature funciona.
```

---

## `data-model.md`

Se escribe **temprano** si algún entregable exige el diagrama de la base de datos: muchas rúbricas lo piden desde la primera entrega, mucho antes de que exista base de datos.

```markdown
# data-model.md — Modelo de datos

**Diseñado en:** Sprint N · **Implementado en:** por etapas (ver §5)
**Motor:** <BD, versión, codificación>

## 1. Diagrama físico
Bloque ```mermaid con erDiagram.

## 2. Diccionario de datos
Una tabla por entidad:
| Campo | Tipo | Nulo | Restricciones | Descripción |
Las restricciones incluyen las anotaciones de validación literales,
para que quien implemente las copie sin reinventarlas.

## 3. Datos semilla
Los datos reales que ya existan en el proyecto previo.

## 4. Reglas de negocio
| # | Regla | Origen |
Incluidas las que solo estaban escritas en el código.

## 5. Decisiones de modelado
| # | Decisión | Motivo |
Qué se modela, qué no, y en qué etapa entra cada tabla.
```

**§5 es clave en proyectos por etapas:** deja explícito qué tablas necesita cada entrega. Modelar de más es incumplir el artículo 8.

---

## `tasks.md`

```markdown
# tasks.md — NNN · <Feature>

| # | Tarea | Criterio | Dueño | Dep. | [P] |
|---|---|:-:|---|:-:|:-:|
| T01 | ... | E1-1a | <nombre> | — | [P] |
| T02 | ... | E1-1b | <nombre> | T01 | |
```

- **`[P]`** marca las paralelizables: sin dependencias entre sí, se pueden repartir a la vez.
- **Dep.** es lo que ordena el sprint. Las tareas que desbloquean a varias personas van primero y se integran el mismo día.
- Cada tarea es atómica y verificable: si no se puede marcar hecha sin discusión, hay que partirla.

---

## El mapeo que justifica todo esto

En un curso, los specs **son** el informe:

| Artefacto SDD | Sección del informe |
|---|---|
| `spec.md` § situación problemática | Situación problemática |
| `spec.md` § objetivos | Objetivos general y específicos |
| `spec.md` § requisitos | Requisitos funcionales y no funcionales |
| `plan.md` | Descripción de la solución planteada |
| `plan.md` § decisiones | Tecnologías usadas |
| `data-model.md` § 1 | Diagrama de la base de datos |
| `data-model.md` § 2 | Diccionario de datos |
| `tasks.md` + evidencia de review | Resultados |

Escribir el spec no es trabajo extra: es escribir el informe antes, y con mejor estructura.
