package pe.edu.utp.overtext.model;

import java.util.List;

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

    public record Color(String nombre, String hex) {
    }
}
