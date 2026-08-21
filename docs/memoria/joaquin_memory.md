# Memoria de Joaquín

> Escritor único: Joaquín (y su agente). Nadie más edita este archivo.
> Ver reglas en `../../CLAUDE.md` §2 y `../constitution.md` art. 9.

**Rol permanente:** **Product Owner** — dueño del backlog, valido cada entrega contra la rúbrica y apruebo los `spec.md` en el checkpoint antes de que nadie escriba código.

## Mi rotación

| Sprint | Mi duo | Compañero | Foco |
|:-:|---|---|---|
| 1 | UI / Front | Dayro | Tema Bootstrap y navbar |
| 2-3 | Datos / Backend | Dayro | Proyecto Spring, rutas y 404 |
| 4-5 | Documento / QA | Jhade | Informe, README y regresión |
| 6-7 | UI / Front | Carlos | Inicio de sesión y listados del panel |

## Mi plan del ciclo

| Sprint | Fechas | Mis tareas | Entrega |
|:-:|---|:-:|---|
| 1 | 20-ago → 04-sep | 3 + PO | ATF1 |
| 2 | 07-sep → 20-sep | 2 + PO | — |
| 3 | 21-sep → 01-oct | 2 + PO | ATF2 |
| 4 | 05-oct → 18-oct | 2 + PO | — |
| 5 | 19-oct → 29-oct | 2 + PO | ATF3 |
| 6 | 02-nov → 15-nov | 3 + PO | — |
| 7 | 16-nov → 29-nov | 2 + PO | — |
| Estab. | 30-nov → 11-dic | Sustentación | TF |

---

## Sprint 1 — Bootstrap y sitio estático · 20-ago → 04-sep

**Duo UI con Dayro.** Sesiones 3-8.

### Como Product Owner — el día 1, antes que nada

El `spec.md` tiene tres `[NECESITA ACLARACIÓN]` que bloquean el modelo de datos y el contenido. **Nadie escribe `plan.md` ni `tasks.md` hasta que los resuelva:**

- [ ] **I1** — ¿La lista válida de colores es la del catálogo (beige, negro, guinda, gris, oliva, azul, marrón) o la del configurador de packs (que incluye un BLANCO que no existe como producto)?
- [ ] **I2** — ¿El umbral de envío gratis es S/ 180 (lo que dice el JS) o S/ 200 (lo que dice el copy)?
- [ ] **I3** — ¿El badge "últimas unidades" se calcula desde un umbral de stock o se asigna a mano por producto?
- [ ] Aprobar `spec.md` → habilita `plan.md`
- [ ] Aprobar `plan.md` → habilita `tasks.md`

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-01 | Bootstrap 5.3 por CDN y `tema-overtext.css` con la paleta de marca (`--bs-primary: #8B1A1A`, fondo `#FFFFFF`, texto `#111111`, secundario `#F5F5F5`, beige `#C8B89A`, bordes `#E5E5E5`) y las tipografías Oswald/Inter | 1a | 3-4 |
| E1-02 | Header como `navbar navbar-expand-lg` responsivo en las 10 páginas, reemplazando `js/nav.js` | 1b | 3-4 |
| E1-25 | `[SÍLABO]` Estilos de párrafo tipográficos en el tema | — | 5-6 |

**E1-01 y E1-02 son lo primero del sprint y desbloquean a todo el equipo.** Nadie debe maquetar sobre una base que va a cambiar: los hago los días 1-2 y los integro el mismo día.

---

## Sprint 2 — Spring Boot y Spring Web · 07-sep → 20-sep

**Duo Datos con Dayro.** Sesiones 9-12.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-01 | Crear el proyecto Spring Boot 3.x con Maven, Java 17+, `spring-boot-starter-web` y `spring-boot-starter-thymeleaf` | — | 9-10 |
| E2-13 | `application.properties` con variables de entorno y `README` de arranque | — | 9-10 |

**E2-01 es la tarea bloqueante del sprint.** Nadie escribe controladores hasta que `mvn spring-boot:run` levante en las **6 máquinas**. Los días 1-2 me toca acompañar a quien no logre compilar.

### Como PO

- [ ] Aprobar `docs/specs/002-migracion-thymeleaf/spec.md`

---

## Sprint 3 — Thymeleaf, rutas y 404 · 21-sep → 01-oct

**Duo Datos con Dayro.** Sesiones 13-16. **Entrega ATF2.**

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-07 | **Página 404 personalizada**: `error/404.html` + `ManejadorErroresGlobal` con `@ControllerAdvice` | **1c** | 15 |
| E2-19 | Página de error 500 con el diseño del sitio | 1c | 15 |

**El 404 vale un cuarto del criterio 1 (6 pts) y es invisible en el uso normal**, así que se olvida con facilidad. Lo hago en la sesión 15 y lo pruebo entrando a `/pagina-que-no-existe`.

