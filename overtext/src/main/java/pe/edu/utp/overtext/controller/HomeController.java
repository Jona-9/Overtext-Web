package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController — E2-05 · criterio 1b.
 *
 * <p>Sirve la página de inicio como ruta por defecto ({@code GET /}).
 * Thymeleaf resuelve la vista {@code templates/paginas/index.html}.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class HomeController {

    /**
     * Página de inicio — ruta raíz del sitio.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/index})
     */
    @GetMapping("/")
    public String inicio() {
        return "paginas/index";
    }
}

