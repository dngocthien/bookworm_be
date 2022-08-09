package com.nash.bookworm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReviewPage {
    private int page;
    private int totalPage;
    private int totalReview;
    private float star;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private List<ReviewDto> reviews = new ArrayList<>();
}
