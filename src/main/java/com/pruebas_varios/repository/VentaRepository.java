package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository 
        extends JpaRepository<Venta, Long>{
    
}
