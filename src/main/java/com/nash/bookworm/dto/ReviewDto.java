package com.nash.bookworm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private Long bookId;
    private String reviewTitle;
    private String reviewDetails;
    private Date reviewDate;
    private int ratingStar;
}
