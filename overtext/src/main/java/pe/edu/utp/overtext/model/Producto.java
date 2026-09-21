package pe.edu.utp.overtext.model;

import java.util.List;

/**
 * Producto — E2-09 · criterio ATF2-2c.
 *
 * <p>Espejo del objeto de {@code static/js/productos.json}, el único origen
 * de verdad del catálogo (constitución art. 7). {@code ProductoServiceImpl}
 * lo deserializa con Jackson; no se reescribe ningún dato de producto en
 * Java.
 *
 * <p>Nomenclatura: constitución art. 5 — entidad sin sufijo. Aunque hoy no
 * es una entidad JPA, ocupa su lugar: cuando el Sprint 4 migre a MySQL,
 * este record se reemplaza por la entidad {@code @Entity Producto} sin que
 * el controlador ni la vista cambien (ver `sprint-03.md`, tarea E2-09).
 */
public record Producto(
        String id,
        String nombre,
        int precio,
        String precioPack,
        String badge,
        String slogan,
        String descripcion,
        String imagen,
        List<String> galeria,
        Color color,
        List<String> tallas) {

    /** Color del producto, tal como lo define {@code productos.json}. */
    public record Color(String nombre, String hex) {
    }
}
