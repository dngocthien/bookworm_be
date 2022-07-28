package com.nash.bookworm.services;

import com.nash.bookworm.entities.OrderItem;
import org.springframework.stereotype.Service;

@Service
public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long id);
}
