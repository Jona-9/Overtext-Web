# Sprint 1 — Bootstrap y sitio estático

**Semanas 2-4 del ciclo · 20-ago → 04-sep-2026 · Sesiones 3 a 8 · Unidad 1**
**Entrega: ATF1** (~04-sep) · **Spec:** `docs/specs/001-sitio-bootstrap/`

> Único sprint de este avance, por compresión de tiempo: el ciclo ya va por la semana 2.

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 3-4 | Bootstrap: definición, instalación por CDN, contenedores, sistema de filas y columnas para diseño responsivo, barras de navegación, imágenes, tablas e íconos |
| 5-6 | Aplicación de Bootstrap: elementos web, ventanas modales, estilos de párrafo y formularios |
| 7 | Integración: configurar Bootstrap e implementar GUI con ventanas flotantes, formularios y otros elementos |
| 8 | **Evaluación — ATF1** |

## 2. Objetivo del sprint

> Convertir el sitio OverText existente en una interfaz construida con Bootstrap 5.3 que demuestre los seis componentes que exige la rúbrica, y dejar diseñado el modelo de datos que el informe requiere.

## 3. Qué pide la rúbrica ATF1 (20 pts)

| Criterio | Pts | Qué exige |
|---|:-:|---|
| 1 Aplicación de framework front-end | 6 | Los **6** componentes: contenedores, menús responsivos, formularios, ventanas modales, **carrusel de imágenes** y sistema de grillas |
| 2 Estructura y organización del código | 6 | Estructurado · limpio · **kebab-case** · JS sin errores |
| 3 Informe | 4 | Situación problemática · objetivos · **diagrama físico de la BD** · descripción de la solución · capturas |
| 4 Nomenclatura | 4 | `ATF1_GRUPO_01.pdf` + `ATF1_GRUPO_01.rar` |

**Consideraciones de la tarea:** 5 páginas mínimo · una con formulario de inicio de sesión · una con formulario de contacto · todas con encabezado, cuerpo y pie · **plantear una versión preliminar de la base de datos**.

> El sitio ya tiene 10 páginas, login y contacto. Lo que falta es el framework, el carrusel y el modelo de datos.

## 4. Alcance

### Duo UI / Front — Joaquín · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-01 | Bootstrap 5.3 por CDN + `tema-overtext.css` con la paleta de marca | 1a | 3-4 |
| E1-02 | Header como `navbar navbar-expand-lg` responsivo en las 10 páginas | 1b | 3-4 |
| E1-03 | Envolver todas las páginas en `.container` / `.container-fluid` | 1a | 3-4 |
| E1-04 | Carrusel en la portada: 3+ diapositivas, controles e indicadores | **1e** | 7 |
| E1-05 | Carrusel en la galería de la ficha, tolerante a productos sin galería | **1e** | 7 |
| E1-06 | Grillas `row`/`col-*` en catálogo, promociones, nosotros y pie | 1f | 3-4 |
| E1-25 | `[SÍLABO]` Estilos de párrafo tipográficos en el tema | — | 5-6 |

**El carrusel es lo más crítico del sprint: hoy no existe y vale un sexto del criterio 1.**

### Duo Datos / Backend — Jonathan · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E1-07 | Formularios de contacto, login y compra a `form-control` + `was-validated` | 1c | 5-6 |
| E1-08 | Modal de confirmación de contacto (migra el modal propio de 102 líneas) | 1d | 5-6 |
| E1-09 | Modal de guía de tallas en la ficha de producto | 1d | 5-6 |
| E1-10 | Panel del carrito convertido en `offcanvas` | 1b | 7 |
| E1-11 | Bootstrap Icons en lugar de los PNG de 4-5 MB | 1a | 3-4 |
| E1-22 | **Diagrama físico de la base de datos** desde `data-model.md` | **3** | — |
| E1-26 | `[SÍLABO]` Tabla de tallas con `table table-striped` | — | 3-4 |

