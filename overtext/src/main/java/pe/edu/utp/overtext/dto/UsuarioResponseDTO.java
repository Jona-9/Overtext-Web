package pe.edu.utp.overtext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de salida para usuarios. No declara el campo password:
 * el hash de la contraseña nunca sale de la capa de servicio.
 * Aplana el rol asociado en rolNombre.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Long id;
    private String email;
    private String nombre;
    private Boolean activo;
    private String rolNombre;
}
