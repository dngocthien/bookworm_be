package com.nash.bookworm.converter;

import com.nash.bookworm.dto.DiscountDto;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountConverter {
    @Autowired
    private BookRepo bookRepo;
    public DiscountDto toDto(Discount discount){
        DiscountDto dto = new DiscountDto();
        dto.setId(discount.getId());
        dto.setBookId(discount.getBook().getId());
        dto.setDiscountPrice(discount.getDiscountPrice());
        dto.setDiscountStartDate(discount.getDiscountStartDate());
        dto.setDiscountEndDate(discount.getDiscountEndDate());
        return dto;
    }

    public Discount toDiscount(DiscountDto dto){
        Discount discount = new Discount();
        discount.setBook(bookRepo.findById(dto.getBookId()).orElse(null));
        discount.setDiscountPrice(dto.getDiscountPrice());
        discount.setDiscountStartDate(dto.getDiscountStartDate());
        discount.setDiscountEndDate(dto.getDiscountEndDate());
        return discount;
    }
}
