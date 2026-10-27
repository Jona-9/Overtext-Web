package pe.edu.utp.overtext.controller.advice;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    List<String> mensajes
) {
}
