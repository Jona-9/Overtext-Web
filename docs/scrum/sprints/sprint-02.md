# Sprint 2 — Spring Boot y Spring Web

**Semanas 5-6 del ciclo · 07-sep → 20-sep-2026 · Sesiones 9 a 12 · Unidad 2**
**Sin entrega** — primer sprint del ATF2 · **Spec:** `docs/specs/002-migracion-thymeleaf/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 9-10 | Desarrollo web en Java: definición de back-end, lenguajes y frameworks de back-end, ventajas. Spring Boot: definición, ventajas, configuración del entorno y creación de proyecto |
| 11-12 | Spring Web: definiciones, usos, ventajas y aplicaciones |

## 2. Objetivo del sprint

> Levantar el proyecto Spring Boot, mover el sitio del ATF1 dentro de él y servir todas las páginas mediante controladores, eliminando la duplicación de encabezado, pie y carrito.

**Este sprint no entrega nada al docente.** Su valor es que el Sprint 3 llegue con los cimientos puestos y pueda concentrarse en Thymeleaf, que es donde están 6 de los 20 puntos del ATF2.

## 3. Hacia qué criterio del ATF2 apunta

| Criterio | Pts | Qué se adelanta aquí |
|---|:-:|---|
| 1 Navegación y sistema de rutas | 6 | 1a rutas de 5+ páginas · 1b página de inicio por defecto |
| 2 Thymeleaf | 6 | 2a los fragments (la parte estructural) |

Los criterios 1c (404), 1d (menú activo), 2b (`th:if`) y 2c (`th:each`) se cierran en el Sprint 3.

## 4. Alcance

### Duo Datos / Backend — Joaquín · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-01 | Crear el proyecto Spring Boot 3.x con Maven, Java 17+, `web` y `thymeleaf` | — | 9-10 |
| E2-05 | `HomeController` con `@GetMapping("/")` — página de inicio por defecto | **1b** | 11-12 |
| E2-06 | Un `@Controller` por sección con rutas limpias: `/catalogo`, `/producto/{id}`, `/promociones`, `/nosotros`, `/contacto`, `/login`, `/checkout` | **1a** | 11-12 |
| E2-13 | `application.properties` con variables de entorno; `README` de arranque | — | 9-10 |

**Nomenclatura obligatoria** (constitución art. 5): `HomeController`, `CatalogoController`, `ContactoController`. Paquete `pe.edu.utp.overtext.controller`.

### Duo UI / Front — José · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E2-02 | Mover CSS, JS e imágenes a `src/main/resources/static/` y las páginas a `templates/paginas/` | — | 11-12 |
| E2-03 | Construir `layout/plantilla.html` con `th:fragment` | **2a** | 11-12 |
| E2-04 | Fragments `cabecera`, `pie`, `carrito` y `scripts` | **2a** | 11-12 |
| E2-14 | Verificar que las rutas de recursos estáticos funcionan tras el traslado | — | 11-12 |

**El mayor retorno del sprint:** el sitio tiene hoy ~1.000 de sus 2.270 líneas de HTML repetidas (encabezado 31 líneas × 10 páginas, pie 42 × 8, carrito 41 × 5). Los fragments las eliminan de golpe: el HTML se reduce a menos de la mitad y el criterio 2a queda cubierto.

### Duo Documento / QA — Jonathan · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E2-15 | Redactar la **INTRODUCCIÓN** del informe (adelantada; el ATF3 la exige) | 3 |
| E2-16 | Actualizar 2.1.2 con Spring Boot y Spring Web como tecnologías | 3 |
| E2-17 | Verificar que las 10 páginas siguen sin errores en consola tras la migración | ATF1-2d |
| E2-18 | Regresión del ATF1: los 6 componentes de Bootstrap siguen funcionando | ATF1-1 |

> **La regresión no es opcional.** El ATF2 conserva todos los requisitos del ATF1: 5 páginas, login, contacto, encabezado/cuerpo/pie y estilos. Romper el carrusel al migrar cuesta puntos en el TF.

## 5. Orden de trabajo

```
Día 1-2   E2-01 crear el proyecto  →  todos clonan y compilan
Día 3-5   E2-02 mover recursos     →  E2-03/E2-04 layout y fragments
Día 6-8   E2-05/E2-06 controladores y rutas
Día 9-10  Regresión ATF1, informe, cierre
```

Nadie escribe controladores hasta que `mvn spring-boot:run` levante en las 6 máquinas. Un entorno roto en una máquina bloquea a esa persona todo el sprint.

## 6. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] `mvn spring-boot:run` levanta y responde en `http://localhost:8080`
- [ ] La página se sirve desde su controlador, no como archivo estático
- [ ] Usa `layout/plantilla.html` y al menos 2 fragments
- [ ] Sin errores en consola del navegador
- [ ] Probado a 375 px y 1440 px
- [ ] Nomenclatura de capas correcta (art. 5)
- [ ] Captura en `informes/capturas/sprint-02/`
- [ ] Bloque "Para consolidar" escrito

## 7. Riesgos

| Riesgo | Mitigación |
|---|---|
| **El equipo aún no domina Spring** — es la primera vez | Este sprint es solo cimientos. Nada de base de datos ni seguridad. |
| Entorno Java/Maven distinto en cada máquina | Día 1: todos compilan y levantan. Versión de Java fijada en el `pom.xml`. |
| Al mover recursos se rompen las rutas absolutas (`/css/...`) | E2-14 tiene tarea propia; se verifica página por página |
| Se rompe algo del ATF1 al migrar | E2-18 regresión obligatoria antes del cierre |
| Seis personas tocando `plantilla.html` a la vez | Un solo duo es dueño del layout (art. 9); el resto espera a que esté en `develop` |

## 8. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 07-sep |
| Daily asíncrono | cada día, en la memoria personal |
| Review | vie 18-sep |
| Retro + consolidación | vie 18-sep, tras la review |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 18-sep

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| | | |

## Retrospectiva — 18-sep

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 3**
