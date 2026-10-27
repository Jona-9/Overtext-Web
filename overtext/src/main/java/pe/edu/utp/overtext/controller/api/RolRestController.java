package pe.edu.utp.overtext.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.overtext.dto.RolDTO;
import pe.edu.utp.overtext.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolRestController {

    private final RolService rolService;

    public RolRestController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listarTodos() {
        return ResponseEntity.ok(rolService.listarTodos());
    }
}
