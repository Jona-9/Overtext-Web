# Constitución del proyecto — OverText

Diez artículos que no se negocian durante el ciclo. Si una tarea los contradice, se corrige la tarea, no el artículo.

Cambiar un artículo requiere acuerdo de los 6 en una retrospectiva, y queda registrado en `memory.md`.

---

### Artículo 1 — La rúbrica manda

Ninguna tarea entra a un sprint si no se traza a un criterio de rúbrica o es prerrequisito directo de uno. En el `tasks.md` cada tarea lleva su criterio entre paréntesis: `(ATF1-1e)`.

### Artículo 2 — kebab-case en español

Archivos, clases CSS e identificadores HTML se nombran en kebab-case y en español: `barra-navegacion`, `tarjeta-producto`, `detalle-producto.html`. Estados con `.activo`, modificadores con `--`: `.navegacion--activa`.

Excepción: el código Java sigue las convenciones de Java (§ artículo 5), y las clases de Bootstrap se usan tal cual vienen.

*Criterio ATF1-2c.*

### Artículo 3 — Cero errores en consola

Ninguna página se entrega si abre con errores o advertencias en la consola del navegador. Se verifica en cada Sprint Review, página por página.

*Criterio ATF1-2d.*

### Artículo 4 — Bootstrap primero, CSS propio después

Si Bootstrap 5 ya tiene el componente, se usa el de Bootstrap y solo se re-tematiza mediante variables en `tema-overtext.css`. Prohibido reimplementar a mano un carrusel, un modal, un offcanvas o una grilla.

El CSS propio existe para **tematizar**, no para sustituir al framework.

### Artículo 5 — Sufijos de capa en Java

| Capa | Nombre |
|---|---|
| Entidad | `Producto` (sin sufijo) |
| Repositorio | `ProductoRepository` |
| Servicio (interfaz) | `ProductoService` |
| Servicio (implementación) | `ProductoServiceImpl` |
| Controlador | `ProductoController` |
| Configuración | `SecurityConfig`, `WebConfig` |

Cada clase en el paquete que le corresponde. Sin excepciones.

*Criterio ATF3-1 y TF-1.*

### Artículo 6 — Cero secretos en el repositorio

Ni contraseñas, ni claves, ni cadenas de conexión con credenciales. Las contraseñas de usuario siempre con BCrypt. La configuración sensible va por variables de entorno.

Antes de cualquier `git add`, confirma con `git rev-parse --show-toplevel` que estás dentro de `overtext-web`.

### Artículo 7 — Un solo origen de verdad por dato

Prohibido duplicar un valor entre HTML y JS, o entre JS y el copy. Si el umbral de envío gratis es S/ 180, ese número existe en **un** sitio y todo lo demás lo lee de ahí.

*Deudas D3 y D4 de `memory.md` son incumplimientos de este artículo heredados del proyecto anterior.*

### Artículo 8 — Simplicidad

No se añade una capa, un patrón de diseño, una dependencia ni una tabla que ninguna rúbrica pida. Ante dos soluciones que cumplen igual, gana la más corta.

El alcance congelado: el checkout de 3 pasos, el ubigeo y el configurador de packs se conservan y re-maquetan, **no se profundizan**.

### Artículo 9 — Un archivo, un escritor

Aplica a las memorias y al reparto de CSS y plantillas entre duos: cada archivo tiene un dueño durante el sprint.

`memory.md` además solo se consolida **cuando los 6 integrantes cerraron el sprint**; nunca a medias. Si falta alguien, la consolidación se aplaza o se funde con la del sprint siguiente.

### Artículo 10 — El informe se escribe durante el sprint

El duo del documento cierra su sección en cada Sprint Review, con las capturas ya archivadas en `informes/capturas/sprint-0N/`. No se redacta la noche anterior a la entrega.

El informe vive en `informes/informe.md`. El `.docx` y el `.pdf` se **generan** al empaquetar; nunca se editan a mano.
