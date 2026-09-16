# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Contrato de trabajo para agentes

Proyecto **OverText** — Marcos de Desarrollo Web (UTP 2026-2, Grupo 01).
Equipo de 6: Joaquín, José, Jonathan, Dayro, Carlos, Jhade.

---

## 1. Antes de actuar, lee siempre

En este orden:

1. `memory.md` — memoria general del equipo. **Última foto estable.**
2. `docs/constitution.md` — los 10 principios no negociables.
3. `docs/specs/<feature-activo>/spec.md` y `plan.md` — qué se está construyendo y por qué.
4. `docs/memoria/<tu-integrante>_memory.md` — tu bitácora personal.

## 2. Regla de oro: un archivo, un escritor

| Archivo | Único escritor |
|---|---|
| `memory.md` | Scrum Master (Jonathan), y solo en la consolidación |
| `docs/memoria/<nombre>_memory.md` | esa persona y su agente |

**Nunca edites `memory.md`.** **Nunca edites la memoria de otra persona.** Escribe solo en la memoria de tu integrante.

## 3. `memory.md` puede estar desactualizada, y es correcto

`memory.md` solo se consolida **cuando los 6 integrantes cierran el sprint**. Mientras tanto está congelada, así que puede no reflejar el trabajo en curso.

- Trata `memory.md` como base estable y las memorias personales como estado provisional.
- **Si `memory.md` contradice lo que ves en el código, gana el código.** Anota la discrepancia en tu memoria personal, bajo "Para consolidar".

## 4. No implementes sin spec aprobado

El ciclo es **Specify → Plan → Tasks → Implement**, con checkpoint humano del Product Owner entre fases.

Si te piden implementar algo que no tiene `spec.md`: escribe el `spec.md`, marca lo ambiguo con `[NECESITA ACLARACIÓN]` y **detente** para que el PO lo apruebe. No pases a código.

## 5. Al terminar una tarea

Anota en `docs/memoria/<tu-integrante>_memory.md`:

- qué hiciste y qué archivos tocaste,
- qué decidiste o aprendiste,
- qué quedó bloqueado,
- y en el bloque **"Para consolidar"**, lo que el resto del equipo necesita saber.

## 6. Convenciones

Están en `docs/constitution.md`. Las tres que más se incumplen:

- **kebab-case en español** para archivos, clases CSS e IDs (`barra-navegacion`, `tarjeta-producto`).
- **Cero errores en consola** en cualquier página que se entregue.
- **Bootstrap primero:** si Bootstrap 5 ya tiene el componente, úsalo y solo re-tematízalo. No lo reimplementes.

## 7. Contexto del proyecto

- `docs/contexto.md` — manual de marca (tono, paleta, copy). Es la fuente de verdad del contenido.
- `app-estatico/` — sitio original, línea base del ATF1.
- `overtext/` — proyecto Spring Boot (desde el Sprint 2).
- `informes/informe.md` — el informe vive en Markdown. **No edites `.docx`**, se genera al exportar.
- Rúbricas y sílabo: `../rubricas/` y `../silabus_general.md`.

## 8. Qué NO hacer

- No añadas una capa, un patrón ni una tabla que ninguna rúbrica pida (constitution art. 8).
- No metas credenciales ni secretos en el repo (art. 6).
- No dupliques un dato entre HTML y JS (art. 7).
- No amplíes el alcance: el checkout de 3 pasos, el ubigeo y el configurador de packs se conservan tal cual, no se profundizan.

## 9. Comandos

**Sitio estático (`app-estatico/`, línea base congelada del ATF1):**

```bash
cd app-estatico
python3 -m http.server 8000   # http://localhost:8000
```

No abrir los `.html` con doble clic: el sitio usa rutas absolutas (`/css/...`) y `fetch` de JSON, así que necesita HTTP (T1 de `memory.md`). Sirve igual con Live Server de VS Code.

**Aplicación Spring Boot (`overtext/`, activa desde el Sprint 2):**

```bash
cd overtext
./mvnw spring-boot:run                                              # http://localhost:8080
./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081  # si 8080 está ocupado
./mvnw clean package                                                 # compilar
./mvnw test                                                          # todos los tests
./mvnw test -Dtest=OvertextApplicationTests                           # un solo test
```

