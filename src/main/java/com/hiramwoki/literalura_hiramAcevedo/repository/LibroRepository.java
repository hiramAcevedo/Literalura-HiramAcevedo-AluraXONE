package com.hiramwoki.literalura_hiramAcevedo.repository;

import com.hiramwoki.literalura_hiramAcevedo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    //List<Libro> findAll(); implementado por defecto por JpaRepository

    @Query("SELECT DISTINCT l.autor FROM Libro l")
    List<String> findAllAuthors();

    List<Libro> findByIdioma(String idioma);

    @Query("SELECT DISTINCT l FROM Libro l WHERE l.anioNacimientoAutor <= :anio AND (l.anioFallecimientoAutor IS NULL OR l.anioFallecimientoAutor >= :anio)")
    List<Libro> findAutoresVivosPorAnio(int anio);

    Optional<Libro> findByTitulo(String titulo);
}
