# AGENTS.md — Contrato de Trabajo y Directivas para Agentes de IA

**Proyecto:** OverText (E-commerce Streetwear Peruano)  
**Curso:** Marcos de Desarrollo Web (UTP 2026-2) — Sección 38189 — Grupo 01  
**Sprint Activo:** **Práctica Calificada 3 (PC3) / ATF3**  
**Enfoque de Evaluación:** **100% BACKEND REST** (Spring Boot Multicapas + Supabase PostgreSQL)  

---

## 1. Reglas Absolutas (No Negociables)

1. **ALCANCE 100% BACKEND:**
   - La evaluación de la PC3 exige **únicamente APIs REST JSON probadas en Postman y cURL**.
   - **PROHIBIDO** crear plantillas HTML, editar archivos CSS, tocar JavaScript de cliente o crear controladores con `@Controller` para Thymeleaf.
   - Todo nuevo controlador debe ser `@RestController` y devolver `ResponseEntity<?>` con DTOs en formato JSON.

2. **UN ARCHIVO, UN ESCRITOR (CERO CONFLICTOS GIT):**
   - Cada agente trabaja en el rol de **UN SOLO INTEGRANTE**.
   - Solo puedes crear o modificar los archivos asignados a ese integrante en `PC3_INSTRUCCIONES.md`.
   - Si necesitas información de otra capa, lee su interfaz o contrato en este documento; **no edites código de otro compañero**.

3. **CONTRATO CANÓNICO DE TIPOS DE DATOS (PROHIBIDO ALUCINAR):**
   - Respeta estrictamente los nombres de variables y tipos de datos definidos en la Sección 3.
   - Por ejemplo: el precio es `Double precio`, el ID es `Long id`, el stock es `Integer stock`. No uses `BigDecimal` ni `float` para evitar errores de compilación al integrar.

4. **MEMORIAS Y SEGUIMIENTO:**
   - `memory.md` es la memoria histórica general y **solo la escribe el Scrum Master (Jonathan)** al consolidar.
   - `docs/pc3-tablero-control.md` es el tablero de control de la PC3; marca tu casilla `[x]` cuando tu tarea esté terminada.

---

## 2. Mapa de Integrantes, Roles y Archivos Permitidos

| Integrante | Rol en la PC3 | Archivos que PUEDE tocar | Archivos que NO DEBE tocar |
|---|---|---|---|
| **Jonathan** | DevOps & Supabase | `overtext/pom.xml`<br>`application.properties`<br>`schema-supabase.sql` | Clases de negocio en `entity/`, `dto/`, `repository/`, `service/` |
| **Dayro** | Modelo & Persistencia | `entity/Categoria.java`<br>`entity/Producto.java`<br>`entity/Rol.java`<br>`entity/Usuario.java` | Repositorios, DTOs, Servicios y Controladores |
| **Carlos** | Repositorios SQL | `repository/CategoriaRepository.java`<br>`repository/ProductoRepository.java`<br>`repository/RolRepository.java`<br>`repository/UsuarioRepository.java` | Entidades, DTOs y Controladores |
| **José** | DTOs & Validaciones | `dto/ProductoRequestDTO.java`<br>`dto/ProductoResponseDTO.java`<br>`dto/CategoriaDTO.java`<br>`dto/RolDTO.java`<br>`dto/UsuarioRequestDTO.java`<br>`dto/UsuarioResponseDTO.java` | Entidades y Servicios |
| **Joaquín** | Servicios y APIs | `service/ProductoService.java`<br>`service/impl/ProductoServiceImpl.java`<br>`service/RolService.java`<br>`service/impl/RolServiceImpl.java`<br>`service/UsuarioService.java`<br>`service/impl/UsuarioServiceImpl.java`<br>`controller/api/ProductoRestController.java`<br>`controller/api/RolRestController.java`<br>`controller/api/UsuarioRestController.java`<br>`advice/GlobalExceptionHandler.java` | Entidades, DTOs y Repositorios |
| **Jhade** | QA & Documentación | `docs/pruebas/`<br>`informes/informe-p3.md`<br>`informes/capturas/pc3/` | Código fuente en `src/main/java/` |

