# Estabilización y sustentación

**Semanas 17-18 del ciclo · 30-nov → 11-dic-2026 · Sesiones 33 a 35 · Unidad 4**
**Entrega: TRABAJO FINAL** · vale el **40 % de la nota del curso**

> **No es un sprint.** Es una ventana de cierre: funcionalidad congelada desde el 29-nov. No se programa nada nuevo.

---

## 1. Qué pasa estas semanas

| Sesión | Tema |
|:---:|---|
| 33-34 | Presentación del proyecto final |
| 35 | **Evaluación — Trabajo Final** |

## 2. Qué pide la rúbrica del TF (20 pts)

| Criterio | Pts | Qué exige |
|---|:-:|---|
| 1 Estructura del proyecto | 4 | Entidades, repositorios, servicios, controladores, **clases de configuración y utilitarios** ordenados por paquetes, con nomenclatura conforme a su funcionalidad |
| 2 Operaciones de seguridad | 4 | a) clase de configuración con públicas y privadas · b) usuarios y contraseñas **encriptadas** en BD · c) formulario de inicio personalizado · d) botón de cierre personalizado |
| 3 Operaciones con la base de datos | 4 | a) lectura de **todas** las tablas · b) inserción · c) actualización · d) eliminación, **todas por interfaz gráfica** |
| 4 Presentación visual | 4 | a) estilos en todas las páginas · b) **fragments** de Thymeleaf · c) navegación fluida · d) coherencia gráfica |
| 5 Informe y sustentación | 4 | a) **vestimenta formal-casual** · b) explicar características y finalidad · c) **demostración en vivo** · d) informe con **todas** las secciones |

**Restricciones:** tablas relacionadas en MySQL · tabla de usuarios con contraseñas encriptadas y roles · CRUD con `@Controller` y Thymeleaf · páginas públicas y privadas · estilos CSS o framework · entidades, repositorios, servicios y controladores.

**Penalizaciones:** archivo dañado o con contraseña, **−3 puntos**. Nombre mal formado, **−1 punto por archivo**.

## 3. Secciones obligatorias del informe

La rúbrica las enumera y el criterio 5d exige **todas**:

- [ ] **Carátula** — nombre del proyecto, integrantes, **docente**, fecha
- [ ] **Introducción**
- [ ] **Descripción del problema a resolver**
- [ ] **Objetivos del proyecto**
- [ ] **Descripción de la solución planteada**, con:
  - [ ] Tecnologías usadas: lenguajes, bibliotecas, programas y herramientas
  - [ ] Descripción técnica del funcionamiento, con diagramas UML — **debe invocar a los anexos**
  - [ ] **Diccionario de datos** de la base de datos
- [ ] **Conclusiones**
- [ ] **Recomendaciones**
- [ ] **Referencias o bibliografía**
- [ ] **Anexos**: código fuente · capturas del funcionamiento · imágenes de la estructura del proyecto

> Tres de estas secciones no venían en la plantilla UTP original: **Docente** en la carátula, **Recomendaciones** y **Anexos**. Se añadieron en el Sprint 1.

## 4. Plan de las dos semanas

### Semana 17 (30-nov → 06-dic) — Verificar y ensayar

| Día | Qué | Quién |
|---|---|---|
| lun 30 | **Auditoría completa** de los 20 criterios con `checklist-entrega.md` | todos |
| mar 01 | Corregir lo que falle en la auditoría. **Solo correcciones, nada nuevo.** | duos según hallazgo |
| mié 02 | Cierre del informe: última revisión de las 11 secciones | Jhade · José |
| jue 03 | **Ensayo 1** de la sustentación, cronometrado | todos |
| vie 04 | Ajustes del guion y de la demo | todos |
| sáb 05 | **Ensayo 2**, con la demo en vivo desde una máquina limpia | todos |
| dom 06 | Exportar el informe a `.docx` y a `.pdf` | Jhade |

### Semana 18 (07-dic → 11-dic) — Entregar

| Día | Qué | Quién |
|---|---|---|
| lun 07 | Empaquetar `TF_GRUPO_01.pdf` y `TF_GRUPO_01.rar` | José · Jhade |
| mar 08 | **Verificar el `.rar` en otra máquina**: descomprimir, compilar y levantar | Jonathan |
| mié 09 | **Sustentación** (según convocatoria del docente) | todos |
| jue 10 | Margen para corregir observaciones | todos |
| vie 11 | **Entrega final** | Jhade |

