# Sistema de memorias

El problema: N personas y sus agentes editando un mismo archivo de contexto produce conflictos de merge constantes y contexto contradictorio.

La solución: **un archivo, un escritor.**

```
proyecto/
├── CLAUDE.md                  # contrato que hace cumplir las reglas a los agentes
├── memory.md                  # memoria GENERAL — escritor único: Scrum Master
└── docs/memoria/
    ├── <nombre>_memory.md     # escritor único: esa persona y su agente
    └── ...                    # una por integrante
```

---

## 1. `memory.md` — memoria general

**Condición de actualización: solo cuando *todos* los integrantes hayan cerrado su sprint.**

Si aunque sea una persona no terminó, `memory.md` no se toca: queda como estaba, el trabajo pendiente se arrastra al siguiente sprint y vive mientras tanto en la memoria personal de quien lo tiene.

**Nunca se consolida un sprint a medias.** La memoria general solo describe estado completo y verificado.

### Plantilla

```markdown
# Memoria general — <Proyecto>

> **Escritor único: <rol/persona>.** Nadie más edita este archivo.
> Se consolida solo cuando los N integrantes cerraron el sprint.
> Es la última foto **estable**: puede estar desactualizada respecto al
> sprint en curso. Si contradice el código, gana el código.

**Última consolidación:** Sprint N — fecha
**Estado de la puerta:** ⬜ <nombre> · ⬜ <nombre> · ...

## 1. Estado actual
Qué está hecho y corriendo. Stack y versiones.

## 2. Decisiones vigentes
| # | Decisión | Motivo | Sprint |

## 3. Convenciones activas
Remite a `docs/constitution.md`. No las duplica.

## 4. Mapa del código
| Ruta | Qué contiene |

## 5. Cobertura de objetivos
| Criterio | Estado | Evidencia (URL + captura) |

## 6. Deuda y pendientes
| # | Pendiente | Origen |

## 7. Trampas conocidas
| # | Trampa |
Cosas que ya rompieron una vez, y por qué.
```

La sección 7 es la que más rendimiento da con el tiempo: evita que la siguiente persona tropiece con lo mismo.

---

## 2. `<nombre>_memory.md` — memoria personal

Escritura libre durante todo el sprint. **Cero conflictos porque nadie más abre ese archivo.**

Contiene el **plan completo del ciclo** de esa persona, no solo el sprint actual: así cualquiera sabe en septiembre qué le toca en noviembre.

### Plantilla

```markdown
# Memoria de <Nombre>

> Escritor único: <Nombre> (y su agente). Nadie más edita este archivo.

**Rol permanente:** <si tiene> — <qué implica>

## Mi rotación
| Sprint | Mi duo | Compañero | Foco |

## Mi plan del ciclo
| Sprint | Fechas | Mis tareas | Entrega |

---

## Sprint 1 — <nombre> · <fechas>
**Duo <X> con <persona>.** Sesiones N-M.

### Mis tareas
| # | Tarea | Criterio | Sesión |

<notas de por qué importan, dependencias, trampas>

## Sprint 2 — ...
<un bloque por sprint, hasta el final del ciclo>

---

## Bitácora — Sprint actual
### <fecha>
- Hice:
- Decidí / aprendí:
- Bloqueo:
- Archivos tocados:

## Para consolidar en memory.md
- [ ] <lo que el resto del equipo necesita saber>

## Contexto propio
Comandos, entorno local, atajos. Solo me sirven a mí.

## Sprints cerrados
<bitácoras archivadas>
```

### El daily vive aquí

Tres líneas al día en la bitácora, no en el chat del grupo. Así el contexto queda versionado en vez de perderse en el historial de mensajes.

---

## 3. La ceremonia de consolidación

Al cierre de cada sprint, 45 minutos tras la review.

**Puerta de entrada.** El Scrum Master verifica que los N integrantes hayan marcado su sprint como cerrado según la Definición de Hecho. Si falta alguien, la ceremonia se corre hasta que termine; si el sprint ya venció, **se cancela** y ese sprint se consolida junto con el siguiente.

Con la puerta abierta:

1. Cada integrante lee su bloque **«Para consolidar»** — 2 min por persona
2. El Scrum Master funde lo aprobado en `memory.md` y actualiza la tabla de cobertura
3. Cada quien archiva su bitácora bajo `## Sprints cerrados` y vacía su bloque
4. **Un solo commit.** `memory.md` queda congelado hasta la siguiente consolidación

### Mientras está congelada

La fuente de verdad sobre trabajo en curso son las memorias personales. Un agente que necesite el estado del día lee `memory.md` (última foto estable) **más** la memoria personal correspondiente, y trata lo segundo como provisional.

---

## 4. `CLAUDE.md` — el contrato

Sin este archivo las reglas anteriores son buenas intenciones. Con él, cualquier agente que abra el repo las cumple.

```markdown
# CLAUDE.md — contrato de trabajo para agentes

## 1. Antes de actuar, lee siempre
1. `memory.md` — memoria general. Última foto estable.
2. `docs/constitution.md` — principios no negociables.
3. `docs/specs/<feature-activo>/spec.md` y `plan.md`.
4. `docs/memoria/<tu-integrante>_memory.md` — tu bitácora.

## 2. Un archivo, un escritor
| Archivo | Único escritor |
|---|---|
| `memory.md` | <rol>, solo en la consolidación |
| `docs/memoria/<nombre>_memory.md` | esa persona y su agente |

**Nunca edites `memory.md`.** **Nunca edites la memoria de otra persona.**

## 3. `memory.md` puede estar desactualizada, y es correcto
Se consolida solo cuando los N cierran el sprint.
- Trátala como base estable; las memorias personales son estado provisional.
- **Si contradice el código, gana el código.** Anota la discrepancia
  en tu memoria personal, bajo «Para consolidar».

## 4. No implementes sin spec aprobado
Ciclo: Specify → Plan → Tasks → Implement, con checkpoint humano entre fases.
Si falta el spec: escríbelo, marca lo ambiguo con `[NECESITA ACLARACIÓN]`
y **detente**.

## 5. Al terminar una tarea
Anota en tu memoria personal: qué hiciste, qué archivos tocaste,
qué decidiste, qué quedó bloqueado, y qué debe consolidarse.

## 6. Convenciones
En `docs/constitution.md`.

## 7. Qué NO hacer
- No añadas capas, patrones ni tablas que ningún objetivo pida.
- No metas secretos en el repo.
- No dupliques un dato entre dos lugares.
- No amplíes el alcance congelado.
```

---

## 5. Por qué funciona

| Problema | Regla que lo resuelve |
|---|---|
| Conflictos de merge en el contexto compartido | Un archivo, un escritor |
| Contexto contradictorio entre agentes | Consolidación completa o ninguna |
| Memoria general que envejece y engaña | «Si contradice el código, gana el código» |
| Trabajo perdido en el chat del grupo | El daily se escribe en la memoria personal |
| «¿Y yo qué hago esta semana?» | El plan completo del ciclo vive en la memoria personal |
