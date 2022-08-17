package com.nash.bookworm.dto;

import com.nash.bookworm.entities.Author;
import com.nash.bookworm.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private Category category;
    private Author author;
    private String bookTitle;
    private String bookSummary;
    private int bookPrice;
    private String bookCoverPhoto;
    private DiscountDto discount;
    private List<ReviewDto> reviews = new ArrayList<>();

    public BookDto(Long o, Category category, Author author, String title,  String summary, int price, String photo) {
        this.id = null;
        this.category = category;
        this.author = author;
        this.bookTitle = title;
        this.bookSummary = summary;
        this.bookPrice = price;
        this.bookCoverPhoto = photo;
    }
}
