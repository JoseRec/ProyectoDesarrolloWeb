package com.pruebas_varios.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long idReview;
    
    @ManyToOne
    @JoinColumn(name = "id_producto") 
    private Producto producto;
    
    private String usuario;
    private String comentario;
    private int calificacion;
}
