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
- `HomeController` + `templates/index.html` son un placeholder mínimo para probar que el proyecto levanta (E2-01). José/Carlos lo reemplazan con la plantilla y los fragments reales (E2-02/E2-03/E2-04).
