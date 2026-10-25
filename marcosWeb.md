# Guía de Sustentación: Backend Monolito con Spring Boot y Thymeleaf — OverText

**Curso:** Marcos de Desarrollo Web — Sección 38189  
**Ciclo:** UTP 2026-2 · Grupo 01  
**Proyecto:** OverText (E-commerce de Streetwear Peruano)  
**Entrega:** ATF2 (Avance de Trabajo Final 2 — Backend Monolítico Spring Boot + Thymeleaf)  
**Integrantes:** Joaquín · Dayro · Jonathan · Jhade · José · Carlos  

---

## 1. Tabla de Distribución y Orden de Exposición

| Orden | Integrante | Rol en la Sustentación | Eje Temático Principal | Archivos de Código a Proyectar | Demostración en Vivo |
|:---:|---|---|---|---|---|
| **1** | **Joaquín** | Apertura + Arquitecto Backend | Arquitectura Monolítica, Maven y Arranque Spring Boot | `pom.xml`<br>`OvertextApplication.java`<br>`application.properties` | Ejecutar `mvn spring-boot:run` y verificar arranque en puerto 8080. |
| **2** | **Dayro** | Backend & Capa de Datos | Modelo de Dominio (Java Records) y Capa de Servicio con IoC | `model/Producto.java`<br>`service/ProductoService.java`<br>`service/ProductoServiceImpl.java` | Inspeccionar inmutabilidad de Records y carga desacoplada desde JSON. |
| **3** | **Jonathan** | Backend & Enrutamiento | Controladores Spring MVC, Rutas Limpias y `Model` | `controller/HomeController.java`<br>`controller/CatalogoController.java`<br>`controller/ProductoController.java` | Navegar a `/`, `/catalogo` y `/producto/{id}` demostrando paso de datos. |
| **4** | **Jhade** | Backend & Control de Errores | Peticiones POST, Validaciones y Manejo de Errores (404/500) | `controller/ContactoController.java`<br>`templates/error/404.html`<br>`templates/error/500.html` | Enviar formulario de contacto y forzar una URL inválida para ver el 404 personalizado. |
| **5** | **José** | UI / Front & Plantillas | Arquitectura Thymeleaf: Sistema de Layout y Fragments | `templates/layout/plantilla.html`<br>`templates/paginas/nosotros.html`<br>`templates/paginas/index.html` | Demostrar reducción de código (~1,000 líneas) con `th:fragment` y `th:replace`. |
| **6** | **Carlos** | UI / Front & Lógica de Vista | Renderizado Dinámico (`th:each`, `th:if`), Menú Activo y Cierre | `templates/paginas/catalogo.html`<br>`templates/paginas/detalle-producto.html` | Inspeccionar DOM (F12) mostrando cómo Thymeleaf compila en HTML puro. |

---

## 2. Desarrollo Detallado por Integrante

```
              ┌─────────────────────────────────────────────────────────────┐
              │           FLUJO ARQUITECTÓNICO DE LA SUSTENTACIÓN           │
              └─────────────────────────────────────────────────────────────┘
  Joaquín                Dayro                  Jonathan                  Jhade
┌─────────┐           ┌─────────┐             ┌───────────┐            ┌─────────┐
│ Spring  │ ───────>  │ Service │ ─────────>  │Controller │ ─────────> │  POST & │
│  Boot   │           │& Records│             │  & Model  │            │ Errores │
└─────────┘           └─────────┘             └───────────┘            └─────────┘
                                                                            │
                                                                            ▼
                                                Carlos                    José
                                              ┌─────────┐              ┌─────────┐
                                              │ Dynamic │ <─────────── │ Layouts │
                                              │Rendering│              │&Fragments
                                              └─────────┘              └─────────┘
```

---

### Integrante 1: Joaquín (Apertura y Fundamentos de Arquitectura)

#### A. Discurso de Apertura (30 - 45 segundos)
> *"Buenos días profesor y compañeros. Somos el Grupo 01 y hoy presentaremos la evolución técnica de nuestra plataforma OverText. En esta entrega hemos migrado nuestra maqueta estática previa hacia un backend monolítico robusto desarrollado con Spring Boot 4 y Java 17, implementando Server-Side Rendering mediante el motor de plantillas Thymeleaf bajo el patrón arquitectónico Modelo-Vista-Controlador (MVC)."*

