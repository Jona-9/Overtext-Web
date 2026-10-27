package pe.edu.utp.overtext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.jsonpath.JsonPath;

import pe.edu.utp.overtext.entity.Producto;
import pe.edu.utp.overtext.repository.ProductoRepository;
import pe.edu.utp.overtext.service.ProductoService;
import pe.edu.utp.overtext.service.RolService;
import pe.edu.utp.overtext.service.UsuarioService;

@SpringBootTest
class OvertextApplicationTests {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void contextLoads() {
        assertThat(productoRepository).isNotNull();
        assertThat(productoService).isNotNull();
        assertThat(rolService).isNotNull();
        assertThat(usuarioService).isNotNull();
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

    @Test
    @DisplayName("GET /api/productos/{id} con ID negativo debe retornar HTTP 400 por validación @Positive")
    void probarEndpointRestProductoIdInvalido() throws Exception {
        mockMvc.perform(get("/api/productos/-5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.mensajes").isArray());
    }

    @Test
    @DisplayName("GET /api/productos/{id} inexistente debe retornar HTTP 404")
    void probarEndpointRestProductoNoEncontrado() throws Exception {
        mockMvc.perform(get("/api/productos/999999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /api/productos con campos vacíos debe retornar HTTP 400 por Bean Validation")
    void probarEndpointRestProductoPostInvalido() throws Exception {
        String jsonInvalido = """
                {
                    "codigo": "",
                    "nombre": "A",
                    "precio": -10.0,
                    "stock": -1,
                    "colorNombre": "",
                    "colorHex": "",
                    "correoProveedor": "invalido",
                    "categoriaId": -1
                }
                """;

        mockMvc.perform(post("/api/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.mensajes").isArray());
    }

    @Test
    @DisplayName("Ciclo completo CRUD de Producto: POST (201), PUT (200) y DELETE (204)")
    void probarCicloCompletoCrudProducto() throws Exception {
        String jsonCrear = """
                {
                    "codigo": "PROD-TEST-TEMPORAL",
                    "nombre": "Short Temporal Para Test",
                    "slogan": "Short de prueba automatizada",
                    "descripcion": "Verificación de ciclo CRUD en Supabase",
                    "precio": 49.90,
                    "precioPack": 39.90,
                    "stock": 15,
                    "imagenPrincipal": "/assets/img/test.webp",
                    "colorNombre": "Gris Carbón",
                    "colorHex": "#222222",
                    "correoProveedor": "test@overtext.pe",
                    "categoriaId": 1
                }
                """;

        MvcResult resultadoPost = mockMvc.perform(post("/api/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCrear))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.codigo").value("PROD-TEST-TEMPORAL"))
                .andReturn();

        Number idNum = JsonPath.read(resultadoPost.getResponse().getContentAsString(), "$.id");
        long productoId = idNum.longValue();

        String jsonActualizar = """
                {
                    "codigo": "PROD-TEST-TEMPORAL",
                    "nombre": "Short Temporal Actualizado",
                    "slogan": "Actualizado para test",
                    "descripcion": "Descripción actualizada",
                    "precio": 55.00,
                    "precioPack": 42.00,
                    "stock": 25,
                    "imagenPrincipal": "/assets/img/test-upd.webp",
                    "colorNombre": "Gris Carbón",
                    "colorHex": "#222222",
                    "correoProveedor": "test.actualizado@overtext.pe",
                    "categoriaId": 1
                }
                """;

        mockMvc.perform(put("/api/productos/" + productoId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonActualizar))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Short Temporal Actualizado"))
                .andExpect(jsonPath("$.precio").value(55.00));

        mockMvc.perform(delete("/api/productos/" + productoId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/productos/" + productoId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/roles debe retornar HTTP 200 con el catálogo de roles")
    void probarEndpointRestRoles() throws Exception {
        mockMvc.perform(get("/api/roles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").exists());
    }

    @Test
    @DisplayName("GET /api/usuarios debe retornar HTTP 200 con la lista de usuarios activos")
    void probarEndpointRestUsuarios() throws Exception {
        mockMvc.perform(get("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").exists());
    }

    @Test
    @DisplayName("Ciclo de Usuario: POST (201), duplicado (400) y DELETE baja lógica (204)")
    void probarCicloUsuario() throws Exception {
        String emailTemporal = "usuario.test." + System.currentTimeMillis() + "@overtext.pe";
        String jsonUsuario = String.format("""
                {
                    "email": "%s",
                    "password": "PasswordSeguro123",
                    "nombre": "Usuario Prueba Test",
                    "rolId": 2
                }
                """, emailTemporal);

        MvcResult resultadoPost = mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUsuario))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.email").value(emailTemporal))
                .andExpect(jsonPath("$.rolNombre").value("CLIENTE"))
                .andReturn();

        Number idNum = JsonPath.read(resultadoPost.getResponse().getContentAsString(), "$.id");
        long usuarioId = idNum.longValue();

        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUsuario))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.mensajes[0]").value("El email ya está registrado: " + emailTemporal));

        mockMvc.perform(delete("/api/usuarios/" + usuarioId))
                .andExpect(status().isNoContent());
    }
}
