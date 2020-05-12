package com.andrewkeddis.getthingsdone.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private Calendar deadline;

    @Column
    private int priority;

    @Column
    private String status;

    @Column
    private Boolean pending;

    @Column
    private Boolean display;

    @CreationTimestamp
    @Column
    private Calendar createdAt;

    @Column
    private String creatorId;

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
                + ", deadline=" + deadline + ", priority=" + priority + ", status=" + status + ", pending=" + pending
                + ", display=" + display + ", createdAt=" + createdAt + ", creatorId=" + creatorId + "]";
    }
}
