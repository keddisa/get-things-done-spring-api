package com.andrewkeddis.getthingsdone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrewkeddis.getthingsdone.models.Category;
import com.andrewkeddis.getthingsdone.services.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category findTask(@PathVariable(value="id") int id) {
		return categoryService.findCategory(id);
	}
	
	@PostMapping(value="/")
	public Category createTask(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@PutMapping("/")
	public Category updateTask(@RequestBody Category category) {
		return categoryService.update(category); 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable(value="id") int id) {
		return categoryService.deleteById(id);
	}
}
