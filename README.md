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
| **Memorias** — seguimiento por integrante | `docs/` |

**Antes de tocar nada, lee `AGENTS.md` (y `PC3_INSTRUCCIONES.md` para la entrega actual).** Vale igual para personas y para agentes de IA.

### Las tres reglas que más se incumplen

1. **Un archivo, un escritor.** `memory.md` lo escribe solo el Scrum Master (Jonathan), y solo cuando cerramos el sprint.
2. **Alcance 100% Backend para la PC3:** Sin maquetado frontend. Todo el CRUD se opera mediante APIs REST en Postman y cURL.
3. **Contrato de tipos estricto:** Respeta los tipos de datos definidos en `AGENTS.md` y `PC3_INSTRUCCIONES.md`.

---

## Mapa del repositorio

| Ruta | Qué es |
|---|---|
| `AGENTS.md` | Contrato de trabajo y directivas para agentes de IA y desarrolladores |
| `PC3_INSTRUCCIONES.md` | Guía de implementación técnica, contrato canónico de datos y responsabilidades de la PC3 |
| `docs/pc3-tablero-control.md` | Tablero operativo de seguimiento y checklist por casillas de la PC3 |
| `memory.md` | Memoria general — última foto estable y decisiones vigentes del proyecto |
| `docs/constitution.md` | Los 10 principios no negociables |
| `docs/contexto.md` | Manual de marca: tono, paleta, copy |
| `informes/informe.md` | El informe general (documento vivo en Markdown) |
| `informes/capturas/pc3/` | Carpeta oficial de las 14 capturas de evaluación de la PC3 |
| `overtext/` | Proyecto Spring Boot (Backend REST activo) |

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
