package com.thafonsotest.users_api.services;


import com.thafonsotest.users_api.dto.CategoryDTO;
import com.thafonsotest.users_api.entities.Category;
import com.thafonsotest.users_api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryDTO::new).toList();
    }

    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        return new CategoryDTO(category);
    }
}
