/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas_varios.controller;

/**
 *
 * @author leidy
 */

import com.pruebas_varios.domain.Producto;
import com.pruebas_varios.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewController {
     @Autowired
    private ProductoService productoService;

    @GetMapping("/new")
    public String newPage(Model model) {
        List<Producto> productos = productoService.getProductosPorCategoria(4L); 
        model.addAttribute("productos", productos);
        return "new";
    }
}
