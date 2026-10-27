package pe.edu.utp.overtext.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.overtext.dto.UsuarioRequestDTO;
import pe.edu.utp.overtext.dto.UsuarioResponseDTO;
import pe.edu.utp.overtext.entity.Rol;
import pe.edu.utp.overtext.entity.Usuario;
import pe.edu.utp.overtext.exception.ResourceNotFoundException;
import pe.edu.utp.overtext.repository.RolRepository;
import pe.edu.utp.overtext.repository.UsuarioRepository;
import pe.edu.utp.overtext.service.UsuarioService;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    private UsuarioResponseDTO toResponseDTO(Usuario u) {
        if (u == null) {
            return null;
        }
        String rolNombre = u.getRol() != null ? u.getRol().getNombre() : null;
        return new UsuarioResponseDTO(
                u.getId(),
                u.getEmail(),
                u.getNombre(),
                u.getActivo(),
                rolNombre
        );
    }

    @Override
    public List<UsuarioResponseDTO> listarActivos() {
        return usuarioRepository.findByActivoTrue().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public Optional<UsuarioResponseDTO> buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO registrar(UsuarioRequestDTO dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado: " + dto.getEmail());
        }

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con ID: " + dto.getRolId()));

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setNombre(dto.getNombre());
        usuario.setActivo(true);
        usuario.setRol(rol);

        Usuario guardado = usuarioRepository.save(usuario);
        return toResponseDTO(guardado);
    }

    @Override
    @Transactional
    public void darDeBaja(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
}
