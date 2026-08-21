# CLAUDE.md — contrato de trabajo para agentes

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
