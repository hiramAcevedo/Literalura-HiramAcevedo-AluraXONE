package com.hiramwoki.literalura_hiramAcevedo.principal;

import com.hiramwoki.literalura_hiramAcevedo.service.GutendexApiService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private final GutendexApiService gutendexApiService;
    private final Scanner scanner;

    public Principal(GutendexApiService gutendexApiService) {
        this.gutendexApiService = gutendexApiService;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        System.out.println("Bienvenido a LiterAlura!");

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarTodosLosLibros();
                    break;
                case 3:
                    listarLibrosPorIdioma();
                    break;
                case 4:
                    listarAutores();
                    break;
                case 5:
                    listarAutoresVivosPorAno();
                    break;
                case 6:
                    System.out.println("Gracias por usar LiterAlura. ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de LiterAlura ---");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar todos los libros");
        System.out.println("3. Listar libros por idioma");
        System.out.println("4. Listar autores");
        System.out.println("5. Listar autores vivos en un año específico");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        // TODO: Implementar la búsqueda de libro por título
        System.out.println("Buscando libro: " + titulo);
    }

    private void listarTodosLosLibros() {
        // TODO: Implementar listado de todos los libros
        System.out.println("Listando todos los libros...");
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el código de idioma (ej. en, es): ");
        String idioma = scanner.nextLine();
        // TODO: Implementar listado de libros por idioma
        System.out.println("Listando libros en idioma: " + idioma);
    }

    private void listarAutores() {
        // TODO: Implementar listado de autores
        System.out.println("Listando todos los autores...");
    }

    private void listarAutoresVivosPorAno() {
        System.out.print("Ingrese el año: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        // TODO: Implementar listado de autores vivos en un año específico
        System.out.println("Listando autores vivos en el año: " + ano);
    }

}
