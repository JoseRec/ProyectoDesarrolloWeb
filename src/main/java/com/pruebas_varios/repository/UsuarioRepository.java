package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por nombre de usuario
    Usuario findByUsername(String username);

    // Buscar usuario por nombre de usuario y contraseña
    Usuario findByUsernameAndPassword(String username, String Password);

    // Buscar usuario por nombre de usuario o correo
    Usuario findByUsernameOrCorreo(String username, String correo);

    // Verificar si existe un usuario por nombre de usuario o correo
    boolean existsByUsernameOrCorreo(String username, String correo);
}
