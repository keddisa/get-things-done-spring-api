package com.andrewkeddis.getthingsdone.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories_table")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "creator_id")
    private String creatorId;

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", creatorId=" + creatorId + "]";
    }
}