#### B. Puntos Teóricos a Explicar
1. **Justificación del Monolito Modular con SSR:** Explicar que para un e-commerce el renderizado del lado del servidor (SSR) mejora el SEO, acelera la carga inicial del DOM y reduce la complejidad de infraestructura en comparación con microservicios.
2. **Estructura y Dependencias en Maven (`pom.xml`):**
   - Uso de `spring-boot-starter-parent` (versión 4.0.8).
   - Inclusión de `spring-boot-starter-webmvc` para la arquitectura web.
   - Inclusión de `spring-boot-starter-thymeleaf` para el motor de plantillas.
   - Fijación estricta de Java 17 como runtime.
3. **Punto de Arranque (`OvertextApplication.java`):**
   - Significado de la anotación `@SpringBootApplication` (combina `@Configuration`, `@EnableAutoConfiguration` y `@ComponentScan`).
   - El método `main` y cómo levanta el contenedor embebido Apache Tomcat.
4. **Configuración Centralizada (`application.properties`):**
   - Puerto dinámico configurable: `server.port=${OVERTEXT_PORT:8080}`.
   - Desactivación de caché de Thymeleaf para entorno de desarrollo: `spring.thymeleaf.cache=false`.
   - Nivel de logging parametrizado para depuración.

#### C. Código a Proyectar
- `overtext/pom.xml`
- `overtext/src/main/java/pe/edu/utp/overtext/OvertextApplication.java`
- `overtext/src/main/resources/application.properties`

#### D. Demostración Práctica
1. Abrir la terminal integrada del IDE.
2. Ejecutar: `mvn spring-boot:run` (o iniciar desde el IDE).
3. Mostrar en la consola la salida del banner de Spring y la confirmación:
   `Tomcat started on port 8080 (http) with context path '/'`.

#### E. Preguntas Típicas del Docente
* **P: ¿Por qué desactivaron la caché de Thymeleaf en `application.properties`?**  
  *R:* Porque en desarrollo necesitamos que cualquier cambio en los archivos HTML se refleje de inmediato en el navegador sin tener que recompilar y reiniciar el servidor. En producción se coloca en `true` para maximizar el rendimiento.
* **P: ¿Qué ventaja tiene usar Maven Wrapper (`mvnw`)?**  
  *R:* Garantiza que los 6 integrantes del equipo y el servidor utilicen exactamente la misma versión de Maven sin necesidad de configuraciones globales en cada máquina.

#### F. Pase al siguiente expositor
> *"Con la base de Spring Boot y el servidor web en ejecución, mi compañero Dayro explicará la capa de datos, los modelos inmutables y la lógica de negocio del servicio."*

---

### Integrante 2: Dayro (Capa de Dominio y Servicios)

#### A. Puntos Teóricos a Explicar
1. **Modelado con Java Records (`Producto.java`):**
   - Explicar las ventajas del `record` introducido en Java 16/17 frente a las clases tradicionales: inmutabilidad por defecto, reducción masiva de código boilerplate (genera automáticamente constructor canónico, getters/accesores, `equals`, `hashCode` y `toString`).
   - Mostrar el anidamiento del sub-record `Color(String nombre, String hex)` para modelar las variantes visuales de cada prenda.
2. **Patrón Service y Principio de Inversión de Control (IoC):**
   - Interfaz `ProductoService`: definición limpia de contratos (`listarTodos()`, `buscarPorId(String id)`).
   - Implementación `ProductoServiceImpl` decorada con la anotación `@Service` para que Spring la gestione como un Bean dentro del contenedor de inyección.
3. **Inyección de Dependencias por Constructor:**
   - Mostrar cómo `ProductoServiceImpl` recibe el componente `ObjectMapper` de Jackson en su constructor.
4. **Estrategia de Carga y Desacoplamiento:**
   - Carga del catálogo desde el classpath (`static/js/productos.json`) mediante `ClassPathResource`.
   - Destacar que los controladores no saben ni les interesa de dónde vienen los datos (si de un JSON en memoria o de una base de datos MySQL); en el siguiente sprint solo se cambiará la implementación del servicio por JPA sin tocar los controladores.

#### B. Código a Proyectar
- `overtext/src/main/java/pe/edu/utp/overtext/model/Producto.java`
- `overtext/src/main/java/pe/edu/utp/overtext/service/ProductoService.java`
- `overtext/src/main/java/pe/edu/utp/overtext/service/ProductoServiceImpl.java`

