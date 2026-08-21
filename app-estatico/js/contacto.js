/* ============================================================
   OVERTEXT — Formulario de contacto
   Al enviar, muestra los datos ingresados en una ventana flotante.
   ============================================================ */
(function () {
    'use strict';

    var formulario = document.getElementById('form-contacto');
    var modal = document.getElementById('modal-contacto');
    if (!formulario || !modal) return;

    var cuerpo = document.getElementById('modal-datos');
    var btnCerrar = modal.querySelector('.modal-cerrar');

    function escapar(txt) {
        return String(txt == null ? '' : txt).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    function abrirModal() {
        modal.classList.add('abierto');
        document.body.style.overflow = 'hidden';
    }

    function cerrarModal() {
        modal.classList.remove('abierto');
        document.body.style.overflow = '';
    }

    function fila(etiqueta, valor) {
        return '<div class="modal-dato"><span>' + etiqueta + '</span><p>' +
            (escapar(valor) || '—') + '</p></div>';
    }

    formulario.addEventListener('submit', function (e) {
        e.preventDefault();

        var datos = {
            nombre:  document.getElementById('contacto-nombre').value.trim(),
            correo:  document.getElementById('contacto-correo').value.trim(),
            asunto:  document.getElementById('contacto-asunto').value.trim(),
            mensaje: document.getElementById('contacto-mensaje').value.trim()
        };

        cuerpo.innerHTML =
            fila('Nombre', datos.nombre) +
            fila('Correo', datos.correo) +
            fila('Asunto', datos.asunto) +
            fila('Mensaje', datos.mensaje);

        abrirModal();
        formulario.reset();
    });

    btnCerrar.addEventListener('click', cerrarModal);
    modal.addEventListener('click', function (e) {
        if (e.target === modal) cerrarModal();
    });
    document.addEventListener('keydown', function (e) {
        if (e.key === 'Escape') cerrarModal();
    });
}());
