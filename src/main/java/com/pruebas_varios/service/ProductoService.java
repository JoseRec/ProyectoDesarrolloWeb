package com.pruebas_varios.service;

import com.pruebas_varios.domain.Producto;
import com.pruebas_varios.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoRepository.findById(producto.getIdProducto()).orElse(null);
    }

    @Transactional(readOnly = true)
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorCategoria(Long idCategoria) {
        return productoRepository.findByCategoria_IdCategoria(idCategoria);
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Transactional
    public void save(Producto producto) {
        productoRepository.save(producto);
    }
}
