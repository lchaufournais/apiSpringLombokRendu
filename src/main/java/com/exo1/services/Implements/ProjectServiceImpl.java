package com.exo1.services.Implements;

import com.exo1.dto.ProjectDTO;
import com.exo1.mapper.ProjectMapper;
import com.exo1.mapper.UserMapper;
import com.exo1.services.ProjectService;
import com.exo1.entities.Project;
import com.exo1.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exo1.repositories.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
        return projectMapper.toProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toProjectEntity(projectDTO);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toProjectDTO(savedProject);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));

        existingProject.setTitle(projectDTO.getTitle());
        existingProject.setDescription(projectDTO.getDescription());

        if (projectDTO.getTasks() != null) {
            existingProject.setTasks(projectDTO.getTasks().stream()
                    .map(TaskMapper.INSTANCE::toTaskEntity)
                    .collect(Collectors.toSet()));
        }

        Project updatedProject = projectRepository.save(existingProject);
        return projectMapper.toProjectDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id " + id);
        }
        projectRepository.deleteById(id);
    }
}
