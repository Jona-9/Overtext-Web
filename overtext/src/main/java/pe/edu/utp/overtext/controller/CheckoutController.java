package pe.edu.utp.overtext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String checkout() {
        return "paginas/checkout";
    }

    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "paginas/confirmacion";
    }
}
