package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ContactoController — E2-06 · criterio 1a.
 *
 * <p>Sirve el formulario de contacto en la ruta limpia {@code GET /contacto}.
 * Thymeleaf resuelve la vista {@code templates/paginas/contacto.html}.
 *
 * <p>El {@code @PostMapping} de procesamiento del formulario se implementa
 * en el Sprint 3 — tarea E2-20.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class ContactoController {

    /**
     * Formulario de contacto.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/contacto})
     */
    @GetMapping("/contacto")
    public String contacto() {
        return "paginas/contacto";
    }
}
