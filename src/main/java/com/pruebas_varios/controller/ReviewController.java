package com.pruebas_varios.controller;


import com.pruebas_varios.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pruebas_varios.domain.Usuario;
import com.pruebas_varios.service.UsuarioService;


@Controller
@RequestMapping("/reviews")
public class ReviewController {
//    
//    @Autowired
//    private ReviewService reviewService;
//
// 
//@PostMapping("/agregar")
//public String agregarReview(@RequestParam("idProducto") Long idProducto,
//                            @RequestParam("nombre") String nombre,
//                            @RequestParam("comentario") String comentario,
//                            @RequestParam("calificacion") int calificacion) { 
//    reviewService.crearReview(idProducto, nombre, comentario, calificacion);
//    return "redirect:/pruebas/producto/" + idProducto;
//}

    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    
    
//    @PostMapping("/agregar")
//    public String agregarReview(@RequestParam("idProducto") Long idProducto,
//                                @RequestParam("comentario") String comentario,
//                                @RequestParam("calificacion") int calificacion,
//                                @AuthenticationPrincipal UserDetails userDetails) {
//        // Obtenemos el username del usuario autenticado
//        String username = userDetails.getUsername();
//        // Buscamos el objeto Usuario completo mediante el servicio
//        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
//        
//        // Creamos la review asociando el producto y el usuario
//        reviewService.crearReview(idProducto, usuario, comentario, calificacion);
//        return "redirect:/pruebas/producto/" + idProducto;
//
//
//
//}
    
    @PostMapping("/agregar")
public String agregarReview(@RequestParam("idProducto") Long idProducto,
                            @RequestParam("comentario") String comentario,
                            @RequestParam("calificacion") int calificacion) {
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName(); // nombre de usuario del autenticado
    Usuario usuario = usuarioService.getUsuarioPorUsername(username);

    if (usuario != null) {
        reviewService.crearReview(idProducto, usuario, comentario, calificacion);
    }

    return "redirect:/pruebas/producto/" + idProducto;
}

}






