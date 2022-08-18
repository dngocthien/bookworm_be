package com.nash.bookworm.controller;

import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public ResponseEntity<BookPage> getBooksPage(@RequestParam("page") int page, @RequestParam("show") int show, @RequestParam("filter") long filter, @RequestParam("type") int type, @RequestParam("sort") int sort) {
        return ResponseEntity.ok().body(service.getBookPage(page, show, filter, type, sort));
    }

    @GetMapping("/books/id/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long id){
        return ResponseEntity.ok().body(service.getBookById( id));
    }
}
