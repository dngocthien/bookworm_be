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
    private String bookCoverPhoto;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

//    @Formula("(discount.discount_price)")
//    private int sale;
    @Formula("(SELECT COUNT(r.id) FROM book b " +
            "left join review r on r.book_id = b.id)")
    private int popular;
}
