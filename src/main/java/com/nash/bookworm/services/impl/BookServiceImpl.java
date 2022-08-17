package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.BookConverter;
import com.nash.bookworm.converter.ReviewConverter;
import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.entities.Book;
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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
    @Transactional
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
    public BookPage getBookPage(int page, int show, long filter, int type, int sort) {
        BookPage bookPage = new BookPage();
        bookPage.setPage(page);

        List<Order> orders = new ArrayList<Order>();
        Order byPrice = new Order(Sort.Direction.ASC, "bookPrice");
        switch (sort) {
            case 1: //sort by highest average rating star
                Order byRecommended = new Order(Sort.Direction.DESC, "recommended");
                orders.add(byRecommended);
                break;
            case 2: //sort by highest number of review
                Order byPopularity = new Order(Sort.Direction.DESC, "popular");
                orders.add(byPopularity);
                orders.add(byPrice);
                break;
            case 3: //sort by final price asc
                Order byFinalPriceLowest = new Order(Sort.Direction.ASC, "finalPrice");
                orders.add(byFinalPriceLowest);
                break;
            case 4: //sort by final price desc
                Order byFinalPriceHighest = new Order(Sort.Direction.DESC, "finalPrice");
                orders.add(byFinalPriceHighest);
                break;
            case 0: //sort by most discount price
                Order byOnSale = new Order(Sort.Direction.DESC, "sale");
                orders.add(byOnSale);
                orders.add(byPrice);
                break;
        }
        Pageable pageable = PageRequest.of(page, show, Sort.by(orders));
        int size;
        List<Book> books;
        switch (type) {
            case 1: //by Category
                books = bookRepo.findByCategoryId(filter, pageable);
                size = bookRepo.findByCategoryId(filter).size();
                bookPage.setTotalPage((int) Math.ceil(size / show));
                bookPage.setTotalBook(size);
                break;
            case 2: //by Author
                books = bookRepo.findByAuthorId(filter, pageable);
                size = bookRepo.findByAuthorId(filter).size();
                bookPage.setTotalPage((int) Math.ceil(size / show));
                bookPage.setTotalBook(size);
                break;
            default:
                books = bookRepo.findAll(pageable).getContent();
                size = bookRepo.findAll().size();
                bookPage.setTotalPage((int) Math.ceil(size / show));
                bookPage.setTotalBook(size);
                break;
        }
        bookPage.setBooks(bookConverter.toDtoList(books));
        return bookPage;
    }
}
