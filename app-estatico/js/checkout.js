/* ============================================================
   OVERTEXT — Checkout (Finalizar compra)
   Página única con pasos que se desbloquean progresivamente:
   1) Datos del cliente → 2) Envío → 3) Pago.
   El tipo de envío revela sus campos inline (sin recargar) y
   recalcula el resumen. Al finalizar arma ot_pedido.
   ============================================================ */
(function () {
    'use strict';

    var form = document.getElementById('form-checkout');
    if (!form) return;

    var COSTOS = { recojo: 0, delivery: 15, provincia: 25 };
    var ETIQUETAS = {
        recojo:   'RECOJO EN ALMACÉN — GRATIS',
        delivery: 'DELIVERY A LIMA — S/ 15.00',
        provincia:'ENVÍO A PROVINCIA — S/ 25.00'
    };
    var TIPO = ''; // se define al elegir opción de envío

    // Acceso al carrito (fuente única de verdad)
    var Carrito = window.Carrito || {
        obtener: function () { return []; },
        vaciar: function () { localStorage.removeItem('ot_carrito'); },
        formatoSoles: function (m) { return 'S/ ' + (m || 0).toFixed(2); }
    };

    function soles(m) { return Carrito.formatoSoles(m); }

    function generarNumero() {
        return 'OT-' + new Date().getFullYear() + '-' + (Math.floor(1000 + Math.random() * 9000));
    }

    function formatFecha() {
        var d = new Date();
        return d.getDate().toString().padStart(2, '0') + '/' +
               (d.getMonth() + 1).toString().padStart(2, '0') + '/' +
               d.getFullYear();
    }

    function escapar(txt) {
        return String(txt).replace(/[&<>"]/g, function (c) {
            return { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;' }[c];
        });
    }

    // Un campo dentro de un sub-bloque de envío no activo cuenta como oculto.
    // (No se puede confiar en offsetWidth: los sub-bloques usan max-height:0,
    //  que mantiene el ancho > 0.)
    function esVisible(el) {
        var caja = el.closest('.envio-campos');
        if (caja && !caja.classList.contains('visible')) return false;
        return !!(el.offsetWidth || el.offsetHeight || el.getClientRects().length);
    }

    /* --- Render dinámico del resumen del pedido --- */
    function renderResumen() {
        var items = Carrito.obtener();
        var cont = document.getElementById('resumen-productos');
        var elSub = document.getElementById('resumen-subtotal');
        var elEnvio = document.getElementById('resumen-envio');
        var elTotal = document.getElementById('resumen-total');

        var subtotal = 0;
        items.forEach(function (it) { subtotal += it.precio * it.cantidad; });
        var costoEnvio = TIPO ? (COSTOS[TIPO] || 0) : 0;
        var total = subtotal + costoEnvio;

        if (cont) {
            if (items.length === 0) {
                cont.innerHTML = '<p class="resumen-vacio">Tu carrito está vacío. ' +
                    '<a href="/catalogo.html">Ver catálogo</a></p>';
            } else {
                cont.innerHTML = items.map(function (it) {
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
            }
        }

        if (elSub) elSub.textContent = soles(subtotal);
        if (elEnvio) {
            if (!TIPO) {
                elEnvio.textContent = 'POR DEFINIR';
                elEnvio.classList.remove('envio-gratis-tag');
            } else {
                elEnvio.textContent = costoEnvio === 0 ? 'GRATIS' : soles(costoEnvio);
                elEnvio.classList.toggle('envio-gratis-tag', costoEnvio === 0);
            }
        }
        if (elTotal) elTotal.textContent = soles(total);

        return { items: items, subtotal: subtotal, costoEnvio: costoEnvio, total: total };
    }

    /* --- Validación por campo (input o select) --- */
    function validarInput(input) {
        var val = input.value.trim();
        var ok = val !== '';
        if (ok && input.type === 'email') {
            ok = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(val);
        }
        if (ok && input.id === 'co-numdoc') {
            var tipo = (document.getElementById('co-doc') || {}).value;
            if (tipo === 'DNI') ok = /^\d{8}$/.test(val);
            else if (tipo === 'RUC') ok = /^\d{11}$/.test(val);
            else ok = /^[A-Za-z0-9]{6,12}$/.test(val); // Carné de extranjería / Pasaporte
        }
        input.classList.toggle('campo-invalido', !ok);
        var msg = input.nextElementSibling;
        if (msg && msg.classList.contains('error-msg')) msg.style.display = ok ? 'none' : 'block';
        return ok;
    }

    // Valida los campos requeridos VISIBLES de un paso
    function validarPaso(paso) {
        var ok = true;
        var sel = '.paso[data-paso="' + paso + '"] input[required], ' +
                  '.paso[data-paso="' + paso + '"] select[required]';
        form.querySelectorAll(sel).forEach(function (c) {
            if (esVisible(c) && !validarInput(c)) ok = false;
        });
        return ok;
    }

    form.querySelectorAll('input[required]').forEach(function (inp) {
        inp.addEventListener('blur', function () { if (esVisible(this)) validarInput(this); });
        inp.addEventListener('input', function () {
            if (this.classList.contains('campo-invalido')) validarInput(this);
        });
    });
    form.querySelectorAll('select[required]').forEach(function (sel) {
        sel.addEventListener('change', function () { if (esVisible(this)) validarInput(this); });
    });

    // El número de documento se revalida al cambiar el tipo
    var selDoc = document.getElementById('co-doc');
    var inpNum = document.getElementById('co-numdoc');
    if (selDoc && inpNum) {
        selDoc.addEventListener('change', function () {
            inpNum.setAttribute('inputmode', (this.value === 'DNI' || this.value === 'RUC') ? 'numeric' : 'text');
            if (inpNum.value.trim() !== '') validarInput(inpNum);
        });
    }

    /* --- Poblar ubigeo (distritos de Lima, departamentos → provincias) --- */
    var ubigeo = null;
    function opt(v) { var o = document.createElement('option'); o.value = v; o.textContent = v; return o; }
    fetch('/js/peru-ubigeo.json')
        .then(function (r) { return r.json(); })
        .then(function (data) {
            ubigeo = data;
            var selDist = document.getElementById('co-distrito');
            if (selDist) data.distritosLima.forEach(function (d) { selDist.appendChild(opt(d)); });
            var selDep = document.getElementById('co-departamento');
            if (selDep) Object.keys(data.departamentos).forEach(function (dep) { selDep.appendChild(opt(dep)); });
        })
        .catch(function (e) { console.error('No se pudo cargar peru-ubigeo.json:', e); });

    var selDep = document.getElementById('co-departamento');
    var selProv = document.getElementById('co-provincia');
    if (selDep && selProv) {
        selDep.addEventListener('change', function () {
            selProv.innerHTML = '<option value="">Elige tu provincia</option>';
            var provs = (ubigeo && ubigeo.departamentos[this.value]) || [];
            provs.forEach(function (p) { selProv.appendChild(opt(p)); });
            selProv.disabled = provs.length === 0;
        });
    }

    /* --- Cambio de opción de envío: revela su sub-bloque y recalcula --- */
    var subbloques = form.querySelectorAll('.envio-campos');
    var errorEnvio = document.getElementById('envio-error');
    form.querySelectorAll('input[name="envio"]').forEach(function (radio) {
        radio.addEventListener('change', function () {
            TIPO = this.value;
            subbloques.forEach(function (b) {
                b.classList.toggle('visible', b.dataset.envio === TIPO);
            });
            if (errorEnvio) errorEnvio.style.display = 'none';
            renderResumen();
        });
    });

    /* --- Gating: "CONTINUAR" desbloquea el siguiente paso --- */
    function desbloquearSiguiente(paso) {
        var actual = form.querySelector('.paso[data-paso="' + paso + '"]');
        actual.classList.add('paso-completado');
        actual.classList.remove('paso-activo');
        var siguiente = form.querySelector('.paso[data-paso="' + (Number(paso) + 1) + '"]');
        if (siguiente) {
            siguiente.classList.remove('paso-bloqueado');
            siguiente.classList.add('paso-activo');
            siguiente.scrollIntoView({ behavior: 'smooth', block: 'center' });
        }
    }

    form.querySelectorAll('.btn-continuar').forEach(function (btn) {
        btn.addEventListener('click', function () {
            var paso = btn.dataset.continuar;
            if (paso === '2' && !TIPO) {
                if (errorEnvio) errorEnvio.style.display = 'block';
                return;
            }
            if (!validarPaso(paso)) {
                var primero = form.querySelector('.paso[data-paso="' + paso + '"] .campo-invalido');
                if (primero) primero.scrollIntoView({ behavior: 'smooth', block: 'center' });
                return;
            }
            desbloquearSiguiente(paso);
        });
    });

    // Reabrir un paso ya completado tocando su cabecera
    form.querySelectorAll('.paso-cabecera').forEach(function (cab) {
        cab.addEventListener('click', function () {
            var paso = cab.closest('.paso');
            if (paso.classList.contains('paso-completado')) {
                paso.classList.remove('paso-completado');
                paso.classList.add('paso-activo');
            }
        });
    });

    /* --- Envío del formulario --- */
    form.addEventListener('submit', function (e) {
        e.preventDefault();

        var resumen = renderResumen();
        if (resumen.items.length === 0) {
            alert('Tu carrito está vacío. Agrega productos antes de finalizar la compra.');
            window.location.href = '/catalogo.html';
            return;
        }

        if (!TIPO) {
            if (errorEnvio) errorEnvio.style.display = 'block';
            var paso2 = form.querySelector('.paso[data-paso="2"]');
            if (paso2) paso2.scrollIntoView({ behavior: 'smooth', block: 'center' });
            return;
        }

        var valido = true;
        form.querySelectorAll('input[required], select[required]').forEach(function (c) {
            if (esVisible(c) && !validarInput(c)) valido = false;
        });
        if (!valido) {
            var primero = form.querySelector('.campo-invalido');
            if (primero) primero.scrollIntoView({ behavior: 'smooth', block: 'center' });
            return;
        }

        var g = function (id) {
            var el = document.getElementById(id);
            return el ? el.value.trim() : '';
        };

        var radioPago = form.querySelector('input[name="pago"]:checked');

        var pedido = {
            numeroPedido:  generarNumero(),
            fecha:         formatFecha(),
            nombre:        g('co-nombre'),
            apellido:      g('co-apellido'),
            telefono:      g('co-telefono'),
            correo:        g('co-correo'),
            dni:           (g('co-doc') ? g('co-doc') + ' ' : '') + g('co-numdoc'),
            tipoEnvio:     TIPO,
            etiquetaEnvio: ETIQUETAS[TIPO],
            notas:         g('co-notas'),
            metodoPago:    radioPago ? radioPago.value : 'deposito',
            subtotal:      resumen.subtotal,
            costoEnvio:    resumen.costoEnvio,
            total:         resumen.total,
            productos:     resumen.items
        };

        if (TIPO === 'delivery') {
            pedido.distrito   = g('co-distrito');
            pedido.direccion  = g('co-direccion');
            pedido.referencia = g('co-referencia');
        } else if (TIPO === 'provincia') {
            pedido.departamento = g('co-departamento');
            pedido.provinciaLoc = g('co-provincia');
            pedido.agencia      = g('co-agencia');
        }

        localStorage.setItem('ot_pedido', JSON.stringify(pedido));
        Carrito.vaciar();
        window.location.href = '/confirmacion.html';
    });

    // Render inicial del resumen al cargar la página
    renderResumen();

}());
