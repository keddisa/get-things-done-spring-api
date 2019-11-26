package com.andrewkeddis.getthingsdone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int id;
	@Column(name="category_name")
	private String name;
	@Column(name="creator_id")
	private String creatorId;
	
	public Category() {
		
	}

	public Category(int id, String name, String creatorId) {
		this.id = id;
		this.name = name;
		this.creatorId = creatorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", creatorId=" + creatorId + "]";
	}
	
}
