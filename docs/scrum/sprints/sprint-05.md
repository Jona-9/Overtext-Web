# Sprint 5 — CRUD, relaciones y validación

**Semanas 11-12 del ciclo · 19-oct → 29-oct-2026 · Sesiones 21 a 24 · Unidad 3**
**Entrega: ATF3** (~30-oct) · **Spec:** `docs/specs/003-crud-catalogo/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 21-22 | Spring validator: relaciones entre tablas, validación de datos, restricciones en las tablas y construcción de aplicaciones web con validación de datos para operaciones CRUD |
| 23 | Integración: implementar JPA con Hibernate en proyectos Spring Web para operaciones CRUD |
| 24 | **Evaluación — ATF3** |

## 2. Objetivo del sprint

> Completar el mantenimiento de productos y categorías desde interfaces Thymeleaf, con inserción, actualización y eliminación funcionando, y validación en todos los campos de ambas entidades.

## 3. Qué pide la rúbrica ATF3 (20 pts)

| Criterio | Pts | Qué exige |
|---|:-:|---|
| 1 Estructura del proyecto | 5 | Por cada tabla: **entidad, repositorio, servicio y controlador**, con su nomenclatura de sufijos y rutas |
| 2 Operaciones de lectura | 5 | a) mostrar **todos** los registros · b) mostrarlos en tabla o componente, **en los formularios de edición** · c) **se cargan todos los datos** del registro seleccionado · d) renderizado con Thymeleaf |
| 3 Operaciones de ejecución | 6 | a) **inserción** por formulario · b) **actualización** por formulario · c) **eliminación** desde la página del listado · d) las entidades tienen **todos los campos con validaciones** |
| 4 Presentación | 4 | Los 2 entregables + informe con carátula, **introducción**, situación problemática, objetivos, diagrama físico, solución y capturas |

**Restricciones de la tarea:** mantenimiento de **al menos 2 tablas** · al menos una con **clave foránea** a otra · en al menos una, **todas las operaciones CRUD** · MySQL · ninguna tabla con **menos de 3 campos** · CRUD con `@Controller` y páginas HTML con Thymeleaf.

> `categoria` (5 campos) y `producto` (11 campos, FK a categoría) cumplen todo. CRUD completo en ambas.

## 4. Alcance

### Duo Datos / Backend — José · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-08 | `@PostMapping` de alta y edición con `th:object` / `th:field` y patrón POST-Redirect-GET | **3a, 3b** | 21-22 |
| E3-09 | Baja con confirmación, desde la fila del listado | **3c** | 21-22 |
| E3-10 | **Bean Validation en todos los campos** de `Producto` y `Categoria` | **3d** | 21-22 |
| E3-21 | `@Valid` + `BindingResult` en los controladores; se reabre el formulario con los errores | **3d** | 21-22 |
| E3-22 | Restricciones en la BD que acompañen a las validaciones: `UNIQUE`, `NOT NULL`, FK | 3d | 21-22 |
| E3-23 | Impedir borrar una categoría con productos asociados (integridad referencial) | 3c | 23 |

**El criterio 3d dice "todos los campos con validaciones", no "algunos".** Las anotaciones campo por campo ya están definidas en `data-model.md` §2.1 y §2.2:

```java
@NotBlank @Size(min=3, max=100)  private String nombre;
@NotNull  @DecimalMin("0.01")    private BigDecimal precio;
@NotNull  @Min(0)                private Integer stock;
@NotNull                         private Categoria categoria;
```

### Duo UI / Front — Jonathan · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E3-07 | `/admin/productos`: listado en tabla con `th:each`, con botones de editar y borrar | **2a, 2b** | 21-22 |
| E3-24 | Formulario de producto que **carga todos los datos** del registro al editar | **2c** | 21-22 |
| E3-25 | Mostrar los errores de validación con `th:errors` y `is-invalid` de Bootstrap | **3d** | 21-22 |
| E3-11 | Lo mismo para `/admin/categorias`: listado, formulario y borrado | 1, 2, 3 | 23 |
| E3-26 | `<select>` de categoría en el formulario de producto, poblado con `th:each` | 2c | 21-22 |
| E3-27 | Mensajes de éxito y error con `RedirectAttributes` y alertas de Bootstrap | 2d | 23 |

**Criterio 2c — "se cargan todos los datos del registro seleccionado".** Es el fallo más común: se abre el formulario de edición y algún campo llega vacío. E3-24 se verifica campo por campo.

### Duo Documento / QA — Joaquín · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E3-28 | **INTRODUCCIÓN** del informe — el ATF3 ya la exige (se adelantó en el Sprint 2) | **4** |
| E3-29 | Actualizar 2.3 con el diagrama físico definitivo y las relaciones | 4 |
| E3-30 | Capturas del CRUD completo: listado, alta, edición, borrado y **errores de validación** | 4 |
| E3-12 | Empaquetar `ATF3_GRUPO_01` y verificar en otra máquina | **4** |
| E3-31 | Regresión ATF1 y ATF2 completa | ATF1, ATF2 |

## 5. Prueba de aceptación del sprint

Se ejecuta en la review, en vivo:

1. Entrar a `/admin/productos` → se ven **los 7 productos** *(2a)*
2. Pulsar "Editar" en uno → el formulario llega con **todos** los campos poblados, incluida la categoría *(2c)*
3. Cambiar el nombre y guardar → el listado refleja el cambio *(3b)*
4. Pulsar "Nuevo", enviar **el formulario vacío** → cada campo muestra su mensaje de error y no se guarda nada *(3d)*
5. Llenarlo bien y guardar → aparece en el listado *(3a)*
6. Borrar ese producto desde la fila → desaparece *(3c)*
7. Intentar borrar una categoría con productos → se impide con un mensaje claro
8. Repetir 1-6 en `/admin/categorias`

## 6. Orden de trabajo

```
Día 1-4   Spring validator recién dictado: validaciones + alta y edición
Día 5-6   Borrado, integridad referencial, mensajes
Día 7     Mantenimiento de categorías (E3-11)
Día 8     Prueba de aceptación completa + regresión
Día 9-10  Informe, capturas, checklist y empaquetado
```

## 7. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] Las cuatro capas con la nomenclatura correcta
- [ ] **Todos** los campos de la entidad tienen validación
- [ ] Enviar el formulario vacío muestra un error por campo, sin guardar
- [ ] Editar carga **todos** los datos del registro
- [ ] Sin errores en consola
- [ ] Captura en `informes/capturas/sprint-05/`
- [ ] Criterio marcado en el checklist
- [ ] Bloque "Para consolidar" escrito

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| Se validan solo algunos campos y el criterio 3d cae de 6 a 3 puntos | Las anotaciones están ya escritas en `data-model.md`; se copian tal cual |
| El formulario de edición deja campos vacíos (criterio 2c) | E3-24 con verificación campo por campo en la prueba de aceptación |
| Solo se hace CRUD en `producto` y no en `categoria` | E3-11 tiene dueño y día asignado |
| Semana 12 concentra evaluación y entrega | El informe se cierra el día 9 |
| Se rompe el ATF2 al añadir el panel | E3-31 regresión obligatoria |

## 9. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 19-oct |
| Daily asíncrono | cada día, en la memoria personal |
| Review | mié 28-oct |
| Retro + consolidación | mié 28-oct, tras la review |
| **Entrega ATF3** | ~30-oct (confirmar en UTP+class) |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 28-oct

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| ATF3-1 estructura (4 capas × 2 tablas) | | |
| ATF3-2a todos los registros | | |
| ATF3-2b tabla y formulario de edición | | |
| ATF3-2c carga completa del registro | | |
| ATF3-2d renderizado Thymeleaf | | |
| ATF3-3a inserción | | |
| ATF3-3b actualización | | |
| ATF3-3c eliminación | | |
| ATF3-3d validaciones en todos los campos | | |

## Retrospectiva — 28-oct

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 6**
