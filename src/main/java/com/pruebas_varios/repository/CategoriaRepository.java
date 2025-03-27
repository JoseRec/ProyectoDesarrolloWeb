package com.pruebas_varios.repository;


import com.pruebas_varios.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository 
        extends JpaRepository<Categoria, Long>{
    
}
