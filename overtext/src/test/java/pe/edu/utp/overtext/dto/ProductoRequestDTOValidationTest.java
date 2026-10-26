package pe.edu.utp.overtext.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * Verifica que las 5 anotaciones Bean Validation exigidas por la P3
 * (@NotBlank, @Size, @NotNull, @Positive y @Email) rechacen los datos
 * inválidos antes de llegar a la capa de servicio.
 *
 * Usa el Validator de Jakarta directamente: no levanta el contexto de
 * Spring ni consulta Supabase, por lo que corre en milisegundos.
 */
class ProductoRequestDTOValidationTest {

    private static Validator validator;

    @BeforeAll
    static void iniciarValidador() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /** Devuelve los nombres de los campos que fallaron la validación. */
    private static Set<String> camposInvalidos(Object dto) {
        return validator.validate(dto).stream()
                .map(ConstraintViolation::getPropertyPath)
                .map(Object::toString)
                .collect(Collectors.toSet());
    }

    private static ProductoRequestDTO productoValido() {
        ProductoRequestDTO dto = new ProductoRequestDTO();
        dto.setCodigo("OT-SHORT-001");
        dto.setNombre("Short Urbano Oliva");
        dto.setPrecio(89.90);
        dto.setPrecioPack(159.90);
        dto.setStock(24);
        dto.setColorNombre("Oliva Militar");
        dto.setColorHex("#4B5320");
        dto.setCorreoProveedor("proveedor@overtext.pe");
        dto.setCategoriaId(2L);
        return dto;
    }

    @Test
    @DisplayName("Un ProductoRequestDTO completo y correcto no genera ninguna violación")
    void aceptaProductoValido() {
        assertThat(camposInvalidos(productoValido())).isEmpty();
    }

    @Test
    @DisplayName("Las 5 validaciones de la P3 rechazan los datos inválidos del producto")
    void rechazaProductoConDatosInvalidos() {
        ProductoRequestDTO dto = productoValido();
        dto.setCodigo("");                       // @NotBlank
        dto.setNombre("AB");                     // @Size(min = 3)
        dto.setPrecio(-10.0);                    // @Positive
        dto.setStock(null);                      // @NotNull
        dto.setCorreoProveedor("no-es-correo");  // @Email

        assertThat(camposInvalidos(dto))
                .contains("codigo", "nombre", "precio", "stock", "correoProveedor");
    }

    @Test
    @DisplayName("@NotNull y @Positive rechazan una categoría ausente o negativa")
    void rechazaCategoriaInvalida() {
        ProductoRequestDTO sinCategoria = productoValido();
        sinCategoria.setCategoriaId(null);
        assertThat(camposInvalidos(sinCategoria)).contains("categoriaId");

        ProductoRequestDTO categoriaNegativa = productoValido();
        categoriaNegativa.setCategoriaId(-5L);
        assertThat(camposInvalidos(categoriaNegativa)).contains("categoriaId");
    }

    @Test
    @DisplayName("UsuarioRequestDTO exige email válido y contraseña de al menos 6 caracteres")
    void rechazaUsuarioConPasswordCortoYEmailInvalido() {
        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setEmail("correo-sin-arroba");  // @Email
        dto.setPassword("123");             // @Size(min = 6)
        dto.setNombre("Jo");                // @Size(min = 3)
        dto.setRolId(null);                 // @NotNull

        assertThat(camposInvalidos(dto))
                .contains("email", "password", "nombre", "rolId");
    }
}
