package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.repository.ProductoRepository;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> listarActivos() {
        return productoRepository.findByActivoTrue();
    }

    @Override
    public List<Producto> listarDisponiblesNativo() {
        return productoRepository.listarProductosDisponiblesNativo();
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }
}
