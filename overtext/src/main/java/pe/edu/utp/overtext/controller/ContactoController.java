package pe.edu.utp.overtext.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ContactoController — E2-06 · criterio 1a, E2-20 · spec 004.
 *
 * <p>Sirve el formulario de contacto en la ruta limpia {@code GET /contacto}.
 * Thymeleaf resuelve la vista {@code templates/paginas/contacto.html}.
 *
 * <p>El {@code POST} lo dispara {@code js/contacto.js} de forma asíncrona,
 * sin tocar la confirmación por modal que ya existe (E1-07/E1-08) — ver
 * spec 004, decisión C. No hay persistencia todavía: eso es Sprint 7 (E4-11).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class ContactoController {

    private static final Logger log = LoggerFactory.getLogger(ContactoController.class);

    /**
     * Formulario de contacto.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/contacto})
     */
    @GetMapping("/contacto")
    public String contacto() {
        return "paginas/contacto";
    }

    /**
     * Procesa el formulario de contacto (E2-20).
     *
     * @return 200 si los 4 campos vienen completos, 400 si alguno llega vacío
     *         (el navegador con JS nunca envía este caso: lo bloquea
     *         {@code was-validated} antes de llamar aquí)
     */
    @PostMapping("/contacto")
    public ResponseEntity<Void> procesarContacto(
            @RequestParam("contacto-nombre") String nombre,
            @RequestParam("contacto-correo") String correo,
            @RequestParam("contacto-asunto") String asunto,
            @RequestParam("contacto-mensaje") String mensaje) {
        if (nombre.isBlank() || correo.isBlank() || asunto.isBlank() || mensaje.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("Mensaje de contacto recibido de {} <{}> — asunto: {}", nombre, correo, asunto);
        return ResponseEntity.ok().build();
    }
}
