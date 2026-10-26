package pe.edu.utp.overtext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de salida para los endpoints de consulta de productos.
 * Aplana la relación con Categoria en categoriaId y categoriaNombre
 * para devolver un JSON de un solo nivel y evitar ciclos de serialización.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String slogan;
    private String descripcion;
    private Double precio;
    private Double precioPack;
    private Integer stock;
    private String imagenPrincipal;
    private String colorNombre;
    private String colorHex;
    private String correoProveedor;
    private Boolean activo;
    private Long categoriaId;
    private String categoriaNombre;
}
