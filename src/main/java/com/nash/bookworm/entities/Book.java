package com.nash.bookworm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private String bookTitle;
    @Lob
    private String bookSummary;
    private int bookPrice;
    @Lob
    private String bookCoverPhoto;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id")
    private Discount discount=null;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

    @Formula("(SELECT AVG(r.rating_star) from review r where r.book_id = id)")
    private Float recommended;

    @Formula("(book_price - (SELECT d.discount_price from discount d where d.book_id = id))")
    private Integer sale;

    @Formula("(SELECT COUNT(r.id) FROM review r where r.book_id = id)")
    private Integer popular;

    @Formula("(SELECT COALESCE((SELECT d.discount_price from discount d where d.book_id = id), book_price))")
    private Integer finalPrice;
}
