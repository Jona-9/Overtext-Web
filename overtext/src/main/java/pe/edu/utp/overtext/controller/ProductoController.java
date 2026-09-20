package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProductoController — E2-06 · criterio 1a.
 *
 * <p>Sirve la ficha de detalle de un producto en la ruta limpia
 * {@code GET /producto/{id}}. Thymeleaf resuelve la vista
 * {@code templates/paginas/detalle-producto.html}.
 *
 * <p>El parámetro {@code id} es el identificador del producto (color/slug); se
 * expone a la vista como {@code idProducto} y de ahí a un atributo
 * {@code data-producto-id} que lee {@code tienda.js} (sin duplicar el dato
 * entre HTML y JS, art. 7). En el Sprint 3, {@code ProductoService} proveerá
 * los datos reales; por ahora el JS del cliente lee del array en memoria.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class ProductoController {

    /**
     * Ficha de detalle de un producto.
     *
     * @param id identificador del producto (ej. {@code "negro"}, {@code "beige"})
     * @param modelo modelo de la vista, recibe {@code idProducto}
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/detalle-producto})
     */
    @GetMapping("/producto/{id}")
    public String detalle(@PathVariable String id, Model modelo) {
        modelo.addAttribute("idProducto", id);
        return "paginas/detalle-producto";
    }
}
