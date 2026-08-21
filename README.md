# OverText

E-commerce de streetwear peruano. Proyecto del curso **Marcos de Desarrollo Web** (UTP 2026-2, sección 38189, Grupo 01).

**Equipo:** Joaquín · José · Jonathan · Dayro · Carlos · Jhade

---

## Cómo arrancar

### Sitio estático (ATF1)

El sitio **no funciona abriendo los HTML con doble clic** (`file://`): usa rutas absolutas y `fetch` de JSON. Hay que servirlo por HTTP.

```bash
cd app-estatico
python3 -m http.server 8000
# http://localhost:8000
```

O con la extensión Live Server de VS Code.

### Aplicación Spring Boot (desde el ATF2)

```bash
cd overtext
mvn spring-boot:run
# http://localhost:8080
```

---

## Cómo trabajamos

| Método | Dónde |
|---|---|
| **SDD** — Specify → Plan → Tasks → Implement | `docs/specs/` |
| **Scrum** — 7 sprints de 2 semanas | `docs/scrum/` |
| **Memorias** — una por integrante, sin conflictos | `docs/memoria/` |

**Antes de tocar nada, lee `CLAUDE.md`.** Vale igual para personas y para agentes.

### Las tres reglas que más se incumplen

1. **Un archivo, un escritor.** `memory.md` lo escribe solo el Scrum Master, y solo cuando los 6 cerramos el sprint.
2. **No se implementa sin `spec.md` aprobado** por el Product Owner.
3. **kebab-case en español** y **cero errores en consola** en toda página que se entregue.

---

## Mapa del repositorio

| Ruta | Qué es |
|---|---|
| `CLAUDE.md` | Contrato de trabajo para agentes y personas |
| `memory.md` | Memoria general — última foto estable del proyecto |
| `docs/constitution.md` | Los 10 principios no negociables |
| `docs/contexto.md` | Manual de marca: tono, paleta, copy |
| `docs/memoria/` | Una memoria por integrante |
| `docs/specs/` | Specs SDD por feature |
| `docs/scrum/roadmap.md` | **Planificación completa del ciclo**: sílabo → sprint → rúbrica |
| `docs/scrum/sprints/` | Los 7 sprints, uno por archivo |
| `docs/scrum/product-backlog.md` | 130 historias, cada una trazada a su criterio |
| `docs/scrum/checklist-entrega.md` | Verificación previa a cada entrega |
| `informes/informe.md` | El informe (documento vivo en Markdown) |
| `app-estatico/` | Sitio del ATF1; se congela tras la entrega |
| `overtext/` | Proyecto Spring Boot (desde el Sprint 2) |

---

## Calendario

| Sprint | Semanas | Fechas | Entrega |
|---|---|---|---|
| 1 | 2-4 | 20-ago → 04-sep | **ATF1** |
| 2 | 5-6 | 07-sep → 20-sep | — |
| 3 | 7-8 | 21-sep → 01-oct | **ATF2** |
| 4 | 9-10 | 05-oct → 18-oct | — |
| 5 | 11-12 | 19-oct → 29-oct | **ATF3** |
| 6 | 13-14 | 02-nov → 15-nov | — |
| 7 | 15-16 | 16-nov → 29-nov | — |
| Estabilización | 17-18 | 30-nov → 11-dic | Sustentación + **TF** |

> Las fechas de las rúbricas son del ciclo 2025. Confirmar cada vencimiento en UTP+class.

---

## Antes de cualquier `git add`

```bash
git rev-parse --show-toplevel   # debe devolver .../overtext-web
```

Hubo un repositorio Git enraizado en el directorio *home* que exponía `.ssh` y `.khipu-secrets`. Verifica siempre.
