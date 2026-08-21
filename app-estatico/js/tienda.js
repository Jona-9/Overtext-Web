/* ============================================================
   OVERTEXT — Tienda (datos desde js/productos.json)
   Renderiza el catálogo y la página de detalle desde una sola
   fuente de datos. Los clics de "añadir al carrito" los maneja
   carrito.js por delegación, así que aquí solo se pinta HTML.
   Requiere servirse por HTTP (Live Server) para que fetch funcione.
   ============================================================ */
(function () {
    'use strict';

    var grid = document.querySelector('.productos-grid');
    var detalle = document.querySelector('.info-detalle-producto');
    if (!grid && !detalle) return;

    fetch('/js/productos.json')
        .then(function (r) { return r.json(); })
        .then(function (productos) {
            if (grid) renderCatalogo(productos);
            if (detalle) renderDetalle(productos);
        })
        .catch(function (e) { console.error('No se pudo cargar productos.json:', e); });

    function esc(t) {
        return String(t == null ? '' : t).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    /* --- Catálogo: cada producto es de un solo color --- */
    function renderCatalogo(productos) {
        grid.innerHTML = productos.map(function (p) {
            var url = '/detalle-producto.html?id=' + encodeURIComponent(p.id);
            var punto = '<span class="color" style="background:' + esc(p.color.hex) +
                '" title="' + esc(p.color.nombre) + '"></span>';
            return '' +
            '<article class="producto-card">' +
                '<span class="producto-badge">' + esc(p.badge) + '</span>' +
                '<a href="' + url + '"><img src="' + esc(p.imagen) + '" alt="' + esc(p.nombre) + '"></a>' +
                '<h3><a href="' + url + '" style="color:inherit;text-decoration:none;">' + esc(p.nombre) + '</a></h3>' +
                '<p>' + esc(p.descripcion) + '</p>' +
                '<p class="precio">S/ ' + p.precio + ' <span>/ pack ' + esc(p.precioPack) + '</span></p>' +
                '<div class="producto-colores">' + punto + '</div>' +
                '<a href="' + url + '" class="btn-agregar">VER PRODUCTO</a>' +
                '<button class="btn-agregar-carrito" data-agregar-carrito ' +
                    'data-id="' + esc(p.id) + '" data-nombre="' + esc(p.nombre) + '" data-precio="' + p.precio + '" ' +
                    'data-variante="' + esc(p.color.nombre.toUpperCase()) + '" ' +
                    'data-imagen="' + esc(p.imagen) + '">AÑADIR AL CARRITO</button>' +
            '</article>';
        }).join('');
    }

    /* --- Detalle --- */
    function renderDetalle(productos) {
        var id = new URLSearchParams(location.search).get('id');
        var p = productos.find(function (x) { return x.id === id; }) || productos[0];
        var fallback = esc(p.imagen);
        // Si una foto de galería aún no existe, cae a la foto principal del producto
        var onerr = ' onerror="this.onerror=null;this.src=\'' + fallback + '\'"';

        document.title = p.nombre + ' — OVERTEXT';
        set('.nombre-detalle', p.nombre);
        set('.slogan-detalle', p.slogan);

        var precioPrincipal = document.querySelector('.precio-principal');
        if (precioPrincipal) precioPrincipal.innerHTML = 'S/ ' + p.precio + ' <span>unidad</span>';
        set('.precio-pack', 'o arma tu pack: ' + p.precioPack);

        var fotoPrincipal = document.querySelector('.foto-principal-wrapper img');
        if (fotoPrincipal) {
            fotoPrincipal.onerror = function () { fotoPrincipal.onerror = null; fotoPrincipal.src = p.imagen; };
            fotoPrincipal.src = p.galeria[0] || p.imagen;
            fotoPrincipal.alt = p.nombre;
        }

        var miniaturas = document.querySelector('.miniaturas-grid');
        if (miniaturas) {
            miniaturas.innerHTML = p.galeria.map(function (src, i) {
                return '<img src="' + esc(src) + '" alt="Vista ' + (i + 1) + '"' + onerr +
                    ' class="miniatura' + (i === 0 ? ' activa' : '') + '">';
            }).join('');
        }

        // Color: indicador de color único (no un selector). varianteAuto() de
        // carrito.js lee el .swatch--activa[title] para armar "COLOR · TALLA".
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

    // Galería clickeable: la miniatura cambia la foto principal (solo en detalle)
    if (detalle) {
        document.addEventListener('click', function (e) {
            var mini = e.target.closest('.miniatura');
            if (!mini) return;
            var main = document.querySelector('.foto-principal-wrapper img');
            if (main) main.src = mini.src;
            document.querySelectorAll('.miniatura').forEach(function (m) { m.classList.remove('activa'); });
            mini.classList.add('activa');
        });
    }
}());
