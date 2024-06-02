package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

import java.util.Optional;

public interface BookService {
    void addBook(Book book);

    Iterable<BookEntity>getBooks();
    boolean deleteBook(Long id);

    BookEntity getById(long id);

}
