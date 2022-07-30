package com.nash.bookworm.services.impl;

import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Category;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.CategoryRepo;
import com.nash.bookworm.repo.DiscountRepo;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> getBooksByCategory(Long id) {
        return bookRepo.findByCategoryId(id);
    }

    @Override
    public List<Book> getBooksByAuthor(Long id) {
        return bookRepo.findByAuthorId(id);
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
