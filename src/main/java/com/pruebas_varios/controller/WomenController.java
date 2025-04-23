/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas_varios.controller;

import com.pruebas_varios.domain.Producto;
import com.pruebas_varios.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author leidy
 */
@Controller
public class WomenController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/women")
    public String womenPage(Model model) {
        List<Producto> productos = productoService.getProductosPorCategoria(2L); // ID de la categoría 'Woman'
        model.addAttribute("productos", productos);
        return "women";
    }
}
