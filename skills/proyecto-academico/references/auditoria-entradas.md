# Auditoría de las entradas

Los documentos de un curso llegan mal con más frecuencia de la que parece: rúbricas duplicadas al descargarlas, archivos de un ciclo anterior, plantillas con contenido de otro trabajo. **Planificar sobre un documento equivocado cuesta semanas.**

Este procedimiento se ejecuta entero antes de leer nada más.

---

## A. Verificación bloqueante — rúbricas duplicadas o faltantes

### A1. ¿Hay rúbricas idénticas?

```bash
md5 rubricas/*.md 2>/dev/null || shasum rubricas/*.md
```

Si dos hashes coinciden, son el mismo archivo con distinto nombre. Si no coinciden, compara igual las que traten de entregas contiguas:

```bash
diff <(sed 's/[[:space:]]//g' rubricas/A.md) <(sed 's/[[:space:]]//g' rubricas/B.md) | head -20
```

**Casi idénticas también cuenta.** Dos rúbricas que solo difieren en la fecha y el nombre del archivo son la misma rúbrica duplicada.

Señales de que una rúbrica no corresponde a su nombre:

- Exige tecnologías de unidades posteriores a su semana en el sílabo
- Sus criterios coinciden con los de otra entrega
- Su total de puntos no cuadra con lo que anuncia el sílabo
- Menciona un tipo de tarea distinto al del nombre del archivo (p. ej. `avance1.md` que dice «TRABAJO FINAL»)

### A2. ¿Están todas?

Cuenta las evaluaciones que anuncia el sistema de evaluación del sílabo y compáralo con el número de rúbricas.

### A3. Si algo falla — detente

**No continúes.** Reporta así:

```
AUDITORÍA: no puedo continuar con seguridad.

  rubricas/avance1.md y rubricas/avance4.md tienen contenido idéntico.
  avance1.md dice «TRABAJO FINAL» y exige Spring Security + MySQL,
  pero el sílabo sitúa el Avance 1 en la semana 4, Unidad 1 (Bootstrap).

  Falta la rúbrica real del Avance 1.

¿Cómo procedo?
  a) Me la pasas
  b) La deduzco del sílabo y la marco como supuesto a validar con el docente
  c) Uso avance1.md tal como está
```

Usa `AskUserQuestion`. **Nunca elijas por el usuario** entre esas opciones.

---

## B. Verificaciones complementarias — informan, no bloquean

Se recogen durante el análisis y se reportan **al final**, cada una con su consecuencia concreta. El usuario decide si actúa.

### B1. Temas del sílabo que ninguna rúbrica califica

Recorre el temario sesión por sesión y marca los que no aparecen en ningún criterio.

Es una diferencia real entre **cumplir la rúbrica** y **cubrir el curso**. Si el equipo quiere lo segundo, esos temas entran al backlog marcados como fuera de rúbrica y recortables.

```
AVISO — temas que se dictan y ninguna rúbrica califica:
  · JWT (sesiones 29-30, dos clases completas)
  · Controladores REST (sesiones 19-20; las rúbricas solo piden @Controller)
  · Tablas e íconos del framework CSS (sesiones 3-4)

¿Se implementan igual, marcados como opcionales?
```

### B2. Secciones que las rúbricas exigen y la plantilla no trae

Extrae la lista de secciones obligatorias de cada rúbrica y compárala con los encabezados de la plantilla.

```
AVISO — la plantilla del informe no contiene:
  · «Docente» en la carátula        → lo exige la rúbrica final
  · Sección RECOMENDACIONES          → distinta de OBSERVACIONES, ambas exigidas
  · Sección ANEXOS                   → código fuente, capturas, estructura
```

Revisa además si la plantilla trae **contenido de otro proyecto** (tablas de ejemplo, requisitos ajenos, bibliografía sin relación). Hay que vaciarla; dejar restos se nota en la sustentación.

### B3. Fechas que no encajan

Compara los años y las fechas de vencimiento de las rúbricas con el ciclo en curso. Es normal que sean de una edición anterior.

```
AVISO — las rúbricas traen fechas del ciclo 2025.
Planifico con las semanas del sílabo y dejo anotado
que cada vencimiento se confirme en el aula virtual.
```

### B4. Contradicciones entre sílabo y rúbrica

Si el sílabo sitúa una entrega en una unidad y la rúbrica exige tecnología de otra, dilo. Suele significar que la rúbrica está desactualizada, o que el docente cambió el esquema.

---

## C. Reporte

Cierra la auditoría con un resumen breve:

```
AUDITORÍA COMPLETA

  Sílabo          silabus_general.md        18 semanas, 4 unidades, 4 evaluaciones
  Rúbricas        4 archivos                sin duplicados
  Plantilla       Documento_Proyecto_UTP.md 3 secciones faltantes (ver avisos)
  Proyecto previo proyectoAnterior/         10 páginas, sin framework CSS

  Avisos: 3 (no bloquean)
```
