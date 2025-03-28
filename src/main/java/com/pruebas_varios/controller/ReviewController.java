package com.pruebas_varios.controller;

import com.pruebas_varios.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;

 
@PostMapping("/agregar")
public String agregarReview(@RequestParam("idProducto") Long idProducto,
                            @RequestParam("nombre") String nombre,
                            @RequestParam("comentario") String comentario,
                            @RequestParam("calificacion") int calificacion) { 
    reviewService.crearReview(idProducto, nombre, comentario, calificacion);
    return "redirect:/pruebas/producto/" + idProducto;
}
}








