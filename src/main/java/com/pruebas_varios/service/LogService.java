/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas_varios.service;

/**
 *
 * @author leidy
 */
import com.pruebas_varios.domain.LogEvento;
import com.pruebas_varios.repository.LogEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogEventoRepository logEventoRepository;

    public void registrarEvento(String mensaje) {
        LogEvento evento = new LogEvento(mensaje);
        logEventoRepository.save(evento);
    }

}
