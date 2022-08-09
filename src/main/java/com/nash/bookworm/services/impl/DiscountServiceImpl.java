package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.DiscountConverter;
import com.nash.bookworm.dto.DiscountDto;
import com.nash.bookworm.entities.Discount;
import com.nash.bookworm.repo.DiscountRepo;
import com.nash.bookworm.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountConverter converter;
    @Autowired
    private DiscountRepo repo;

    @Override
    public void saveDiscount(DiscountDto dto) {
        repo.save(converter.toDiscount(dto));
    }

    @Override
    public DiscountDto getDiscountByBookId(Long id) {
        Discount discount = repo.findByBookId(id);
        if (discount != null) {
            return converter.toDto(discount);
        }
        return null;
    }
}
