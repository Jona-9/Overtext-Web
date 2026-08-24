/* ============================================================
   OVERTEXT — Validación de inicio de sesión
   Credenciales válidas: admin@mail.com / 123456 → intranet.html
   ============================================================ */
(function () {
    'use strict';

    var CREDENCIALES = { usuario: 'admin@mail.com', contrasena: '123456' };

    var formulario = document.getElementById('formulario-sesion');
    if (!formulario) return;

    var mensaje = document.getElementById('mensaje-sesion');

    function validarCredenciales(usuario, contrasena) {
        return usuario === CREDENCIALES.usuario && contrasena === CREDENCIALES.contrasena;
    }

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var usuario = document.getElementById('usuario').value.trim();
        var contrasena = document.getElementById('contrasena').value;

        if (validarCredenciales(usuario, contrasena)) {
            if (mensaje) {
                mensaje.textContent = 'Acceso correcto. Redirigiendo…';
                mensaje.className = 'mensaje-sesion mensaje-ok';
            }
            window.location.href = '/intranet.html';
        } else {
            // El aviso va en la interfaz, no en la consola: la página se entrega
            // sin errores de consola (constitución art. 3 · criterio ATF1-2d).
            if (mensaje) {
                mensaje.textContent = 'Credenciales no válidas. Verifica tu usuario y contraseña.';
                mensaje.className = 'mensaje-sesion mensaje-error';
            }
        }
    });
}());
