package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CatalogoController — E2-06 · criterio 1a.
 *
 * <p>Sirve el listado de productos en la ruta limpia {@code GET /catalogo}.
 * Thymeleaf resuelve la vista {@code templates/paginas/catalogo.html}.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class CatalogoController {

    /**
     * Listado del catálogo de productos.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/catalogo})
     */
    @GetMapping("/catalogo")
    public String catalogo() {
        return "paginas/catalogo";
    }
}
