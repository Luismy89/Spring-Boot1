package com.example.blogCesur.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String autor;
    @Column(columnDefinition = "text")
    private String texto;
    private Date fecha;
    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private Boolean aprobado;
    @ManyToOne
    Noticia noticia;
}
