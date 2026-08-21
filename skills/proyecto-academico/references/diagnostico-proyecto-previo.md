# Diagnóstico de un proyecto previo

Cuando el equipo ya tiene un proyecto y quiere partir de él, la pregunta no es «¿sirve?» sino **«qué parte sirve, qué falta, y qué no vale la pena tocar»**.

El resultado va a `docs/diagnostico-previo.md`.

---

## 1. Inventario

Recoge datos, no opiniones.

### Archivos y volumen

```bash
find . -type f -name '*.html' -o -name '*.css' -o -name '*.js' | head -50
wc -l *.html css/*.css js/*.js
du -sh assets/ 2>/dev/null
```

Anota: cuántas páginas, cuántas líneas por capa, peso de los recursos estáticos.

### Duplicación

**El dato de mayor rendimiento del diagnóstico.** Mide cuánto del marcado se repite entre páginas: encabezado, pie, menú, componentes compartidos.

Si un curso exige un motor de plantillas con fragments, esa duplicación es exactamente el trabajo que el framework elimina, y es un criterio de rúbrica servido en bandeja. Exprésalo en líneas y en porcentaje:

> El encabezado son 31 líneas repetidas en 10 páginas; el pie, 42 en 8. En total ~1.000 de las 2.270 líneas de HTML (44 %) son marcado repetido.

### Datos embebidos

Busca dónde viven los datos hoy: JSON, arrays en el código, valores escritos a mano en el marcado.

**Cada estructura de datos que encuentres es una futura tabla.** Anota los campos exactos con su tipo — eso alimenta el modelo de datos sin inventar nada.

### Estado y sesión

`localStorage`, `sessionStorage`, cookies, autenticación simulada. Aquí suele estar la mayor brecha frente a una rúbrica de seguridad.

### Deuda y roturas

Código muerto, archivos sin referenciar, enlaces vacíos, funcionalidad a medias, incoherencias entre partes.

```bash
# archivos que nadie referencia
for f in $(find assets -type f); do
  n=$(basename "$f")
  c=$(grep -rIl "$n" --include='*.html' --include='*.css' --include='*.js' . | wc -l)
  [ "$c" -eq 0 ] && echo "SIN REFERENCIAS: $f"
done
```

---

## 2. Clasificación

Cada pieza va a una de tres columnas. **Las tres importan por igual.**

| Columna | Qué entra | Qué implica |
|---|---|---|
| **Conservar** | Funciona y cubre o acerca a un criterio | No se toca salvo para adaptarlo |
| **Adaptar** | Existe pero no cumple la rúbrica en su forma actual | Es el trabajo real de los sprints |
| **No tocar** | Funciona y **no da puntos** | Se conserva tal cual; prohibido invertir sprints |

### «No tocar» es la columna que salva el proyecto

Un proyecto previo suele tener funcionalidad elaborada que ninguna rúbrica califica: un proceso de compra de varios pasos, un catálogo geográfico, un configurador. Es tentador mejorarla porque es lo más visible, y es exactamente donde se pierden los sprints.

Escríbela explícitamente, con nombre y archivo:

> **No tocar:** el asistente de compra de 3 pasos (`js/checkout.js`, 305 líneas) y su validación por tipo de documento; el JSON de división geográfica (25 departamentos); el configurador de packs. Se re-maquetan con el framework, **no se profundizan**.

---

## 3. Brechas contra cada rúbrica

Una tabla por entrega:

| Criterio | Estado actual | Brecha |
|---|---|---|
| Framework CSS con 6 componentes | CSS propio, sin framework; **no hay carrusel** | Migrar y crear el carrusel |
| Código limpio y kebab-case | kebab-case ✔; 616 líneas de CSS muerto, 15 estilos en línea | Limpieza |
| Diagrama de base de datos | No existe modelo de datos | Diseñarlo en el primer sprint |

Sé concreto y verificable: «no hay carrusel» vale; «el front-end necesita mejoras» no.

---

## 4. Entidades inferibles

De los datos embebidos, deduce las tablas futuras con sus campos reales:

| Entidad | Campos observados | Fuente |
|---|---|---|
| Producto | id, nombre, precio, descripción, imagen, galería[], color{nombre,hex}, tallas[] | `js/productos.json` |
| Pedido | número, fecha, cliente, envío, subtotal, total, método de pago | `js/checkout.js` |

Anota también las **reglas de negocio** que estén escritas en el código: umbrales, costos fijos, validaciones. Son requisitos reales que nadie documentó.

---

## 5. Incoherencias

Contradicciones entre partes del proyecto. Cada una es una decisión pendiente que hay que llevar al `spec.md` como `[NECESITA ACLARACIÓN]`:

> - Los colores del configurador no coinciden con los del catálogo: hay uno que no existe como producto.
> - El envío gratis dice S/ 180 en el código y S/ 200 en el texto de la página.
> - Todos los productos muestran «últimas unidades» sin stock real detrás.

---

## 6. Veredicto

Cierra con una recomendación clara, no con un resumen:

> **Partir del proyecto existente.** Aporta el diseño, el copy y la identidad de marca ya trabajados, y su duplicación de marcado (44 %) es justamente lo que el criterio de fragments premia. Lo que falta —framework CSS, carrusel, backend, base de datos y seguridad— es trabajo nuevo que habría que hacer igual empezando de cero.
>
> **Riesgo principal:** los recursos estáticos pesan 39 MB y el entregable es un comprimido. Hay que optimizarlos en el primer sprint.
