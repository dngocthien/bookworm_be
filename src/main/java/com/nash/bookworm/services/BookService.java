package com.nash.bookworm.services;

import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> getBooksByCategory(Long id);
    List<Book> getBooksByAuthor(Long id);

    void saveDiscount(Discount discount);
}
