package pe.edu.utp.overtext.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import tools.jackson.databind.ObjectMapper;

import pe.edu.utp.overtext.model.Producto;

/**
 * ProductoServiceImpl — E2-09 · criterio ATF2-2c.
 *
 * <p>Lee {@code static/js/productos.json} desde el classpath (no un
 * archivo del sistema de ficheros: así funciona igual en {@code mvnw
 * spring-boot:run} y dentro del {@code .jar} empaquetado) y lo cachea en
 * memoria al arrancar. Es la misma fuente de datos que sigue leyendo
 * {@code tienda.js} por {@code fetch}: un solo origen de verdad para el
 * catálogo, con dos lectores durante la transición a {@code th:each}
 * (constitución art. 7, decisión de diseño de la tarea E2-09).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code ServiceImpl}.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private static final String RUTA_CATALOGO = "static/js/productos.json";

    private final List<Producto> productos;

    public ProductoServiceImpl(ObjectMapper objectMapper) {
        this.productos = cargarCatalogo(objectMapper);
    }

    @Override
    public List<Producto> listarTodos() {
        return productos;
    }

    @Override
    public Optional<Producto> buscarPorId(String id) {
        return productos.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();
    }

    private static List<Producto> cargarCatalogo(ObjectMapper objectMapper) {
        try (InputStream flujo = new ClassPathResource(RUTA_CATALOGO).getInputStream()) {
            Producto[] arreglo = objectMapper.readValue(flujo, Producto[].class);
            return List.copyOf(Arrays.asList(arreglo));
        } catch (IOException excepcion) {
            throw new IllegalStateException(
                    "No se pudo cargar el catálogo desde " + RUTA_CATALOGO, excepcion);
        }
    }
}
