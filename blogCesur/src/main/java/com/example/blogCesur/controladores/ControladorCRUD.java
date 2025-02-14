package com.example.blogCesur.controladores;

import com.example.blogCesur.entidades.Noticia;
import com.example.blogCesur.repositorios.RepositorioComentarios;
import com.example.blogCesur.repositorios.RepositorioNoticias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ControladorCRUD {
    @Autowired
    private RepositorioNoticias repositorioNoticias;
    @Autowired
    private RepositorioComentarios repositorioComentarios;


    @GetMapping("/crud/noticias")
    public String crud(Model model){
        model.addAttribute("noticias", repositorioNoticias.findAll());
        return "listaNoticias";
    }

    @GetMapping("/crud/noticias/{id}/comentarios")
    public String crudComentarios(@PathVariable long id, Model model){
        Optional<Noticia> noticia = repositorioNoticias.findById(id);
        if (noticia.isPresent()) {
            model.addAttribute("noticia", noticia.get());
            model.addAttribute("comentarios", repositorioComentarios.findByNoticia(noticia.get()));
        }
        return "listaComentarios";
    }

    @Transactional
    @PostMapping("/crud/noticias/{noticiaId}/comentarios/desaprobar")
    public String desaprobarComentario(@PathVariable long noticiaId, @RequestParam long comentarioId){
        repositorioComentarios.desaprobarComentario(comentarioId);
        return  "redirect:/crud/noticias/"+ noticiaId + "/comentarios";
    }

    @GetMapping("/crud/noticias/insertar")
    public String muestraFormulario(Model model){
        Noticia noticia = new Noticia();
        noticia.setFecha(Date.valueOf(LocalDate.now()));
        model.addAttribute("noticia", new Noticia());
        return "formularioNoticias";
    }

    @PostMapping("/crud/noticias/insertar")
    public String recibeDatosFormulario(@ModelAttribute Noticia noticia){
        String redireccion = noticia.getId()==0 ? "redirect:/crud/noticias/insertar" : "redirect:/crud/noticias";
        repositorioNoticias.save(noticia);
        return redireccion;
    }

    @GetMapping("/crud/noticias/modificar/{id}")
    public String modificarNoticia(@PathVariable long id, Model model){
        Optional<Noticia> noticia = repositorioNoticias.findById(id);
        if (noticia.isPresent()){
            model.addAttribute("noticia", noticia.get());
            return "formularioNoticias";
        }
        return "redirect:/crud/noticias";
    }

    @GetMapping("/crud/noticias/eliminar/{id}")
    @Transactional
    public String eliminarNoticia(@PathVariable long id) {
        repositorioComentarios.deleteByNoticiaId(id);
        repositorioNoticias.deleteById(id);
        return "redirect:/crud/noticias";
    }
}
