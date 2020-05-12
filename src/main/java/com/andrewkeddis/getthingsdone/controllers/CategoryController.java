package com.andrewkeddis.getthingsdone.controllers;

import com.andrewkeddis.getthingsdone.models.Category;
import com.andrewkeddis.getthingsdone.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public List<Category> findAllByUser(@RequestBody String userId) {
        return categoryService.findAllByUser(userId);
    }

    @GetMapping("/{id}")
    public Category findTask(@PathVariable(value = "id") int id) {
        return categoryService.findCategory(id);
    }

    @PostMapping(value = "/new")
    public Category createTask(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/")
    public Category updateTask(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") int id) {
        return categoryService.deleteById(id);
    }
}
