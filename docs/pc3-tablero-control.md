# pc3-tablero-control.md — Tablero Operativo de Seguimiento y Control PC3
## OverText E-commerce (Spring Boot + Supabase PostgreSQL)

**Curso:** Marcos de Desarrollo Web (UTP 2026-2) — Sección 38189 — Grupo 01  
**Base de Datos:** PostgreSQL en la nube con Supabase  
**Scrum Master e Integrador:** Jonathan  
**Alcance:** 100% Backend REST (Spring Boot + Supabase PostgreSQL). Cero horas en frontend: no se maquetan vistas ni formularios para la P3; el CRUD se opera y sustenta exclusivamente en Postman y cURL.  

> **Propósito de este documento:**  
> Tablero operativo y oficial de seguimiento para la **Práctica Calificada 3 (PC3)**.  
> Cada integrante (o agente de IA asignado a su rol) debe marcar sus casillas `[x]` a medida que completa sus archivos de código, sus capturas y su sección de documentación.  
> Para consultar las directivas generales de agentes y el contrato estricto de tipos de datos, lee primero **[`AGENTS.md`](Desktop/Overtext-Web/AGENTS.md)** y **[`PC3_INSTRUCCIONES.md`](Desktop/Overtext-Web/PC3_INSTRUCCIONES.md)**.

**Regla de Oro:** Cada integrante actualiza sus casillas `[x]` al completar su código, sus capturas y su redacción.  

---

## 1. Estado de la Puerta de Consolidación PC3

| Integrante | Rol en la PC3 | Capa / Especialidad | Tiempo Est. | Ventana Límite | Estado | Aprobación |
|---|---|---|:---:|:---:|:---:|:---:|
| **Jonathan** | Scrum Master & DevOps | Infraestructura & Supabase | 3 - 4 h | Lun 26 — 12:00 | 🟨 En curso | [ ] Aprobado |
| **Dayro** | Backend Developer | Capa Entity (JPA) | 2 - 3 h | Lun 26 — 18:00 | 🟨 En curso | [ ] Aprobado |
| **Carlos** | Backend Developer | Capa Repository (JPA / Nativo) | 3 h | Mar 27 — 13:00 | 🟨 En curso | [ ] Aprobado |
| **José** | Backend Developer | Capa DTO & Bean Validation | 3 h | Mar 27 — 13:00 | ⬜ Pendiente | [ ] Aprobado |
| **Joaquín** | Backend Developer | Capa Service & Controller REST | 5 - 6 h | Mié 28 — 13:00 | ⬜ Pendiente | [ ] Aprobado |
| **Jhade** | QA & Editora del Informe | Pruebas Postman / cURL & Doc | 6 - 8 h | Jue 29 — 14:00 | ⬜ Pendiente | [ ] Aprobado |

> ⏳ **DEADLINE FINAL DE ENTREGA:** **Jueves hasta las 18:00 hrs.**  
> 🛡️ **Colchón de Contingencia y Ensayo de Sustentación:** Jueves de 14:00 a 18:00 hrs (4 horas libres de buffer).

---

## 2. Cronograma Maestro y Distribución Temporal

```
[Dom 25 - Lun 26 12:00] Fase 1: Jonathan (DevOps & Supabase, 4h)
          │
          ▼
[Lun 26 14:00 - 18:00]  Fase 2: Dayro (Entidades JPA, 3h)
          │
     ┌────┴────────────────────────┐
     ▼                             ▼
[Mar 27 09:00 - 13:00]        [Mar 27 09:00 - 13:00]
Fase 3A: Carlos               Fase 3B: José
(Repositorios SQL, 3h)        (DTOs + Bean Validation, 3h)
     └────┬────────────────────────┘
          │
          ▼
[Mar 27 14:00 - Mié 28 13:00] Fase 4: Joaquín (Services, Controllers REST, Excepciones, 6h)
          │
          ▼
[Mié 28 14:00 - 19:00]        Fase 5: Jhade (Pruebas Postman/cURL, Capturas 08-14, 4h)
          │
          ▼
[Jue 29 09:00 - 14:00]        Fase 6: Consolidación, Informe Técnico APA y ZIP (Jhade + Jonathan, 4h)
          │
          ▼
[Jue 29 14:00 - 18:00]        BUFFER DE SEGURIDAD (4h) & ENTREGA ANTES DE LAS 6:00 PM
```

