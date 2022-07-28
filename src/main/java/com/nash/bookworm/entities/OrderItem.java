package com.nash.bookworm.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private int quantity;
    private int price;
}
