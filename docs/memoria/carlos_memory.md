# Memoria de Carlos

> Escritor único: Carlos (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | Datos / Backend | Jonathan | Modales, offcanvas e íconos |
| 2-3 | UI / Front | José | Layout, fragments y Thymeleaf |
| 4-5 | Datos / Backend | José | Repositorios, servicios y validación |
| 6-7 | UI / Front | Joaquín | Cierre de sesión, roles en la vista y panel |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 5 | ATF1 |
| 2 | 07-sep → 20-sep | 2 | — |
| 3 | 21-sep → 01-oct | 3 | ATF2 |
| 4 | 05-oct → 18-oct | 3 | — |
| 5 | 19-oct → 29-oct | 3 | ATF3 |
| 6 | 02-nov → 15-nov | 3 | — |
| 7 | 16-nov → 29-nov | 4 | — |
| Estab. | 30-nov → 11-dic | Sustentación | TF |

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo Datos con Jonathan.** Sesiones 3-8. **Entrega ATF1.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-08 | **Modal de confirmación de contacto** — migra el modal propio de 102 líneas al `modal` de Bootstrap | **1d** | 5-6 |
| E1-09 | **Modal de guía de tallas** en la ficha de producto | **1d** | 5-6 |
| E1-10 | Panel del carrito convertido en **`offcanvas`** de Bootstrap | 1b | 7 |
| E1-11 | **Bootstrap Icons** en lugar de los PNG de 4-5 MB | 1a | 3-4 |
| E1-26 | `[SÍLABO]` Tabla de tallas con `table table-striped` | — | 3-4 |

### Por qué mis tareas rinden doble

- **E1-10** elimina 243 líneas duplicadas: el panel del carrito está copiado en 6 páginas. El `offcanvas` de Bootstrap lo resuelve y de paso cubre el criterio 1b.
- **E1-11** ataca la deuda D1: `carta.png`, `instagram.png` y `ubicacion.png` pesan **4-5 MB cada uno** para mostrarse a 24 px. Bootstrap Icons los reemplaza por CDN y el `.rar` adelgaza de golpe.
- **E1-09 y E1-26** son la misma pantalla: la tabla de tallas (S/M/L/XL con cintura, cadera y largo) vive dentro del modal. Cubro el criterio 1d y el tema de tablas del sílabo a la vez.

**Constitución art. 4:** no reimplemento nada a mano. Si Bootstrap ya tiene el componente, uso el suyo y solo lo re-tematizo.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo UI con José.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-03 | Construir `layout/plantilla.html` con `th:fragment` | **2a** | 11-12 |
| E2-04 | Fragments `cabecera`, `pie`, `carrito` y `scripts` | **2a** | 11-12 |

### La tarea de mayor retorno de todo el ATF2

El sitio tiene hoy **~1.000 de sus 2.270 líneas de HTML repetidas** (44 %):

| Bloque | Duplicación |
|---|---|
| Encabezado | 31 líneas × 10 páginas |
| Pie | 42 líneas × 8 páginas + 2 variantes |
| Panel del carrito | 41 líneas × 5 páginas |

Los fragments las eliminan de golpe: el HTML se reduce a menos de la mitad y el criterio 2a queda cubierto.

**Soy el dueño único del layout durante este sprint** (constitución art. 9). Nadie más lo toca hasta que esté en `develop`; con 6 personas editando `plantilla.html` a la vez, el conflicto es seguro.

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo UI con José.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-08 | Menú de navegación con `th:classappend` marcando el **enlace activo** | **1d** | 13-14 |
| E2-10 | `th:if` / `th:unless` para el badge de stock y el carrito vacío | **2b** | 13-14 |
| E2-23 | `th:href="@{...}"` en **todos** los enlaces y `th:src` en las imágenes | 1a | 13-14 |

**E2-10 es el criterio 2b entero** (*«un condicional para renderizado»*). Con un solo `th:if` bien puesto basta, pero tiene que ser visible y demostrable en la review.

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo Datos con José.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-03 | `CategoriaRepository` y `ProductoRepository` extendiendo `JpaRepository` | **1** | 17-18 |
| E3-04 | `CategoriaService`/`CategoriaServiceImpl` y `ProductoService`/`ProductoServiceImpl` | **1** | 19-20 |
| E3-13 | `[SÍLABO]` `ProductoRestController` con `@RestController` | — | 19-20 |

### Cuidado con el criterio 1

El descriptor "Completo" exige **las cuatro capas para cada tabla, con su nomenclatura de sufijos y rutas**. Si me salto la capa de servicio "para ir más rápido", el criterio baja de **5 puntos a 2**.

```
entity/Producto.java              repository/ProductoRepository.java
service/ProductoService.java      service/impl/ProductoServiceImpl.java
controller/ProductoController.java
```

Interfaz **y** implementación. Siempre.

**E3-13** cubre el *«proyectos web y REST»* de la sesión 19-20 del sílabo. Ninguna rúbrica lo pide, pero es la base sobre la que Jonathan monta JWT en el Sprint 7.

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo Datos con José.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-10 | **Bean Validation en todos los campos** de `Producto` y `Categoria` | **3d** | 21-22 |
| E3-21 | `@Valid` + `BindingResult` en los controladores; el formulario se reabre con los errores | **3d** | 21-22 |
| E3-22 | Restricciones en la BD que acompañen a las validaciones: `UNIQUE`, `NOT NULL`, FK | 3d | 21-22 |

### El criterio 3d dice "todos los campos", no "algunos"

Vale **6 puntos**; con validaciones parciales cae a 3. Las anotaciones ya están escritas campo por campo en `data-model.md` §2.1 y §2.2 — **las copio tal cual, no las invento**:

```java
@NotBlank @Size(min=3, max=100)  private String nombre;
@NotNull  @DecimalMin("0.01")    private BigDecimal precio;
@NotNull  @Min(0)                private Integer stock;
@NotNull                         private Categoria categoria;
```

Prueba de aceptación: enviar el formulario **vacío** debe mostrar un mensaje de error **por cada campo** y no guardar nada.

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo UI con Joaquín.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-06 | **Botón de cerrar sesión** personalizado conectado a `logout`, con CSRF | **2d** | 27-28 |
| E4-07 | `sec:authorize` en el fragment de cabecera: el menú de administración solo se ve con rol ADMIN | 2a | 27-28 |
| E4-19 | Página **403** con el diseño del sitio | 2a | 27-28 |

**El botón ya existe** en `intranet.html` desde el ATF1: solo lo conecto a `logout`. Es un punto del criterio 2 casi gratis.

Requiere `thymeleaf-extras-springsecurity6` para usar `sec:authorize`. Lo añado al `pom.xml` en el día 1.

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo UI con Joaquín.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-30 | Detalle de pedido: cabecera + líneas, con `th:each` | 3a | 31-32 |
| E4-12 | **KPI del panel calculados con consultas reales** | 3a | 31-32 |
| E4-31 | Marcar un mensaje de contacto como atendido | 3c | 31-32 |
| E4-32 | Cambiar el estado de un pedido: pendiente → pagado → enviado → entregado | 3c | 31-32 |

**E4-12** reemplaza los números escritos a mano en `intranet.html` (128 pedidos del mes, 42 pendientes, 6 productos activos, S/ 8.4k en ventas) por `COUNT` y `SUM` reales. En la sustentación se nota mucho la diferencia.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] E5-01 auditoría de los 20 criterios *(30-nov)*
- [ ] E5-02 correcciones de lo que falle *(01-dic)*
- [ ] E5-05 y E5-06 los dos ensayos

