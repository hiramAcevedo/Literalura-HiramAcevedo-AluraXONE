package com.hiramwoki.literalura_hiramAcevedo.service;

import com.hiramwoki.literalura_hiramAcevedo.model.AutoresDTO;
import com.hiramwoki.literalura_hiramAcevedo.model.Libro;
import com.hiramwoki.literalura_hiramAcevedo.model.LibrosDTO;
import com.hiramwoki.literalura_hiramAcevedo.repository.LibroRepository;
import com.hiramwoki.literalura_hiramAcevedo.util.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {

    private final GutendexApiService apiService;
    private final LibroRepository libroRepository;

    public LibroServicio(GutendexApiService apiService, LibroRepository libroRepository) {
        this.apiService = apiService;
        this.libroRepository = libroRepository;
    }

    public List<LibrosDTO> buscarLibroPorTitulo(String titulo) throws IOException, InterruptedException {
        String jsonResponse = apiService.buscarLibroPorTitulo(titulo);
        return JsonParser.parseLibros(jsonResponse);
    }

    public void guardarLibro(LibrosDTO libroDTO) {
        Libro libro = new Libro(
                libroDTO.titulo(),
                libroDTO.autor().nombre(),
                libroDTO.idioma(),
                libroDTO.numeroDeDescargas()
        );
        libroRepository.save(libro);
    }

    public List<LibrosDTO> listarLibrosRegistrados() {
        return libroRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private LibrosDTO convertirADTO(Libro libro) {
        return new LibrosDTO(
                libro.getTitulo(),
                new AutoresDTO(libro.getAutor(), null, null), // Asumiendo que no guardamos fecha de nacimiento/muerte
                libro.getIdioma(),
                libro.getNumeroDeDescargas()
        );
    }
    public List<AutoresDTO> listarAutoresRegistrados() {
        return libroRepository.findAllAuthors().stream()
                .map(autor -> new AutoresDTO(autor, null, null))
                .collect(Collectors.toList());
    }

}
