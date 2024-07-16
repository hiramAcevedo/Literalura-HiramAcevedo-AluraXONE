package com.hiramwoki.literalura_hiramAcevedo.service;

import com.hiramwoki.literalura_hiramAcevedo.model.AutoresDTO;
import com.hiramwoki.literalura_hiramAcevedo.model.Libro;
import com.hiramwoki.literalura_hiramAcevedo.model.LibrosDTO;
import com.hiramwoki.literalura_hiramAcevedo.repository.LibroRepository;
import com.hiramwoki.literalura_hiramAcevedo.util.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
        Optional<Libro> libroExistente = libroRepository.findByTitulo(libroDTO.titulo());
        if (libroExistente.isEmpty()) {
            Libro libro = new Libro(
                    libroDTO.titulo(),
                    libroDTO.autor().nombre(),
                    libroDTO.idioma(),
                    libroDTO.numeroDeDescargas(),
                    libroDTO.autor().fechaNacimiento(),
                    libroDTO.autor().fechaFallecimiento()
            );
            libroRepository.save(libro);
            System.out.println("El libro '" + libroDTO.titulo() + "' ha sido guardado en la base de datos.");
        } else {
            System.out.println("El libro '" + libroDTO.titulo() + "' ya existe en la base de datos.");
        }
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

    public List<LibrosDTO> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public List<AutoresDTO> listarAutoresVivosPorAnio(int anio) {
        return libroRepository.findAutoresVivosPorAnio(anio).stream()
                .map(libro -> new AutoresDTO(libro.getAutor(), libro.getAnioNacimientoAutor(), libro.getAnioFallecimientoAutor()))
                .distinct()
                .collect(Collectors.toList());
    }

}
