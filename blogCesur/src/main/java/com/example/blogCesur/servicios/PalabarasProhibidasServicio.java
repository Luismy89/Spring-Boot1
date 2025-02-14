package com.example.blogCesur.servicios;

import com.example.blogCesur.entidades.PalabrasProhibidas;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PalabarasProhibidasServicio {

    public List<String> cargarPalabrasProhibidas(String filePath) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        PalabrasProhibidas palabrasProhibidas = objectMapper.readValue(new File(filePath), PalabrasProhibidas.class);
        return palabrasProhibidas.getPalabrasProhibidas();
    }
}
