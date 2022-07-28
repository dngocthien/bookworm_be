package com.nash.bookworm.services;

import com.nash.bookworm.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order saveOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getOrderByUserId(Long id);
}
