package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * LoginController — E2-06 · criterio 1a.
 *
 * <p>Sirve el formulario de inicio de sesión en la ruta limpia
 * {@code GET /login}. Thymeleaf resuelve la vista
 * {@code templates/paginas/login.html}.
 *
 * <p>La autenticación real (Spring Security) se implementa en el Sprint 6
 * — tareas E4-02 a E4-17. Por ahora la ruta solo sirve la vista.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class LoginController {

    /**
     * Página de inicio de sesión.
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/login})
     */
    @GetMapping("/login")
    public String login() {
        return "paginas/login";
    }
}
