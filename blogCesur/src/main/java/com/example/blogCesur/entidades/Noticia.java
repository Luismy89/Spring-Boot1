package com.example.blogCesur.entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity //crea una tabla en la base de datos con los campos que se le añadan
@Data //Para los getters y los setters
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    @Column(columnDefinition = "text")
    private String contenido;
    private String imagen;
    private Date fecha;
}
