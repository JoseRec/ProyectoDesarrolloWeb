package com.pruebas_varios.controller;

import com.pruebas_varios.domain.Producto;
import com.pruebas_varios.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/men")
    public String menPage(Model model) {
        List<Producto> productos = productoService.getProductosPorCategoria(1L);
        model.addAttribute("productos", productos);
        return "men";
    }
}
