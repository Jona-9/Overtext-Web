/* ============================================================
   OVERTEXT — Validación de inicio de sesión
   Credenciales válidas: admin@mail.com / 123456 → intranet.html
   Sirve tanto a la página (login.html) como a #modal-login (E2-01):
   ambos formularios llevan la clase .formulario-sesion, así que la misma
   lógica valida cualquiera de los dos sin duplicar código (art. 7).
   ============================================================ */
(function () {
    'use strict';

    var CREDENCIALES = { usuario: 'admin@mail.com', contrasena: '123456' };

    var formularios = document.querySelectorAll('.formulario-sesion');
    if (!formularios.length) return;

    function validarCredenciales(usuario, contrasena) {
        return usuario === CREDENCIALES.usuario && contrasena === CREDENCIALES.contrasena;
    }

    Array.prototype.forEach.call(formularios, function (formulario) {
        var mensaje = formulario.querySelector('.mensaje-sesion');

        formulario.addEventListener('submit', function (e) {
            e.preventDefault();
            e.stopPropagation();

            // E1-07 · Validación de Bootstrap: sin campos válidos no se
            // comprueban las credenciales.
            formulario.classList.add('was-validated');
            if (!formulario.checkValidity()) return;

            var usuario = formulario.querySelector('input[name="usuario"]').value.trim();
            var contrasena = formulario.querySelector('input[name="contrasena"]').value;

            if (validarCredenciales(usuario, contrasena)) {
                if (mensaje) {
                    mensaje.textContent = 'Acceso correcto. Redirigiendo…';
                    mensaje.className = 'mensaje-sesion mensaje-ok';
                }
                window.location.href = '/intranet.html';
            } else {
                // Sin console.error: una credencial equivocada es un caso
                // previsto, no un fallo de la página (criterio 2d, consola limpia).
                if (mensaje) {
                    mensaje.textContent = 'Credenciales no válidas. Verifica tu usuario y contraseña.';
                    mensaje.className = 'mensaje-sesion mensaje-error';
                }
            }
        });
    });
}());
