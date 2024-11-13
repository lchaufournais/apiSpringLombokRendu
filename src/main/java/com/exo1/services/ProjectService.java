package com.exo1.services;

import com.exo1.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO getProjectById(Long id);
    List<ProjectDTO> getAllProjects();
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);
    void deleteProject(Long id);
}
