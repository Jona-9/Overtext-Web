# Sprint 7 — JWT e integración final

**Semanas 15-16 del ciclo · 16-nov → 29-nov-2026 · Sesiones 29 a 32 · Unidad 4**
**Sin entrega** — segundo sprint del Trabajo Final · **Spec:** `docs/specs/004-seguridad-pedidos/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 29-30 | JWT: definición, usos, ventajas, importancia e implementación de Spring Security con JWT en un proyecto web |
| 31-32 | Integración de temas de front-end y back-end: proyecto web con conexión a bases de datos, sistemas de validación y seguridad mediante Spring y Thymeleaf con Bootstrap |

## 2. Objetivo del sprint

> Cerrar la funcionalidad del proyecto: todas las tablas con lectura desde el panel, los pedidos y mensajes persistidos en MySQL, y JWT implementado sobre la API REST.

Al terminar este sprint el proyecto queda **funcionalmente completo**. Las semanas 17-18 son solo estabilización, informe y sustentación.

## 3. Hacia qué criterio del TF apunta

| Criterio | Pts | Qué se cubre aquí |
|---|:-:|---|
| 1 Estructura del proyecto | 4 | **Completo**: entidades, repositorios, servicios, controladores, `config/` y `util/` por paquetes |
| 3 Operaciones con la base de datos | 4 | a) **lectura de todas las tablas** · b) inserción · c) actualización · d) eliminación, todas por interfaz gráfica |
| 4 Presentación visual | 4 | a) estilos en todas las páginas · b) **fragments** · c) navegación fluida · d) coherencia gráfica |

**Ojo con el criterio 3a: "lectura de *todas* las tablas".** No basta con productos y categorías: hay que poder listar pedidos, detalles, mensajes de contacto, usuarios, roles y colores desde el panel.

## 4. Alcance

### Duo Datos / Backend — Jonathan · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-09 | Entidades restantes: `Pedido`, `DetallePedido`, `MensajeContacto`, `Color`, `VarianteProducto` — con repositorio, servicio y controlador cada una | **1, 3a** | 31-32 |
| E4-10 | El proceso de compra **persiste el pedido en MySQL** en lugar de `localStorage` | **3b** | 31-32 |
| E4-11 | El formulario de contacto guarda en `mensaje_contacto` | **3b** | 31-32 |
| E4-26 | Gestión de usuarios y roles desde el panel (alta, edición, activar/desactivar) | 3b, 3c | 31-32 |
| E4-27 | `[SÍLABO]` **JWT**: `JwtUtil` en `util/`, filtro de autenticación y endpoint `/api/auth/login` que emite el token | — | 29-30 |
| E4-28 | `[SÍLABO]` Proteger `/api/**` con JWT, dejando la web con sesión de formulario | — | 29-30 |

> **JWT no lo pide ninguna rúbrica**, pero sí el sílabo (sesiones 29-30) y el objetivo del equipo de implementar todo lo del curso. Se aplica sobre la API REST creada en el Sprint 4, sin tocar la autenticación web por formulario. Si el tiempo aprieta, es lo primero que se recorta.

### Duo UI / Front — Joaquín · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-29 | Listados en el panel para **cada** tabla: pedidos, detalles, mensajes, usuarios, roles, colores | **3a** | 31-32 |
| E4-30 | Detalle de pedido: cabecera + líneas, con `th:each` | 3a | 31-32 |
| E4-12 | KPI del panel calculados con **consultas reales** (hoy están escritos a mano: 128 / 42 / 6 / S/ 8.4k) | 3a | 31-32 |
| E4-31 | Marcar un mensaje de contacto como atendido | 3c | 31-32 |
| E4-32 | Cambiar el estado de un pedido (pendiente → pagado → enviado → entregado) | 3c | 31-32 |
| E4-33 | Repaso de coherencia gráfica en **todas** las páginas, incluidas las nuevas del panel | **4d** | 31-32 |

### Duo Documento / QA — José · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E4-34 | **Diccionario de datos** completo, tabla por tabla | 5 |
| E4-35 | Terminar los diagramas UML de 2.1.2.2 | 5 |
| E4-36 | Redactar OBSERVACIONES, CONCLUSIONES y **RECOMENDACIONES** | 5 |
| E4-37 | **BIBLIOGRAFÍA** real: Spring, Bootstrap, Thymeleaf, MySQL y la bibliografía base del sílabo | 5 |
| E4-38 | Montar los **ANEXOS**: código fuente, capturas, estructura del proyecto | 5 |
| E4-39 | Regresión completa ATF1 + ATF2 + ATF3 + Sprint 6 | todos |

## 5. Prueba de aceptación del sprint

1. Desde el panel se puede **listar cada una de las tablas** de la base de datos *(3a)*
2. Completar una compra de punta a punta → el pedido aparece en `/admin/pedidos` con sus líneas *(3b)*
3. Enviar el formulario de contacto → el mensaje aparece en `/admin/mensajes` *(3b)*
4. Cambiar el estado de un pedido y ver el cambio reflejado *(3c)*
5. Los KPI del panel coinciden con lo que hay realmente en la base *(3a)*
6. `POST /api/auth/login` con credenciales válidas devuelve un token JWT; `GET /api/productos` sin token responde 401 y con token responde 200 *(sílabo)*
7. Recorrido completo del sitio: coherencia gráfica y navegación fluida *(4c, 4d)*

## 6. Orden de trabajo

```
Día 1-4   E4-27/E4-28 JWT, con la clase recién dictada
Día 5-8   Entidades restantes, persistencia de pedidos y mensajes,
          listados del panel  (sesión 31-32, integración)
Día 9-10  KPI reales, coherencia gráfica, regresión completa
```

> **Congelación de funcionalidad al terminar este sprint.** Lo que no esté hecho el 29-nov no entra al Trabajo Final: las semanas 17-18 son para estabilizar y sustentar, no para programar.

## 7. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] Cada tabla nueva tiene sus 4 capas con la nomenclatura correcta
- [ ] Cada tabla es visible desde el panel *(3a)*
- [ ] Los datos que antes vivían en `localStorage` están en MySQL
- [ ] Sin errores en consola
- [ ] La página nueva mantiene la coherencia gráfica del sitio *(4d)*
- [ ] Captura en `informes/capturas/sprint-07/`
- [ ] Bloque "Para consolidar" escrito

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| **El criterio 3a exige *todas* las tablas** y es fácil dejar alguna sin listado | E4-29 enumera tabla por tabla; se verifica contra `data-model.md` |
| JWT consume tiempo y no da nota | Se hace primero (días 1-4) y es lo primero que se recorta si algo se retrasa |
| Se intenta programar en las semanas 17-18 | Congelación explícita el 29-nov |
| El panel nuevo se ve distinto al resto del sitio | E4-33 repaso de coherencia gráfica, criterio 4d |
| El informe se acumula para el final | El duo del documento cierra 5 secciones grandes en este sprint |
| Mezclar JWT con la sesión web rompe el inicio de sesión | Cadenas de filtros separadas: `/api/**` con JWT, el resto con formulario |

## 9. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 16-nov |
| Daily asíncrono | cada día, en la memoria personal |
| Review | vie 27-nov |
| Retro + consolidación | vie 27-nov, tras la review |
| **Congelación de funcionalidad** | dom 29-nov |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 27-nov

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| TF-1 estructura por capas y paquetes | | |
| TF-3a lectura de todas las tablas | | |
| TF-3b inserción | | |
| TF-3c actualización | | |
| TF-3d eliminación | | |
| TF-4a estilos en todas las páginas | | |
| TF-4b fragments | | |
| TF-4c navegación fluida | | |
| TF-4d coherencia gráfica | | |
| `[SÍLABO]` JWT | | |

## Retrospectiva — 27-nov

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para la estabilización**
