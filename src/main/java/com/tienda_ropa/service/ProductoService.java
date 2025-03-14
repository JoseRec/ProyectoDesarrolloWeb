package com.tienda_ropa.service;

import com.tienda_ropa.domain.Producto;
import com.tienda_ropa.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> getProductosByCategoria(int idCategoria) {
        return productoRepository.findByIdCategoria(idCategoria);
    }
}
