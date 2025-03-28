package com.pruebas_varios.service;

import com.pruebas_varios.domain.Producto;
import com.pruebas_varios.domain.Review;
import com.pruebas_varios.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductoService productoService; 

    @Override
    public Review guardarReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> obtenerReviewsPorProducto(Long idProducto) {
 
        return reviewRepository.findByProductoIdProducto(idProducto);
    }

    @Override
    public Review crearReview(Long idProducto, String usuario, String comentario, int calificacion) {
  
        Producto producto = productoService.getProductoById(idProducto);
        if (producto == null) {
            return null; 
        }
        Review nuevaReview = new Review();
        nuevaReview.setProducto(producto);
        nuevaReview.setUsuario(usuario);
        nuevaReview.setComentario(comentario);
        nuevaReview.setCalificacion(calificacion);
        return guardarReview(nuevaReview);
    }
}
