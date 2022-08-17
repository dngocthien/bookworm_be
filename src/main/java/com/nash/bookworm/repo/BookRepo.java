package com.nash.bookworm.repo;

import com.nash.bookworm.entities.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByCategoryId(Long id, Pageable pageable);
    List<Book> findByCategoryId(Long id);

    List<Book> findByAuthorId(Long id, Pageable pageable);
    List<Book> findByAuthorId(Long id);

//    @Query("select b from Book b inner join b.reviews review where  > :avg")
//    public List<Book> findByAvgStar(@Param("avg") long avg, Pageable pageable);

}
