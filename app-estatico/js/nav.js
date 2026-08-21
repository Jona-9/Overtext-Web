(function () {
    var btn = document.getElementById('btn-hamburger');
    var menu = document.querySelector('.menu-principal');
    if (!btn || !menu) return;

    btn.addEventListener('click', function () {
        btn.classList.toggle('abierto');
        menu.classList.toggle('abierto');
    });

    // Tocar el fondo oscurecido (pseudo-elemento del menú) cierra el menú
    menu.addEventListener('click', function (e) {
        if (e.target === menu) {
            btn.classList.remove('abierto');
            menu.classList.remove('abierto');
        }
    });

    menu.querySelectorAll('.enlace').forEach(function (link) {
        link.addEventListener('click', function () {
            btn.classList.remove('abierto');
            menu.classList.remove('abierto');
        });
    });
}());
