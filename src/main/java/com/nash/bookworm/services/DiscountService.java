package com.nash.bookworm.services;

import com.nash.bookworm.dto.DiscountDto;
import org.springframework.stereotype.Service;

@Service
public interface DiscountService {
    void saveDiscount(DiscountDto dto);
    DiscountDto getDiscountByBookId(Long id);
}
