package com.nash.bookworm.dto;

import com.nash.bookworm.entities.Book;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class ReviewDto {
    private Long id;
    private Long bookId;
    private String reviewTitle;
    private String reviewDetails;
    private Date reviewDate;
    private int ratingStart;
}
