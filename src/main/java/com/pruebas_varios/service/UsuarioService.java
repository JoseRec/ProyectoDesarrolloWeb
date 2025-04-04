package com.pruebas_varios.service;

import com.pruebas_varios.domain.Usuario;
import com.pruebas_varios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
    }

    // Obtener un usuario por su nombre de usuario
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Obtener un usuario por su nombre de usuario y contraseña
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    // Obtener un usuario por su nombre de usuario o correo
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioRepository.findByUsernameOrCorreo(username, correo);
    }

    // Verificar si un usuario con el nombre de usuario o correo ya existe
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioRepository.existsByUsernameOrCorreo(username, correo);
    }

    // Guardar un usuario
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    @Transactional
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
