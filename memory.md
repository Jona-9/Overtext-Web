# Memoria general — OverText

> **Escritor único: Scrum Master (Jonathan).** Nadie más edita este archivo.
> Se consolida **solo cuando los 6 integrantes cerraron el sprint**. Si falta alguien, este archivo no se toca.
> Es la última foto **estable**: puede estar desactualizada respecto al sprint en curso. Si contradice el código, gana el código.
>
> **Propósito de este archivo:** Registro histórico y memoria viva del equipo OverText. Contiene las decisiones de arquitectura permanentes, el estado consolidado de las entregas evaluadas (ATF1 y ATF2 cerrados) y el estado general del avance en curso (Sprint 4 / PC3).  
> **Para agentes de IA:** No edites este archivo a menos que actúes en el rol explícito de Scrum Master en la consolidación de un sprint. Para conocer tus tareas y código asignado, consulta obligatoriamente **[`AGENTS.md`](Desktop/Overtext-Web/AGENTS.md)** y **[`PC3_INSTRUCCIONES.md`](Desktop/Overtext-Web/PC3_INSTRUCCIONES.md)**.

**Última consolidación formal:** **Sprint 3 — Cierre de ATF2.** Todas las ramas integradas a `testing`.
**Sprint en curso:** **Sprint 4 / Práctica Calificada 3 (PC3)** (19-oct → 29-oct-2026). Persistencia en Supabase, Arquitectura Multicapas, CRUD REST y Validaciones. **Alcance: 100% Backend (sin frontend).**
**Estado de la puerta de control:** 🟨 En curso · Jonathan (SM & DevOps) · Dayro · Carlos · José · Joaquín · Jhade

---

## 1. Estado actual

**ATF2 cerrado y verificado al 100%. En ejecución activa de la PC3 (ATF3).**

- **Línea base congelada:** `app-estatico/` — se conserva intacta como referencia del ATF1, no se edita ni se borra.
- **Proyecto activo:** `overtext/` — Spring Boot **4.0.8** + Thymeleaf, Java 17/21, Maven Wrapper. `./mvnw spring-boot:run` levanta en `http://localhost:8080`. Compilación limpia y 0 errores de consola.
- **10 rutas limpias por controlador y páginas de error integradas:**
  `/`, `/catalogo`, `/producto/{id}`, `/promociones`, `/nosotros`, `/contacto`, `/login`, `/checkout`, `/confirmacion`, `/admin`.
  Páginas de error personalizadas con el diseño de la marca en `templates/error/404.html` y `500.html`.
- **Plantilla base y fragments:** `layout/plantilla.html` centraliza 5 `th:fragment` (`cabecera`, `carrito`, `pie`, `modales`, `scripts`), eliminando la duplicación en las 10 vistas.
- **Renderizado Dinámico Thymeleaf:**
  - `catalogo.html` utiliza `th:each="producto : ${productos}"`, `th:if`, `th:unless`, `th:style` y `th:data-*`.
  - `promociones.html` renderiza dinámicamente los colores del configurador de packs con `th:each`.
  - Rutas e imágenes normalizadas con `th:href="@{...}"` y `th:src="@{...}"`.
- **Foco actual (PC3 / ATF3 — 100% Backend):**
  - **Cero desarrollo de frontend:** El HTML, CSS y plantillas Thymeleaf de la P2 quedan totalmente congelados. Ningún integrante invierte tiempo en maquetar vistas ni formularios para la P3; la rúbrica evalúa exclusivamente servicios REST.
  - **Base de Datos en la Nube:** Migración hacia **Supabase (PostgreSQL)** mediante driver `postgresql` y Spring Data JPA. Script DDL preparado en `overtext/src/main/resources/schema-supabase.sql`.
  - **Arquitectura Multicapas:** Implementación en curso de `entity/`, `dto/`, `repository/`, `service/`, `service/impl/` y `controller/api/`.
  - **APIs CRUD y Validaciones:** Endpoints REST (`GET`, `POST`, `PUT`, `DELETE`), Select JPA + Select Nativo, Bean Validation completo (`@Size`, `@Email`, `@NotNull`, `@Positive`, `@NotBlank`) y validaciones en métodos GET y POST.
  - **Seguimiento granular:** Gestionado formalmente en **[`docs/pc3-tablero-control.md`](Desktop/Overtext-Web/docs/pc3-tablero-control.md)** y la matriz **[`PC3_INSTRUCCIONES.md`](Desktop/Overtext-Web/PC3_INSTRUCCIONES.md)**.

