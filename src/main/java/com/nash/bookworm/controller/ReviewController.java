package com.nash.bookworm.controller;

import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.dto.ReviewPage;
import com.nash.bookworm.entities.Review;
import com.nash.bookworm.services.BookService;
import com.nash.bookworm.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping("/reviews")
    public void saveReview(@RequestBody ReviewDto dto, HttpServletResponse response){
        service.saveReview(dto);
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
    }

    @GetMapping("/reviews")
    public ResponseEntity<ReviewPage> getReviewByBookId(@RequestParam long id, @RequestParam int page, @RequestParam int show, @RequestParam int star, @RequestParam int sort){
        return ResponseEntity.ok().body(service.getReviewPage(id, page, show, star, sort));
    }
}
