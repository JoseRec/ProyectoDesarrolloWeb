package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Consulta para obtener productos de una categoría específica
    List<Producto> findByCategoria_IdCategoria(Long idCategoria);
}
