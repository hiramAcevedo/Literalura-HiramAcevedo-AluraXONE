package com.hiramwoki.literalura_hiramAcevedo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String idioma;

    @Column(name = "numero_descargas")
    private int numeroDeDescargas;

    @Column(name = "anio_nacimiento_autor")
    private Integer anioNacimientoAutor;

    @Column(name = "anio_fallecimiento_autor")
    private Integer anioFallecimientoAutor;

    public Libro() {}

    public Libro(String titulo, String autor, String idioma, int numeroDeDescargas, Integer anioNacimientoAutor, Integer anioFallecimientoAutor) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
        this.anioNacimientoAutor = anioNacimientoAutor;
        this.anioFallecimientoAutor = anioFallecimientoAutor;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public String getIdioma() {
        return idioma;
    }


    public int getNumeroDeDescargas() {
        return numeroDeDescargas;
    }


    public Integer getAnioNacimientoAutor() {
        return anioNacimientoAutor;
    }


    public Integer getAnioFallecimientoAutor() {
        return anioFallecimientoAutor;
    }

}
