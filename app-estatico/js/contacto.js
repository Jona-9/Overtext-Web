/* ============================================================
   OVERTEXT — Formulario de contacto
   Valida con Bootstrap (was-validated) y, si los datos son válidos,
   muestra lo ingresado en una ventana flotante.
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
        e.stopPropagation();

        // E1-07 · Validación de Bootstrap: si algún campo no cumple, se marca
        // el formulario y no se envía. El modal solo se abre con datos válidos.
        formulario.classList.add('was-validated');
        if (!formulario.checkValidity()) return;

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
        formulario.classList.remove('was-validated');
    });

    btnCerrar.addEventListener('click', cerrarModal);
    modal.addEventListener('click', function (e) {
        if (e.target === modal) cerrarModal();
    });
    document.addEventListener('keydown', function (e) {
        if (e.key === 'Escape') cerrarModal();
    });
}());
