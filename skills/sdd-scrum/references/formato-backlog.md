# Product Backlog

Una historia por fila, cada una trazada a lo que la justifica. Es la fuente única de la que salen los sprints y las memorias personales.

---

## Codificación

`E<épica>-<número>` — `E1-01`, `E3-14`.

Una épica por entrega, o por bloque temático si no hay entregas. Los números **no se reordenan nunca**: una vez asignados, se citan desde los sprints, las memorias y los commits.

Si una historia aparece tarde, se le da el siguiente número libre de su épica aunque quede fuera de orden lógico.

---

## Formato

```markdown
# Product Backlog — <Proyecto>

**Product Owner:** <nombre> · **Scrum Master:** <nombre>
Artículo 1: toda historia se traza a un criterio u objetivo.

Estados: ⬜ pendiente · 🟨 en curso · ✅ hecho
Marca `[SÍLABO]`: se dicta pero ninguna rúbrica lo califica.
Es lo primero que se recorta si el tiempo aprieta.

## Épica 1 — <Nombre> · <Entrega> · Sprint N

| # | Historia | Criterio | Duo | Estado |
|---|---|:-:|---|:-:|
| E1-01 | <verbo + objeto, concreto> | 1a | UI | ⬜ |

## Épica 2 — ...

### Sprint N — <subtítulo>
<Cuando una épica abarca dos sprints, se subdivide.>

---

## Resumen
| Épica | Historias | Sprints | Entrega |
| **Total** | **N** | **N** | **N entregas** |
```

---

## Cómo redactar una historia

**Verbo + objeto + detalle verificable.** Debe poder marcarse hecha sin discusión.

| ✔ | ✘ |
|---|---|
| «Carrusel en la portada: 3+ diapositivas, controles e indicadores» | «Mejorar la portada» |
| «Bean Validation en **todos** los campos de X e Y» | «Añadir validaciones» |
| «Verificar que las 10 páginas usan 2+ fragments, sin excepción» | «Revisar Thymeleaf» |

Cuando el criterio dice «todos» o «en todas», **repítelo en negrita**. Es donde se pierden los puntos: la diferencia entre 6 y 3 puntos suele ser una sola página olvidada.

---

## Historias que no son código

Entran al backlog con el mismo peso:

- Documentación y evidencia
- Empaquetado y verificación de entregables
- **Regresión** — obligatoria desde el segundo sprint
- Ensayos, si hay presentación oral

Si no están en el backlog, no tienen dueño; y si no tienen dueño, no se hacen.

---

## Trazabilidad

Cada historia lleva **la referencia exacta**, no una categoría vaga:

- Con rúbrica: el criterio y su letra — `3d`, no «validaciones»
- Sin rúbrica: el objetivo específico o el requisito — `RQF-0004`
- Fuera de rúbrica: la marca `[SÍLABO]` y la sesión en que se dicta

Una historia que no se puede trazar **no entra al sprint** (artículo 1). O se descarta, o se descubre que falta un objetivo en el spec.

---

## Verificación del reparto

Tras generar el backlog y las memorias personales, comprobar y **mostrar el resultado**:

```bash
# historias sin dueño
comm -23 <(grep -ohE '^\| E[0-9]-[0-9]{2} ' docs/scrum/product-backlog.md | tr -d '| ' | sort -u) \
         <(grep -ohE '\| E[0-9]-[0-9]{2} \|' docs/memoria/*_memory.md | tr -d '| ' | sort -u)

# historias asignadas a dos personas
grep -ohE '\| E[0-9]-[0-9]{2} \|' docs/memoria/*_memory.md | tr -d '| ' | sort | uniq -d

# cuántas lleva cada quien
for f in docs/memoria/*_memory.md; do
  printf "%-12s %s\n" "$(basename "$f" _memory.md)" \
    "$(grep -cE '\| E[0-9]-[0-9]{2} \|' "$f")"
done
```

Ambas listas deben salir **vacías**. El reparto no tiene por qué ser idéntico: quien lleva Product Owner o Scrum Master carga menos historias de implementación, y eso es correcto — pero hay que decirlo al reportar.

Las historias compartidas por todo el equipo y las de cierre no aparecerán en estas listas si se escriben como casillas en vez de filas de tabla. Verifícalas aparte.
