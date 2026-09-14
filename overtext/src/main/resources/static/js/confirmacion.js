/* ============================================================
   OVERTEXT — Confirmación de pedido
   Lee localStorage['ot_pedido'] y muestra el detalle del pedido.
   ============================================================ */
(function () {
    'use strict';

    var cont = document.getElementById('confirmacion-contenido');
    if (!cont) return;

    function soles(m) { return 'S/ ' + (Number(m) || 0).toFixed(2); }

    function escapar(txt) {
        return String(txt == null ? '' : txt).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    var pedido;
    try {
        pedido = JSON.parse(localStorage.getItem('ot_pedido'));
    } catch (e) {
        pedido = null;
    }

    if (!pedido) {
        cont.innerHTML =
            '<div class="confirmacion-vacio">' +
                '<h1>NO HAY PEDIDO QUE MOSTRAR</h1>' +
                '<p class="confirmacion-lema">Aún no has finalizado una compra.</p>' +
                '<a href="/catalogo.html" class="btn-finalizar">IR AL CATÁLOGO</a>' +
            '</div>';
        return;
    }

    var productosHTML = (pedido.productos || []).map(function (it) {
        return '' +
        '<div class="producto-resumen">' +
            '<img src="' + escapar(it.imagen) + '" alt="' + escapar(it.nombre) + '">' +
            '<div class="info-producto">' +
                '<p class="nombre">' + escapar(it.nombre) + '</p>' +
                '<p class="detalle">' + escapar(it.variante || '') +
                    (it.cantidad > 1 ? ' · x' + it.cantidad : '') + '</p>' +
                '<p class="precio">' + soles(it.precio * it.cantidad) + '</p>' +
            '</div>' +
        '</div>';
    }).join('');

    // Datos de entrega según tipo
    var entrega = '';
    if (pedido.tipoEnvio === 'delivery') {
        entrega =
            '<div><span>Distrito</span>' + escapar(pedido.distrito) + '</div>' +
            '<div><span>Dirección</span>' + escapar(pedido.direccion) + '</div>' +
            '<div><span>Referencia</span>' + escapar(pedido.referencia || '—') + '</div>';
    } else if (pedido.tipoEnvio === 'provincia') {
        entrega =
            '<div><span>Departamento</span>' + escapar(pedido.departamento) + '</div>' +
            '<div><span>Provincia</span>' + escapar(pedido.provinciaLoc) + '</div>' +
            '<div><span>Agencia</span>' + escapar(pedido.agencia) + '</div>';
    } else {
        entrega = '<div><span>Punto de recojo</span>Almacén OVERTEXT — Lima</div>';
    }

    var pago = pedido.metodoPago === 'yape' ? 'YAPE / PLIN' : 'DEPÓSITO / TRANSFERENCIA';

    cont.innerHTML =
        '<div class="confirmacion-cabecera">' +
            '<div class="confirmacion-check">✓</div>' +
            '<h1>Pedido confirmado</h1>' +
            '<p class="confirmacion-lema">Tu pedido está en camino. Gracias por comprar inteligente.</p>' +
            '<div class="confirmacion-meta">' +
                '<span>N.º ' + escapar(pedido.numeroPedido) + '</span>' +
                '<span>' + escapar(pedido.fecha) + '</span>' +
            '</div>' +
        '</div>' +

        '<div class="confirmacion-tarjeta">' +
            '<h3>Productos</h3>' +
            productosHTML +
            '<div class="totales-seccion">' +
                '<div class="total-fila"><span>SUBTOTAL</span><span>' + soles(pedido.subtotal) + '</span></div>' +
                '<div class="total-fila"><span>ENVÍO</span><span' +
                    (pedido.costoEnvio === 0 ? ' class="envio-gratis-tag"' : '') + '>' +
                    (pedido.costoEnvio === 0 ? 'GRATIS' : soles(pedido.costoEnvio)) + '</span></div>' +
                '<div class="total-fila total-final"><span class="fila-label">TOTAL</span>' +
                    '<span class="fila-valor">' + soles(pedido.total) + '</span></div>' +
            '</div>' +
        '</div>' +

        '<div class="confirmacion-tarjeta">' +
            '<h3>Datos del cliente</h3>' +
            '<div class="confirmacion-datos">' +
                '<div><span>Nombre</span>' + escapar(pedido.nombre) + ' ' + escapar(pedido.apellido) + '</div>' +
                '<div><span>Teléfono</span>' + escapar(pedido.telefono) + '</div>' +
                '<div><span>Correo</span>' + escapar(pedido.correo) + '</div>' +
                '<div><span>Documento</span>' + escapar(pedido.dni || '—') + '</div>' +
            '</div>' +
        '</div>' +

        '<div class="confirmacion-tarjeta">' +
            '<h3>Envío y pago</h3>' +
            '<div class="confirmacion-datos">' +
                '<div><span>Método de envío</span>' + escapar(pedido.etiquetaEnvio) + '</div>' +
                '<div><span>Método de pago</span>' + pago + '</div>' +
                entrega +
                (pedido.notas ? '<div><span>Notas</span>' + escapar(pedido.notas) + '</div>' : '') +
            '</div>' +
        '</div>' +

        '<a href="/catalogo.html" class="btn-finalizar">SEGUIR COMPRANDO</a>';

}());
