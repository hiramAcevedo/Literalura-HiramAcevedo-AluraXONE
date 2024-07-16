package com.hiramwoki.literalura_hiramAcevedo.util;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiramwoki.literalura_hiramAcevedo.model.AutoresDTO;
import com.hiramwoki.literalura_hiramAcevedo.model.LibrosDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<LibrosDTO> parseLibros(String json) throws IOException {
        JsonNode rootNode = objectMapper.readTree(json);
        JsonNode resultsNode = rootNode.path("results");
        List<LibrosDTO> libros = new ArrayList<>();

        for (JsonNode bookNode : resultsNode) {
            String titulo = bookNode.path("title").asText();
            String idioma = bookNode.path("languages").get(0).asText();
            int descargas = bookNode.path("download_count").asInt();

            JsonNode authorsNode = bookNode.path("authors");
            String nombreAutor = authorsNode.isEmpty() ? "Autor desconocido" : authorsNode.get(0).path("name").asText();

            AutoresDTO autor = new AutoresDTO(nombreAutor, null, null);
            libros.add(new LibrosDTO(titulo, autor, idioma, descargas));
        }

        return libros;
    }
}
