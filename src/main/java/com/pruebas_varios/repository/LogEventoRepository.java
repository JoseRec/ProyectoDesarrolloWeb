/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebas_varios.repository;

/**
 *
 * @author leidy
 */
import com.pruebas_varios.domain.LogEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEventoRepository extends JpaRepository<LogEvento, Long> {
}
