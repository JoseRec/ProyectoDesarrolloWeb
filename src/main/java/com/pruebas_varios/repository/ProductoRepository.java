package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository 
        extends JpaRepository<Producto, Long>{

}
