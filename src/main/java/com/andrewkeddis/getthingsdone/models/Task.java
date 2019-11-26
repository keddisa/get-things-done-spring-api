package com.andrewkeddis.getthingsdone.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="category")
	private String category;
	@Column(name="deadline")
	private Date deadline;
	@Column(name="priority")
	private int priority;
	@Column(name="status")
	private String status;
	@Column(name="pending")
	private Boolean pending;
	@Column(name="display")
	private Boolean display;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	@Column(name="creator_id")
	private String creatorId;
	
	public Task() {
	}

	public Task(String title, String description, String category, Date deadline, int priority, String status,
			Boolean pending, Boolean display, Date createdAt, String creatorId) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.deadline = deadline;
		this.priority = priority;
		this.status = status;
		this.pending = pending;
		this.display = display;
		this.createdAt = createdAt;
		this.creatorId = creatorId;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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

	public Boolean getPending() {
		return pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", deadline=" + deadline + ", priority=" + priority + ", status=" + status + ", pending=" + pending
				+ ", display=" + display + ", createdAt=" + createdAt + ", creatorId=" + creatorId + "]";
	}

	
}
