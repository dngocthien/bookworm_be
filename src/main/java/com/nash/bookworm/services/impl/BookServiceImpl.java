package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.BookConverter;
import com.nash.bookworm.converter.ReviewConverter;
import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.entities.Review;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.CategoryRepo;
import com.nash.bookworm.repo.DiscountRepo;
import com.nash.bookworm.repo.ReviewRepo;
import com.nash.bookworm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
    private ReviewRepo reviewRepo;
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private ReviewConverter reviewConverter;

    @Override
    public void saveBook(BookDto dto) {
        Book book = bookConverter.toBook(dto);
        bookRepo.save(book);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            BookDto dto = bookConverter.toDTO(book);
            return dto;
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
    public void saveDiscount(Discount discount) {
        discountRepo.save(discount);
    }

    @Override
    public BookPage getBookPage(int page, int show, long filter, int type, int sort) {
        BookPage bookPage = new BookPage();
        bookPage.setPage(page);
        List<BookDto> bookDtos;

        List<Order> orders = new ArrayList<Order>();
        if (sort == 0) {
            Order byOnSale = new Order(Sort.Direction.DESC, "discount.discountPrice");
            orders.add(byOnSale);
            Order byPrice = new Order(Sort.Direction.ASC, "bookPrice");
            orders.add(byPrice);
        }
        Pageable pageable = PageRequest.of(page, show, Sort.by(orders));
        switch (type) {
            case 1:
                bookDtos = getBooksByCategory(filter, pageable);
                bookPage.setTotalPage((int) Math.ceil(getBooksByCategory(filter).size() / show));
                bookPage.setTotalBook(getBooksByCategory(filter).size());
                break;
            case 2:
                bookDtos = getBooksByAuthor(filter, pageable);
                bookPage.setTotalPage((int) Math.ceil(getBooksByAuthor(filter).size() / show));
                bookPage.setTotalBook(getBooksByAuthor(filter).size());
                break;
            default:
                bookDtos = getAllBooks(pageable);
                bookPage.setTotalPage((int) Math.ceil(bookRepo.findAll().size() / show));
                bookPage.setTotalBook(bookRepo.findAll().size());
                break;
        }
        bookPage.setBooks(bookDtos);
        return bookPage;
    }

//    @Override
//    public void addDiscountToBook(Long id, Discount discount) {
////        Discount discount1 = discountRepo.save(discount);
////        repo.findById(id).ifPresent(book -> book.getDiscounts().add(discount1));
//    }
}
