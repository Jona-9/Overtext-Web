package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IntranetController — E2-06 · criterio 1a.
 *
 * <p>Sirve el panel de administración en la ruta limpia
 * {@code GET /admin}. Thymeleaf resuelve la vista
 * {@code templates/paginas/intranet.html}.
 *
 * <p>La protección de esta ruta (solo rol {@code ADMIN}) se implementa
 * en el Sprint 6 con Spring Security — tarea E4-02.
 *
 * <p>Nomenclatura: constitución art. 5 — sufijo {@code Controller},
 * paquete {@code pe.edu.utp.overtext.controller}.
 */
@Controller
public class IntranetController {

    /**
     * Panel de administración (intranet).
     *
     * @return nombre lógico de la vista Thymeleaf ({@code paginas/intranet})
     */
    @GetMapping("/admin")
    public String admin() {
        return "paginas/intranet";
    }
}