### Como PO — antes de entregar

- [ ] Verificar los 4 criterios del ATF2 contra la rúbrica, uno por uno
- [ ] Confirmar que el `.rar` **no incluye `target/`**

---

## Sprint 4 — Spring Data, JPA y MySQL · 05-oct → 18-oct

**Duo Documento/QA con Jhade.** Sesiones 17-20.

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E3-19 | `README` con los pasos para crear la base y arrancar en una máquina nueva | — |
| E3-20 | **Regresión ATF1 + ATF2**: los 6 componentes de Bootstrap, los fragments, el 404 y el menú activo siguen funcionando | ATF1, ATF2 |

Este sprint estoy fuera del código de Spring: me toca garantizar que **nada de lo ya entregado se rompió** al conectar MySQL.

### Como PO

- [ ] Aprobar `docs/specs/003-crud-catalogo/spec.md`

---

## Sprint 5 — CRUD, relaciones y validación · 19-oct → 29-oct

**Duo Documento/QA con Jhade.** Sesiones 21-24. **Entrega ATF3.**

### Mis tareas

| # | Tarea | Criterio |
|---|---|:-:|
| E3-31 | Regresión completa ATF1 + ATF2 | ATF1, ATF2 |
| E3-12 | Empaquetar `ATF3_GRUPO_01.pdf` y `.rar`, y **verificarlo en otra máquina** | **4** |

### Como PO — dirijo la prueba de aceptación en la review

Se ejecuta en vivo, y yo la conduzco:

1. `/admin/productos` muestra los 7 productos *(2a)*
2. "Editar" abre el formulario con **todos** los campos poblados, incluida la categoría *(2c)*
3. Cambiar el nombre y guardar → el listado lo refleja *(3b)*
4. Enviar el formulario **vacío** → un error por campo, sin guardar *(3d)*
5. Llenarlo bien → aparece en el listado *(3a)*
6. Borrar desde la fila → desaparece *(3c)*
7. Borrar una categoría con productos → se impide con mensaje claro
8. Repetir 1-6 en `/admin/categorias`

---

## Sprint 6 — Spring Security · 02-nov → 15-nov

**Duo UI con Carlos.** Sesiones 25-28.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-05 | Conectar el `login.html` que existe desde el ATF1 a `formLogin` con `loginPage("/login")` | **2c** | 27-28 |
| E4-18 | Mostrar el mensaje de error de credenciales inválidas en el formulario | 2c | 27-28 |
| E4-20 | Mostrar el nombre de la persona autenticada en la cabecera | 2c | 27-28 |

**El formulario ya existe**: no lo rehago, solo lo conecto. Es medio punto del criterio 2 casi gratis.

### Como PO

- [ ] Aprobar `docs/specs/004-seguridad-pedidos/spec.md`

---

## Sprint 7 — JWT e integración final · 16-nov → 29-nov

**Duo UI con Carlos.** Sesiones 29-32.

### Mis tareas

| # | Tarea | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-29 | Listados en el panel para **cada** tabla: pedidos, detalles, mensajes, usuarios, roles, colores, variantes | **3a** | 31-32 |
| E4-33 | Repaso de coherencia gráfica en todas las páginas, incluidas las nuevas del panel | **4d** | 31-32 |

**El criterio 3a dice "lectura de *todas* las tablas".** Verifico E4-29 contra `data-model.md` tabla por tabla: no basta con productos y categorías.

### Como PO

- [ ] Confirmar la **congelación de funcionalidad el 29-nov**. Lo que no esté hecho no entra al TF.

---

## Estabilización · 30-nov → 11-dic

### Mis tareas

- [ ] **30-nov:** conducir la auditoría de los 20 criterios con `checklist-entrega.md`
- [ ] E5-08 acordar la vestimenta formal-casual *(criterio 5a — un punto que se pierde por descuido)*
- [ ] E5-04 guion de la sustentación
- [ ] E5-05 y E5-06 los dos ensayos

### Mi bloque en la sustentación — 3 minutos

**Problema, objetivos y finalidad.** Abro la exposición:

> OverText vende por Facebook y WhatsApp. El catálogo son publicaciones dispersas, cada pedido se arma a mano por chat y no queda registro de nada. No hay control de inventario y la atención no escala: fuera de horario, la venta se pierde.

Luego los objetivos general y específicos, y paso a Jonathan con la arquitectura.

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

- Servir el sitio: **no funciona con `file://`** (rutas absolutas y `fetch`). Live Server o `python3 -m http.server` dentro de `app-estatico/`.
- Paleta de marca y copy: `docs/contexto.md`.
- Rúbricas: `../../../rubricas/`. Sílabo: `../../../silabus_general.md`.

---

## Sprints cerrados

*(vacío)*
