package com.nash.bookworm.dto;

import com.nash.bookworm.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
    private Long id;
    private Long bookId;
    private Date discountStartDate;
    private Date discountEndDate;
    private int discountPrice;
}
