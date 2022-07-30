package com.nash.bookworm.controller;

import com.nash.bookworm.entities.Book;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(service.getAllBooks());
    }

    @GetMapping("/books/category/{id}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String id){
        System.out.println("here");
        return ResponseEntity.ok().body(service.getBooksByCategory(Long.parseLong(id)));
    }

    @GetMapping("/books/author/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable String id){
        System.out.println("here");
        return ResponseEntity.ok().body(service.getBooksByAuthor(Long.parseLong(id)));
    }
}
