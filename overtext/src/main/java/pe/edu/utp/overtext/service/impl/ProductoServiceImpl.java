package pe.edu.utp.overtext.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.utp.overtext.dto.ProductoRequestDTO;
import pe.edu.utp.overtext.dto.ProductoResponseDTO;
import pe.edu.utp.overtext.entity.Categoria;
import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.exception.ResourceNotFoundException;
import pe.edu.utp.overtext.repository.CategoriaRepository;
import pe.edu.utp.overtext.repository.ProductoRepository;
import pe.edu.utp.overtext.service.ProductoService;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    private ProductoResponseDTO toResponseDTO(Producto p) {
        if (p == null) {
            return null;
        }
        Long catId = p.getCategoria() != null ? p.getCategoria().getId() : null;
        String catNombre = p.getCategoria() != null ? p.getCategoria().getNombre() : null;

        return new ProductoResponseDTO(
                p.getId(),
                p.getCodigo(),
                p.getNombre(),
                p.getSlogan(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getPrecioPack(),
                p.getStock(),
                p.getImagenPrincipal(),
                p.getColorNombre(),
                p.getColorHex(),
                p.getCorreoProveedor(),
                p.getActivo(),
                catId,
                catNombre
        );
    }

    @Override
    public List<ProductoResponseDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public List<ProductoResponseDTO> listarActivos() {
        return productoRepository.findByActivoTrue().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public List<ProductoResponseDTO> listarDisponiblesNativo() {
        return productoRepository.listarProductosDisponiblesNativo().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public Optional<ProductoResponseDTO> buscarPorId(Long id) {
        return productoRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    @Transactional
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        if (productoRepository.findByCodigo(dto.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un producto con el código: " + dto.getCodigo());
        }

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        Producto producto = new Producto();
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setSlogan(dto.getSlogan());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setPrecioPack(dto.getPrecioPack());
        producto.setStock(dto.getStock());
        producto.setImagenPrincipal(dto.getImagenPrincipal());
        producto.setColorNombre(dto.getColorNombre());
        producto.setColorHex(dto.getColorHex());
        producto.setCorreoProveedor(dto.getCorreoProveedor());
        producto.setActivo(true);
        producto.setCategoria(categoria);

        Producto guardado = productoRepository.save(producto);
        return toResponseDTO(guardado);
    }

    @Override
    @Transactional
    public ProductoResponseDTO actualizar(Long id, ProductoRequestDTO dto) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        if (!existente.getCodigo().equalsIgnoreCase(dto.getCodigo())) {
            productoRepository.findByCodigo(dto.getCodigo()).ifPresent(otro -> {
                if (!otro.getId().equals(id)) {
                    throw new IllegalArgumentException("Ya existe otro producto con el código: " + dto.getCodigo());
                }
            });
        }

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        existente.setCodigo(dto.getCodigo());
        existente.setNombre(dto.getNombre());
        existente.setSlogan(dto.getSlogan());
        existente.setDescripcion(dto.getDescripcion());
        existente.setPrecio(dto.getPrecio());
        existente.setPrecioPack(dto.getPrecioPack());
        existente.setStock(dto.getStock());
        existente.setImagenPrincipal(dto.getImagenPrincipal());
        existente.setColorNombre(dto.getColorNombre());
        existente.setColorHex(dto.getColorHex());
        existente.setCorreoProveedor(dto.getCorreoProveedor());
        existente.setCategoria(categoria);

        Producto actualizado = productoRepository.save(existente);
        return toResponseDTO(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        productoRepository.delete(existente);
    }
}
