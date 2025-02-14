package com.example.blogCesur.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PalabrasProhibidas {
    @JsonProperty("palabrasProhibidas")
    private List<String> palabrasProhibidas;

    public List<String> getPalabrasProhibidas() {
        return palabrasProhibidas;
    }

    public void setPalabrasProhibidas(List<String> palabrasProhibidas) {
        this.palabrasProhibidas = palabrasProhibidas;
    }
}