---

## 3. Contrato Canónico de Datos (Tipos y Nombres Exactos)

Cualquier agente que genere código en `entity/`, `dto/`, `service/` o `controller/api/` **debe usar exactamente estos nombres y tipos**:

> [!NOTE]
> Las entidades de dominio en `entity/` (`Categoria`, `Producto`, `Rol`, `Usuario`) utilizan las anotaciones de Lombok `@Data`, `@NoArgsConstructor` y `@AllArgsConstructor`, eliminando constructores manuales y métodos getters/setters repetitivos.

### A. Entidad y DTO `Categoria`
- `Long id` (PK, generado automáticamente)
- `String nombre` (Ej: "Shorts Urbanos")
- `String slug` (Ej: "shorts-urbanos", único)
- `String descripcion` (Texto descriptivo)
- `Boolean activo` (Por defecto `true`)

### B. Entidad y DTO `Producto`
| Campo Java | Tipo de Dato | Equivalente en PostgreSQL | Anotaciones Bean Validation (en RequestDTO) |
|---|:---:|:---:|---|
| `id` | `Long` | `BIGSERIAL PRIMARY KEY` | *(Generado por la BD, omitir en Request)* |
| `codigo` | `String` | `VARCHAR(40) UNIQUE` | `@NotBlank(message = "El código es obligatorio")` |
| `nombre` | `String` | `VARCHAR(100)` | `@NotBlank` y `@Size(min = 3, max = 100)` |
| `slogan` | `String` | `VARCHAR(150)` | *(Opcional)* |
| `descripcion` | `String` | `TEXT` | *(Opcional)* |
| `precio` | `Double` | `DECIMAL(10,2)` | `@NotNull` y `@Positive(message = "El precio debe ser positivo")` |
| `precioPack` | `Double` | `DECIMAL(10,2)` | `@PositiveOrZero` |
| `stock` | `Integer` | `INT` | `@NotNull` y `@PositiveOrZero` |
| `imagenPrincipal` | `String` | `VARCHAR(255)` | *(Opcional)* |
| `colorNombre` | `String` | `VARCHAR(40)` | `@NotBlank(message = "El color es obligatorio")` |
| `colorHex` | `String` | `VARCHAR(10)` | `@NotBlank` |
| `correoProveedor` | `String` | `VARCHAR(100)` | `@NotBlank` y `@Email(message = "Debe ser un email válido")` |
| `activo` | `Boolean` | `BOOLEAN` | *(Por defecto true)* |
| `categoriaId` | `Long` | `BIGINT REFERENCES categoria(id)` | `@NotNull` y `@Positive` (en RequestDTO) |

### C. Entidad y DTO `Rol`
- **Entidad `Rol`:**
  - `Long id` (PK, generado automáticamente con `@GeneratedValue(strategy = GenerationType.IDENTITY)`)
  - `String nombre` (Ej: "ADMIN", "CLIENTE", único, `VARCHAR(40) NOT NULL`)
  - `String descripcion` (`VARCHAR(150)`, opcional)
  - Relación: `@OneToMany(mappedBy = "rol")` hacia `Usuario`.
- **DTO `RolDTO` (Lectura/Catálogo):**
  - `Long id`
  - `String nombre`
  - `String descripcion`

### D. Entidad y DTOs `Usuario`
- **Entidad `Usuario`:**
  - `Long id` (PK, generado automáticamente con `@GeneratedValue(strategy = GenerationType.IDENTITY)`)
  - `String email` (Único, `VARCHAR(100) NOT NULL`)
  - `String password` (`VARCHAR(255) NOT NULL`, omitir hash en respuestas)
  - `String nombre` (`VARCHAR(100) NOT NULL`)
  - `Boolean activo` (Por defecto `true`, `BOOLEAN NOT NULL`)
  - Relación: `@ManyToOne` hacia `Rol` con `@JoinColumn(name = "rol_id", nullable = false)`.

