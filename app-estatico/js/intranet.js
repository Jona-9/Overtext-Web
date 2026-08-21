/* ============================================================
   OVERTEXT — Intranet
   Botón de cierre de sesión con confirmación.
   ============================================================ */
(function () {
    'use strict';

    var boton = document.getElementById('btn-cerrar-sesion');
    if (!boton) return;

    boton.addEventListener('click', function () {
        if (confirm('¿Deseas cerrar sesión?')) {
            window.location.href = '/login.html';
        }
    });
}());
