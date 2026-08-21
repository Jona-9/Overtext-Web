# Constitución del proyecto

Principios no negociables. Si una tarea los contradice, se corrige la tarea, no el artículo.

Cambiar un artículo requiere acuerdo de todo el equipo en una retrospectiva, y queda registrado en `memory.md`.

---

## Artículos base — van siempre

### Artículo 1 — El objetivo manda

Ninguna tarea entra a un sprint si no se traza a un criterio de rúbrica, a un objetivo del proyecto, o es prerrequisito directo de uno.

En `tasks.md` cada tarea lleva su trazabilidad entre paréntesis: `(E1-1e)`.

> **Sin rúbricas:** se traza a los objetivos específicos o a un requisito funcional del `spec.md`.

### Artículo 2 — Nomenclatura consistente

*(Adaptar al proyecto. Ejemplo para un proyecto en español con front-end propio:)*

Archivos, clases CSS e identificadores en kebab-case y en español: `barra-navegacion`, `tarjeta-producto`. Estados con `.activo`, modificadores con `--`.

El código de cada lenguaje sigue las convenciones de su lenguaje.

### Artículo 3 — Cero errores en consola

Nada se entrega si abre con errores o advertencias. Se verifica en cada Sprint Review.

### Artículo 4 — El framework primero

Si el framework elegido ya tiene el componente, se usa el suyo y solo se re-tematiza. Prohibido reimplementar a mano lo que la librería ya resuelve.

El código propio existe para **tematizar y extender**, no para sustituir al framework.

### Artículo 5 — Sufijos de capa

*(Adaptar al stack. Ejemplo para una arquitectura por capas:)*

| Capa | Nombre |
|---|---|
| Entidad | `Producto` (sin sufijo) |
| Repositorio | `ProductoRepository` |
| Servicio (interfaz) | `ProductoService` |
| Servicio (implementación) | `ProductoServiceImpl` |
| Controlador | `ProductoController` |
| Configuración | `SecurityConfig` |

Cada clase en su paquete. Sin excepciones: las rúbricas de arquitectura suelen puntuar exactamente esto.

### Artículo 6 — Cero secretos en el repositorio

Ni contraseñas, ni claves, ni cadenas de conexión con credenciales. Las contraseñas de usuario siempre cifradas. La configuración sensible va por variables de entorno.

Antes de cualquier `git add`, confirma que estás en el repositorio correcto:

```bash
git rev-parse --show-toplevel
```

### Artículo 7 — Un solo origen de verdad por dato

Prohibido duplicar un valor entre dos lugares. Si un umbral vale 180, ese número existe en **un** sitio y todo lo demás lo lee de ahí.

### Artículo 8 — Simplicidad

No se añade una capa, un patrón, una dependencia ni una tabla que ningún objetivo pida. Ante dos soluciones que cumplen igual, gana la más corta.

El alcance congelado se respeta: lo que está marcado «no tocar» se conserva, no se profundiza.

### Artículo 9 — Un archivo, un escritor

Aplica a las memorias y al reparto de archivos entre duos: cada archivo tiene un dueño durante el sprint.

`memory.md` además solo se consolida **cuando todos cerraron el sprint**; nunca a medias.

### Artículo 10 — La documentación se escribe durante el sprint

El duo del documento cierra su sección en cada Sprint Review, con la evidencia ya archivada. No se redacta la noche anterior a la entrega.

Si hay un documento formal, vive en Markdown versionado. Los formatos binarios se **generan** al exportar; nunca se editan a mano.

---

## Artículos propios del proyecto

Añade aquí los que salgan de las decisiones específicas: restricciones del cliente, convenciones heredadas, límites técnicos.

Cada uno con **su razón**. Un artículo sin motivo explicado se incumple en tres semanas.

---

## Cómo se usa

- `CLAUDE.md` remite aquí; no duplica las convenciones.
- `memory.md` §3 remite aquí; no las duplica.
- Cada sprint verifica en su Definición de Hecho los artículos que apliquen.
- Cuando alguien incumple uno, no se discute el caso: se corrige y, si el artículo es el problema, se lleva a la retrospectiva.
