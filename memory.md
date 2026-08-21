# Memoria general — OverText

> **Escritor único: Scrum Master (Jonathan).** Nadie más edita este archivo.
> Se consolida **solo cuando los 6 integrantes cerraron el sprint**. Si falta alguien, este archivo no se toca.
> Es la última foto **estable**: puede estar desactualizada respecto al sprint en curso. Si contradice el código, gana el código.

**Última consolidación:** ninguna todavía — Sprint 1 en curso.
**Estado de la puerta:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## 1. Estado actual

Repositorio recién creado. Andamiaje de documentación y memorias listo. Sin código propio todavía.

- **Línea base:** `app-estatico/`, copia intacta del sitio OverText anterior (10 páginas HTML, CSS propio modular, JS vanilla, carrito en `localStorage`).
- **Stack objetivo:** Bootstrap 5.3 → Spring Boot 3.x + Thymeleaf → Spring Data JPA + MySQL → Spring Security.
- **Stack actual:** HTML + CSS propio + JS vanilla. Sin framework, sin backend, sin base de datos.

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

## 3. Convenciones activas

Ver `docs/constitution.md`. No se duplican aquí.

## 4. Mapa del código

| Ruta | Qué contiene |
|---|---|
| `app-estatico/` | Sitio del ATF1. Se congela tras la entrega. |
| `overtext/` | Proyecto Spring Boot. **Aún no existe** — se crea en el Sprint 2. |
| `docs/specs/` | Specs SDD por feature. |
| `docs/scrum/roadmap.md` | **Planificación de las 18 semanas**: sílabo → sprint → rúbrica. |
| `docs/scrum/sprints/` | Los 7 sprints, uno por archivo, + la estabilización. |
| `docs/memoria/` | Una memoria por integrante. |
| `informes/informe.md` | El informe, documento vivo. |
| `informes/capturas/` | Evidencia por sprint. |

## 5. Cobertura de rúbrica

Leyenda: ⬜ pendiente · 🟨 en curso · ✅ cubierto y con evidencia

### ATF1 — 20 pts

| Criterio | Estado | Evidencia |
|---|---|---|
| 1a Contenedores | ⬜ | |
| 1b Menú responsivo | ⬜ | |
| 1c Formularios | ⬜ | |
| 1d Ventanas modales | ⬜ | |
| 1e Carrusel de imágenes | ⬜ | |
| 1f Sistema de grillas | ⬜ | |
| 2a Código estructurado | ⬜ | |
| 2b Código limpio | ⬜ | |
| 2c kebab-case | ⬜ | |
| 2d JS sin errores en consola | ⬜ | |
| 3 Informe (5 secciones) | ⬜ | |
| 4 Nomenclatura del entregable | ⬜ | |

*(Las tablas de ATF2, ATF3 y TF se añaden al llegar a cada avance.)*

## 6. Deuda y pendientes

| # | Pendiente | Origen |
|---|---|---|
| D1 | `assets/` pesa ~72 MB; objetivo < 15 MB antes de empaquetar | Sprint 1 |
| D2 | `css/style.css` (616 líneas) es código muerto con un `:root` conflictivo | Sprint 1 |
| D3 | Colores del configurador de packs ≠ colores del catálogo (hay un BLANCO inexistente) | Sprint 1 |
| D4 | Envío gratis: S/ 180 en el JS vs "desde 2 packs" (S/ 200) en el copy | Sprint 1 |
| D5 | `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` describen archivos que no existen | Sprint 1 |
| D6 | El `.git` roto del *home* quedó en `~/.git-ROTO-backup-20260820`; borrarlo cuando haya confianza | Sprint 1 |

## 7. Trampas conocidas

| # | Trampa |
|---|---|
| T1 | El sitio usa rutas absolutas (`/css/...`) y `fetch` de JSON: **no funciona con `file://`**. Hay que servirlo por HTTP (Live Server o Spring). |
| T2 | Había un repositorio Git enraizado en `/Users/jonatl9`. Antes de cualquier `git add`, confirma con `git rev-parse --show-toplevel` que estás dentro de `overtext-web`. |
| T3 | El `.rar` de entrega no debe llevar contraseña ni estar dañado: cuesta −3 puntos en el TF. Ábrelo en otra máquina antes de enviar. |
