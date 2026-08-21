# Formato de las propuestas

Se presentan **3 o 4** propuestas para que el usuario elija. Si hay proyecto previo, una de ellas es adaptarlo.

---

## Cómo elegir qué proponer

Las propuestas deben ser **distintas entre sí**, no variaciones del mismo dominio. Buenas fuentes:

- Un dominio que el equipo conozca de primera mano (se nota en la sustentación)
- Un proceso real de una organización pequeña: un negocio, un club, un consultorio
- Algo con **entidades relacionadas de forma natural**, porque las rúbricas casi siempre exigen claves foráneas y CRUD

**Criterio de descarte:** si un dominio no da al menos dos entidades relacionadas y un flujo de mantenimiento con alta, edición y baja, no sirve para una rúbrica típica de desarrollo web. Descártalo antes de proponerlo.

**Calibra la ambición.** Marca cuál es la más segura y cuál la más ambiciosa, y di por qué. Un proyecto que cubre la rúbrica y se termina vale más que uno brillante a medias.

---

## Formato de cada propuesta

```markdown
### Propuesta N — <Nombre>

**Dominio.** Dos o tres frases: qué organización, qué problema real.

**Problema a resolver.** Qué se hace hoy y por qué no funciona.
Concreto y verificable, no genérico.

**Entidades tentativas**

| Entidad | Campos clave | Relación |
|---|---|---|
| ... | ... | ... |

**Cómo cubre cada rúbrica**

| Entrega | Criterio | Cómo se cubre aquí |
|---|---|---|
| E1 | Framework CSS, 6 componentes | Carrusel en portada, modal de X, grilla de Y... |
| E2 | Fragments y rutas | ... |
| E3 | CRUD con FK | Mantenimiento de A y B, con A→B |
| E4 | Seguridad con roles | Rol administrador y rol cliente |

**Riesgo principal.** Lo más probable que salga mal.

**Esfuerzo.** Bajo · Medio · Alto, y por qué.
```

---

## La tabla comparativa

Después de las propuestas, una tabla que las enfrente. Es lo que el usuario mira para decidir:

| | Prop. 1 | Prop. 2 | Prop. 3 | Prop. 4 |
|---|:-:|:-:|:-:|:-:|
| Entidades relacionadas | 5 | 8 | 4 | 9 |
| Cubre todos los criterios | ✔ | ✔ | ✔ | ✔ |
| Reutiliza trabajo previo | ✔ | — | — | — |
| Esfuerzo | Medio | Alto | Bajo | Alto |
| Riesgo | Bajo | Medio | Bajo | Alto |
| Material para sustentar | Alto | Alto | Bajo | Alto |

Cierra con **una recomendación explícita y su razón**. No dejes al usuario eligiendo a ciegas entre cuatro opciones equivalentes.

---

## El checkpoint

Después de presentar, **detente**. Usa `AskUserQuestion` con las propuestas como opciones.

No escribas `docs/propuesta-proyecto.md` hasta que el usuario elija.

---

## El artefacto final

Una vez elegida, `docs/propuesta-proyecto.md` desarrolla solo esa, ampliada:

```markdown
# Propuesta de proyecto — <Nombre>

## 1. Situación problemática
Prosa. Es la sección 1.1 del informe: se escribe una vez y se reutiliza
en las cuatro entregas.

## 2. Objetivos
### 2.1 General
Un párrafo que nombre la solución y el marco tecnológico.

### 2.2 Específicos
Uno por entrega, cada uno etiquetado con la entrega que lo cubre.

## 3. Alcance
### Dentro
### Fuera — explícitamente
Lo que NO se hará. Tan importante como lo anterior.

## 4. Stack
### Obligatorio (lo exigen las rúbricas)
### Opcional — fuera de rúbrica
Marcado como recortable.

## 5. Modelo de datos preliminar
Entidades, campos, relaciones. Alimenta el diagrama que las rúbricas
suelen pedir desde la primera entrega.

## 6. Cobertura de rúbricas
Una tabla por entrega: criterio → cómo se cubre → en qué sprint.

## 7. Riesgos
```

Este archivo y `docs/matriz-cobertura.md` son la entrada de `/sdd-scrum`.
