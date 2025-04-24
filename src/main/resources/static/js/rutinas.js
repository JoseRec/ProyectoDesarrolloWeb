//funcion carga en el carrito un producto seleccionado por el usuario
function addCart(formulario) {
    var idProducto = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias > 0) {
        //Se incluye el producto en el carrito
        var ruta = "/carrito/agregar/"+idProducto
        $("#resultBlock").load(ruta)
    } else {
        window.alert("No hay existencias...");
    }
}