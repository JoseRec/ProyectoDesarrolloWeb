package com.tienda_ropa.repository;
import com.tienda_ropa.domain.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoriaRepository extends JpaRepository<Categorias,Long> {
    
}
