package com.nash.bookworm.controller;

import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public ResponseEntity<BookPage> getBooksPage(@RequestParam("page") int page, @RequestParam("show") int show, @RequestParam int filter, @RequestParam int type) {
        BookPage bookPage = new BookPage();
        bookPage.setPage(page);
        bookPage.setTotalPage((int) Math.ceil(service.totalBook() / show));
        Pageable pageable = PageRequest.of(page, show);
        switch (type) {
            case 1:
                bookPage.setBooks(service.getBooksByCategory((long) filter, pageable));
                bookPage.setTotalBook(service.totalBook());
                break;
            case 2:
                bookPage.setBooks(service.getBooksByAuthor((long) filter, pageable));
                bookPage.setTotalBook(service.totalBook());
                break;
            default:
                bookPage.setBooks(service.getAllBooks(pageable));
                bookPage.setTotalBook(service.totalBook());
                break;
        }
        return ResponseEntity.ok().body(bookPage);
    }

//    @GetMapping("/books/category/{id}")
//    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String id) {
//        System.out.println("here");
//        return ResponseEntity.ok().body(service.getBooksByCategory(Long.parseLong(id)));
//    }
//
//    @GetMapping("/books/author/{id}")
//    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable String id) {
//        System.out.println("here");
//        return ResponseEntity.ok().body(service.getBooksByAuthor(Long.parseLong(id)));
//    }
}
