package pe.edu.utp.overtext.service;

import java.util.List;
import java.util.Optional;

import pe.edu.utp.overtext.model.Producto;

/**
 * ProductoService — E2-09 · criterio ATF2-2c.
 *
 * <p>Interfaz de servicio para el catálogo. Deliberadamente estable: cuando
 * el Sprint 4 introduzca Spring Data JPA y MySQL, {@code ProductoServiceImpl}
 * cambia de leer {@code productos.json} a inyectar un
 * {@code ProductoRepository}, pero ningún controlador ni plantilla que
 * dependa de esta interfaz se toca (E2-09, `sprint-03.md` §4).
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Service} para la
 * interfaz, paquete {@code pe.edu.utp.overtext.service}.
 */
public interface ProductoService {

    /** Los 7 productos del catálogo, en el orden de {@code productos.json}. */
    List<Producto> listarTodos();

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto (ej. {@code "short-negro"})
     * @return el producto si existe, vacío si no — el llamador decide cómo
     *         traducir la ausencia (típicamente un 404, ver
     *         {@code ProductoController})
     */
    Optional<Producto> buscarPorId(String id);
}
