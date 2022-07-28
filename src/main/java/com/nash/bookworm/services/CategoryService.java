package com.nash.bookworm.services;

import com.nash.bookworm.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
}
