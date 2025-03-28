package com.pruebas_varios.repository;

import com.pruebas_varios.domain.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductoIdProducto(Long idProducto);
}
