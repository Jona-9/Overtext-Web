# Roles, duos y rotación

Todo lo de aquí se propone **con su razón** y se marca como ajustable. En Scrum el equipo se autoorganiza; la skill sugiere un punto de partida para que la primera reunión no empiece en blanco.

---

## Roles permanentes

| Rol | Cuántos | Responsabilidad | A quién proponer |
|---|:-:|---|---|
| **Product Owner** | 1 | Dueño del backlog, valida contra los criterios, aprueba los `spec.md` | Quien tenga más claro el dominio o más contacto con quien evalúa |
| **Scrum Master** | 1 | Facilita ceremonias, desbloquea, **único escritor de `memory.md`** | Quien administre el repositorio o tenga más contexto técnico global |
| **Editor del documento** | 1 | Custodia la voz única del informe todo el ciclo | Quien escriba mejor; **no rota** |

**Product Owner y Scrum Master también programan.** En un equipo pequeño no hay sitio para roles a tiempo completo, pero llevan menos historias de implementación y eso hay que decirlo al repartir.

### Por qué el editor del documento no rota

Si el informe pasa por cinco manos, se nota: cambian el tono, la terminología y el nivel de detalle entre secciones. Una persona fija lo mantiene coherente; su **compañero de duo sí rota**, así que igual pasa por las distintas capas del proyecto.

---

## Duos

Dos personas por área. Menos de dos y no hay revisión cruzada; más de dos y se pisan.

| Duo | Área |
|---|---|
| **A — Interfaz** | Front-end, plantillas, componentes, estilos |
| **B — Datos** | Modelo, persistencia, servicios, seguridad |
| **C — Documento y calidad** | Documentación, evidencia, regresión, empaquetado |

Con 4 personas: dos duos, y el documento se reparte. Con 6: tres duos. Con más de 6: añade un duo antes que engordar los existentes.

### Por qué duos y no individuos

- Nadie se bloquea solo
- Revisión cruzada natural dentro del duo
- Los pull request los revisa **otro** duo, no el propio
- Cada duo es dueño de sus archivos durante el sprint (artículo 9), y eso elimina los conflictos

---

## Rotación

**Rotar cada entrega, no cada sprint.** Un sprint es poco para aprender un área; dos entregas seguidas en la misma es demasiado.

| Entrega | Duo A | Duo B | Duo C |
|:-:|---|---|---|
| 1 | P1 · P4 | P3 · P5 | P2 · **P6** |
| 2 | P2 · P5 | P1 · P4 | P3 · **P6** |
| 3 | P3 · P4 | P2 · P5 | P1 · **P6** |
| 4 | P1 · P5 | P3 · P4 | P2 · **P6** |

Reglas al construirla:

1. **Todos pasan por el área de datos** al menos una vez. Suele ser el objetivo de aprendizaje y lo que hay que defender en la sustentación.
2. **Nadie repite compañero** dos entregas seguidas.
3. **El editor del documento** (P6) se queda en el duo C; su compañero rota.
4. **Nadie repite área** dos entregas seguidas, salvo el editor.

Verifica la tabla antes de proponerla: es fácil que alguien acabe sin pasar nunca por el back-end.

---

## Reparto dentro del duo

Las historias se reparten **por persona, no por duo**. Cada memoria personal lleva sus propias tareas con nombre y apellido.

Al repartir:

- **Equilibra el número**, pero descuenta carga a quien lleva Product Owner o Scrum Master.
- **Agrupa lo relacionado.** Quien hace el modal hace también la tabla que va dentro.
- **Marca las dependencias.** Si la tarea de A bloquea a B, dilo en ambas memorias.
- **Señala lo crítico.** Si una tarea vale un criterio entero, la memoria de esa persona debe decirlo.

---

## Reparto de una presentación oral

Si hay sustentación, **todos hablan**. Es la razón de la rotación: cada quien debe poder explicar el área por la que pasó.

| Bloque | Quién | Min |
|---|---|:-:|
| Problema, objetivos y finalidad | Product Owner | 3 |
| Arquitectura y tecnologías | Scrum Master | 3 |
| Modelo de datos y operaciones | Duo de datos | 4 |
| Seguridad y control de acceso | Quien la implementó | 3 |
| Interfaz y experiencia | Editor del documento | 3 |
| Conclusiones | Todos | 2 |

Cada bloque va en la memoria personal de quien lo expone, **con un guion escrito**, no solo el título. Se ensaya al menos dos veces, cronometrado, y con un plan B por si falla la demo en vivo.
