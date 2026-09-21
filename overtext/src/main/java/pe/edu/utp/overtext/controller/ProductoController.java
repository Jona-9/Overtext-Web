package pe.edu.utp.overtext.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import pe.edu.utp.overtext.service.ProductoService;

/**
 * ProductoController — E2-06 · criterio 1a. Extendido en E2-09 · criterio 2c.
 *
 * <p>Sirve la ficha de detalle de un producto en la ruta limpia
 * {@code GET /producto/{id}}. Thymeleaf resuelve la vista
 * {@code templates/paginas/detalle-producto.html}.
 *
 * <p>Si el {@code id} no existe en el catálogo, responde <b>404</b> en vez
 * de dejar que el cliente muestre el primer producto — cierra la deuda
 * <b>D17</b> (`memory.md` §6): antes, {@code tienda.js:57} caía a
 * {@code productos[0]} cuando no encontraba el id. Con el filtro en el
 * servidor, esa ruta silenciosa deja de ser alcanzable (E2-09, `sprint-03.md`).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Ficha de detalle de un producto.
     *
     * @param id identificador del producto (ej. {@code "short-negro"})
     * @param modelo modelo de la vista, recibe {@code idProducto} y {@code producto}
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/detalle-producto})
     * @throws ResponseStatusException 404 si el id no está en el catálogo
     */
    @GetMapping("/producto/{id}")
    public String detalle(@PathVariable String id, Model modelo) {
        var producto = productoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe el producto: " + id));
        modelo.addAttribute("idProducto", id);
        modelo.addAttribute("producto", producto);
        return "paginas/detalle-producto";
    }
}
