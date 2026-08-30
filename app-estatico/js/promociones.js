/* ============================================================
   OVERTEXT — Configurador de packs (página promociones)
   Cada prenda es color + talla; se arma un pack de 6.
   Depende de window.Carrito (js/carrito.js), que debe cargarse antes.
   ============================================================ */
(function () {
    'use strict';

    var MAX = 6;
    var seleccion = [];        // [{ nombre, color, talla }]
    var tallaActual = 'M';
    var opciones = document.querySelectorAll('.color-opcion');
    var tallas = document.querySelectorAll('.pack-talla');
    var slotsCont = document.querySelector('.slots');
    var contador = document.querySelector('.contador-slots');
    var btnPack = document.querySelector('.boton-carrito-pack');
    if (!btnPack || !slotsCont) return;

    // Luminancia aproximada de un 'rgb(r, g, b)' para decidir si la talla
    // del slot se escribe en blanco o en negro.
    function esClaro(rgb) {
        var n = rgb.match(/\d+/g);
        if (!n) return false;
        return (n[0] * 0.299 + n[1] * 0.587 + n[2] * 0.114) > 150;
    }

    function render() {
        var html = '';
        for (var i = 0; i < MAX; i++) {
            if (seleccion[i]) {
                html += '<div class="slot lleno' + (esClaro(seleccion[i].color) ? ' slot--claro' : '') +
                    '" data-idx="' + i + '" title="Quitar" style="background-color:' +
                    seleccion[i].color + ';"><span class="slot-talla">' + seleccion[i].talla + '</span></div>';
            } else {
                html += '<div class="slot vacio"></div>';
            }
        }
        slotsCont.innerHTML = html;
        contador.textContent = seleccion.length + ' DE ' + MAX + ' SELECCIONADOS';
        btnPack.disabled = seleccion.length !== MAX;
        marcarColores();
    }

    // El resaltado de una muestra significa "este color ya esta en el pack",
    // asi que se recalcula desde la seleccion en cada render.
    function marcarColores() {
        opciones.forEach(function (op) {
            var nombre = op.querySelector('.nombre-color').textContent.trim();
            var cuantos = seleccion.filter(function (s) { return s.nombre === nombre; }).length;
            op.classList.toggle('activo', cuantos > 0);
            var contadorColor = op.querySelector('.contador-color');
            if (contadorColor) contadorColor.textContent = cuantos ? '\u00D7' + cuantos : '';
        });
    }

    tallas.forEach(function (t) {
        t.addEventListener('click', function () {
            tallaActual = t.dataset.talla;
            tallas.forEach(function (x) { x.classList.remove('activo'); });
            t.classList.add('activo');
        });
    });

    opciones.forEach(function (op) {
        op.addEventListener('click', function () {
            if (seleccion.length >= MAX) return;
            var nombre = op.querySelector('.nombre-color').textContent.trim();
            // El color de cada muestra ahora vive en una clase CSS, no en un
            // atributo style, así que se lee el valor ya resuelto por el navegador.
            var color = getComputedStyle(op.querySelector('.color-muestra')).backgroundColor;
            seleccion.push({ nombre: nombre, color: color, talla: tallaActual });
            render();
        });
    });

    // Tocar un slot lleno lo quita
    slotsCont.addEventListener('click', function (e) {
        var slot = e.target.closest('.slot.lleno');
        if (!slot) return;
        seleccion.splice(parseInt(slot.dataset.idx, 10), 1);
        render();
    });

    btnPack.addEventListener('click', function () {
        if (seleccion.length !== MAX) return;
        window.Carrito.agregar({
            id: 'pack-x6',
            nombre: 'PACK X6',
            variante: seleccion.map(function (s) { return s.nombre + ' T-' + s.talla; }).join(' · '),
            precio: 100,
            imagen: '/assets/img/sitio/pack-short.webp',
            cantidad: 1
        });
        window.Carrito.abrirPanel();
        seleccion = [];
        render();
    });

    render();
}());
