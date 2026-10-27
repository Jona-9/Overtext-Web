package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.dto.ProductoRequestDTO;
import pe.edu.utp.overtext.dto.ProductoResponseDTO;

public interface ProductoService {

    List<ProductoResponseDTO> listarTodos();

    List<ProductoResponseDTO> listarActivos();

    List<ProductoResponseDTO> listarDisponiblesNativo();

    Optional<ProductoResponseDTO> buscarPorId(Long id);

    ProductoResponseDTO crear(ProductoRequestDTO dto);

    ProductoResponseDTO actualizar(Long id, ProductoRequestDTO dto);

    void eliminar(Long id);
}
