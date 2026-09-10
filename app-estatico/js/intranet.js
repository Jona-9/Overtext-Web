/* ============================================================
   OVERTEXT — Intranet
   Tabla de productos (desde js/productos.json) con los dos arquetipos
   de ventana modal del ejemplo del profesor:
     - "Ver" en cada fila -> #modal-detalle-producto (solo lectura)
     - "+ Nuevo producto"  -> #modal-nuevo-producto  (alta, sin persistencia:
       el CRUD real es del ATF3, art. 8)
   El botón "Cerrar sesión" ya no usa confirm() nativo: abre
   #modal-cerrar-sesion, el mismo componente que el resto del sitio.
   ============================================================ */
(function () {
    'use strict';

    var cuerpoTabla = document.getElementById('tabla-productos');
    if (!cuerpoTabla) return;

    var selectColor = document.getElementById('nuevo-producto-color');
    var modalDetalle = document.getElementById('modal-detalle-producto');
    var colIzq = document.getElementById('modal-detalle-col-izq');
    var colDer = document.getElementById('modal-detalle-col-der');
    var descripcionEl = document.getElementById('modal-detalle-descripcion');
    var formularioNuevo = document.getElementById('formulario-nuevo-producto');

    var productos = [];

    function esc(t) {
        return String(t == null ? '' : t).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    function dato(etiqueta, valor) {
        return '<p class="modal-detalle-dato"><strong>' + etiqueta + ':</strong> ' + valor + '</p>';
    }

    fetch('/js/productos.json')
        .then(function (r) { return r.json(); })
        .then(function (datos) {
            productos = datos;
            renderTabla(productos);
            renderOpcionesColor(productos);
        })
        .catch(function (e) { console.error('No se pudo cargar productos.json:', e); });

    function renderTabla(lista) {
        cuerpoTabla.innerHTML = lista.map(function (p) {
            var punto = '<span class="modal-detalle-swatch" style="background:' + esc(p.color.hex) + '"></span>';
            return '' +
                '<tr>' +
                '<td><strong>' + esc(p.nombre) + '</strong></td>' +
                '<td>' + punto + esc(p.color.nombre) + '</td>' +
                '<td>S/ ' + esc(p.precio) + '</td>' +
                '<td>' + esc(p.tallas.join(' · ')) + '</td>' +
                '<td><span class="badge bg-dark">' + esc(p.badge) + '</span></td>' +
                '<td><button type="button" class="btn btn-outline-dark btn-sm" ' +
                'data-bs-toggle="modal" data-bs-target="#modal-detalle-producto" ' +
                'data-id="' + esc(p.id) + '">Ver</button></td>' +
                '</tr>';
        }).join('');
    }

    function renderOpcionesColor(lista) {
        if (!selectColor) return;
        var vistos = {};
        var opciones = lista.reduce(function (html, p) {
            if (vistos[p.color.nombre]) return html;
            vistos[p.color.nombre] = true;
            return html + '<option value="' + esc(p.color.nombre) + '">' + esc(p.color.nombre) + '</option>';
        }, '');
        selectColor.insertAdjacentHTML('beforeend', opciones);
    }

    // Patrón estándar de Bootstrap: un solo modal reutilizado por todas las
    // filas, relleno con el `data-id` del botón que lo abrió
    // (event.relatedTarget), no con un modal por fila.
    if (modalDetalle) {
        modalDetalle.addEventListener('show.bs.modal', function (event) {
            var id = event.relatedTarget && event.relatedTarget.dataset.id;
            var p = productos.filter(function (x) { return x.id === id; })[0];
            if (!p) return;

            colIzq.innerHTML =
                dato('Código', esc(p.id)) +
                dato('Nombre', esc(p.nombre)) +
                dato('Color', esc(p.color.nombre)) +
                dato('Tallas', esc(p.tallas.join(' · ')));

            colDer.innerHTML =
                dato('Precio', 'S/ ' + esc(p.precio)) +
                dato('Precio por pack', esc(p.precioPack)) +
                dato('Estado', '<span class="badge bg-dark">' + esc(p.badge) + '</span>');

            descripcionEl.textContent = p.slogan + ' ' + p.descripcion;
        });
    }

    // Alta sin persistencia (art. 8): valida y avisa, no escribe en
    // productos.json — eso llega con el backend del ATF3.
    if (formularioNuevo) {
        formularioNuevo.addEventListener('submit', function (e) {
            e.preventDefault();
            e.stopPropagation();

            formularioNuevo.classList.add('was-validated');
            if (!formularioNuevo.checkValidity()) return;

            var modal = bootstrap.Modal.getOrCreateInstance(formularioNuevo.closest('.modal'));
            modal.hide();
            formularioNuevo.reset();
            formularioNuevo.classList.remove('was-validated');
        });
    }
}());
