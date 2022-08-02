package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.ReviewConverter;
import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.dto.ReviewPage;
import com.nash.bookworm.entities.Review;
import com.nash.bookworm.repo.ReviewRepo;
import com.nash.bookworm.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo repo;
    @Autowired
    private ReviewConverter converter;

    @Override
    public void saveReview(ReviewDto dto) {
        repo.save(converter.toReview((dto)));
    }

    @Override
    public ReviewPage getReviewPage(long id, int page, int show) {
        ReviewPage reviewPage = new ReviewPage();
        reviewPage.setPage(page);
        reviewPage.setTotalPage((int) Math.ceil(repo.findByBookId(id).size()/show));
        reviewPage.setTotalReview(repo.findByBookId(id).size());

        int a = repo.countByBookIdAndStar(id, 1);
        int b = repo.countByBookIdAndStar(id, 2);
        int c = repo.countByBookIdAndStar(id, 3);
        int d = repo.countByBookIdAndStar(id, 4);
        int e = repo.countByBookIdAndStar(id, 5);
        reviewPage.setOne(a);
        reviewPage.setTwo(b);
        reviewPage.setThree(c);
        reviewPage.setFour(d);
        reviewPage.setFive(e);
        if(a+b+c+d+e>0) {
            reviewPage.setStar((1 * a + 2 * b + 3 * c + 4 * d + 5 * e) / (a + b + c + d + e));
        }else{
            reviewPage.setStar(0);
        }

        Pageable pageable = PageRequest.of(page, show);
        List<Review> reviews = repo.findByBookId(id, pageable);
        reviewPage.getReviews().addAll(converter.toDtoList(reviews));
        return reviewPage;
    }
}
