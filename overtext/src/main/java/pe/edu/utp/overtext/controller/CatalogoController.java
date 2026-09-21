package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.utp.overtext.service.ProductoService;

/**
 * CatalogoController — E2-06 · criterio 1a. Extendido en E2-09 · criterio 2c.
 *
 * <p>Sirve el listado de productos en la ruta limpia {@code GET /catalogo}.
 * Thymeleaf resuelve la vista {@code templates/paginas/catalogo.html}.
 *
 * <p>Expone {@code productos} desde {@link ProductoService} para que la
 * vista pueda iterarlos con {@code th:each} (tarea E2-21, `sprint-03.md`). Hasta
 * que esa tarea se cierre, {@code tienda.js} sigue pintando el catálogo por
 * su cuenta desde el mismo {@code productos.json}; ambos caminos leen la
 * misma fuente, sin duplicar el dato (art. 7).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class CatalogoController {

    private final ProductoService productoService;

    public CatalogoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Listado del catálogo de productos.
     *
     * @param modelo modelo de la vista, recibe {@code productos}
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/catalogo})
     */
    @GetMapping("/catalogo")
    public String catalogo(Model modelo) {
        modelo.addAttribute("productos", productoService.listarTodos());
        return "paginas/catalogo";
    }
}
