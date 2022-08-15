package com.nash.bookworm.controller;

import com.nash.bookworm.dto.OrderDto;
import com.nash.bookworm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public void saveOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);
    }
}