---

## 2. Decisiones vigentes

| # | Decisión | Motivo | Sprint |
|---|---|---|---|
| 1 | Partir del proyecto OverText anterior, no empezar de cero | Ahorra el diseño, el copy y la identidad de marca ya trabajados | 1 |
| 2 | Bootstrap 5 + capa de tema propia (`tema-overtext.css`) | La rúbrica exige framework CSS; el tema conserva la identidad | 1 |
| 3 | El informe se escribe en Markdown, no en `.docx` | Un binario en Git con 6 personas es conflicto garantizado | 1 |
| 4 | `memory.md` se consolida solo con los 6 sprints cerrados | La memoria general solo describe estado completo y verificado | 1 |
| 5 | Repositorio nuevo en `overtext-web/` | Había un `.git` enraizado en el *home* que exponía `.ssh` y `.khipu-secrets` | 1 |
| 6 | No profundizar checkout, ubigeo ni configurador de packs | Funcionan y no dan puntos de rúbrica | 1 |
| 7 | 7 sprints: 1 para el ATF1 y 2 para cada avance siguiente | El ciclo ya va por la semana 2; el ATF1 no da para dos sprints | 1 |
| 8 | Cada sprint usa solo lo dictado esas mismas semanas | Ningún sprint pide una tecnología antes de que se enseñe | 1 |
| 9 | Implementar también los temas del sílabo sin rúbrica (tablas e íconos, REST, **JWT**) | El objetivo es cubrir todo el curso; la rúbrica es el piso, no el techo | 1 |
| 10 | Cada Sprint Review verifica también los criterios de los avances anteriores | Una regresión en el ATF1 cuesta puntos en el TF | 1 |
| 11 | Congelación de funcionalidad el 29-nov | Las semanas 17-18 son para estabilizar y sustentar, no para programar | 1 |
| 12 | Los 7 colores válidos son los de `js/productos.json`: negro, stone beige, guinda, gris, oliva militar, azul marino y marrón | **El BLANCO nunca existió como producto.** Decisión I1 del PO | 1 |
| 13 | Envío gratis desde **S/ 200** | Decisión I2 del PO; coincide con el copy "desde 2 packs" | 1 |
| 14 | El badge de stock bajo se calcula con `stock < 10`, no se guarda | Decisión I3 del PO; un dato calculado no se duplica (art. 7) | 1 |
| 15 | `esquema-fisico.sql` es la fuente autoritativa del modelo de datos | `data-model.md` es la vista lógica; el diagrama se genera, no se dibuja | 1 |
| 16 | Se escribió el DDL de las 10 tablas ya en el Sprint 1, aunque el ATF3 solo use 3 | Las cuatro rúbricas piden el diagrama físico, y a medias no demuestra nada | 1 |
| 17 | **La rama de integración es `testing`.** `develop` no existe ni se va a crear | La DoD la nombraba por inercia de la plantilla; los PR ya entran a `testing` | 1 |
| 18 | Jhade lleva la redacción del informe en un documento propio, fuera del repo | Es la editora y custodia la voz única (art. 10). `informes/informe.md` es el esqueleto limpio: **sus `⬜` no son trabajo pendiente** | 1 |
| 19 | Toda deuda o decisión de PO que toque código sale del Planning con **dueño y número de tarea** | D3 y D4 las detectaron 3 personas y esperaron 3 días a un "duo dueño" que no existía. El art. 9 protege el código, no reparte el trabajo | 1 |
| 20 | **Spring Boot 4.0.8, no 3.x** | `start.spring.io` retiró la línea 3.x el 14-sep, el día que se generó el proyecto. Trazada en `spec.md` §7 (A2) y `plan.md` §3 | 2 |
| 21 | **Base de Datos en la Nube con Supabase (PostgreSQL)** | Garantiza persistencia remota accesible para los 6 integrantes, simplifica la sustentación en vivo y evita depender de MySQL local en la máquina del evaluador | PC3 / 4 |
| 22 | **Tablero de control operativo (`docs/pc3-tablero-control.md`)** | Permite marcar casillas `[x]` por tarea, archivo y captura para cada integrante sin generar conflictos de merge en la memoria general | PC3 / 4 |

