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
        e.stopPropagation();

        // E1-07 · Validación de Bootstrap: sin campos válidos no se comprueban
        // las credenciales.
        formulario.classList.add('was-validated');
        if (!formulario.checkValidity()) return;

        var usuario = document.getElementById('usuario').value.trim();
        var contrasena = document.getElementById('contrasena').value;

        if (validarCredenciales(usuario, contrasena)) {
            if (mensaje) {
                mensaje.textContent = 'Acceso correcto. Redirigiendo…';
                mensaje.className = 'mensaje-sesion mensaje-ok';
            }
            window.location.href = '/intranet.html';
        } else {
            // Sin console.error: una credencial equivocada es un caso previsto,
            // no un fallo de la página (criterio 2d, consola limpia).
            if (mensaje) {
                mensaje.textContent = 'Credenciales no válidas. Verifica tu usuario y contraseña.';
                mensaje.className = 'mensaje-sesion mensaje-error';
            }
        }
    });
}());
