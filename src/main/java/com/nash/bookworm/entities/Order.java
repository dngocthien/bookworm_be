package com.nash.bookworm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orderr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Userr userr;
    private Date orderDate;
    private int orderAmount;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderItem> orderItems = new ArrayList<>();
}
