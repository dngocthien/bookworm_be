package com.nash.bookworm.converter;

import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.entities.Book;
import com.nash.bookworm.entities.Review;
import com.nash.bookworm.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookConverter {
    @Autowired
    private ReviewConverter reviewConverter;
    @Autowired
    private DiscountService discountService;
    public BookDto toDTO(Book book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setCategory((book.getCategory()));
        dto.setAuthor(book.getAuthor());
        dto.setBookTitle(book.getBookTitle());
        dto.setBookSummary(book.getBookSummary());
        dto.setBookPrice(book.getBookPrice());
        dto.setBookCoverPhoto(book.getBookCoverPhoto());
        dto.setDiscount(discountService.getDiscountByBookId(book.getId()));

        List<Review> reviews = book.getReviews();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for(Review review: reviews){
            ReviewDto reviewDto = reviewConverter.toDto(review);
            reviewDtos.add(reviewDto);
        }
        dto.setReviews(reviewDtos);
        return dto;
    }

    public Book toBook(BookDto dto){
        Book book = new Book();
        book.setCategory((dto.getCategory()));
        book.setAuthor(dto.getAuthor());
        book.setBookTitle(dto.getBookTitle());
        book.setBookSummary(dto.getBookSummary());
        book.setBookPrice(dto.getBookPrice());
        book.setBookCoverPhoto(dto.getBookCoverPhoto());
        return book;
    }

    public List<BookDto> toDtoList(List<Book> books){
        List<BookDto> results = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = toDTO(book);
            results.add(dto);
        }
        return results;
    }
}
