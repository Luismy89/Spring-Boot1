package com.example.blogCesur.repositorios;

import com.example.blogCesur.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNoticias extends JpaRepository<Noticia, Long> {
}
