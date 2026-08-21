# Hoja de ruta del ciclo — OverText

Planificación completa de las 18 semanas: **7 sprints**, 4 entregas.
Un sprint para el ATF1 y dos sprints para cada uno de los avances 2, 3 y 4.

Cada sprint se apoya en los temas que el docente dicta **esas mismas semanas**: lo que se ve en clase el martes se aplica al proyecto esa semana. Ningún sprint pide una tecnología antes de que se haya enseñado.

---

## 1. Vista general

| Sprint | Semanas | Fechas | Sesiones del sílabo | Unidad | Entrega |
|:---:|:---:|---|:---:|---|---|
| **1** | 2-4 | 20-ago → 04-sep | 3 – 8 | U1 · Frameworks de front-end | **ATF1** ~04-sep |
| **2** | 5-6 | 07-sep → 20-sep | 9 – 12 | U2 · Introducción a Spring | — |
| **3** | 7-8 | 21-sep → 01-oct | 13 – 16 | U2 · Introducción a Spring | **ATF2** ~02-oct |
| **4** | 9-10 | 05-oct → 18-oct | 17 – 20 | U3 · Spring con bases de datos | — |
| **5** | 11-12 | 19-oct → 29-oct | 21 – 24 | U3 · Spring con bases de datos | **ATF3** ~30-oct |
| **6** | 13-14 | 02-nov → 15-nov | 25 – 28 | U4 · Spring Security | — |
| **7** | 15-16 | 16-nov → 29-nov | 29 – 32 | U4 · Spring Security | — |
| **Estab.** | 17-18 | 30-nov → 11-dic | 33 – 35 | U4 · Cierre | Sustentación + **TF** |

> Las fechas de vencimiento que traen las rúbricas son del ciclo 2025. Confirmar cada una en UTP+class al abrirse la tarea.

## 2. Peso en la nota

```
Nota final = 20% ATF1 + 20% ATF2 + 20% ATF3 + 40% TF
```

Nota mínima aprobatoria: **12**. No hay examen rezagado y ninguna nota se reemplaza.

## 3. Sílabo → sprint → rúbrica

| Sesión | Tema del sílabo | Sprint | Se aplica en | Criterio |
|:---:|---|:---:|---|---|
| 3-4 | Bootstrap: CDN, contenedores, filas y columnas responsivas, navbar, imágenes, **tablas**, **íconos** | 1 | Navbar, grillas, contenedores, tabla de tallas, Bootstrap Icons | ATF1-1a, 1b, 1f |
| 5-6 | Bootstrap: elementos web, **ventanas modales**, estilos de párrafo, **formularios** | 1 | Modal de contacto y de guía de tallas, formularios validados | ATF1-1c, 1d |
| 7 | Integración: GUI con ventanas flotantes, formularios y otros elementos | 1 | Carrusel, offcanvas, toast, accordion | ATF1-1e |
| 8 | **Evaluación** | 1 | **ATF1** | — |
| 9-10 | Back-end en Java. Spring Boot: entorno y creación de proyecto | 2 | Crear el proyecto `overtext` con Maven | ATF2-1 |
| 11-12 | Spring Web: definiciones, usos, aplicaciones | 2 | Controladores y sistema de rutas | ATF2-1a, 1b |
| 13-14 | Thymeleaf: definiciones, usos, aplicaciones | 3 | Fragments, `th:if`, `th:each` | ATF2-2 |
| 15 | Integración: Spring Web + Thymeleaf | 3 | Página 404, menú activo | ATF2-1c, 1d |
| 16 | **Evaluación** | 3 | **ATF2** | — |
| 17-18 | ORM, Hibernate, Spring Data, configuración con MySQL | 4 | Conexión a `overtext_db`, entidades | ATF3-1 |
| 19-20 | JPA: proyectos web **y REST** con Spring, CRUD a MySQL | 4 | Repositorios, servicios, lectura del catálogo | ATF3-1, 2 |
| 21-22 | Spring validator: **relaciones entre tablas**, validación, restricciones | 5 | FK categoría→producto, Bean Validation | ATF3-3d |
| 23 | Integración: JPA con Hibernate para CRUD | 5 | Panel de mantenimiento completo | ATF3-3 |
| 24 | **Evaluación** | 5 | **ATF3** | — |
| 25-26 | Spring Security: tipos de validación y configuración | 6 | `SecurityConfig`, páginas públicas y privadas | TF-2a |
| 27-28 | Autorización y autenticación de usuarios | 6 | `UserDetailsService`, BCrypt, roles | TF-2b, 2c, 2d |
| 29-30 | **JWT**: definición, usos e implementación | 7 | API REST protegida con JWT | *sílabo, sin rúbrica* |
| 31-32 | Integración front + back: BD, validación y seguridad con Spring, Thymeleaf y Bootstrap | 7 | Cierre funcional completo | TF-1, 3, 4 |
| 33-34 | Presentación del proyecto final | Estab. | Sustentación | TF-5 |
| 35 | **Evaluación** | Estab. | **TF** | — |

