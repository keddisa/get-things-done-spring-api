package com.andrewkeddis.getthingsdone.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrewkeddis.getthingsdone.models.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	List<Category> findByCreatorId(String creatorId);
}
