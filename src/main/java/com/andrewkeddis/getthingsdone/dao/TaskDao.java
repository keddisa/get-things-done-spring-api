package com.andrewkeddis.getthingsdone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andrewkeddis.getthingsdone.models.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {
	@Query("select t from Task t where t.display = true and t.creatorId =:creatorId")
	List<Task> findAllDisplay(@Param("creatorId") String creatorId);
	@Query("select t from Task t where t.display = true and t.category =:category and t.creatorId =:creatorId")
	List<Task> findByCategory(@Param("category") String category, @Param("creatorId") String creatorId);
	
//	List<Task> findAllOrderByPriorityDesc();
}
