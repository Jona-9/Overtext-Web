package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * NosotrosController — E2-06 · criterio 1a.
 *
 * <p>Sirve la página institucional en la ruta limpia {@code GET /nosotros}.
 * Thymeleaf resuelve la vista {@code templates/paginas/nosotros.html}.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class NosotrosController {

    /**
     * Página institucional «Nosotros».
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/nosotros})
     */
    @GetMapping("/nosotros")
    public String nosotros() {
        return "paginas/nosotros";
    }
}