---

## 3. Checklist de Responsabilidades por Integrante

### 1. Jonathan — DevOps, Limpieza de Frontend y Supabase *(Est.: 3-4h | Límite: Lun 26 12:00)*
- [x] **Limpieza de Frontend y Conversión a Backend REST Puro:**
  - [x] Retirar dependencia `spring-boot-starter-thymeleaf` de `overtext/pom.xml`.
  - [x] Retirar controladores de vistas HTML de P2 (`CatalogoController`, `HomeController`, etc.), preparando el proyecto exclusivamente para los `@RestController`.
  - [x] Desacoplar plantillas `templates/` y estáticos para que el proyecto sea 100% Backend REST JSON.
- [x] **Configuración en Supabase:**
  - [x] Crear proyecto en [Supabase](https://supabase.com).
  - [x] Ejecutar script DDL `schema-supabase.sql` en el SQL Editor de Supabase.
  - [x] Verificar creación de tablas `categoria` y `producto` con los 7 registros iniciales.
- [x] **Configuración de Spring Boot:**
  - [x] Añadir dependencias en `overtext/pom.xml` (`postgresql`, `spring-boot-starter-data-jpa`, `spring-boot-starter-validation`).
  - [x] Configurar credenciales y URL JDBC en `overtext/src/main/resources/application.properties`.
  - [x] Probar arranque limpio de Spring Boot y conexión HikariCP a Supabase como API REST pura.
- [ ] **Capturas Obligatorias:**
  - [ ] `informes/capturas/pc3/01-supabase-dashboard.png` (Dashboard web del proyecto activo).
  - [ ] `informes/capturas/pc3/02-supabase-tablas.png` (Table Editor con registros).
  - [ ] `informes/capturas/pc3/03-cmd-arranque-hikari.png` (Consola mostrando conexión exitosa en puerto 8080).
- [ ] **Documentación:**
  - [ ] Redactar sección *3.1 Conexión a Base de Datos en la Nube con Supabase y Pool HikariCP*.
- [ ] **Git:** Merge de `jonathan_avance3` a `testing` (solo al finalizar toda la Fase 1 y verificar con Supabase).

---

### 2. Dayro — Capa Entity (Mapeo Objeto-Relacional JPA) *(Est.: 2-3h | Límite: Lun 26 18:00)*
- [ ] **Código de Entidades:**
  - [x] Crear paquete `pe.edu.utp.overtext.entity`.
  - [x] Crear entidad `Categoria.java` (`@Entity`, `@Table(name = "categoria")`, `@Id`, `@GeneratedValue`, relación `@OneToMany`).
  - [x] Crear entidad `Producto.java` (`@Entity`, `@Table(name = "producto")`, relación `@ManyToOne` hacia Categoria, getters, setters y constructores).
  - [x] Crear entidad `Rol.java` (`@Entity`, `@Table(name = "rol")`, `@Id`, relación `@OneToMany(mappedBy = "rol")`).
  - [x] Crear entidad `Usuario.java` (`@Entity`, `@Table(name = "usuario")`, `@Id`, relación `@ManyToOne` hacia `Rol`).
  - [ ] Verificar que no existan errores de compilación (`./mvnw compile`).
- [x] **Capturas Obligatorias:**
  - [x] `informes/capturas/pc3/04-1-entidades-jpa.png` a `04-4-entidades-jpa.png` (Código en IDE mostrando anotaciones `@Entity`, `@Id`, `@ManyToOne` y `@OneToMany` para Categoria, Producto, Rol y Usuario).
- [ ] **Documentación:**
  - [x] Redactar sección *3.2 Modelo de Dominio y Mapeo Objeto-Relacional (JPA)* con diccionario de campos de Categoria, Producto, Rol y Usuario (en `informes/secciones-p3/3.2-modelo-de-dominio-jpa.md`).
- [ ] **Git:** Merge de `feature/p3-dayro-entity` a `testing`.

---

### 3. Carlos — Capa Repository (Consultas JPA y Consulta Nativa) *(Est.: 3h | Límite: Mar 27 13:00)*
- [x] **Código de Repositorios:**
  - [x] Crear paquete `pe.edu.utp.overtext.repository`.
  - [x] Crear interfaz `CategoriaRepository.java` extendiendo `JpaRepository<Categoria, Long>`.
  - [x] Crear interfaz `ProductoRepository.java` extendiendo `JpaRepository<Producto, Long>`.
  - [x] Implementar **Select JPA:** `List<Producto> findByActivoTrue();`.
  - [x] Implementar **Select Nativo (Requisito P3):**
    `@Query(value = "SELECT * FROM producto WHERE stock > 0 AND activo = true ORDER BY precio ASC", nativeQuery = true)`
    `List<Producto> listarProductosDisponiblesNativo();`
- [ ] **Capturas Obligatorias:**
  - [ ] `informes/capturas/pc3/05-cmd-query-nativa-logs.png` (Terminal/CMD con logs de Hibernate mostrando la consulta nativa SQL).
- [ ] **Documentación:**
  - [ ] Redactar sección *3.3 Capa de Persistencia y Consultas: JPA vs SQL Nativo*.
- [ ] **Git:** Merge de `feature/p3-carlos-repository` a `testing`.

---

### 4. José — Capa DTO y Reglas de Bean Validation *(Est.: 3h | Límite: Mar 27 13:00)*
- [ ] **Código de DTOs:**
  - [ ] Crear paquete `pe.edu.utp.overtext.dto`.
  - [ ] Crear `ProductoRequestDTO.java` con las 5 anotaciones obligatorias:
    - [ ] `@NotBlank` en código y nombre.
    - [ ] `@Size(min = 3, max = 100)` en nombre.
    - [ ] `@NotNull` en precio, stock y categoría.
    - [ ] `@Positive` en precio.
    - [ ] `@Email` en `correoProveedor`.
  - [ ] Crear `ProductoResponseDTO.java` para serializar respuestas limpias a Postman/Frontend.
  - [ ] Crear `CategoriaDTO.java`.
- [ ] **Capturas Obligatorias:**
  - [ ] `informes/capturas/pc3/06-dto-validaciones-codigo.png` (Código en IDE destacando las 5 anotaciones Bean Validation).
- [ ] **Documentación:**
  - [ ] Redactar sección *3.4 Capa DTO y Validación de Datos con Bean Validation* con tabla de restricciones.
- [ ] **Git:** Merge de `feature/p3-jose-dto` a `testing`.

---

### 5. Joaquín — Capa Service y Controladores REST con CRUD Completo *(Est.: 5-6h | Límite: Mié 28 13:00)*
- [ ] **Código de Servicios y Transaccionalidad:**
  - [ ] Actualizar interfaz `ProductoService.java` con métodos CRUD y consultas especializadas.
  - [ ] Implementar `ProductoServiceImpl.java` en `service/impl/` con `@Transactional` e inyección de repositorios.
  - [ ] Desacoplar la lectura estática de `productos.json` y conectar a la base de datos Supabase.
- [ ] **Código de Controladores REST:**
  - [ ] Crear paquete `pe.edu.utp.overtext.controller.api` y la clase `ProductoRestController.java` (`@RestController`, `@RequestMapping("/api/productos")`, `@Validated`).
  - [ ] Implementar `GET /api/productos` (Select JPA).
  - [ ] Implementar `GET /api/productos/nativos` (Select Nativo).
  - [ ] Implementar `GET /api/productos/{id}` con validación `@PathVariable @Positive Long id`.
  - [ ] Implementar `POST /api/productos` con validación `@Valid @RequestBody ProductoRequestDTO dto`.
  - [ ] Implementar `PUT /api/productos/{id}` con validación `@PathVariable @Positive` y `@Valid`.
  - [ ] Implementar `DELETE /api/productos/{id}` con validación `@PathVariable @Positive`.
  - [ ] Crear `GlobalExceptionHandler.java` (`@RestControllerAdvice`) para retornar HTTP 400 en errores de validación.
- [ ] **Capturas Obligatorias:**
  - [ ] `informes/capturas/pc3/07-postman-endpoints-list.png` (Colección en Postman con todos los endpoints creados).
- [ ] **Documentación:**
  - [ ] Redactar sección *3.5 Lógica de Servicios y Endpoints de la API REST*.
- [ ] **Git:** Merge de `feature/p3-joaquin-service-api` a `testing`.

---

### 6. Jhade — Líder de Documentación, Pruebas en Postman/cURL y Empaque *(Est.: 6-8h | Límite: Jue 29 14:00)*
- [ ] **Ejecución y Pruebas de APIs:**
  - [ ] Crear y ejecutar la colección en Postman con las 7 peticiones (GET, POST válido, POST con errores 400, PUT, DELETE).
  - [ ] Exportar colección a `docs/pruebas/OverText_PC3_Postman_Collection.json`.
  - [ ] Ejecutar script de terminal `bash docs/pruebas/pruebas_curl_pc3.sh`.
- [ ] **Capturas Obligatorias:**
  - [ ] `informes/capturas/pc3/08-postman-get-jpa.png` (GET JPA - 200 OK).
  - [ ] `informes/capturas/pc3/09-postman-get-nativo.png` (GET Nativo - 200 OK).
  - [ ] `informes/capturas/pc3/10-postman-get-invalido.png` (GET ID negativo - **HTTP 400**).
  - [ ] `informes/capturas/pc3/11-postman-post-valido.png` (POST válido - **HTTP 201 Created**).
  - [ ] `informes/capturas/pc3/12-postman-post-errores.png` (POST con datos erróneos - **HTTP 400** Bean Validation).
  - [ ] `informes/capturas/pc3/13-postman-put-delete.png` (PUT y DELETE exitosos).
  - [ ] `informes/capturas/pc3/14-cmd-curl-ejecucion.png` (Terminal/CMD con la ejecución del script cURL).
- [ ] **Documentación e Informe Oficial UTP:**
  - [ ] Integrar Carátula UTP, Capítulo 2 (Generalidades), Capítulo 3 (Desarrollo Técnico), Capítulo 4 (Evidencias con las 14 capturas) y Bibliografía APA.
  - [ ] Generar PDF final `PC3_GRUPO_01.pdf`.
  - [ ] Generar empaque comprimido limpio (sin carpeta `target/`).

---

## 4. Verificación de Criterios Rúbrica P3

- [ ] Reutilización de la base Spring Boot de P2 para el backend multicapas.
- [ ] Arquitectura Multicapas completa: `Entity`, `DTO`, `Controller`, `Repository`, `Service`, `ServiceImpl`.
- [ ] Conexión a Base de Datos en la Nube (PostgreSQL en Supabase).
- [ ] CRUD Completo implementado y verificado (GET, POST, PUT, DELETE).
- [ ] APIs ejecutadas y documentadas en Postman y cURL.
- [ ] Al menos un Select JPA y al menos un Select Nativo.
- [ ] DTO con validaciones `@Size`, `@Email`, `@NotNull`, `@Positive`, `@NotBlank`.
- [ ] Controlador con validaciones en POST (`@Valid`) y GET (`@Positive`).
- [ ] Las 14 capturas archivadas en `informes/capturas/pc3/`.
- [ ] Informe técnico en PDF sin campos vacíos y con bibliografía APA.

---

## 5. Aprobación Final del Scrum Master

> **Cláusula de Cierre:** Este documento certifica que las 6 fases han sido ejecutadas, verificadas sin conflictos en la rama `testing`, probadas contra Supabase y documentadas en el informe oficial.

**Firma de Aprobación:**  
- [ ] **Jonathan — Scrum Master (Aprobado y Consolidado)**  
*Fecha de Aprobación:* `___ / ___ / 2026`
