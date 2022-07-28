package com.nash.bookworm.services.impl;

import com.nash.bookworm.entities.Book;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo repo;

    @Override
    public Book saveBook(Book book) {
        return repo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}
