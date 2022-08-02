package com.nash.bookworm.converter;

import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.entities.Review;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewConverter {
    @Autowired
    private BookRepo repo;
    public ReviewDto toDto(Review review) {
        System.out.println(review.getReviewTitle());
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setBookId(review.getBook().getId());
        dto.setReviewTitle(review.getReviewTitle());
        dto.setReviewDetails(review.getReviewDetails());
        dto.setReviewDate(review.getReviewDate());
        dto.setRatingStart(review.getRatingStar());
        return dto;
    }

    public Review toReview(ReviewDto dto) {
        Review review = new Review();
        review.setId(dto.getId());
        review.setBook(repo.findById(dto.getBookId()).orElse(null));
        review.setReviewTitle(dto.getReviewTitle());
        review.setReviewDetails(dto.getReviewDetails());
        review.setReviewDate(dto.getReviewDate());
        review.setRatingStar(dto.getRatingStart());
        return review;
    }

    public List<ReviewDto> toDtoList(List<Review> reviews){
        List<ReviewDto> results = new ArrayList<>();
        for(Review review: reviews){
            ReviewDto dto = toDto(review);
            results.add(dto);
        }
        return  results;
    }
}
