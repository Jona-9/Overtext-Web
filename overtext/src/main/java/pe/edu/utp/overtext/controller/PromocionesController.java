package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.utp.overtext.service.ProductoService;

/**
 * PromocionesController — E2-06 · criterio 1a. Extendido en E2-22 · criterio 2c.
 *
 * <p>Sirve el configurador de packs en la ruta limpia {@code GET /promociones}.
 * Thymeleaf resuelve la vista {@code templates/paginas/promociones.html}.
 *
 * <p>Expone {@code productos} desde {@link ProductoService} — cada producto es de
 * un solo color, y son exactamente los 7 colores del configurador (spec 003 §5.3):
 * reutilizar esta lista evita duplicar el hex en {@code promociones.css} (art. 7).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class PromocionesController {

    private final ProductoService productoService;

    public PromocionesController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Página de promociones y configurador de packs.
     *
     * @param modelo modelo de la vista, recibe {@code productos}
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/promociones})
     */
    @GetMapping("/promociones")
    public String promociones(Model modelo) {
        modelo.addAttribute("productos", productoService.listarTodos());
        return "paginas/promociones";
    }
}
