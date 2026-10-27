package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.dto.UsuarioRequestDTO;
import pe.edu.utp.overtext.dto.UsuarioResponseDTO;

public interface UsuarioService {

    List<UsuarioResponseDTO> listarActivos();

    Optional<UsuarioResponseDTO> buscarPorId(Long id);

    UsuarioResponseDTO registrar(UsuarioRequestDTO dto);

    void darDeBaja(Long id);
}
