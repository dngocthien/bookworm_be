package com.nash.bookworm.repo;

import com.nash.bookworm.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByAuthorName(String name);
}
