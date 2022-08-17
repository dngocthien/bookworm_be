package com.nash.bookworm.services.impl;

import com.nash.bookworm.entities.Category;
import com.nash.bookworm.repo.CategoryRepo;
import com.nash.bookworm.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo repo;

    @Override
    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByName(String name) {
        return repo.findByCategoryName(name);
    }
}
