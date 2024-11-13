package com.exo1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_task_count")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectTaskCount {

    @Id
    private Long project_id;

    private String project_tilt;
    private int task_count;
}