#### C. Demostración Práctica
1. Mostrar el código de `Producto.java` y resaltar su concisión (menos de 20 líneas para un modelo completo con listas y sub-records).
2. Mostrar el método `buscarPorId(String id)` en `ProductoServiceImpl.java` y señalar el uso del API de Streams (`productos.stream().filter(...).findFirst()`) retornando un `Optional<Producto>`.

#### D. Preguntas Típicas del Docente
* **P: ¿Por qué el método `buscarPorId` retorna un `Optional<Producto>` en lugar de `Producto` directamente?**  
  *R:* Para evitar errores de tipo `NullPointerException`. El `Optional` obliga explícitamente a la capa consumidora (el controlador) a manejar el escenario donde el producto solicitado no existe.
* **P: ¿Por qué inyectar dependencias por constructor en lugar de usar `@Autowired` en el campo?**  
  *R:* Porque es la recomendación oficial de Spring: facilita la inmutabilidad de los campos (`final`), evita referencias nulas y permite realizar pruebas unitarias fácilmente sin necesidad de levantar el contexto de Spring.

#### E. Pase al siguiente expositor
> *"Teniendo estructurada nuestra lógica de negocio y datos, mi compañero Jonathan detallará cómo la capa de controladores atiende las solicitudes HTTP y envía la información hacia las vistas."*

---

### Integrante 3: Jonathan (Controladores Spring MVC, Enrutamiento y `Model`)

#### A. Puntos Teóricos a Explicar
1. **Patrón Modelo-Vista-Controlador en Spring Web:**
   - Diferencia fundamental entre `@Controller` y `@RestController`: `@Controller` resuelve plantillas HTML enviándolas al motor de vistas (Thymeleaf), mientras que `@RestController` serializa datos directamente en JSON/XML.
2. **Mapeo de Rutas Limpias y Navegación Principal:**
   - `HomeController`: ruta raíz `@GetMapping("/")` que devuelve `"paginas/index"`.
   - Controladores de secciones institucionales: `NosotrosController` (`/nosotros`), `PromocionesController` (`/promociones`) e `IntranetController` (`/admin`).
3. **Paso de Datos mediante el objeto `Model`:**
   - Explicar cómo `CatalogoController` inyecta el `ProductoService`, obtiene la lista de prendas y la registra con `modelo.addAttribute("productos", ...)`.
4. **Enrutamiento Dinámico con Parámetros de Ruta (`@PathVariable`):**
   - Mostrar `ProductoController` con el endpoint `@GetMapping("/producto/{id}")`.
   - Explicar la captura de variables en la URL y cómo se busca el ítem con el servicio. Si no se encuentra, se arroja una excepción HTTP controlada (`ResponseStatusException(HttpStatus.NOT_FOUND)`).

#### B. Código a Proyectar
- `overtext/src/main/java/pe/edu/utp/overtext/controller/HomeController.java`
- `overtext/src/main/java/pe/edu/utp/overtext/controller/CatalogoController.java`
- `overtext/src/main/java/pe/edu/utp/overtext/controller/ProductoController.java`

#### C. Demostración Práctica
1. Abrir el navegador en `http://localhost:8080/` demostrando que carga la portada por defecto sin necesidad de ingresar `.html` ni rutas adicionales.
2. Dirigirse a `http://localhost:8080/catalogo` para evidenciar que el controlador entregó el catálogo completo al modelo.
3. Hacer clic en una prenda específica y mostrar la barra de direcciones: `http://localhost:8080/producto/negro`, explicando cómo `@PathVariable` procesó el identificador.

#### D. Preguntas Típicas del Docente
* **P: ¿Qué función cumple el String retornado por los métodos anotados con `@GetMapping`?**  
  *R:* Es el nombre lógico de la vista. Spring Web delega este nombre a Thymeleaf, el cual le antepone el prefijo `templates/` y le añade el sufijo `.html` para ubicar el archivo correspondiente en el disco.
* **P: ¿Cómo viaja la información desde `CatalogoController` hasta la página web?**  
  *R:* A través del objeto `org.springframework.ui.Model`. Al ejecutar `modelo.addAttribute("productos", lista)`, los objetos quedan disponibles como variables de contexto evaluables por Thymeleaf en el servidor.

#### E. Pase al siguiente expositor
> *"Además de despachar información, el backend debe recibir envíos de datos y garantizar la estabilidad ante errores, aspecto que explicará mi compañera Jhade."*

---

