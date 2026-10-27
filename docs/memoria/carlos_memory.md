# Memoria personal — Carlos

> Escritor único: Carlos y su agente. Bitácora provisional; `memory.md` no se toca.

## PC3 — Fase 3A: Capa Repository (rama `feature/p3-carlos-repository`)

### Qué hice
- Creé `RolRepository` (`findByNombre`) y `UsuarioRepository` (`findByEmail`, `findByActivoTrue`).
- Redacté la sección 3.3 del informe (`informes/secciones-p3/3.3-capa-persistencia-jpa-vs-nativo.md`).
- Ejecuté y verifiqué la suite de pruebas contra Supabase con `mvn test` (8/8 pruebas exitosas en verde).
- Archivé la evidencia visual obligatoria: `informes/capturas/pc3/05-cmd-query-nativa-logs.png` demostrando la ejecución del Select Nativo SQL con logs de Hibernate.
- Marqué mis casillas en `docs/pc3-tablero-control.md` (bloque de Carlos al 100% técnico).

### Archivos tocados
- `overtext/src/main/java/pe/edu/utp/overtext/repository/RolRepository.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/repository/UsuarioRepository.java` (nuevo)
- `informes/secciones-p3/3.3-capa-persistencia-jpa-vs-nativo.md` (nuevo)
- `informes/capturas/pc3/05-cmd-query-nativa-logs.png` (nuevo)
- `docs/pc3-tablero-control.md` (bloque de Carlos actualizado a finalizado)
- `docs/memoria/carlos_memory.md` (actualizado)

### Decisiones / aprendido
- `CategoriaRepository` y `ProductoRepository` ya existían y cumplen el contrato; no se modificaron.
- Los repos existentes incluyen `findBySlug` y `findByCodigo`, que no están en `PC3_INSTRUCCIONES.md`. Se dejaron y se documentaron en 3.3.
- Se comprobó que `listarProductosDisponiblesNativo()` ejecuta el SQL nativo en Supabase y retorna los productos con existencias ordenados por precio.

### Estado / PR
- Código Java, documentación y capturas al 100%.
- Compilación verificada con `mvn clean test` (8/8 tests exitosos).
- Rama `feature/p3-carlos-repository` lista para Pull Request / Merge manual a `testing` por el Scrum Master.
