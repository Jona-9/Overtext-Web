/* ============================================================
   OVERTEXT — Formulario de contacto
   Valida con Bootstrap (was-validated) y, si los datos son válidos,
   muestra lo ingresado en el modal #modal-contacto.
   Sirve tanto a la página (contacto.html) como a #modal-contactanos
   (E2-02): ambos formularios llevan la clase .form-contacto, así que la
   misma lógica atiende cualquiera de los dos sin duplicar código (art. 7).
   ============================================================ */
(function () {
    'use strict';

    var formularios = document.querySelectorAll('.form-contacto');
    var modal = document.getElementById('modal-contacto');
    if (!formularios.length || !modal) return;

    var cuerpo = document.getElementById('modal-datos');

    // E1-08 · El modal es de Bootstrap: la apertura, el cierre con Esc, el
    // clic fuera y el bloqueo del scroll los gestiona el framework.
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

            // E1-07 · Validación de Bootstrap: si algún campo no cumple, se
            // marca el formulario y no se envía. El modal solo se abre con
            // datos válidos.
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

            // Si el envío vino de un modal (#modal-contactanos), se cierra
            // ese primero y la confirmación se abre en su evento `hidden`:
            // Bootstrap no apila dos backdrops a la vez.
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
