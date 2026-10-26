package pe.edu.utp.overtext;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.repository.ProductoRepository;

@SpringBootTest
class OvertextApplicationTests {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void contextLoads() {
        assertThat(productoRepository).isNotNull();
    }

    @Test
    @DisplayName("Debe consultar los 7 productos sembrados en Supabase mediante JPA y Select Nativo")
    void probarConexionYConsultasSupabase() {
        List<Producto> todos = productoRepository.findAll();
        assertThat(todos).hasSize(7);

        List<Producto> activosJpa = productoRepository.findByActivoTrue();
        assertThat(activosJpa).hasSize(7);

        List<Producto> disponiblesNativo = productoRepository.listarProductosDisponiblesNativo();
        assertThat(disponiblesNativo).hasSize(7);
    }
}
