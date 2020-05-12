package com.andrewkeddis.getthingsdone.dao;

import com.andrewkeddis.getthingsdone.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    List<Category> findByCreatorId(String creatorId);
}
