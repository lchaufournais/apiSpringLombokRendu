package com.exo1.controllers;

import com.exo1.dto.ProjectTaskCountDTO;
import com.exo1.services.ProjectTaskCountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-task-count")
@AllArgsConstructor
public class ProjectTaskCountController {

    @Autowired
    private ProjectTaskCountService projectTaskCountService;

    @GetMapping("/{projectId}")
    public List<ProjectTaskCountDTO> getProjectTaskCount(@PathVariable Long projectId) {
        return projectTaskCountService.getProjectTaskCount();
    }
}
