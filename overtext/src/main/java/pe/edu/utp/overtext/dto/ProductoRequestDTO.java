package pe.edu.utp.overtext.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de entrada para crear y actualizar productos (POST y PUT).
 * Concentra las 5 validaciones Bean Validation exigidas por la P3:
 * @NotBlank, @Size, @NotNull, @Positive y @Email.
 * No expone id ni activo: los controla el backend, no el cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {

    @NotBlank(message = "El código es obligatorio")
    private String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "Debe tener entre 3 y 100 caracteres")
    private String nombre;

    private String slogan;

    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @PositiveOrZero(message = "El precio de pack no puede ser negativo")
    private Double precioPack;

    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    private String imagenPrincipal;

    @NotBlank(message = "El nombre del color es obligatorio")
    private String colorNombre;

    @NotBlank(message = "El código hexadecimal es obligatorio")
    private String colorHex;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    private String correoProveedor;

    @NotNull(message = "La categoría es obligatoria")
    @Positive(message = "El ID de categoría debe ser válido")
    private Long categoriaId;
}
