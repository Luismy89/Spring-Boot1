package com.example.blogCesur.controladores;

import com.example.blogCesur.entidades.Comentario;
import com.example.blogCesur.entidades.Noticia;
import com.example.blogCesur.servicios.PalabarasProhibidasServicio;
import com.example.blogCesur.repositorios.RepositorioComentarios;
import com.example.blogCesur.repositorios.RepositorioNoticias;
import com.example.blogCesur.servicios.ValidadorComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ControladorPrincipal {
    @Autowired
    private RepositorioNoticias repositorioNoticias;
    @Autowired
    private RepositorioComentarios repositorioComentarios;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("noticias", repositorioNoticias.findAll(Sort.by(Sort.Direction.DESC, "fecha")));
        return "index";
    }
    @GetMapping("/noticia/{id}")
    public String mostrarNoticia(@PathVariable long id, Model model) {
        Optional<Noticia> noticia = repositorioNoticias.findById(id);
        if (noticia.isPresent()) {
            model.addAttribute("noticia", noticia.get());
            Comentario comentario = new Comentario();
            comentario.setFecha(Date.valueOf(LocalDate.now()));
            comentario.setAprobado(true);
            comentario.setNoticia(noticia.get());
            model.addAttribute("comentario", comentario);
            model.addAttribute("comentarios", repositorioComentarios.findByNoticia(noticia.get()));

            return "verNoticia";
        }
        return "redirect:/crud/noticias";
    }

    @PostMapping("/comentar")
    public String comentar(@ModelAttribute Comentario comentario, Model model) /*throws IOException*/ {
        repositorioComentarios.save(comentario);


        return "redirect:/noticia/"+comentario.getNoticia().getId();
    }
}
