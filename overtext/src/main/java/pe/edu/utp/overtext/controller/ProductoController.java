package pe.edu.utp.overtext.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import pe.edu.utp.overtext.service.ProductoService;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

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
