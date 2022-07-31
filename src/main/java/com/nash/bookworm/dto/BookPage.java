package com.nash.bookworm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookPage {
    private int page;
    private int totalPage;
    private int totalBook;
    private List<BookDto> books = new ArrayList<>();
}