### Mi bloque en la sustentación — 4 minutos, con José

**Modelo de datos y CRUD.** Después de Jonathan:

> La base tiene tablas relacionadas: categoría agrupa productos, el pedido tiene sus líneas de detalle, el usuario tiene un rol. Sobre productos y categorías hay mantenimiento completo desde el panel: crear, consultar, editar y eliminar, todo con formularios Thymeleaf y validación en cada campo.

Demuestro en vivo: crear un producto, editarlo, enviar el formulario vacío para mostrar los errores de validación, y borrarlo. Paso a Dayro con la seguridad.

---

## Bitácora — Sprint 1

### 2026-08-20
- Hice: —
- Decidí / aprendí: —
- Bloqueo: —
- Archivos tocados: —

---

## Para consolidar en memory.md

- [ ]

---

## Contexto propio

- Servir el sitio: **no funciona con `file://`**. Live Server o `python3 -m http.server` en `app-estatico/`.
- Fuentes de datos para el modelo: `app-estatico/js/productos.json` (7 productos), `app-estatico/js/checkout.js` (costos de envío), `app-estatico/detalle-producto.html` (tabla de tallas).
- El modal de contacto actual está en `contacto.html` con `role="dialog"` y `aria-modal`: conservar esos atributos al migrar a Bootstrap.

---

## Sprints cerrados

*(vacío)*
