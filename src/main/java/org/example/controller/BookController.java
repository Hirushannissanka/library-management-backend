package org.example.controller;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")

@CrossOrigin
public class BookController {
    @Autowired
    BookService service;
    @PostMapping
    public void addBook(@RequestBody Book book){
        service.addBook(book);

    }
    @GetMapping("/get")
    public Iterable<BookEntity>getBooks(){
        return service.getBooks();
    }
    @GetMapping("/search/{id}")
    public BookEntity getById(@PathVariable Long id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        if(service.deleteBook(id)){
            return "Deleted";
        }else{
            return "Not Deleted";
        }
    }

}
