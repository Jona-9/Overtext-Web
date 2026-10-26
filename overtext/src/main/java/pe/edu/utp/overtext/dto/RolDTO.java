package pe.edu.utp.overtext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de roles para el catálogo de asignación (GET /api/roles).
 * Omite la colección de usuarios de la entidad Rol.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {

    private Long id;
    private String nombre;
    private String descripcion;
}
