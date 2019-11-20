package com.andrewkeddis.getthingsdone.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.andrewkeddis.getthingsdone.models.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
}
