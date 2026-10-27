# Memoria personal — Carlos

> Escritor único: Carlos y su agente. Bitácora provisional; `memory.md` no se toca.

## PC3 — Fase 3A: Capa Repository (rama `feature/p3-carlos-repository`)

### Qué hice
- Creé `RolRepository` (`findByNombre`) y `UsuarioRepository` (`findByEmail`, `findByActivoTrue`).
- Redacté la sección 3.3 del informe.
- Marqué mis casillas en `docs/pc3-tablero-control.md` (solo mi bloque).

### Archivos tocados
- `overtext/src/main/java/pe/edu/utp/overtext/repository/RolRepository.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/repository/UsuarioRepository.java` (nuevo)
- `informes/secciones-p3/3.3-capa-persistencia-jpa-vs-nativo.md` (nuevo)
- `docs/pc3-tablero-control.md` (bloque de Carlos)
- `docs/memoria/carlos_memory.md` (nuevo)

### Decisiones / aprendido
- `CategoriaRepository` y `ProductoRepository` ya existían y cumplen el contrato; no se modificaron.
- Los repos existentes incluyen `findBySlug` y `findByCodigo`, que no están en `PC3_INSTRUCCIONES.md`. Se dejaron y se documentaron en 3.3.

### Bloqueado / pendiente
- Captura `05-cmd-query-nativa-logs.png`: requiere correr la app contra Supabase y fotografiar los logs de Hibernate.
- Merge de `feature/p3-carlos-repository` a `testing`.
- No se ejecutó compilación (`./mvnw`) tras crear los repos.

### Para consolidar
- Fase 3A (Repository) completa en código: 4 repositorios listos para Joaquín (Fase 4).
- Sección 3.3 entregada en `informes/secciones-p3/`; Jhade la integra en `informe-p3.md`.
- Falta la Captura 5 y el merge.
