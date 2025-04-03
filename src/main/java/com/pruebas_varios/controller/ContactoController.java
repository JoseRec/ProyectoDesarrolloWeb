package com.pruebas_varios.controller;

import com.pruebas_varios.service.CorreoService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactoController {

    @Autowired
    private CorreoService correoService;

    @GetMapping("/pruebas/contacto")
    public String mostrarFormulario() {
        return "pruebas/contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarFormulario(@RequestParam String nombre,
            @RequestParam String email,
            @RequestParam String mensaje) throws MessagingException {

        String asunto = "Nuevo mensaje de contacto";

        String contenidoHtml = "<h2>Mensaje de Contacto</h2>"
                + "<p><strong>Nombre:</strong> " + nombre + "</p>"
                + "<p><strong>Correo:</strong> " + email + "</p>"
                + "<p><strong>Mensaje:</strong></p><p>" + mensaje + "</p>";

        String correoAdministrador = "jose06yose@gmail.com"; // Cambia esto por el correo real del administrador

        correoService.enviarCorreoHtml(correoAdministrador, asunto, contenidoHtml);

        return "redirect:/pruebas/contacto";
    }
}
