
(function () {
    'use strict';

    var formularios = document.querySelectorAll('.form-contacto');
    var modal = document.getElementById('modal-contacto');
    if (!formularios.length || !modal) return;

    var cuerpo = document.getElementById('modal-datos');

    var ventana = bootstrap.Modal.getOrCreateInstance(modal);

    function escapar(txt) {
        return String(txt == null ? '' : txt).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    function fila(etiqueta, valor) {
        return '<div class="modal-dato"><span>' + etiqueta + '</span><p>' +
            (escapar(valor) || '—') + '</p></div>';
    }

    function valor(formulario, nombre) {
        var campo = formulario.querySelector('[name="' + nombre + '"]');
        return campo ? campo.value.trim() : '';
    }

    Array.prototype.forEach.call(formularios, function (formulario) {
        formulario.addEventListener('submit', function (e) {
            e.preventDefault();
            e.stopPropagation();

            formulario.classList.add('was-validated');
            if (!formulario.checkValidity()) return;

            var datos = {
                nombre:  valor(formulario, 'contacto-nombre'),
                correo:  valor(formulario, 'contacto-correo'),
                asunto:  valor(formulario, 'contacto-asunto'),
                mensaje: valor(formulario, 'contacto-mensaje')
            };

            cuerpo.innerHTML =
                fila('Nombre', datos.nombre) +
                fila('Correo', datos.correo) +
                fila('Asunto', datos.asunto) +
                fila('Mensaje', datos.mensaje);

            formulario.reset();
            formulario.classList.remove('was-validated');

            var contenedor = formulario.closest('.modal');
            if (contenedor) {
                contenedor.addEventListener('hidden.bs.modal', function abrir() {
                    contenedor.removeEventListener('hidden.bs.modal', abrir);
                    ventana.show();
                });
                bootstrap.Modal.getOrCreateInstance(contenedor).hide();
            } else {
                ventana.show();
            }
        });
    });
}());
