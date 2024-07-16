package com.hiramwoki.literalura_hiramAcevedo.principal;

import com.hiramwoki.literalura_hiramAcevedo.model.AutoresDTO;
import com.hiramwoki.literalura_hiramAcevedo.model.LibrosDTO;
import com.hiramwoki.literalura_hiramAcevedo.service.LibroServicio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private final LibroServicio libroServicio;
    private final Scanner scanner;

    public Principal(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        System.out.println("Bienvenido a LiterAlura!");

        while (true) {
            mostrarMenu();
            String opcionStr = scanner.nextLine().trim();

            if (opcionStr.equals("0")) {
                System.out.println("Gracias por usar LiterAlura. ¡Hasta pronto!");
                break;
            }

            try {
                int opcion = Integer.parseInt(opcionStr);
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de LiterAlura ---");
        System.out.println("1- buscar libro por titulo");
        System.out.println("2- listar libros registrados");
        System.out.println("3- listar autores registrados");
        System.out.println("4- listar autores vivos en un determinado año");
        System.out.println("5- listar libros por idioma");
        System.out.println("0 - salir");
        System.out.print("Elija la opción a través de su número: ");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                buscarLibroPorTitulo();
                break;
            case 2:
                listarLibrosRegistrados();
                break;
            case 3:
                listarAutoresRegistrados();
                break;
            case 4:
                System.out.println("Funcionalidad aún no implementada");
                break;
            case 5:
                System.out.println("Funcionalidad aún no implementada");
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String titulo = scanner.nextLine().trim();
        try {
            List<LibrosDTO> libros = libroServicio.buscarLibroPorTitulo(titulo);
            if (!libros.isEmpty()) {
                System.out.println("\n----- LIBROS ENCONTRADOS -----");
                int count = 0;
                for (LibrosDTO libro : libros) {
                    if (count >= 5) break;
                    System.out.println("Título: " + libro.titulo());
                    System.out.println("Autor: " + libro.autor().nombre());
                    System.out.println("Idioma: " + libro.idioma());
                    System.out.println("Número de descargas: " + libro.numeroDeDescargas());
                    System.out.println("-----------------------------");
                    count++;
                }
                if (libros.size() > 5) {
                    System.out.println("Se encontraron " + libros.size() + " resultados. Mostrando los primeros 5.");
                }

                // Guardar el primer libro en la base de datos
                LibrosDTO libroAGuardar = libros.get(0);
                libroServicio.guardarLibro(libroAGuardar);
                System.out.println("El libro '" + libroAGuardar.titulo() + "' ha sido guardado en la base de datos.");
            } else {
                System.out.println("No se encontraron libros con ese título.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
        }
    }

    private void listarLibrosRegistrados() {
        List<LibrosDTO> libros = libroServicio.listarLibrosRegistrados();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("\n----- LIBROS REGISTRADOS -----");
            for (LibrosDTO libro : libros) {
                System.out.println("Título: " + libro.titulo());
                System.out.println("Autor: " + libro.autor().nombre());
                System.out.println("Idioma: " + libro.idioma());
                System.out.println("Número de descargas: " + libro.numeroDeDescargas());
                System.out.println("-----------------------------");
            }
        }
    }

    private void listarAutoresRegistrados() {
        List<AutoresDTO> autores = libroServicio.listarAutoresRegistrados();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            System.out.println("\n----- AUTORES REGISTRADOS -----");
            for (AutoresDTO autor : autores) {
                System.out.println("Nombre: " + autor.nombre());
                System.out.println("-----------------------------");
            }
        }
    }

}
