package com.tienda_ropa.service;

import com.tienda_ropa.domain.Categorias;
import com.tienda_ropa.repository.CategoriaRepository;
import com.tienda_ropa.domain.Categorias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriasRepository;

    @Transactional(readOnly = true)
    public List<Categorias> getCategorias(boolean activos) {
        return categoriasRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Categorias getCategoria(Categorias categoria) {
        return categoriasRepository.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    public void delete(Categorias categoria) {
        categoriasRepository.delete(categoria);
    }
    
    public void save(Categorias categoria) {
        categoriasRepository.save(categoria);
    }
}

