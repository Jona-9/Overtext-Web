
(function () {
    'use strict';

    var detalle = document.querySelector('.info-detalle-producto');
    if (!detalle) return;

    fetch('/js/productos.json')
        .then(function (r) { return r.json(); })
        .then(function (productos) { renderDetalle(productos); })
        .catch(function (e) { console.error('No se pudo cargar productos.json:', e); });

    function esc(t) {
        return String(t == null ? '' : t).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    function renderDetalle(productos) {
        var id = detalle.dataset.productoId;
        var p = productos.find(function (x) { return x.id === id; }) || productos[0];
        var fallback = esc(p.imagen);

        var onerr = ' onerror="this.onerror=null;this.src=\'' + fallback + '\'"';

        document.title = p.nombre + ' — OVERTEXT';
        set('.nombre-detalle', p.nombre);
        set('.slogan-detalle', p.slogan);

        var precioPrincipal = document.querySelector('.precio-principal');
        if (precioPrincipal) precioPrincipal.innerHTML = 'S/ ' + p.precio + ' <span>unidad</span>';
        set('.precio-pack', 'o arma tu pack: ' + p.precioPack);

        var imgs = (p.galeria && p.galeria.length) ? p.galeria : [p.imagen];
        var inner = document.querySelector('#carrusel-galeria .carousel-inner');
        if (inner) {
            inner.innerHTML = imgs.map(function (src, i) {
                return '<div class="carousel-item' + (i === 0 ? ' active' : '') + '">' +
                    '<img src="' + esc(src) + '" class="d-block w-100" alt="' +
                    esc(p.nombre) + ' — vista ' + (i + 1) + '"' + onerr + '>' +
                '</div>';
            }).join('');
        }

        var indicadores = document.querySelector('#carrusel-galeria .carousel-indicators');
        if (indicadores) {
            indicadores.innerHTML = imgs.length > 1 ? imgs.map(function (src, i) {
                return '<button type="button" data-bs-target="#carrusel-galeria" data-bs-slide-to="' + i + '"' +
                    (i === 0 ? ' class="active" aria-current="true"' : '') +
                    ' aria-label="Vista ' + (i + 1) + '"></button>';
            }).join('') : '';
        }

        var soloUna = imgs.length <= 1;
        document.querySelectorAll('#carrusel-galeria .carousel-control-prev, #carrusel-galeria .carousel-control-next')
            .forEach(function (c) { c.classList.toggle('d-none', soloUna); });

        var grupoColores = document.querySelector('.grupo-colores');
        if (grupoColores) {
            grupoColores.innerHTML =
                '<span class="swatch swatch--activa" style="background:' + esc(p.color.hex) +
                    ';" title="' + esc(p.color.nombre) + '"></span>' +
                '<span class="selector-valor">' + esc(p.color.nombre) + '</span>';
        }

        var grupoTallas = document.querySelector('.grupo-tallas');
        if (grupoTallas) {
            grupoTallas.innerHTML = p.tallas.map(function (t, i) {
                return '<button class="btn-talla' + (i === 1 ? ' btn-talla--activa' : '') + '">' + esc(t) + '</button>';
            }).join('');
        }

        var btn = document.querySelector('.btn-carrito[data-agregar-carrito]');
        if (btn) {
            btn.dataset.id = p.id;
            btn.dataset.nombre = p.nombre;
            btn.dataset.precio = p.precio;
            btn.dataset.imagen = p.imagen;
        }
    }

    function set(sel, txt) {
        var el = document.querySelector(sel);
        if (el) el.textContent = txt;
    }

}());
