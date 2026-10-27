package pe.edu.utp.overtext.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import pe.edu.utp.overtext.dto.ProductoRequestDTO;
import pe.edu.utp.overtext.dto.ProductoResponseDTO;
import pe.edu.utp.overtext.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@Validated
public class ProductoRestController {

    private final ProductoService productoService;

    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(productoService.listarActivos());
    }

    @GetMapping("/nativos")
    public ResponseEntity<List<ProductoResponseDTO>> listarNativos() {
        return ResponseEntity.ok(productoService.listarDisponiblesNativo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable @Positive(message = "El ID debe ser positivo") Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(@Valid @RequestBody ProductoRequestDTO dto) {
        ProductoResponseDTO creado = productoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(
            @PathVariable @Positive(message = "El ID debe ser positivo") Long id,
            @Valid @RequestBody ProductoRequestDTO dto) {
        ProductoResponseDTO actualizado = productoService.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable @Positive(message = "El ID debe ser positivo") Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
