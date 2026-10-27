package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.dto.RolDTO;

public interface RolService {

    List<RolDTO> listarTodos();

    Optional<RolDTO> buscarPorId(Long id);
}
