package com.tienda_ropa.controller;

import com.tienda_ropa.domain.Producto;
import com.tienda_ropa.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/producto/{id}")
    public String detalleProducto(@PathVariable int id, Model model) {
        Producto producto = productoService.getProductoById(id);
        if (producto == null) {
            return "redirect:/productos";
        }
        model.addAttribute("producto", producto);
        return "detalle_producto";
    }
}