- **DTO `UsuarioRequestDTO` (Creación con Bean Validation):**
  | Campo Java | Tipo de Dato | Anotaciones Bean Validation |
  |---|:---:|---|
  | `email` | `String` | `@NotBlank(message = "El email es obligatorio")`<br>`@Email(message = "Debe ser un email válido")` |
  | `password` | `String` | `@NotBlank(message = "La contraseña es obligatoria")`<br>`@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")` |
  | `nombre` | `String` | `@NotBlank(message = "El nombre es obligatorio")`<br>`@Size(min = 3, max = 100, message = "Debe tener entre 3 y 100 caracteres")` |
  | `rolId` | `Long` | `@NotNull(message = "El rol es obligatorio")`<br>`@Positive(message = "El ID de rol debe ser positivo")` |

- **DTO `UsuarioResponseDTO` (Respuesta Segura al Cliente):**
  - `Long id`
  - `String email`
  - `String nombre`
  - `Boolean activo`
  - `String rolNombre` (Nombre del rol asociado, omitiendo el hash de contraseña)

---

## 4. Endpoints y Verbos HTTP Canónicos

### A. Endpoints de Productos (`ProductoRestController` bajo `/api/productos`)
1. `GET /api/productos`: Lista completa de productos activos (**Select JPA**). Retorna `200 OK` con `List<ProductoResponseDTO>`.
2. `GET /api/productos/nativos`: Lista de productos con stock > 0 (**Select Nativo**). Retorna `200 OK`.
3. `GET /api/productos/{id}`: Búsqueda por ID. Requiere validación en GET con `@PathVariable @Positive Long id`. Si existe retorna `200 OK`, si no `404 Not Found`.
4. `POST /api/productos`: Creación de producto. Requiere `@Valid @RequestBody ProductoRequestDTO dto`. Retorna `201 Created` con el producto creado.
5. `PUT /api/productos/{id}`: Actualización de producto. Requiere `@PathVariable @Positive Long id` y `@Valid @RequestBody ProductoRequestDTO dto`. Retorna `200 OK`.
6. `DELETE /api/productos/{id}`: Eliminación física o lógica. Requiere `@PathVariable @Positive Long id`. Retorna `204 No Content`.

### B. Endpoints de Usuarios (`UsuarioRestController` bajo `/api/usuarios`)
1. `GET /api/usuarios`: Lista de usuarios activos (`List<UsuarioResponseDTO>`). Retorna `200 OK`.
2. `GET /api/usuarios/{id}`: Búsqueda de usuario por ID. Requiere `@PathVariable @Positive Long id`. Si existe retorna `200 OK`, si no `404 Not Found`.
3. `POST /api/usuarios`: Registro de nuevo usuario. Requiere `@Valid @RequestBody UsuarioRequestDTO dto`. Retorna `201 Created` con `UsuarioResponseDTO`. Si el email ya está registrado, retorna `400 Bad Request`.
4. `DELETE /api/usuarios/{id}`: Baja lógica (`activo = false`) con `@PathVariable @Positive Long id`. Retorna `204 No Content`.

### C. Endpoints de Roles (`RolRestController` bajo `/api/roles`)
1. `GET /api/roles`: Listar catálogo de roles disponibles para asignación (`List<RolDTO>`). Retorna `200 OK`.

---

## 5. Manejo Global de Errores (`GlobalExceptionHandler`)

Debe interceptar:
- `MethodArgumentNotValidException` (fallas en `@Valid` del POST o PUT).
- `ConstraintViolationException` (fallas en `@Positive` del GET).
- `ResourceNotFoundException` (ID no encontrado).
- Respuestas de error deben retornar código HTTP `400 Bad Request` o `404 Not Found` en formato JSON legible con fecha, código y lista de mensajes de error.
