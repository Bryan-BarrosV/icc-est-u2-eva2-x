package controllers;

import models.Book;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LibroController {

    public Set<Book> procesarLibros(List<Book> libros) {
        Comparator<Book> comparador = new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int comparacionTitulo = b2.getTitulo().compareTo(b1.getTitulo());
                if (comparacionTitulo != 0) {
                    return comparacionTitulo;
                }
                int comparacionAnio = Integer.compare(b1.getAnio(), b2.getAnio());
                if (comparacionAnio == 0) {
                    return 0; // Duplicados: mismo título y año
                }
                return comparacionAnio;
            }
        };

        Set<Book> librosOrdenados = new TreeSet<>(comparador);
        for (Book libro : libros) {
            librosOrdenados.add(libro);
        }
        return librosOrdenados;
    }
}
