
package com.tienda_ropa.controller;
import com.tienda_ropa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriasService;

    @GetMapping("/new")
    public String news(Model model) {
        return "Categorias/new"; 
    }
    
      @GetMapping("/women")
    public String women(Model model) {  
        return "Categorias/women"; 
    }

    @GetMapping("/men")
    public String men(Model model) {  
        return "Categorias/men"; 
    }

     @GetMapping("/kids")
    public String kids(Model model) {  
        return "Categorias/kids"; 
    }
    
       @GetMapping("/season")
    public String season(Model model) {  
        return "Categorias/season"; 
    }


}
