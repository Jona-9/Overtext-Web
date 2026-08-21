/* ============================================================
   OVERTEXT — Carrito de compras (fuente única de verdad)
   Estado persistente en localStorage['ot_carrito'].
   Expone window.Carrito y auto-inicializa en cada página.
   ============================================================ */
(function () {
    'use strict';

    var CLAVE = 'ot_carrito';
    var UMBRAL_ENVIO_GRATIS = 180; // S/ para desbloquear envío gratis

    /* --- Persistencia --- */
    function obtenerCarrito() {
        try {
            var datos = JSON.parse(localStorage.getItem(CLAVE));
            return Array.isArray(datos) ? datos : [];
        } catch (e) {
            return [];
        }
    }

    function guardarCarrito(items) {
        localStorage.setItem(CLAVE, JSON.stringify(items));
        renderizarCarrito();
    }

    function vaciarCarrito() {
        localStorage.removeItem(CLAVE);
        renderizarCarrito();
    }

    /* --- Operaciones --- */
    function agregarProducto(prod) {
        if (!prod || !prod.id) return;
        var items = obtenerCarrito();
        var variante = prod.variante || '';
        var cantidad = parseInt(prod.cantidad, 10) || 1;
        var existente = items.find(function (it) {
            return it.id === prod.id && it.variante === variante;
        });
        if (existente) {
            existente.cantidad += cantidad;
        } else {
            items.push({
                id: prod.id,
                nombre: prod.nombre || 'Producto',
                variante: variante,
                precio: parseFloat(prod.precio) || 0,
                cantidad: cantidad,
                imagen: prod.imagen || ''
            });
        }
        guardarCarrito(items);
    }

    function eliminarProducto(id, variante) {
        var items = obtenerCarrito().filter(function (it) {
            return !(it.id === id && it.variante === (variante || ''));
        });
        guardarCarrito(items);
    }

    function cambiarCantidad(id, variante, delta) {
        var items = obtenerCarrito();
        var it = items.find(function (x) {
            return x.id === id && x.variante === (variante || '');
        });
        if (!it) return;
        it.cantidad += delta;
        if (it.cantidad < 1) {
            items = items.filter(function (x) { return x !== it; });
        }
        guardarCarrito(items);
    }

    function calcularTotales() {
        var items = obtenerCarrito();
        var subtotal = 0, cantidadTotal = 0;
        items.forEach(function (it) {
            subtotal += it.precio * it.cantidad;
            cantidadTotal += it.cantidad;
        });
        return { subtotal: subtotal, cantidadTotal: cantidadTotal };
    }

    function formatoSoles(monto) {
        return 'S/ ' + monto.toFixed(2);
    }

    /* --- Render del panel lateral y del badge --- */
    function renderizarCarrito() {
        var totales = calcularTotales();
        var items = obtenerCarrito();

        // Badge del header (puede existir en todas las páginas)
        document.querySelectorAll('.carrito-contador').forEach(function (b) {
            b.textContent = totales.cantidadTotal;
            b.style.display = totales.cantidadTotal > 0 ? '' : 'none';
        });

        var panel = document.getElementById('carrito-lateral');
        if (!panel) return; // páginas sin panel (ej. checkout) solo actualizan badge

        // Conteo
        var conteo = panel.querySelector('.carrito-conteo');
        if (conteo) {
            conteo.textContent = totales.cantidadTotal +
                (totales.cantidadTotal === 1 ? ' PRODUCTO' : ' PRODUCTOS');
        }

        // Lista de items
        var contenedor = panel.querySelector('.carrito-items');
        if (contenedor) {
            if (items.length === 0) {
                contenedor.innerHTML =
                    '<p class="carrito-vacio">Tu carrito está vacío. Arma tu pack y listo.</p>';
            } else {
                contenedor.innerHTML = items.map(itemHTML).join('');
            }
        }

        // Barra de envío gratis
        var texto = panel.querySelector('.envio-gratis-texto');
        var progreso = panel.querySelector('.envio-gratis-progreso');
        if (texto && progreso) {
            var falta = UMBRAL_ENVIO_GRATIS - totales.subtotal;
            if (falta <= 0) {
                texto.textContent = '¡ENVÍO GRATIS DESBLOQUEADO!';
                progreso.style.width = '100%';
            } else {
                texto.textContent = 'TE FALTAN ' + formatoSoles(falta) + ' PARA ENVÍO GRATIS';
                progreso.style.width = (totales.subtotal / UMBRAL_ENVIO_GRATIS * 100) + '%';
            }
        }

        // Totales del pie (envío se define al finalizar compra)
        var footer = panel.querySelector('.carrito-footer');
        if (footer) {
            var lineaSub = footer.querySelector('.resumen-linea span:last-child');
            if (lineaSub) lineaSub.textContent = formatoSoles(totales.subtotal);
            var monto = footer.querySelector('.total-monto');
            if (monto) monto.textContent = formatoSoles(totales.subtotal);
        }
    }

    function escapar(txt) {
        return String(txt).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    function itemHTML(it) {
        var v = escapar(it.variante);
        return '' +
        '<article class="item-carrito" data-id="' + escapar(it.id) + '" data-variante="' + v + '">' +
            '<div class="item-img-wrap"><img src="' + escapar(it.imagen) + '" alt="' + escapar(it.nombre) + '"></div>' +
            '<div class="item-info">' +
                '<h3>' + escapar(it.nombre) + '</h3>' +
                '<p class="item-variante">' + v + '</p>' +
                '<div class="item-controles">' +
                    '<div class="selector-cantidad">' +
                        '<button type="button" data-accion="menos" aria-label="Menos">−</button>' +
                        '<span>' + it.cantidad + '</span>' +
                        '<button type="button" data-accion="mas" aria-label="Más">+</button>' +
                    '</div>' +
                    '<span class="item-precio">' + formatoSoles(it.precio * it.cantidad) + '</span>' +
                '</div>' +
            '</div>' +
            '<button class="btn-eliminar" data-accion="eliminar" aria-label="Eliminar">' +
                '<svg width="11" height="11" viewBox="0 0 11 11" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round">' +
                '<line x1="1" y1="1" x2="10" y2="10"/><line x1="10" y1="1" x2="1" y2="10"/></svg>' +
            '</button>' +
        '</article>';
    }

    /* --- Panel abrir / cerrar --- */
    function abrirPanel() {
        var panel = document.getElementById('carrito-lateral');
        var overlay = document.getElementById('overlay-carrito');
        if (!panel) return;
        panel.classList.add('abierto');
        if (overlay) overlay.classList.add('activo');
        document.body.style.overflow = 'hidden';
    }

    function cerrarPanel() {
        var panel = document.getElementById('carrito-lateral');
        var overlay = document.getElementById('overlay-carrito');
        if (panel) panel.classList.remove('abierto');
        if (overlay) overlay.classList.remove('activo');
        document.body.style.overflow = '';
    }

    /* --- Construir variante desde selectores activos (página de detalle) --- */
    function varianteAuto() {
        var partes = [];
        var talla = document.querySelector('.btn-talla--activa');
        var color = document.querySelector('.swatch--activa');
        if (color && color.getAttribute('title')) partes.push(color.getAttribute('title').toUpperCase());
        if (talla) partes.push('TALLA ' + talla.textContent.trim());
        return partes.join(' · ');
    }

    /* --- Inicialización --- */
    function init() {
        renderizarCarrito();

        // Abrir/cerrar panel
        var abrir = document.getElementById('abrir-carrito');
        var cerrar = document.getElementById('cerrar-carrito');
        var seguir = document.getElementById('seguir-comprando');
        var overlay = document.getElementById('overlay-carrito');
        if (abrir) abrir.addEventListener('click', abrirPanel);
        if (cerrar) cerrar.addEventListener('click', cerrarPanel);
        if (seguir) seguir.addEventListener('click', cerrarPanel);
        if (overlay) overlay.addEventListener('click', cerrarPanel);

        // Delegación +/−/eliminar dentro del panel
        var lista = document.querySelector('.carrito-items');
        if (lista) {
            lista.addEventListener('click', function (e) {
                var boton = e.target.closest('[data-accion]');
                if (!boton) return;
                var art = boton.closest('.item-carrito');
                if (!art) return;
                var id = art.dataset.id;
                var variante = art.dataset.variante;
                var accion = boton.dataset.accion;
                if (accion === 'mas') cambiarCantidad(id, variante, 1);
                else if (accion === 'menos') cambiarCantidad(id, variante, -1);
                else if (accion === 'eliminar') eliminarProducto(id, variante);
            });
        }

        // Selectores de cantidad (+/−) en páginas de producto
        document.querySelectorAll('.control-cantidad').forEach(function (ctrl) {
            var valor = ctrl.querySelector('.valor-cantidad');
            ctrl.querySelectorAll('.btn-cantidad').forEach(function (btn, idx) {
                btn.addEventListener('click', function () {
                    var n = parseInt(valor.textContent, 10) || 1;
                    n = idx === 0 ? Math.max(1, n - 1) : n + 1; // primer botón = menos
                    valor.textContent = n;
                });
            });
        });

        // Delegación en document: funciona con nodos renderizados dinámicamente
        // (catálogo y detalle se pintan desde js/tienda.js después de este init).
        document.addEventListener('click', function (e) {
            // Selección de talla (página de detalle)
            var talla = e.target.closest('.grupo-tallas .btn-talla');
            if (talla) {
                talla.parentElement.querySelectorAll('.btn-talla')
                    .forEach(function (b) { b.classList.remove('btn-talla--activa'); });
                talla.classList.add('btn-talla--activa');
                return;
            }
            // Selección de color (página de detalle)
            var sw = e.target.closest('.grupo-colores .swatch');
            if (sw) {
                sw.parentElement.querySelectorAll('.swatch')
                    .forEach(function (s) { s.classList.remove('swatch--activa'); });
                sw.classList.add('swatch--activa');
                return;
            }
            // Botones declarativos "Agregar al carrito"
            var btn = e.target.closest('[data-agregar-carrito]');
            if (btn) {
                e.preventDefault();
                var d = btn.dataset;
                var variante = d.variante || '';
                if (btn.hasAttribute('data-variante-auto')) variante = varianteAuto();
                var cantidad = 1;
                if (d.cantidadEl) {
                    var celda = document.querySelector(d.cantidadEl);
                    if (celda) cantidad = parseInt(celda.textContent, 10) || 1;
                }
                agregarProducto({
                    id: d.id,
                    nombre: d.nombre,
                    variante: variante,
                    precio: d.precio,
                    imagen: d.imagen,
                    cantidad: cantidad
                });
                abrirPanel();
            }
        });
    }

    /* --- API pública --- */
    window.Carrito = {
        obtener: obtenerCarrito,
        guardar: guardarCarrito,
        vaciar: vaciarCarrito,
        agregar: agregarProducto,
        eliminar: eliminarProducto,
        cambiarCantidad: cambiarCantidad,
        calcularTotales: calcularTotales,
        render: renderizarCarrito,
        abrirPanel: abrirPanel,
        cerrarPanel: cerrarPanel,
        formatoSoles: formatoSoles,
        UMBRAL_ENVIO_GRATIS: UMBRAL_ENVIO_GRATIS
    };

    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
}());
