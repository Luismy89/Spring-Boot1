package com.example.blogCesur.servicios;

import java.util.List;

public class ValidadorComentario {

    private final List<String> palabrasProhibidas;

    public ValidadorComentario(List<String> palabrasProhibidas) {
        this.palabrasProhibidas = palabrasProhibidas;
    }

    public boolean contienePalabraProhibida(String comentario){
        for (String palabra : palabrasProhibidas){
            if(comentario.toLowerCase().contains(palabra.toLowerCase())){
                return true;
            }
        }
        return false;
    }


}
