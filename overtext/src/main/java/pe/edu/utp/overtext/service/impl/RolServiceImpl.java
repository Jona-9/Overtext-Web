package pe.edu.utp.overtext.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.overtext.dto.RolDTO;
import pe.edu.utp.overtext.entity.Rol;
import pe.edu.utp.overtext.repository.RolRepository;
import pe.edu.utp.overtext.service.RolService;

@Service
@Transactional(readOnly = true)
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    private RolDTO toDTO(Rol rol) {
        if (rol == null) {
            return null;
        }
        return new RolDTO(rol.getId(), rol.getNombre(), rol.getDescripcion());
    }

    @Override
    public List<RolDTO> listarTodos() {
        return rolRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Optional<RolDTO> buscarPorId(Long id) {
        return rolRepository.findById(id).map(this::toDTO);
    }
}
