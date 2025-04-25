/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas_varios.service;

/**
 *
 * @author leidy
 */
import com.pruebas_varios.domain.Marca;
import com.pruebas_varios.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getMarcas() {
        return marcaRepository.findAll();
    }

    public void save(Marca marca) {
        marcaRepository.save(marca);
    }

    public void delete(Marca marca) {
        marcaRepository.delete(marca);
    }

    public Marca getMarcaById(Long idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }

    public void delete(Long idMarca) {
        marcaRepository.deleteById(idMarca);
    }

}
