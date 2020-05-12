package com.andrewkeddis.getthingsdone.dto;

import lombok.*;

import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskDto {
    private int id;
    private String title;
    private String description;
    private String category;
    private int priority;
    private String status;
    private Calendar createdAt;
    private Calendar deadline;
    private Boolean pending;
}