## 4. Temas del sílabo que ninguna rúbrica exige

El objetivo del equipo es **implementar todo lo que se lleva en el curso**, no solo lo que se califica. Estos temas se dictan pero no aparecen en ninguna rúbrica, así que se planifican explícitamente como extras:

| Tema | Sesión | Sprint | Cómo se cubre |
|---|:---:|:---:|---|
| Tablas de Bootstrap | 3-4 | 1 | Tabla de tallas con `table table-striped` |
| Íconos | 3-4 | 1 | Bootstrap Icons (reemplaza los PNG pesados) |
| Estilos de párrafo | 5-6 | 1 | Clases tipográficas en `tema-overtext.css` |
| Controladores **REST** | 19-20 | 4 | `ProductoRestController` con `@RestController` |
| **JWT** | 29-30 | 7 | Autenticación por token para la API REST |

Van marcados como `[SÍLABO]` en el backlog y en cada sprint. Si el tiempo aprieta, son lo primero que se recorta: no cuestan nota, pero sí cuentan para el objetivo del proyecto y dan material para la sustentación.

## 5. Rotación de duos

Rotan cada avance para que los 6 pasen por el back-end de Spring — es el logro de aprendizaje del curso y lo que se sustenta en la semana 17.

| Sprint(s) | UI / Front | Datos / Backend | Documento / QA |
|---|---|---|---|
| 1 | Joaquín · Dayro | Jonathan · Carlos | José · **Jhade** |
| 2-3 | José · Carlos | Joaquín · Dayro | Jonathan · **Jhade** |
| 4-5 | Jonathan · Dayro | José · Carlos | Joaquín · **Jhade** |
| 6-7 | Joaquín · Carlos | Jonathan · Dayro | José · **Jhade** |

Roles permanentes: **Joaquín** Product Owner · **Jonathan** Scrum Master e integrador de memoria · **Jhade** editora del informe.

## 6. Acumulación de la rúbrica

Cada avance conserva lo exigido por el anterior. Nada se puede romper al avanzar:

| Requisito | ATF1 | ATF2 | ATF3 | TF |
|---|:-:|:-:|:-:|:-:|
| 5 páginas mínimo | ✔ | ✔ | ✔ | ✔ |
| Formulario de inicio de sesión | ✔ | ✔ | ✔ | ✔ |
| Formulario de contacto | ✔ | ✔ | ✔ | ✔ |
| Encabezado, cuerpo y pie en todas | ✔ | ✔ | ✔ | ✔ |
| Estilos / framework CSS | ✔ | ✔ | ✔ | ✔ |
| Diagrama físico de la BD en el informe | ✔ | ✔ | ✔ | ✔ |
| Thymeleaf con fragments | | ✔ | ✔ | ✔ |
| Rutas, inicio por defecto y 404 | | ✔ | ✔ | ✔ |
| MySQL con tablas relacionadas | | | ✔ | ✔ |
| CRUD completo desde interfaz | | | ✔ | ✔ |
| Validaciones en todos los campos | | | ✔ | ✔ |
| Spring Security con roles y BCrypt | | | | ✔ |
| Introducción en el informe | | | ✔ | ✔ |
| Diccionario de datos, UML, anexos | | | | ✔ |
| Sustentación oral | | | | ✔ |

**Regla derivada:** en cada Sprint Review se verifican también los criterios de los avances anteriores. Una regresión en el ATF1 cuesta puntos en el TF.

## 7. Detalle por sprint

- [Sprint 1 — Bootstrap y sitio estático](sprints/sprint-01.md) → ATF1
- [Sprint 2 — Spring Boot y Spring Web](sprints/sprint-02.md)
- [Sprint 3 — Thymeleaf, rutas y 404](sprints/sprint-03.md) → ATF2
- [Sprint 4 — Spring Data, JPA y MySQL](sprints/sprint-04.md)
- [Sprint 5 — CRUD, relaciones y validación](sprints/sprint-05.md) → ATF3
- [Sprint 6 — Spring Security](sprints/sprint-06.md)
- [Sprint 7 — JWT e integración final](sprints/sprint-07.md)
- [Estabilización y sustentación](sprints/estabilizacion.md) → TF
