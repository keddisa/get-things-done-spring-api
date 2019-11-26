package com.andrewkeddis.getthingsdone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrewkeddis.getthingsdone.dao.CategoryDao;
import com.andrewkeddis.getthingsdone.models.Category;

@Service
public class CategoryService { 
	
	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> findAllByUser(String userId) {
		String updatedUserId = "";
		for(int i=0; i<userId.length(); i++) {
			if ("0123456789".contains(Character.toString(userId.charAt(i)))) {
				updatedUserId += userId.charAt(i);
			}
		}
		return categoryDao.findByCreatorId(updatedUserId);
	}
	
	
	
	public Category findCategory(int id) {
		Optional<Category> tempCategory = categoryDao.findById(id);
		if (tempCategory.isPresent()) {
			return tempCategory.get();
			
		} else {
			return null;
		}
	}



	
	public Category update(Category category) {
		Optional<Category> tempCategory = categoryDao.findById(category.getId());
		if (tempCategory.isPresent()) {
			return categoryDao.save(tempCategory.get());
		}
		return null;
	}

	public Category save(Category category) {
		System.out.println(category);
		return categoryDao.save(category); 
	}
	
	public String deleteById(int id) {
		Optional<Category> tempCategory = categoryDao.findById(id);
		if (tempCategory.isPresent()) {
			categoryDao.deleteById(id);
			return "Category with id "+id+ " has been deleted";
		} else {
			return "Did not find category with id " + id;
		}
	}

}