---

## 3. Convenciones activas

Ver `docs/constitution.md`. No se duplican aquí.

---

## 4. Mapa del código

| Ruta | Qué contiene |
|---|---|
| `app-estatico/` | Sitio del ATF1. Congelado, no se edita. |
| `overtext/` | Proyecto Spring Boot activo. Controladores en `controller/`, plantillas en `templates/`, estáticos en `static/`. |
| `docs/pc3-tablero-control.md` | **Tablero de seguimiento y control con checklist por casillas de la PC3.** |
| `PC3_INSTRUCCIONES.md` | Guía de implementación técnica, contrato canónico de datos y responsabilidades de la PC3. |
| `docs/specs/` | Specs SDD por feature. |
| `docs/scrum/roadmap.md` | Planificación de las 18 semanas: sílabo → sprint → rúbrica. |
| `docs/memoria/` | Una memoria por integrante. |
| `informes/informe.md` | Informe general vivo. |
| `informes/capturas/pc3/` | Carpeta oficial de las 14 capturas de la PC3. |

---

## 5. Cobertura de rúbrica

Leyenda: ⬜ pendiente · 🟨 en curso · ✅ cubierto y con evidencia

### ATF1 — 20 pts (Cerrado)
Todos los 12 criterios cubiertos y verificados con 0 errores de consola.

### ATF2 — 20 pts (Cerrado en Sprint 3)

| Criterio | Pts | Estado | Evidencia | Quién |
|---|:-:|:---:|---|---|
| 1a Rutas de 5+ páginas | 6 | ✅ | 9 controllers, 10 rutas limpias en `pe.edu.utp.overtext.controller` | Dayro |
| 1b Página de inicio por defecto | — | ✅ | `HomeController` → `GET /` → `paginas/index` | Joaquín / Jonathan |
| 1c Página 404 personalizada | — | ✅ | `templates/error/404.html` y `500.html` con diseño completo | Joaquín / Dayro |
| 1d Menú activo con `th:classappend` | — | ✅ | Fragment `cabecera(paginaActiva, mostrarCarrito)` calcula la clase `active` | Carlos |
| 2a Fragments | 6 | ✅ | `layout/plantilla.html` con 5 fragments (`cabecera`, `carrito`, `pie`, `modales`, `scripts`) | Carlos |
| 2b `th:if`/`th:unless` | — | ✅ | Badge de stock y mensajes condicionales en `catalogo.html` | José / Carlos |
| 2c `th:each` | — | ✅ | Renderizado de tarjetas en catálogo y muestras de color en `promociones.html` | José |

### PC3 / ATF3 — 20 pts (En Curso en Sprint 4 / PC3)

