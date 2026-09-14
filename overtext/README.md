# overtext — proyecto Spring Boot

Backend del Sprint 2 (ATF2). Ver `docs/scrum/sprints/sprint-2.md` en la raíz del repo.

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
./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

## Compilar

```bash
./mvnw clean package
```

## Notas

- Spring Boot **4.0.8** (decisión del 14-sep: start.spring.io ya no ofrece la línea 3.x que pedía originalmente `sprint-2.md`).
- Paquete base: `pe.edu.utp.overtext`. Controllers en `pe.edu.utp.overtext.controller` (constitución art. 5).
- `HomeController` sirve `templates/paginas/index.html`, la portada real del ATF1 (E2-02). CSS, JS e imágenes viven en `static/` con las mismas rutas absolutas (`/css/...`, `/js/...`, `/assets/...`) que ya usaban las 10 páginas, así que no hubo que tocarlas. La plantilla base y los fragments (`layout/plantilla.html`) son de Carlos, E2-03/E2-04.
