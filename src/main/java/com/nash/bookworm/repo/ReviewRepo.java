package com.nash.bookworm.repo;

import com.nash.bookworm.entities.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByBookId(Long id);

//    @Query("SELECT r FROM Review r WHERE r.book.id = ?1")
    List<Review> findByBookId( Long id, Pageable pageable);

    @Query("SELECT r FROM Review r WHERE r.book.id = ?1 AND r.ratingStar = ?2")
    List<Review> findByBookIdAndStar(Long id, int star, Pageable pageable);

    @Query("SELECT COUNT(r.id) FROM Review r WHERE r.book.id = ?1 AND r.ratingStar = ?2")
    int countByBookIdAndStar(long id, int star);
}
