package com.thafonsotest.users_api.controller;

import com.thafonsotest.users_api.entities.Category;
import com.thafonsotest.users_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/categories"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){ // Search for all the categories
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Category> findById(@PathVariable Long id){ // Search for one id in the category
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

}
