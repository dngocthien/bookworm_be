package com.nash.bookworm.services.impl;

import com.nash.bookworm.entities.Author;
import com.nash.bookworm.repo.AuthorRepo;
import com.nash.bookworm.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo repo;

    @Override
    public Author saveAuthor(Author author) {
        return repo.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Author getAuthorByName(String name) {
        return repo.findByAuthorName(name);
    }
}
