package com.nash.bookworm.services;

import com.nash.bookworm.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
}