| Criterio Evaluado en `P3.md` | Pts | Estado | Evidencia Planificada | Quién |
|---|:---:|:---:|---|---|
| 1.1 Reutilización de P2 | — | ✅ | Monolito Spring Boot con Thymeleaf operativo | Todo el equipo |
| 1.1 Arquitectura Multicapas (`Entity`, `DTO`, `Controller`, `Repository`, `Service`, `ServiceImpl`) | 5 | 🟨 | Paquetes en `pe.edu.utp.overtext.*` | Dayro, José, Carlos, Joaquín, Jhade |
| 1.1 Conexión a Base de Datos (Supabase Postgres) | — | 🟨 | `pom.xml`, `application.properties`, `schema-supabase.sql` | Jonathan |
| 1.2 CRUD Completo (`GET`, `POST`, `PUT`, `DELETE`) | 6 | ⬜ | `ProductoRestController.java` | Joaquín / Jhade |
| 1.2 Ejecución en Postman / cURL | — | 🟨 | `docs/pruebas/pruebas_curl_pc3.sh` y colección JSON | Jhade |
| 1.2 Select con JPA y Select Nativo | — | ⬜ | `ProductoRepository.java` (`findByActivoTrue` y `@Query(nativeQuery = true)`) | Carlos |
| 1.2 DTO con `@Size`, `@Email`, `@NotNull`, `@Positive`, `@NotBlank` | 5 | ⬜ | `ProductoRequestDTO.java` con las 5 anotaciones | José |
| 1.2 Controlador con Validaciones en POST y GET | — | ⬜ | `@Valid` en POST y `@Positive` en GET en `ProductoRestController` | Joaquín / Jhade |
| Documentación e Informe UTP (Cap. 2, 3 y Bibliografía) | 4 | ⬜ | `informes/informe-p3.md` con las 14 capturas | Jhade |

---

## 6. Deuda y pendientes

### Abiertas
| # | Pendiente | Origen | Dueño | Estado |
|---|---|---|---|---|
| D12 | `js/login.js` tiene credenciales en el cliente | Sprint 1 | Sprint 6 (Spring Security) | Pendiente |
| D15 | Clases CSS sin uso (~18 clases) | Sprint 1 | Refactor UI | Baja prioridad |
| **PC3-01** | Limpieza de frontend (conversión a Backend REST puro) y conexión a Supabase | PC3 | **Jonathan** | **En curso** |
| **PC3-02** | Crear entidades JPA `Categoria` y `Producto` | PC3 | **Dayro** | Bloqueado por PC3-01 |
| **PC3-03** | Crear repositorios con Select JPA y Select Nativo | PC3 | **Carlos** | Bloqueado por PC3-02 |
| **PC3-04** | Crear DTOs con las 5 validaciones obligatorias | PC3 | **José** | Bloqueado por PC3-02 |
| **PC3-05** | Implementar `ProductoServiceImpl` y `ProductoRestController` | PC3 | **Joaquín** | Bloqueado por PC3-03 y 04 |
| **PC3-06** | Ejecutar pruebas Postman/cURL y compilar informe con 14 capturas | PC3 | **Jhade** | Bloqueado por PC3-05 |

### Cerradas en el Sprint 3
| # | Pendiente | Cómo se cerró |
|---|---|---|
| D7 | Checkpoint retroactivo de PO en spec 001 | ✅ Cerrado con aprobación de Joaquín |
| D16 | Checkpoint retroactivo en spec 002 | ✅ Cerrado con `plan.md` y `tasks.md` trazados |
| D17 | `/producto/{id}` inexistente no daba 404 | ✅ `ProductoController` lanza `ResponseStatusException(HttpStatus.NOT_FOUND)` |
| D18 | Modal duplicado en 9 páginas | ✅ Modales centralizados en fragment `modales` de `plantilla.html` |

---

## 7. Aprobación y Visto Bueno del Scrum Master

> **Certificación del Scrum Master:**  
> En mi rol de Scrum Master (Jonathan), certifico la presente actualización de la memoria general del proyecto OverText. Se da por concluido formalmente el ciclo del **ATF2 (Sprint 3)** con todos sus criterios cubiertos y se autoriza el inicio de las tareas de la **PC3 / ATF3** bajo el esquema anti-conflictos estipulado en [`PC3_INSTRUCCIONES.md`](Desktop/Overtext-Web/PC3_INSTRUCCIONES.md) y [`docs/pc3-tablero-control.md`](Desktop/Overtext-Web/docs/pc3-tablero-control.md).

- [x] **Aprobado por el Scrum Master:** **Jonathan (Scrum Master)**  
*Fecha de Registro y Aprobación:* **25 de Octubre de 2026**
