
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

            formulario.classList.add('was-validated');
            if (!formulario.checkValidity()) return;

            var usuario = formulario.querySelector('input[name="usuario"]').value.trim();
            var contrasena = formulario.querySelector('input[name="contrasena"]').value;

            if (validarCredenciales(usuario, contrasena)) {
                if (mensaje) {
                    mensaje.textContent = 'Acceso correcto. Redirigiendo…';
                    mensaje.className = 'mensaje-sesion mensaje-ok';
                }
                window.location.href = '/admin';
            } else {

                if (mensaje) {
                    mensaje.textContent = 'Credenciales no válidas. Verifica tu usuario y contraseña.';
                    mensaje.className = 'mensaje-sesion mensaje-error';
                }
            }
        });
    });
}());
