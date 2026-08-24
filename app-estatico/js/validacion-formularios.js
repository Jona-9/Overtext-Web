/* ============================================================
   OVERTEXT — Validación de formularios (Bootstrap 5)
   Historia E1-07 · criterio ATF1-1c

   Aplica a todo formulario marcado con .needs-validation.
   Si hay campos inválidos detiene el envío y marca el formulario
   con .was-validated, para que Bootstrap muestre los mensajes
   de .invalid-feedback.

   Se carga ANTES que el script propio de cada página: usa
   stopImmediatePropagation() para que ese script no llegue a
   procesar un formulario incompleto.
   ============================================================ */
(function () {
    'use strict';

    var formularios = document.querySelectorAll('.needs-validation');

    Array.prototype.forEach.call(formularios, function (formulario) {
        formulario.addEventListener('submit', function (evento) {
            if (!formulario.checkValidity()) {
                evento.preventDefault();
                evento.stopImmediatePropagation();

                var primerInvalido = formulario.querySelector(':invalid');
                if (primerInvalido) primerInvalido.focus();
            }
            formulario.classList.add('was-validated');
        }, false);
    });
}());
