package com.andrewkeddis.getthingsdone.services;

import com.andrewkeddis.getthingsdone.dao.TaskDao;
import com.andrewkeddis.getthingsdone.dto.TaskDto;
import com.andrewkeddis.getthingsdone.models.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskDao taskDao;
    private final ModelMapper modelMapper;

    public TaskService(ModelMapper modelMapper, TaskDao taskDao) {
        this.modelMapper = modelMapper;
        this.taskDao = taskDao;
    }

    public List<TaskDto> findAll() {
        List<Task> tasks = taskDao.findAll();
        List<TaskDto> taskDtos = tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
        return taskDtos;
    }

    public List<TaskDto> currentUserDisplayTasks(String userId) {
        String updatedUserId = "";
        for (int i = 0; i < userId.length(); i++) {
            if ("0123456789".contains(Character.toString(userId.charAt(i)))) {
                updatedUserId += userId.charAt(i);
            }
        }
        List<Task> tasks = taskDao.findAllDisplay(updatedUserId);
        List<TaskDto> taskDtos = tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
        return taskDtos;
    }

    public TaskDto findTask(int id) {
        Optional<Task> task = taskDao.findById(id);
        if (task.isPresent()) {
            return modelMapper.map(task, TaskDto.class);
        } else {
            return null;
        }
    }

    public List<TaskDto> findByCategory(String category, String userId) {
        String updatedUserId = "";
        for (int i = 0; i < userId.length(); i++) {
            if ("0123456789".contains(Character.toString(userId.charAt(i)))) {
                updatedUserId += userId.charAt(i);
            }
        }
        List<Task> tasks = taskDao.findByCategory(category, updatedUserId);
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    public Task removeTask(int id) {
        Optional<Task> tempTask = taskDao.findById(id);
        if (tempTask.isPresent()) {
            tempTask.get().setDisplay(false);
            taskDao.save(tempTask.get());
        }
        return null;
    }

    public TaskDto update(Task task) {
        Optional<Task> tempTask = taskDao.findById(task.getId());
        if (tempTask.isPresent()) {
            task.setCreatedAt(tempTask.get().getCreatedAt());
            if (task.getDisplay() == null) {
                task.setDisplay(tempTask.get().getDisplay());
            }
            if (task.getPending() == null) {
                task.setPending(tempTask.get().getPending());
            }
            if (task.getCreatorId() == null) {
                task.setCreatorId(tempTask.get().getCreatorId());
            }
        }
        return modelMapper.map(taskDao.save(task), TaskDto.class);
    }

    public TaskDto save(Task task) {
        task.setDisplay(true);
        task.setPending(true);
        Task savedTask = taskDao.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    public String deleteById(int id) {
        Optional<Task> tempTask = taskDao.findById(id);
        if (tempTask.isPresent()) {
            taskDao.deleteById(id);
            return "Task with id " + id + " has been deleted";
        } else {
            return "Did not find task with id " + id;
        }
    }
}
