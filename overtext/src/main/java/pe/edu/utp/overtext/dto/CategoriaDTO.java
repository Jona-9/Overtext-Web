package pe.edu.utp.overtext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de categorías. Omite la colección de productos de la entidad
 * para no arrastrar el catálogo completo en cada respuesta.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;
    private String nombre;
    private String slug;
    private String descripcion;
    private Boolean activo;
}
