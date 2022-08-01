package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.BookConverter;
import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Category;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.CategoryRepo;
import com.nash.bookworm.repo.DiscountRepo;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    public void saveBook(BookDto dto) {
        Book book = bookConverter.toBook(dto);
        bookRepo.save(book);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            return bookConverter.toDTO(book);
        }
        return null;
    }

    @Override
    public List<BookDto> getAllBooks(Pageable pageable) {
        List<Book> books = bookRepo.findAll(pageable).getContent();
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<BookDto> getBooksByCategory(Long id, Pageable pageable) {
        List<Book> books = bookRepo.findByCategoryId(id, pageable);
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    public List<BookDto> getBooksByCategory(Long id) {
        List<Book> books = bookRepo.findByCategoryId(id);
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<BookDto> getBooksByAuthor(Long id, Pageable pageable) {
        List<Book> books = bookRepo.findByAuthorId(id, pageable);
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookConverter.toDTO(book);
            results.add(dto);
        }
        return results;

    }

    public List<BookDto> getBooksByAuthor(Long id) {
        List<Book> books = bookRepo.findByAuthorId(id);
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
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

    @Override
    public BookPage getBookPage(int page, int show, long filter, int type) {
        BookPage bookPage = new BookPage();
        bookPage.setPage(page);
        Pageable pageable = PageRequest.of(page, show);
        List<BookDto> bookDtos;
        switch (type) {
            case 1:
                bookDtos = getBooksByCategory(filter, pageable);
                bookPage.setTotalPage((int) Math.ceil(bookDtos.size() / show));
                bookPage.setTotalBook(getBooksByCategory(filter).size());
                bookPage.setBooks(bookDtos);
                break;
            case 2:
                bookDtos = getBooksByAuthor(filter, pageable);
                bookPage.setTotalPage((int) Math.ceil(bookDtos.size() / show));
                bookPage.setTotalBook(getBooksByAuthor(filter).size());
                bookPage.setBooks(bookDtos);
                break;
            default:
                bookDtos = getAllBooks(pageable);
                bookPage.setTotalPage((int) Math.ceil(bookDtos.size() / show));
                bookPage.setTotalBook(bookDtos.size());
                bookPage.setBooks(bookDtos);
                break;
        }
        return bookPage;
    }

//    @Override
//    public void addDiscountToBook(Long id, Discount discount) {
////        Discount discount1 = discountRepo.save(discount);
////        repo.findById(id).ifPresent(book -> book.getDiscounts().add(discount1));
//    }
}
