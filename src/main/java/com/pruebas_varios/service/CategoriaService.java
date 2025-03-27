package com.pruebas_varios.service;


import com.pruebas_varios.domain.Categoria;
import com.pruebas_varios.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaRepository.findAll();

        return lista;
    }
    
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        categoria =  categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
        return categoria;
    }
}
