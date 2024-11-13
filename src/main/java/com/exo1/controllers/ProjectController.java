package com.exo1.controllers;

import com.exo1.dto.ProjectDTO;
import com.exo1.services.ProjectTaskCountService;
import com.exo1.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectTaskCountService projectTaskCountService;

    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO projectSave = projectService.createProject(projectDTO);
        projectTaskCountService.refreshMaterializedView();
        return projectSave;
    }

    @PutMapping("/{id}")
    public ProjectDTO updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
        ProjectDTO projectUpdated = projectService.updateProject(id, projectDTO);
        projectTaskCountService.refreshMaterializedView();
        return projectUpdated;
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        projectTaskCountService.refreshMaterializedView();
    }
}
