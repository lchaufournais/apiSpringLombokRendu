package com.exo1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectTaskCountDTO {
    private Long project_id;
    private String project_tilt;
    private int task_count;
}
