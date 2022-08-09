package com.nash.bookworm.services;

import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.dto.ReviewPage;
import com.nash.bookworm.entities.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    void saveReview(ReviewDto dto);
    ReviewPage getReviewPage(long id, int page, int show, int star, int sort);
}
