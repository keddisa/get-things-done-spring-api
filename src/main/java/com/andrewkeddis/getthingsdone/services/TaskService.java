package com.andrewkeddis.getthingsdone.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrewkeddis.getthingsdone.dao.TaskDao;
import com.andrewkeddis.getthingsdone.models.Task;
import com.andrewkeddis.getthingsdone.models.TaskDisplay;

@Service
public class TaskService { 
	
	@Autowired
	TaskDao taskDao;
	
	public List<TaskDisplay> findAll() {
		return refactorTasks(taskDao.findAll());
		
	}
	
	public List<TaskDisplay> findAllDisplay() {
		List<Task> tasks = taskDao.findAllDisplay();
		return refactorTasks(tasks);
	}
	
	public TaskDisplay findTask(int id) {
		Optional<Task> tempTask = taskDao.findById(id);
		if (tempTask.isPresent()) {
			return refactorTask(tempTask.get());
			
		} else {
			return null;
		}
	}

	public List<TaskDisplay> findByCategory(String category) {
		return refactorTasks(taskDao.findByCategory(category));
	}
	
//	public List<Task> findByPriority() {
//		return taskDao.findAllOrderByPriorityDesc();
//	}

	public Task removeTask(int id) {
		Optional<Task> tempTask = taskDao.findById(id);
		if (tempTask.isPresent()) {
			tempTask.get().setDisplay(false);
			taskDao.save(tempTask.get());
		}
		return null;
	}
	
	public TaskDisplay update(Task task) {
		Optional<Task> tempTask = taskDao.findById(task.getId());
		if (tempTask.isPresent()) {
			task.setCreatedAt(tempTask.get().getCreatedAt());
			if(task.getDisplay() == null) {
				task.setDisplay(tempTask.get().getDisplay()); 
			}
			if(task.getPending() == null) {
				task.setPending(tempTask.get().getPending()); 
			}	
		}
		return refactorTask(taskDao.save(task));
	}

	public Task save(Task task) {
		return taskDao.save(task);
	}
	
	public String deleteById(int id) {
		Optional<Task> tempTask = taskDao.findById(id);
		if (tempTask.isPresent()) {
			taskDao.deleteById(id);
			return "Task with id "+id+ " has been deleted";
		} else {
			return "Did not find task with id " + id;
		}
	}

	public List<TaskDisplay> refactorTasks (List<Task> tasks) {
		List<TaskDisplay> tasksDisplay = new ArrayList<>(); 
		
		for (Task task : tasks) {
			
			tasksDisplay.add(refactorTask(task));
		}
		return tasksDisplay;
	}

	private TaskDisplay refactorTask(Task task) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		TaskDisplay taskDisplay = new TaskDisplay();
		taskDisplay.setId(task.getId());
		taskDisplay.setTitle(task.getTitle());
		taskDisplay.setDescription(task.getDescription());
		taskDisplay.setCategory(task.getCategory());
		taskDisplay.setPriority(task.getPriority());
		taskDisplay.setStatus(task.getStatus());
		taskDisplay.setPending(task.getPending());
		taskDisplay.setCreatedAt(simpleDate.format(task.getCreatedAt()));
		if(task.getDeadline() != null) {
			taskDisplay.setDeadline(simpleDate.format(task.getDeadline()));
		}
		return taskDisplay;
	}
}
