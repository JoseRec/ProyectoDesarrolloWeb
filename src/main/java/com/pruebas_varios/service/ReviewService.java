package com.pruebas_varios.service;

import com.pruebas_varios.domain.Review;
import java.util.List;

public interface ReviewService {
    Review guardarReview(Review review);
    List<Review> obtenerReviewsPorProducto(Long idProducto);
    Review crearReview(Long idProducto, String usuario, String comentario, int calificacion);
}
