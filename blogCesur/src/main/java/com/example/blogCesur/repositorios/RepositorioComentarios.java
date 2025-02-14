package com.example.blogCesur.repositorios;

import com.example.blogCesur.entidades.Comentario;
import com.example.blogCesur.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioComentarios extends JpaRepository<Comentario, Long> {
    public List<Comentario> findByNoticia(Noticia noticia);
    public void deleteByNoticiaId(long noticiaId);
    @Modifying
    @Query("UPDATE Comentario comentario SET comentario.aprobado = false WHERE comentario.id = :id")
    public void desaprobarComentario(@Param("id") long id);
    //public int countComentarioBy(Noticia noticia)
}
