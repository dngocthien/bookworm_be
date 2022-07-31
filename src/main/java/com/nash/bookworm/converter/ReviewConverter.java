package com.nash.bookworm.converter;

import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    public ReviewDto toDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setBookId(review.getBook().getId());
        dto.setReviewTitle(review.getReviewTitle());
        dto.setReviewDetails(review.getReviewDetails());
        dto.setReviewDate(review.getReviewDate());
        dto.setRatingStart(review.getRatingStart());
        return dto;
    }
}
