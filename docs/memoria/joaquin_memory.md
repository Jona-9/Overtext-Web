# Memoria personal — Joaquín

> Escritor único: Joaquín y su agente. Bitácora provisional; `memory.md` no se toca.

## PC3 — Fase 4: Capa Service y Controladores REST (rama `feature/p3-joaquin-service-api`)

### Qué hice
- Diseñé y completé la capa Service:
  - `ProductoService` y su implementación `ProductoServiceImpl` con CRUD completo, mapeo Entity ↔ DTO, transaccionalidad `@Transactional(readOnly = true)` / `@Transactional` y conexión contra Supabase PostgreSQL.
  - `RolService` y `RolServiceImpl` para el catálogo de roles.
  - `UsuarioService` y `UsuarioServiceImpl` con validación de emails duplicados, asignación de roles y baja lógica (`activo = false`).
- Implementé los controladores REST en el paquete canónico `pe.edu.utp.overtext.controller.api`:
  - `ProductoRestController` (`/api/productos`): endpoints para Select JPA, Select Nativo, GET con `@Positive`, POST con `@Valid`, PUT y DELETE.
  - `RolRestController` (`/api/roles`): catálogo de roles.
  - `UsuarioRestController` (`/api/usuarios`): listado, búsqueda con `@Positive`, registro con `@Valid` y baja lógica con `@Positive`.
- **Cumplimiento de Directiva de Usuario:** Se eliminaron todos los comentarios de las clases de controladores, garantizando código 100% puro y limpio. Se retiró cualquier componente de `@ControllerAdvice` / `GlobalExceptionHandler` manteniendo exclusivamente la arquitectura estándar enseñada en clase con respuestas semánticas en `ResponseEntity`.
- Creé y exporté la colección oficial de Postman: `docs/pruebas/OverText_PC3_Postman_Collection.json` con todos los endpoints de Productos, Roles y Usuarios.
- Archivé la evidencia visual obligatoria: `informes/capturas/pc3/07-postman-endpoints-list.png` mostrando la estructura de peticiones configuradas en Postman.
- Actualicé y amplié la suite de pruebas en `OvertextApplicationTests.java`, cubriendo la totalidad de endpoints y validaciones.
- Ejecuté `mvn clean test` contra Supabase PostgreSQL: **15 de 15 pruebas exitosas en verde** (0 fallas, 0 errores, `BUILD SUCCESS`).
- Redacté la sección técnica oficial del informe: `informes/secciones-p3/3.5-logica-servicios-endpoints-api-rest.md`.
- Actualicé el tablero de control en `docs/pc3-tablero-control.md`.

### Archivos tocados
- `overtext/src/main/java/pe/edu/utp/overtext/service/ProductoService.java` (modificado)
- `overtext/src/main/java/pe/edu/utp/overtext/service/impl/ProductoServiceImpl.java` (nuevo / reubicado)
- `overtext/src/main/java/pe/edu/utp/overtext/service/RolService.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/service/impl/RolServiceImpl.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/service/UsuarioService.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/service/impl/UsuarioServiceImpl.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/controller/api/ProductoRestController.java` (nuevo / reubicado)
- `overtext/src/main/java/pe/edu/utp/overtext/controller/api/RolRestController.java` (nuevo)
- `overtext/src/main/java/pe/edu/utp/overtext/controller/api/UsuarioRestController.java` (nuevo)
- `overtext/src/test/java/pe/edu/utp/overtext/OvertextApplicationTests.java` (modificado)
- `informes/secciones-p3/3.5-logica-servicios-endpoints-api-rest.md` (nuevo)
- `informes/capturas/pc3/07-postman-endpoints-list.png` (nuevo)
- `docs/pruebas/OverText_PC3_Postman_Collection.json` (nuevo)
- `docs/memoria/joaquin_memory.md` (nuevo)
- `docs/pc3-tablero-control.md` (actualizado)

### Decisiones / aprendido
- Se eliminaron las versiones preliminares en `controller/` y `service/` para situarlas en sus paquetes canónicos `controller/api/` y `service/impl/`, evitando colisiones de beans en el contenedor de Spring.
- Los controladores están libres de comentarios por directiva explícita del usuario.
- Se eliminó el paquete `advice/` para apegarse 100% al temario enseñado por el docente, resolviendo respuestas HTTP semánticas (`200 OK`, `201 Created`, `204 No Content`, `400 Bad Request`, `404 Not Found`) con `ResponseEntity` nativo.
- La suite completa de 15 pruebas unitarias e integración se ejecuta limpiamente contra la base de datos Supabase en la nube.

### Estado / PR
- Código Java, documentación y pruebas al 100%.
- Rama `feature/p3-joaquin-service-api` lista para Pull Request y merge a `testing` por el Scrum Master.
