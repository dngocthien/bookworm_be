package com.nash.bookworm.entities;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "discount")
@Data
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Date discountStartDate;
    private Date discountEndDate;
    private int discountPrice;

}
