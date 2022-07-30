package com.nash.bookworm.controller;

import com.nash.bookworm.entities.Author;
import com.nash.bookworm.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return ResponseEntity.ok().body(authorService.getAllAuthors());
    }
}
