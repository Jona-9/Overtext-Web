package pe.edu.utp.overtext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pe.edu.utp.overtext.controller.api.ProductoRestController;
import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.repository.ProductoRepository;
import pe.edu.utp.overtext.service.ProductoService;

@SpringBootTest
class OvertextApplicationTests {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductoRestController(productoService)).build();
    }

    @Test
    void contextLoads() {
        assertThat(productoRepository).isNotNull();
        assertThat(productoService).isNotNull();
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

    @Test
    @DisplayName("GET /api/productos debe retornar HTTP 200 con la lista JSON de productos de Supabase")
    void probarEndpointRestProductos() throws Exception {
        mockMvc.perform(get("/api/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(7))
                .andExpect(jsonPath("$[0].codigo").exists())
                .andExpect(jsonPath("$[0].precio").isNumber());
    }

    @Test
    @DisplayName("GET /api/productos/nativos debe retornar HTTP 200 con la consulta SQL nativa")
    void probarEndpointRestNativo() throws Exception {
        mockMvc.perform(get("/api/productos/nativos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(7));
    }
}