### Integrante 4: Jhade (Peticiones POST, Validaciones y Manejo de Errores)

#### A. Puntos Teóricos a Explicar
1. **Recepción y Procesamiento de Formularios (`@PostMapping`):**
   - Explicar `ContactoController.java` y su método `procesarContacto(...)` con anotación `@PostMapping("/contacto")`.
   - Uso de la anotación `@RequestParam` para mapear los campos del formulario enviados por el cliente (`contacto-nombre`, `contacto-correo`, `contacto-asunto`, `contacto-mensaje`).
2. **Validación del Lado del Servidor:**
   - Explicar por qué la validación en el cliente (HTML5/JS) no es suficiente y debe reforzarse en el backend.
   - Demostrar el uso de `.isBlank()` y la respuesta con códigos de estado HTTP mediante `ResponseEntity`: retorno de `400 Bad Request` si algún dato falta o `200 OK` si el procesamiento es correcto.
3. **Flujo de Compra y Autenticación:**
   - Mención de `CheckoutController` (`/checkout`, `/confirmacion`) y `LoginController` (`/login`).
4. **Gestión de Errores HTTP Personalizada en Spring Boot:**
   - Explicar la convención estándar de Spring Boot: cualquier plantilla ubicada dentro de `templates/error/` cuyo nombre coincida con el código HTTP (como `404.html` o `500.html`) se activa automáticamente.
   - Evitar la pantalla genérica de Spring (*WhiteLabel Error Page*), manteniendo el look & feel, la marca OverText y enlaces de recuperación.

#### B. Código a Proyectar
- `overtext/src/main/java/pe/edu/utp/overtext/controller/ContactoController.java`
- `overtext/src/main/resources/templates/error/404.html`
- `overtext/src/main/resources/templates/error/500.html`

#### C. Demostración Práctica
1. En el navegador, ingresar intencionalmente una ruta inexistente: `http://localhost:8080/pagina-que-no-existe` o `http://localhost:8080/producto/id-invalido`.
2. Mostrar la pantalla de Error 404 personalizada con el título *"ESTA PÁGINA NO EXISTE"* y hacer clic en el botón *"VOLVER AL INICIO"*.
3. Mostrar brevemente el código del formulario en `ContactoController.java` y la verificación de campos requeridos.

#### D. Preguntas Típicas del Docente
* **P: ¿Por qué no fue necesario configurar un `@ExceptionHandler` explícito para que funcione el 404?**  
  *R:* Porque Spring Boot cuenta con un controlador de errores por defecto (`BasicErrorController`) que mapea automáticamente los códigos de error HTTP a los archivos encontrados en la carpeta `templates/error/{codigo}.html`.
* **P: ¿Qué sucede si el usuario intenta enviar el formulario de contacto con datos vacíos burlando el JavaScript?**  
  *R:* El backend intercepta la petición en `ContactoController`, detecta campos en blanco con `nombre.isBlank()`, rechaza el procesamiento y devuelve un código de estado `400 Bad Request`.

#### E. Pase al siguiente expositor
> *"Habiendo revisado los controladores y el manejo de peticiones, mi compañero José mostrará la arquitectura de plantillas con Thymeleaf y cómo organizamos nuestros fragmentos reutilizables."*

---

### Integrante 5: José (Arquitectura Thymeleaf: Sistema de Layout y Fragments)

#### A. Puntos Teóricos a Explicar
1. **Filosofía de Thymeleaf y "Natural Templates":**
   - Explicar que Thymeleaf utiliza atributos HTML5 estándar con el prefijo `th:*`. Esto permite abrir las plantillas en un navegador como prototipos estáticos sin romper el diseño, a diferencia de motores como JSP.
2. **Eliminación de Redundancia (Principio DRY):**
   - En el ATF1 estático se repetían más de 1,000 líneas entre encabezados, pies de página y carritos.
   - Con Thymeleaf se centralizaron estos elementos en un único archivo maestro: `layout/plantilla.html`.
3. **Definición de Fragmentos (`th:fragment`):**
   - `cabecera(paginaActiva, mostrarCarrito)`: fragmento parametrizado que recibe variables para saber qué enlace pintar como activo y si debe mostrar el botón del carrito.
   - `carrito`: offcanvas lateral de compras.
   - `pie`: footer corporativo con enlaces legales, redes sociales y contacto.
   - `modales`: ventanas modales para login y contacto.
   - `scripts`: bundle centralizado de librerías JavaScript (Bootstrap 5.3, scripts propios).
