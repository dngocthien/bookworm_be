package com.nash.bookworm.dto;

import com.nash.bookworm.entities.Author;
import com.nash.bookworm.entities.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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
}
