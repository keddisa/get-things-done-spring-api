package com.andrewkeddis.getthingsdone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andrewkeddis.getthingsdone.models.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {
	@Query("select t from Task t where t.display = true")
	List<Task> findAllDisplay();
	@Query("select t from Task t where t.display = true and t.category =:category")
	List<Task> findByCategory(@Param("category") String category);
	
//	List<Task> findAllOrderByPriorityDesc();
}
