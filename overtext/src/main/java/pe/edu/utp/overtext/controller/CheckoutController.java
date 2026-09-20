package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * CheckoutController — E2-06 · criterio 1a.
 *
 * <p>Sirve el flujo de compra de 3 pasos:
 * <ul>
 *   <li>{@code GET /checkout} — formulario de pedido</li>
 *   <li>{@code GET /confirmacion} — página de confirmación post-pago</li>
 * </ul>
 * Las vistas Thymeleaf están en {@code templates/paginas/}.
 *
 * <p>Alcance congelado (constitución art. 8): el checkout de 3 pasos,
 * el ubigeo y la lógica de carrito permanecen en JS; el Sprint 7
 * (E4-10) migrará el pedido a persistencia MySQL.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class CheckoutController {

    /**
     * Formulario de checkout (3 pasos).
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/checkout})
     */
    @GetMapping("/checkout")
    public String checkout() {
        return "paginas/checkout";
    }

    /**
     * Página de confirmación de pedido.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/confirmacion})
     */
    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "paginas/confirmacion";
    }
}
