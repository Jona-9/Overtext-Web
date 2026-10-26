package pe.edu.utp.overtext.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.utp.overtext.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Select JPA (Requisito P3)
    List<Producto> findByActivoTrue();

    // Select Nativo (Requisito P3)
    @Query(value = "SELECT * FROM producto WHERE stock > 0 AND activo = true ORDER BY precio ASC", nativeQuery = true)
    List<Producto> listarProductosDisponiblesNativo();

    Optional<Producto> findByCodigo(String codigo);
}
