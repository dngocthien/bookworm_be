package com.nash.bookworm.services.impl;

import com.nash.bookworm.dto.OrderDto;
import com.nash.bookworm.dto.OrderItemDto;
import com.nash.bookworm.entities.Order;
import com.nash.bookworm.entities.OrderItem;
import com.nash.bookworm.entities.Userr;
import com.nash.bookworm.repo.BookRepo;
import com.nash.bookworm.repo.OrderRepo;
import com.nash.bookworm.repo.UserRepo;
import com.nash.bookworm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void saveOrder(OrderDto dto) {
        System.out.println(dto.toString());
        Order order = new Order();
        Userr u = userRepo.findById(dto.getUserId()).orElse(new Userr());
        order.setUserr(u);
        order.setOrderDate(dto.getOrderDate());
        order.setOrderAmount(dto.getOrderAmount());

        OrderItem orderItem = new OrderItem();
        for (OrderItemDto itemDto : dto.getOrderItems()) {
            orderItem.setBook(bookRepo.findById(itemDto.getBookId()).orElse(null));
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setPrice(itemDto.getPrice());
            order.getOrderItems().add(orderItem);
        }
        orderRepo.save(order);
    }
}
