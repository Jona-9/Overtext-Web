# overtext — proyecto Spring Boot

Backend del Sprint 2 (ATF2). Ver `docs/scrum/sprints/sprint-02.md` en la raíz del repo.

## Requisitos

- Java 17+ (probado con Java 21)
- No hace falta Maven instalado: el proyecto trae `./mvnw`

## Arrancar

```bash
cd overtext
./mvnw spring-boot:run
```

Levanta en `http://localhost:8080`. Si ese puerto ya está ocupado en tu máquina:

```bash
OVERTEXT_PORT=8081 ./mvnw spring-boot:run
```

## Compilar

```bash
./mvnw clean package
```

## Variables de entorno (E2-13)

Todas tienen valor por defecto: el proyecto arranca sin configurar nada.

| Variable | Por defecto | Para qué sirve |
|---|---|---|
| `OVERTEXT_PORT` | `8080` | Puerto donde escucha la app |
| `OVERTEXT_THYMELEAF_CACHE` | `false` | Caché de plantillas Thymeleaf (en `false` los cambios en `.html` se ven sin reiniciar) |
| `OVERTEXT_LOG_LEVEL` | `INFO` | Nivel de log del paquete `pe.edu.utp.overtext` |

No se versionan credenciales en `application.properties` (constitución art. 6). Cuando
llegue MySQL (Sprint 4, E3-19) sus credenciales entrarán también por variable de
entorno, nunca escritas en el repo.

## Notas

- Spring Boot **4.0.8** (decisión del 14-sep: start.spring.io ya no ofrece la línea 3.x que pedía originalmente `sprint-2.md`).
- Paquete base: `pe.edu.utp.overtext`. Controllers en `pe.edu.utp.overtext.controller` (constitución art. 5).
- `HomeController` sirve `templates/paginas/index.html`, la portada real del ATF1 (E2-02). CSS, JS e imágenes viven en `static/` con las mismas rutas absolutas (`/css/...`, `/js/...`, `/assets/...`) que ya usaban las 10 páginas, así que no hubo que tocarlas. La plantilla base y los fragments (`layout/plantilla.html`) son de Carlos, E2-03/E2-04.
