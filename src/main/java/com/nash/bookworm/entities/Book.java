package com.nash.bookworm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Discount> discounts = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();
}
