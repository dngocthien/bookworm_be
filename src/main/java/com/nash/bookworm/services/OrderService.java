package com.nash.bookworm.services;

import com.nash.bookworm.dto.OrderDto;
import com.nash.bookworm.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void saveOrder(OrderDto order);
}
