package com.nash.bookworm.services;

import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.entities.Discount;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void saveBook(BookDto book);
    BookDto getBookById(Long id);
    List<BookDto> getAllBooks(Pageable pageable);
    List<BookDto> getBooksByCategory(Long id, Pageable pageable);
    List<BookDto> getBooksByAuthor(Long id, Pageable pageable);
    int totalBook();

    void saveDiscount(Discount discount);

    BookPage getBookPage(int page, int show, long filter, int type);
}
