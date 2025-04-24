package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByCategoria_IdCategoria(Long idCategoria);
    
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    
}
