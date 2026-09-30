package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.utp.overtext.service.ProductoService;

@Controller
public class CatalogoController {

    private final ProductoService productoService;

    public CatalogoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model modelo) {
        modelo.addAttribute("productos", productoService.listarTodos());
        return "paginas/catalogo";
    }
}
