package com.andrewkeddis.getthingsdone.controllers;

import com.andrewkeddis.getthingsdone.dto.TaskDto;
import com.andrewkeddis.getthingsdone.models.Task;
import com.andrewkeddis.getthingsdone.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/current-user")
    public List<TaskDto> currentUserDisplayTasks(@RequestBody String userId) {
        return taskService.currentUserDisplayTasks(userId);
    }

    @GetMapping("/")
    public List<TaskDto> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDto findTask(@PathVariable(value = "id") int id) {
        return taskService.findTask(id);
    }

    @PostMapping("/category/{category}")
    public List<TaskDto> findByCategory(@PathVariable(value = "category") String category, @RequestBody String userId) {
        return taskService.findByCategory(category, userId);
    }

    @PostMapping(value = "/new")
    public TaskDto createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/")
    public TaskDto updateTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.update(task);
    }

    @PutMapping("/remove/{id}")
    public String removeTask(@PathVariable(value = "id") int id) {
        Task tempTask = taskService.removeTask(id);
        if (tempTask != null) {
            return "Task has been removed";
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") int id) {
        return taskService.deleteById(id);
    }
}
