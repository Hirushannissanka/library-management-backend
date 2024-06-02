package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void addBook(Book book) {
        BookEntity entity=mapper.convertValue(book,BookEntity.class);
        bookRepository.save(entity);

    }

    @Override
    public Iterable<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public BookEntity getById(long id) {
        Optional<BookEntity> byId = bookRepository.findById(id);
        return mapper.convertValue(byId,BookEntity.class);
    }


}