4. **Consumo de Fragmentos (`th:replace`):**
   - Sintaxis `th:replace="~{layout/plantilla :: cabecera(...)}"`.
   - Explicar cómo las páginas individuales sustituyen sus etiquetas contenedor por el código procesado en el servidor.

#### B. Código a Proyectar
- `overtext/src/main/resources/templates/layout/plantilla.html`
- `overtext/src/main/resources/templates/paginas/nosotros.html`
- `overtext/src/main/resources/templates/paginas/index.html`

#### C. Demostración Práctica
1. Abrir `layout/plantilla.html` y mostrar la definición del fragmento `cabecera` con sus parámetros:
   ```html
   <nav th:fragment="cabecera(paginaActiva, mostrarCarrito)" class="navbar ...">
   ```
2. Abrir `paginas/nosotros.html` y señalar que tiene menos de 50 líneas: invoca a la cabecera, pie, modales y scripts con `th:replace`, dejando únicamente el contenido central.
3. Mostrar en el navegador cómo la página `/nosotros` luce completa con navegación, estilos y pie de página.

#### D. Preguntas Típicas del Docente
* **P: ¿Cuál es la diferencia entre `th:replace`, `th:insert` y `th:include`?**  
  *R:* `th:replace` reemplaza por completo la etiqueta contenedora por el contenido del fragmento; `th:insert` inserta el fragmento dentro de la etiqueta contenedora; y `th:include` (en desuso en Thymeleaf 3+) solo insertaba los hijos del fragmento. En OverText usamos `th:replace` para mantener un DOM limpio y sin tags anidados innecesarios.
* **P: ¿Cómo sabe la barra de navegación qué página está viendo el usuario?**  
  *R:* A través de los parámetros del fragmento. Al invocar `cabecera(paginaActiva='nosotros', ...)`, la plantilla recibe ese valor y activa la clase visual correspondiente.

#### E. Pase al siguiente expositor
> *"Para concluir la presentación, mi compañero Carlos explicará el renderizado dinámico de datos mediante directivas de iteración, condicionales y enlaces en Thymeleaf."*

---

### Integrante 6: Carlos (Renderizado Dinámico en Vistas, Condicionales y Cierre)

#### A. Puntos Teóricos a Explicar
1. **Sintaxis de Expresiones Estándar de Thymeleaf:**
   - Expresiones de variables `${...}` para leer atributos del modelo.
   - Expresiones de URL `@{...}`: cruciales para resolver rutas relativas y absolutas respecto al contexto de la aplicación, evitando enlaces rotos tanto en hipervínculos como en hojas de estilo o imágenes.
   - Expresiones de texto inlined `[[...]]`: interpolación directa de valores en el texto.
2. **Iteración de Colecciones con `th:each`:**
   - Mostrar la grilla dinámica de productos en `catalogo.html`:
     ```html
     <div class="col-12 col-sm-6 col-lg-4 col-xl-3" th:each="producto : ${productos}">
     ```
   - Explicar cómo por cada objeto `Producto` en la lista, Thymeleaf crea una tarjeta completa con su imagen, precio, descripción y tallas.
3. **Lógica Condicional con `th:if` y `th:unless`:**
   - `th:if="${!#strings.isEmpty(producto.badge)}"`: renderiza la etiqueta de oferta solo si el producto posee una insignia configurada.
   - `th:if="${#lists.isEmpty(productos)}"`: muestra un mensaje amigable indicando que no hay productos disponibles en caso de lista vacía.
4. **Manipulación Dinámica de Atributos del DOM:**
   - Menú de navegación activo: `th:classappend="${paginaActiva == 'catalogo'} ? 'active'"`.
   - Muestras de color con estilos en línea: `th:style="'background:' + ${producto.color.hex}"`.
   - Atributos `data-*` (`th:data-id`, `th:data-precio`): puente entre los datos del backend y la funcionalidad del carrito de compras en JavaScript.

#### B. Código a Proyectar
- `overtext/src/main/resources/templates/paginas/catalogo.html`
- `overtext/src/main/resources/templates/paginas/detalle-producto.html`

#### C. Demostración Práctica
1. Abrir la página del catálogo en el navegador: `http://localhost:8080/catalogo`.
2. Presionar `F12` y abrir el inspector de elementos sobre una tarjeta de producto.
3. Demostrar que en el código fuente del navegador **no aparece ningún atributo `th:*`**, sino HTML puro generado dinámicamente en el servidor:
   - Los enlaces `th:href` se convirtieron en `href="/producto/negro"`.
   - Los precios dinámicos están compilados directamente en el texto.
   - El enlace "CATÁLOGO" del menú tiene la clase CSS `active`.

