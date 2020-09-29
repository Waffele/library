package chmielecki.a.library.services;

import chmielecki.a.library.domain.Book;

import java.util.Optional;

public interface BookService {


    public Book saveUpdateBook(Book book);
    public Book deleteBook(Book book);
    public Optional<Book> findBookById(Long id);
}
