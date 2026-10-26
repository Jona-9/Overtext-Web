package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.entity.Producto;

public interface ProductoService {

    List<Producto> listarTodos();

    List<Producto> listarActivos();

    List<Producto> listarDisponiblesNativo();

    Optional<Producto> buscarPorId(Long id);
}