En Windows sin bash usa `mvnw.cmd` en vez de `./mvnw`. No hace falta Maven instalado, el wrapper lo trae todo. Java 17+ (el equipo prueba con 21).

**Antes de cualquier `git add`:**

```bash
git rev-parse --show-toplevel   # debe devolver la raíz de overtext-web
```

Hubo un repositorio Git roto en el directorio *home* de una máquina del equipo que exponía `.ssh` y `.khipu-secrets` (T2 de `memory.md`). Verifica siempre que no estás commiteando fuera de este repo.

## 10. Arquitectura

**Dos implementaciones en paralelo, no una migración terminada:**

- `app-estatico/` — el sitio del ATF1: 10 páginas HTML sueltas, Bootstrap 5.3 por CDN, CSS propio modular (`main.css`/`layout.css` + `css/componentes/` + `css/paginas/`), JS vanilla, carrito en `localStorage`. **Se congeló tras la entrega del ATF1**; no se toca salvo que una spec lo diga explícitamente.
- `overtext/` — el mismo sitio sirviéndose desde Spring Boot 4.0.8 + Thymeleaf (Java 17, Maven). Es donde va todo el desarrollo desde el Sprint 2.

**Dentro de `overtext/` (Maven estándar):**

- Paquete base `pe.edu.utp.overtext`; cada clase en el paquete de su capa, sin excepciones (constitution art. 5): `Producto` (entidad, sin sufijo), `ProductoRepository`, `ProductoService`/`ProductoServiceImpl`, `ProductoController`, `SecurityConfig`/`WebConfig`. Hoy solo existe `controller/HomeController.java`; el resto de capas aparece a medida que avanzan los sprints (JPA/MySQL en Sprint 4-5, Security en Sprint 6).
- `src/main/resources/templates/paginas/*.html` — las páginas migradas a Thymeleaf. `src/main/resources/static/{css,js,assets}/` — los mismos recursos del ATF1, **con las mismas rutas absolutas** (`/css/...`, `/js/...`, `/assets/...`) que ya usaban las 10 páginas estáticas, para no reescribir referencias.
- Los controladores devuelven nombres de vista relativos a `templates/` (p. ej. `HomeController` devuelve `"paginas/index"` para `GET /`), no sirven HTML como estático.
- La plantilla base y los fragments reutilizables (cabecera, pie, carrito, scripts) viven en `templates/layout/plantilla.html` — ver `docs/specs/002-migracion-thymeleaf/spec.md` para qué fragments existen y cuáles quedan pendientes (`th:each`, `th:href="@{...}"`, menú activo son del Sprint 3, no de este).
- Único test hoy: `OvertextApplicationTests` (carga de contexto). No hay JPA ni base de datos todavía: el modelo de 10 tablas está diseñado en `docs/specs/001-sitio-bootstrap/esquema-fisico.sql` (fuente autoritativa) pero **sin implementar**.

**Reglas de datos y estado que cruzan ambas implementaciones:**

- El carrito vive en `localStorage` vía `js/carrito.js`; el umbral de envío gratis (`UMBRAL_ENVIO_GRATIS`, S/ 200) está definido una sola vez ahí — no lo dupliques en HTML ni en otro JS (art. 7).
- `abrirPanel`/`cerrarPanel` de `carrito.js` son API pública que otros scripts llaman para abrir el offcanvas del carrito; no son código muerto aunque no se vean referenciados directamente en el HTML.
- `promociones.js` deriva los colores del DOM (`.nombre-color`, `getComputedStyle`) en vez de tener un array propio, para no duplicar `js/productos.json` — sigue ese patrón si tocas el configurador.
- Los 7 colores de producto válidos son los de `js/productos.json`; el blanco no existe como producto (decisión de PO, ver `memory.md` decisión 12).

**Ruido a ignorar:** el directorio `JavaScript/` en la raíz del repo es un repositorio Git aparte (remoto propio en GitHub), una tarea de curso sin relación con OverText. No es parte de esta arquitectura.