#### D. Preguntas Típicas del Docente
* **P: ¿Por qué es fundamental usar `th:href="@{/catalogo}"` en lugar de un `href="/catalogo"` convencional?**  
  *R:* Porque la sintaxis de arroba `@` maneja automáticamente el contexto de la aplicación web (*context path*). Si la aplicación se despliega en una subcarpeta o servidor proxy (por ejemplo `/tienda`), `@{...}` ajustará los enlaces automáticamente sin romper la navegación.
* **P: ¿Thymeleaf compromete la seguridad frente a ataques XSS?**  
  *R:* No, al contrario: por defecto, `th:text` y las expresiones entre corchetes escapan todos los caracteres especiales HTML (`<`, `>`, `&`, etc.), previniendo ataques de inyección de código (*Cross-Site Scripting*).

#### E. Discurso de Cierre de la Sustentación (30 segundos)
> *"En conclusión, hemos transformado con éxito una maqueta estática en un backend monolítico en Spring Boot completamente operativo, modular y escalable. Logramos implementar el patrón MVC, encapsular los datos con Java Records y Servicios, centralizar el layout con fragmentos de Thymeleaf y compilar vistas dinámicas sin duplicar código. Con esta base sólida, el proyecto queda totalmente listo para la siguiente fase de persistencia con MySQL y seguridad con Spring Security. Muchas gracias, quedamos atentos a sus preguntas."*

---

## 3. Matriz de Cumplimiento de la Rúbrica UTP (ATF2)

Esta tabla resume cómo la división garantiza la cobertura del 100% de los puntos de la rúbrica de evaluación:

| Criterio de Rúbrica | Puntaje | Exigencia de la Rúbrica | Expositor Responsable | Evidencia Técnica en el Proyecto |
|---|:---:|---|---|---|
| **1. Navegación y Rutas** | **6 pts** | • Rutas limpias en 5+ páginas<br>• Página de inicio por defecto (`/`)<br>• Página 404 personalizada<br>• Menú de navegación funcional | **Joaquín**<br>**Jonathan**<br>**Jhade** | `HomeController` en `/`, 10 controladores de sección, `templates/error/404.html`, menú con enlaces `@Controller`. |
| **2. Thymeleaf** | **6 pts** | • 2+ fragments en todas las páginas<br>• Condicionales de renderizado (`th:if`)<br>• Bloques repetitivos (`th:each`)<br>• Estilos y diseño responsivo | **José**<br>**Carlos** | `plantilla.html` con 5 fragments (`cabecera`, `carrito`, `pie`, `modales`, `scripts`), `th:each` en catálogo, `th:if` en badges y stock. |
| **3. Informe Técnico** | **4 pts** | Problemática, objetivos, arquitectura MVC, diagramas y capturas | **Jonathan**<br>**Jhade** | Documentación del informe técnico en Markdown con estructura UTP. |
| **4. Nomenclatura y Empaque** | **4 pts** | Entregables según formato oficial (`ATF2_GRUPO_01.rar` sin carpeta `target/`) | **Equipo** | Limpieza de build con `mvn clean` y verificación de empaque. |

---

## 4. Recomendaciones Finales para el Día de la Sustentación

1. **Entorno listo antes de conectar la videollamada / proyector:**
   - Tener el proyecto abierto en el IDE favorito (IntelliJ IDEA o VS Code).
   - Tener el servidor ya probado con `mvn spring-boot:run` corriendo en segundo plano.
   - Pestañas del navegador abiertas listas en:
     - `http://localhost:8080/` (Portada)
     - `http://localhost:8080/catalogo` (Catálogo con `th:each`)
     - `http://localhost:8080/producto/negro` (Detalle dinámico)
     - `http://localhost:8080/404-test` (Página de error)
2. **Fluidez en los relevos:** Cada expositor debe terminar dando el pase exacto al compañero por su nombre. Esto demuestra coordinación y trabajo en equipo.
3. **Muestra dual (Código + Pantalla):** Siempre explicar primero 20 segundos el fragmento de código fuente en el IDE y de inmediato conmutar a la pantalla del navegador para que el docente vea el resultado visual renderizado.
