package com.nash.bookworm.dto;

import com.nash.bookworm.entities.Userr;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private Long userId;
    private Date orderDate;
    private int orderAmount;
    private List<OrderItemDto> orderItems;
}
