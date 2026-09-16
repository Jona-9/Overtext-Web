package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PromocionesController — E2-06 · criterio 1a.
 *
 * <p>Sirve el configurador de packs en la ruta limpia {@code GET /promociones}.
 * Thymeleaf resuelve la vista {@code templates/paginas/promociones.html}.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class PromocionesController {

    /**
     * Página de promociones y configurador de packs.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/promociones})
     */
    @GetMapping("/promociones")
    public String promociones() {
        return "paginas/promociones";
    }
}
