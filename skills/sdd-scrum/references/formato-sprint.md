# Roadmap, sprints y checklist

---

## 1. `docs/scrum/roadmap.md`

La planificación completa del periodo. Es el índice del que cuelga todo.

```markdown
# Hoja de ruta — <Proyecto>

## 1. Vista general
| Sprint | Semanas | Fechas | Sesiones | Unidad | Entrega |

## 2. Peso de cada entrega
La fórmula de la nota y el mínimo aprobatorio. *(Solo si es académico.)*

## 3. Temas → sprint → criterio
Una fila por sesión: qué se dicta, en qué sprint se aplica,
dónde se aplica y qué criterio cubre.

## 4. Temas sin criterio asociado
Los que se dictan y ninguna rúbrica califica.
Marcados `[SÍLABO]`, con la regla de que son lo primero que se recorta.

## 5. Rotación de duos
| Sprint(s) | Duo A | Duo B | Duo C |
Y los roles permanentes.

## 6. Acumulación de requisitos
| Requisito | E1 | E2 | E3 | E4 |
**Regla derivada:** cada Sprint Review verifica también los criterios
de las entregas anteriores.

## 7. Detalle por sprint
Enlaces a `sprints/sprint-0N.md`.
```

### Cómo calcular el calendario

1. Parte de **la semana actual**, no de la semana 1. Si el periodo ya avanzó, el primer sprint es más corto: dilo explícitamente.
2. Ancla el final de cada sprint a su entrega. Un sprint que termina tres días después de la entrega no sirve.
3. Reparte los sprints restantes de forma uniforme entre entregas.
4. Asigna a cada sprint las sesiones que se dictan en sus semanas: **ningún sprint puede pedir una tecnología antes de que se enseñe.**
5. Si las fechas de las rúbricas son de un periodo anterior, avísalo y planifica con las semanas del calendario oficial.

---

## 2. `docs/scrum/sprints/sprint-0N.md`

Un archivo por sprint. Autocontenido: quien lo abre sabe qué hacer sin leer nada más.

```markdown
# Sprint N — <Nombre>

**Semanas X-Y · <fechas> · Sesiones A a B · <Unidad>**
**Entrega: <E>** (~fecha) · **Spec:** `docs/specs/NNN-<feature>/`

## 1. Temas que se dictan estas semanas
| Sesión | Tema |
Copiados **literales** del sílabo.

## 2. Objetivo del sprint
> Una sola frase, en cita.

Si el sprint no entrega nada, di por qué existe.

## 3. Qué pide la rúbrica
| Criterio | Pts | Qué exige |
Más las restricciones de la tarea, y qué parte ya viene del sprint anterior.

## 4. Alcance
### Duo <X> — <Persona> · <Persona>
| # | Historia | Criterio | Sesión |

<Nota de por qué estas tareas importan: qué desbloquean,
cuánto valen, dónde está la trampa.>

<Un bloque por duo. Y uno de «todo el equipo» si aplica.>

## 5. Orden de trabajo
```
Día 1-2   <lo que desbloquea a los demás>
Día 3-6   <trabajo en paralelo por duo>
Día 7-8   <integración>
Día 9-10  <verificación y cierre>
```

## 6. Definición de Hecho
Casillas verificables, incluida la evidencia archivada
y el bloque «Para consolidar» escrito.

## 7. Riesgos
| Riesgo | Mitigación |

## 8. Ceremonias
| Ceremonia | Cuándo |

**Puerta de consolidación:** ⬜ <nombre> · ⬜ <nombre> · ...

---

## Sprint Review — <fecha>
*(por completar)*
| Criterio | Estado | Evidencia |
Una fila por criterio que el sprint debía cubrir.

## Retrospectiva — <fecha>
*(por completar)*
**Qué funcionó** · **Qué no** · **Qué cambiamos para el Sprint N+1**
```

### Reglas al redactarlo

- **Los temas van literales.** Es lo que el docente dictará; parafrasearlos pierde el anclaje.
- **Cada tarea con su criterio y su sesión.** Sin eso no se puede verificar que el sprint use lo recién aprendido.
- **Di dónde está la trampa.** «El criterio dice *todos* los campos, no *algunos*» vale más que repetir el enunciado.
- **Nombra a las personas**, no a los roles abstractos.
- **El orden de trabajo importa.** Identifica qué desbloquea a los demás y ponlo primero.
- **Desde el sprint 2, siempre una tarea de regresión con dueño.**

---

## 3. `docs/scrum/checklist-entrega.md`

Se ejecuta antes de cada entrega. Nada se envía con una casilla sin marcar.

```markdown
# Checklist de entrega

## A. Funcionamiento
- [ ] El proyecto compila y arranca desde cero
- [ ] Sin errores en consola
- [ ] Probado en el rango de pantallas que exige el proyecto
- [ ] <verificaciones que se acumulan por entrega>

## B. Criterios visibles
Marcar **dónde** se demuestra cada componente exigido.
- [ ] <componente> → ______

## C. Documentación
- [ ] Documento actualizado y exportado
- [ ] Todas las secciones que la entrega exige
- [ ] Evidencia archivada

## D. Empaquetado  *(suele valer un criterio entero)*
- [ ] Nombre **exacto** del patrón exigido
- [ ] Numeración con el formato exigido (dos dígitos si aplica)
- [ ] Sin contraseña
- [ ] **Verificado en otra máquina**: descomprimido, compilado y arrancado
- [ ] Sin artefactos de compilación dentro

## E. Cierre
- [ ] Etiqueta en la rama principal
- [ ] Los N integrantes cerraron su sprint → habilita consolidar `memory.md`
- [ ] Tabla de cobertura actualizada
```

**El bloque D es el más rentable.** Es de los puntos más fáciles de conseguir y de perder: las penalizaciones por nombre mal formado o comprimido dañado suelen estar escritas en la rúbrica.

Extrae de las rúbricas las penalizaciones exactas y ponlas aquí con su valor.
