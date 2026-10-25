package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.utp.overtext.service.ProductoService;

@Controller
public class PromocionesController {

    private final ProductoService productoService;

    public PromocionesController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/promociones")
    public String promociones(Model modelo) {
        modelo.addAttribute("productos", productoService.listarTodos());
        return "paginas/promociones";
    }
}
