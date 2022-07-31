package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.BookConverter;
import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Category;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.CategoryRepo;
import com.nash.bookworm.repo.DiscountRepo;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BookConverter bookConverter;

    @Override
    public Book saveBook(BookDto dto) {
        Book book = bookConverter.toBook(dto);
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks(Pageable pageable) {
        List<Book> books = bookRepo.findAll(pageable).getContent();
        List<BookDto> results = new ArrayList<>();
        for(Book book: books){
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<BookDto> getBooksByCategory(Long id, Pageable pageable) {
        List<Book> books = bookRepo.findByCategoryId(id, pageable);
        List<BookDto> results = new ArrayList<>();
        for(Book book: books){
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<BookDto> getBooksByAuthor(Long id, Pageable pageable) {
        List<Book> books = bookRepo.findByAuthorId(id, pageable);
        List<BookDto> results = new ArrayList<>();
        for(Book book: books){
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalBook() {
        return (int) bookRepo.count();
    }

    @Override
    public void saveDiscount(Discount discount) {
        discountRepo.save(discount);
    }

//    @Override
//    public void addDiscountToBook(Long id, Discount discount) {
////        Discount discount1 = discountRepo.save(discount);
////        repo.findById(id).ifPresent(book -> book.getDiscounts().add(discount1));
//    }
}