## 5. La sustentación vale 3 de los 4 puntos del criterio 5

| Punto | Qué hacer |
|---|---|
| a) Vestimenta **formal-casual** | Acordarlo el 30-nov, no la mañana de la exposición. Es un punto que se pierde por descuido. |
| b) Explicar características y **finalidad** | Abrir con el problema: OverText vende por chat, sin catálogo consultable ni registro de pedidos. Luego la solución. |
| c) **Demostración del funcionamiento** | Guion de demo en vivo (§6) |
| d) Informe con todas las secciones | §3 |

### Reparto de la exposición

| Bloque | Quién | Minutos |
|---|---|:-:|
| Problema, objetivos y finalidad | Joaquín (PO) | 3 |
| Arquitectura y tecnologías | Jonathan | 3 |
| Modelo de datos y CRUD | José · Carlos | 4 |
| Seguridad: roles, BCrypt, público vs. privado | Dayro | 3 |
| Interfaz, Bootstrap y Thymeleaf | Jhade | 3 |
| Conclusiones y cierre | todos | 2 |

> Los seis hablan. La rotación de duos durante el ciclo existe justamente para que cada quien pueda explicar el back-end.

## 6. Guion de la demostración en vivo

Se ensaya completo dos veces. Si algo falla en el ensayo, se arregla antes.

1. Portada → **carrusel**, menú responsivo, catálogo en grilla *(4a, 4c, 4d)*
2. Ficha de producto → galería, modal de guía de tallas
3. Añadir al carrito → **offcanvas** con el total
4. Completar una compra → confirmación
5. En el panel: el **pedido recién creado** aparece con sus líneas *(3a, 3b)*
6. Formulario de contacto → el mensaje aparece en el panel *(3b)*
7. Intentar entrar a `/admin` **sin sesión** → redirige al inicio de sesión *(2a)*
8. Iniciar sesión como ADMIN → **CRUD completo de un producto**: crear, editar, borrar *(3b, 3c, 3d)*
9. Enviar el formulario vacío → **errores de validación** campo por campo
10. Cerrar sesión con el botón personalizado *(2d)*
11. Mostrar en MySQL que `usuario.password` es un hash `$2a$...` *(2b)*
12. Mostrar la estructura de paquetes del proyecto *(1)*

**Preparar un plan B:** capturas o un video de respaldo por si falla la conexión, el proyector o MySQL el día de la exposición.

## 7. Auditoría del 30-nov

Se recorre `docs/scrum/checklist-entrega.md` entero, más los criterios de los tres avances anteriores. Cualquier regresión se corrige el 01-dic.

| Bloque | Criterios |
|---|---|
| Estructura | TF-1: paquetes `config/` y `util/` presentes y con nomenclatura correcta |
| Seguridad | TF-2a, 2b, 2c, 2d |
| Base de datos | TF-3a **todas** las tablas, 3b, 3c, 3d |
| Presentación | TF-4a, 4b, 4c, 4d |
| Regresión ATF1 | Los 6 componentes de Bootstrap siguen vivos |
| Regresión ATF2 | Fragments en todas, 404, menú activo, inicio por defecto |
| Regresión ATF3 | CRUD y validaciones intactos |

## 8. Riesgos

| Riesgo | Mitigación |
|---|---|
| **Se intenta programar funcionalidad nueva** | Congelación desde el 29-nov. Solo correcciones. |
| La demo falla en vivo | Dos ensayos completos + plan B con capturas o video |
| Se olvida un punto tonto: la vestimenta | Acordado el 30-nov, está en el checklist |
| El `.rar` está dañado o lleva contraseña | **−3 puntos.** Verificación en otra máquina el 08-dic. |
| El nombre no lleva dos dígitos (`GRUPO_1` en vez de `GRUPO_01`) | **−1 punto por archivo.** Está en el checklist §D. |
| Falta una sección del informe | §3 es una lista de verificación, no una guía |
| El proyecto no compila en una máquina limpia | Se prueba desde el `.rar` descomprimido, no desde el repositorio |

## 9. Entregables

1. **`TF_GRUPO_01.pdf`** — informe con carátula y las 11 secciones
2. **`TF_GRUPO_01.rar`** — proyecto web completo, sin contraseña, sin `target/`

Todo dentro de un único archivo de envío.

---

## Cierre del ciclo

*(por completar tras la sustentación)*

**Qué salió bien**

**Qué haríamos distinto**

**Nota obtenida por criterio**
