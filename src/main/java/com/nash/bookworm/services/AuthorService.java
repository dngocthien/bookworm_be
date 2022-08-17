package com.nash.bookworm.services;

import com.nash.bookworm.entities.Author;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author getAuthorByName(String name);
}
