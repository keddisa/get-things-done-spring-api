package com.andrewkeddis.getthingsdone.models;

public class TaskDisplay {
	private int id;
	private String title;
	private String description;
	private String category;
	private int priority;
	private String status;
	private String createdAt;
	private String deadline;
	private Boolean pending;
	
	public TaskDisplay() {
	}

	public TaskDisplay(int id, String title, String description, String category, int priority, String status,
			String createdAt, String deadline, Boolean pending) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.priority = priority;
		this.status = status;
		this.createdAt = createdAt;
		this.deadline = deadline;
		this.pending = pending;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public boolean getPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}	

}
