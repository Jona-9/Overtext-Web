package pe.edu.utp.overtext.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoController {

    private static final Logger log = LoggerFactory.getLogger(ContactoController.class);

    @GetMapping("/contacto")
    public String contacto() {
        return "paginas/contacto";
    }

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
