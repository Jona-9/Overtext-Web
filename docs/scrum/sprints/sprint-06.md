# Sprint 6 — Spring Security

**Semanas 13-14 del ciclo · 02-nov → 15-nov-2026 · Sesiones 25 a 28 · Unidad 4**
**Sin entrega** — primer sprint del Trabajo Final · **Spec:** `docs/specs/004-seguridad-pedidos/`

---

## 1. Temas que se dictan estas semanas

| Sesión | Tema |
|:---:|---|
| 25-26 | Introducción a Spring Security: definiciones, tipos de validación y configuración de Spring Security en un proyecto web |
| 27-28 | Autorización y autenticación: conceptos, ventajas, usos y construcción de proyectos web con autenticación y autorización de usuarios |

## 2. Objetivo del sprint

> Reemplazar el inicio de sesión simulado en el navegador por Spring Security real: usuarios y roles en MySQL, contraseñas cifradas con BCrypt y separación efectiva entre páginas públicas y privadas.

## 3. Hacia qué criterio del TF apunta

| Criterio | Pts | Qué se cubre aquí |
|---|:-:|---|
| 1 Estructura del proyecto | 4 | Aparecen los paquetes `config/` y `util/`, que el descriptor "Completo" exige |
| 2 Operaciones de seguridad | 4 | **Los 4 puntos completos**: a) clase de configuración con públicas y privadas · b) usuarios y contraseñas **encriptadas** en BD · c) formulario de inicio de sesión **personalizado** · d) botón **personalizado** de cerrar sesión |

**Dos de los cuatro puntos vienen casi gratis:** el formulario de inicio de sesión (`login.html`) existe desde el ATF1 y el botón de cerrar sesión existe en el panel. Solo hay que conectarlos a `formLogin` y `logout`.

## 4. Punto de partida: lo que hay que destruir

El proyecto anterior tiene seguridad **simulada, no real**:

| Problema actual | Archivo |
|---|---|
| Credenciales escritas en el cliente: `admin@mail.com` / `123456` | `js/login.js` |
| El panel es accesible por URL directa, **sin ninguna sesión** | `intranet.html` |
| No hay usuarios, ni roles, ni hash, ni sesión, ni CSRF | — |

Todo eso se elimina en este sprint. Es el mayor salto de calidad del proyecto.

## 5. Alcance

### Duo Datos / Backend — Jonathan · Dayro

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-01 | Añadir `spring-boot-starter-security` | 2a | 25-26 |
| E4-02 | Entidades `Rol` y `Usuario` con FK, repositorios y servicios | **2b** | 25-26 |
| E4-16 | `BCryptPasswordEncoder` como `@Bean` en `config/` | **2b** | 25-26 |
| E4-03 | `UsuarioDetailsService` implementando `UserDetailsService` | **2b** | 27-28 |
| E4-04 | `config/SecurityConfig` con `SecurityFilterChain`: públicas vs. privadas | **2a** | 27-28 |
| E4-17 | `CargaInicial` siembra los roles `ADMIN` y `CLIENTE` y un usuario administrador con contraseña **cifrada** | 2b | 27-28 |
| E4-08 | **Eliminar `js/login.js`** y todo rastro de credenciales en el cliente | 2b | 27-28 |

**Separación de rutas exigida por el criterio 2a:**

```java
.requestMatchers("/", "/catalogo", "/producto/**", "/promociones",
                 "/nosotros", "/contacto", "/css/**", "/js/**", "/img/**").permitAll()
.requestMatchers("/admin/**").hasRole("ADMIN")
.requestMatchers("/mi-cuenta/**").hasRole("CLIENTE")
.anyRequest().authenticated()
```

### Duo UI / Front — Joaquín · Carlos

| # | Historia | Criterio | Sesión |
|---|---|:-:|:-:|
| E4-05 | Conectar el `login.html` existente a `formLogin` con `loginPage("/login")` | **2c** | 27-28 |
| E4-18 | Mostrar el mensaje de error de credenciales inválidas en el formulario | 2c | 27-28 |
| E4-06 | Botón de cerrar sesión conectado a `logout`, con CSRF | **2d** | 27-28 |
| E4-07 | `sec:authorize` en el fragment de cabecera: el menú de administración solo se ve con rol ADMIN | 2a | 27-28 |
| E4-19 | Página **403** con el diseño del sitio | 2a | 27-28 |
| E4-20 | Mostrar el nombre de la persona autenticada en la cabecera | 2c | 27-28 |

