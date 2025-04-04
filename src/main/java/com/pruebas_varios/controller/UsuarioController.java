package com.pruebas_varios.controller;

import com.pruebas_varios.domain.Usuario;
import com.pruebas_varios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    // Listado de todos los usuarios
    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }

    // Formulario para crear un nuevo usuario
    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

    // Guardar usuario, incluyendo la carga de una imagen (si existe)
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario, 
            @RequestParam(value = "imagenFile", required = false) MultipartFile imagenFile) {
        if (imagenFile != null && !imagenFile.isEmpty()) {
            usuarioService.save(usuario, false);
            // Implementación futura para subir imagen a Firebase
            // usuario.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "usuario", usuario.getIdUsuario()));
        }
        usuarioService.save(usuario, true);
        return "redirect:/usuario/listado";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    // Modificar usuario
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
