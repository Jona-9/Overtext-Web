package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.model.Producto;

public interface ProductoService {

    List<Producto> listarTodos();

    Optional<Producto> buscarPorId(String id);
}
