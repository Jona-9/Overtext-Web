package pe.edu.utp.overtext.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Positive;
import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@Validated
public class ProductoRestController {

    private final ProductoService productoService;

    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * GET /api/productos
     * Retorna la lista de productos activos utilizando Select JPA.
     */
    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        return ResponseEntity.ok(productoService.listarActivos());
    }

    /**
     * GET /api/productos/nativos
     * Retorna productos con stock > 0 y activos utilizando Select SQL Nativo.
     */
    @GetMapping("/nativos")
    public ResponseEntity<List<Producto>> listarNativos() {
        return ResponseEntity.ok(productoService.listarDisponiblesNativo());
    }

    /**
     * GET /api/productos/{id}
     * Búsqueda por ID con validación @Positive.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable @Positive(message = "El ID debe ser positivo") Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
