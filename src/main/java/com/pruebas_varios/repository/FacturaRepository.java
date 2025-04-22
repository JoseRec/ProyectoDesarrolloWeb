package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository 
        extends JpaRepository<Factura, Long>{
    
}
