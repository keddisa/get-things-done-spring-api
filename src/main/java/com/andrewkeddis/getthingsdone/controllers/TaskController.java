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

import com.andrewkeddis.getthingsdone.models.Task;
import com.andrewkeddis.getthingsdone.models.TaskDisplay;
import com.andrewkeddis.getthingsdone.services.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/")
	public List<TaskDisplay> findAllDisplay(@RequestBody String userId) {
		return taskService.findAllDisplay(userId);
	}
	
	@GetMapping("/all")
	public List<TaskDisplay> findAll() {
		return taskService.findAll();
	}
	
	@GetMapping("/{id}")
	public TaskDisplay findTask(@PathVariable(value="id") int id) {
		return taskService.findTask(id);
	}
	
	@PostMapping("/category/{category}")
	public List<TaskDisplay> findByCategory(@PathVariable(value="category") String category, @RequestBody String userId) {
		return taskService.findByCategory(category, userId);
	}
	
	
	@PostMapping(value="/new")
	public TaskDisplay createTask(@RequestBody Task task) {
		task.setDisplay(true);
		task.setPending(true);
		return taskService.save(task);
	}
	
	@PutMapping("/")
	public TaskDisplay updateTask(@RequestBody Task task) {
		System.out.println(task);
		return taskService.update(task); 
	}
	
	@PutMapping("/remove/{id}")
	public String removeTask(@PathVariable(value="id") int id) {
		Task tempTask = taskService.removeTask(id);
		if (tempTask != null) {
			return "Task has been removed";
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable(value="id") int id) {
		return taskService.deleteById(id);
	}
}