> Requiere `thymeleaf-extras-springsecurity6` para usar `sec:authorize`.

### Duo Documento / QA — José · Jhade

| # | Historia | Criterio |
|---|---|:-:|
| E4-21 | Redactar **2.1.2.1 Tecnologías usadas** del informe | 5 |
| E4-22 | Empezar **2.1.2.2 Descripción técnica** con los diagramas UML (clases y casos de uso) | 5 |
| E4-23 | Actualizar el diagrama físico con `usuario` y `rol` | 5 |
| E4-24 | Capturas: inicio de sesión, error de credenciales, 403, panel con sesión iniciada | 5 |
| E4-25 | Regresión ATF1, ATF2 y ATF3 completa | todos |

## 6. Prueba de aceptación del sprint

En la review, en vivo:

1. Entrar a `/admin/productos` **sin sesión** → redirige al formulario de inicio de sesión *(2a)*
2. Iniciar sesión con credenciales incorrectas → mensaje de error, sin acceso *(2c)*
3. Iniciar sesión como ADMIN → entra al panel; la cabecera muestra el menú de administración *(2a, 2c)*
4. Pulsar cerrar sesión → vuelve al inicio y `/admin` queda inaccesible otra vez *(2d)*
5. Iniciar sesión como CLIENTE e ir a `/admin` → **403** *(2a)*
6. En MySQL: `SELECT password FROM usuario` → empieza por `$2a$` *(2b)*
7. Las páginas públicas siguen abiertas sin sesión *(2a)*

## 7. Orden de trabajo

```
Día 1-3   E4-01/E4-02/E4-16 dependencia, entidades y cifrado
Día 4-6   E4-03/E4-04 UserDetailsService y SecurityConfig
Día 7-8   E4-05/E4-06/E4-07 formulario, cierre de sesión y menú por rol
Día 9-10  Prueba de aceptación, regresión, informe
```

## 8. Definición de Hecho

- [ ] `mvn clean package` sin errores
- [ ] Las páginas públicas siguen accesibles **sin** sesión
- [ ] Las privadas redirigen al inicio de sesión
- [ ] `usuario.password` en MySQL empieza por `$2a$`
- [ ] El botón de cerrar sesión funciona
- [ ] Sin errores en consola
- [ ] Captura en `informes/capturas/sprint-06/`
- [ ] Bloque "Para consolidar" escrito

## 9. Riesgos

| Riesgo | Mitigación |
|---|---|
| **CSRF rompe todos los formularios existentes** — es el fallo clásico al activar Security | Los formularios de Thymeleaf con `th:action` incluyen el token solo si usan `th:action`. E4-25 revisa cada formulario: contacto, compra, alta y edición de producto. |
| Se bloquean CSS, JS e imágenes y el sitio se ve roto | `permitAll()` explícito para `/css/**`, `/js/**`, `/img/**` en E4-04 |
| Queda una contraseña sin cifrar en los datos semilla | Constitución art. 6. E4-17 usa siempre el encoder. |
| Se olvida borrar `js/login.js` y quedan credenciales visibles en el código entregado | E4-08 con tarea propia |
| El menú de administración se ve para todos | E4-07 con `sec:authorize` |

## 10. Ceremonias

| Ceremonia | Cuándo |
|---|---|
| Planning | lun 02-nov |
| Daily asíncrono | cada día, en la memoria personal |
| Review | vie 13-nov |
| Retro + consolidación | vie 13-nov, tras la review |

**Puerta de consolidación:** ⬜ Joaquín · ⬜ José · ⬜ Jonathan · ⬜ Dayro · ⬜ Carlos · ⬜ Jhade

---

## Sprint Review — 13-nov

*(por completar)*

| Criterio | Estado | Evidencia |
|---|---|---|
| TF-2a config con públicas y privadas | | |
| TF-2b usuarios y contraseñas cifradas | | |
| TF-2c formulario de inicio personalizado | | |
| TF-2d botón de cierre personalizado | | |

## Retrospectiva — 13-nov

*(por completar)*

**Qué funcionó**

**Qué no**

**Qué cambiamos para el Sprint 7**
