package pe.edu.utp.overtext.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de entrada para el registro de usuarios (POST /api/usuarios).
 * Recibe la contraseña en claro únicamente para que el servicio la cifre;
 * nunca se devuelve al cliente (ver UsuarioResponseDTO).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "Debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El rol es obligatorio")
    @Positive(message = "El ID de rol debe ser positivo")
    private Long rolId;
}