### Duo Documento / QA — José · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E1-12 | Eliminar `css/style.css` (616 líneas de código muerto) | 2b |
| E1-13 | Extraer el script incrustado de `promotions.html` a `js/promociones.js` | 2a, 2b |
| E1-14 | Eliminar los 15 estilos en línea | 2b |
| E1-15 | Quitar los valores de relleno que parpadean al cargar | 2b, 2d |
| E1-16 | Optimizar `assets/` de 39 MB a **menos de 15 MB** | — |
| E1-17 | Actualizar `docs/01-arquitectura-css.md` y `02-sistema-diseno.md` | 2a |
| E1-18 | Verificar kebab-case archivo por archivo | **2c** |
| E1-20 | Limpiar la plantilla UTP; añadir Docente, Recomendaciones y Anexos | 3 |
| E1-21 | Redactar 1.1, 1.2, 2.1, 2.2 y 2.3 del informe | **3** |
| E1-23 | Capturas de las 10 páginas + foto de la estructura | 3 |
| E1-24 | Empaquetar `ATF1_GRUPO_01` y verificar en otra máquina | **4** |

### Todo el equipo

| # | Historia | Criterio |
|---|---|:-:|
| E1-19 | Verificar consola sin errores en las 10 páginas | **2d** |
| — | Crear y mantener su `<nombre>_memory.md` | — |

## 5. Bloqueo previo: el checkpoint del Product Owner

El `spec.md` tiene tres `[NECESITA ACLARACIÓN]` que **Joaquín debe resolver el día 1**, porque condicionan el modelo de datos y el contenido:

1. ¿La lista válida de colores es la del catálogo (beige, negro, guinda, gris, oliva, azul, marrón) o la del configurador de packs (que incluye un BLANCO inexistente)?
2. ¿El umbral de envío gratis es S/ 180 (lo que dice el JS) o S/ 200 (lo que dice el copy)?
3. ¿El badge "últimas unidades" se calcula desde un umbral de stock o se asigna a mano?

Hasta que se aprueben, **no se escribe `plan.md` ni `tasks.md`**, y E1-22 queda a la espera.

## 6. Orden de trabajo

El **tema Bootstrap + navbar (E1-01, E1-02)** desbloquea a todos los demás. Se hace primero y se integra el mismo día, para que nadie maquete sobre una base que va a cambiar.

```
Día 1-2   E1-01 tema  →  E1-02 navbar  →  todos parten de aquí
Día 3-6   UI: contenedores, grillas, carruseles
          Datos: formularios, modales, offcanvas
          Doc/QA: limpieza, assets, plantilla del informe
Día 7-9   Integración, redacción del informe, capturas
Día 10    Verificación con el checklist y empaquetado
```

## 7. Definición de Hecho

- [ ] Código en `develop` vía PR revisado por otro duo
- [ ] La página abre **sin errores en consola** *(criterio 2d)*
- [ ] Probado a 375 px y 1440 px
- [ ] Nombres en **kebab-case** *(criterio 2c)*
- [ ] Captura archivada en `informes/capturas/sprint-01/`
- [ ] Criterio de rúbrica marcado en `docs/scrum/checklist-entrega.md`
- [ ] Bloque "Para consolidar" escrito en la memoria personal

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| El carrusel no existe y es un sexto del criterio 1 | Se hace en la sesión 7, con la clase de integración recién dictada. No se deja para el final. |
| El sitio no funciona con `file://` | Servir siempre por HTTP (`python3 -m http.server` o Live Server) |
| 39 MB de assets inflan el `.rar` | E1-16 tiene fecha propia, no se posterga |
| Reescribir con Bootstrap rompe el diseño de marca | El tema se hace **primero** (E1-01) y todo se maqueta encima |
| El informe se deja para el último día | Constitución art. 10: el duo del documento cierra su sección en la review |

## 9. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | jue 20-ago |
| Daily asíncrono | cada día, en la memoria personal |
| Review | vie 04-sep |
| Retro + consolidación | vie 04-sep, tras la review |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ✅ Jonathan *(26-ago: E1-07, E1-22)* · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade
`memory.md` se actualiza **solo con los 6 marcados**.

---

## Sprint Review — 04-sep

*(por completar)*

| Criterio | Estado | Evidencia (URL + captura) |
|---|---|---|
| | | |

## Retrospectiva — 04-sep

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 2**
