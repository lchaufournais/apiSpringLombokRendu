package com.exo1.services.Implements;

import com.exo1.dto.ProjectTaskCountDTO;
import com.exo1.entities.ProjectTaskCount;
import com.exo1.mapper.ProjectTaskCountMapper;
import com.exo1.repositories.ProjectTaskCountRepository;
import com.exo1.services.ProjectTaskCountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectTaskCountImpl implements ProjectTaskCountService {

    @Autowired
    private ProjectTaskCountRepository projectTaskCountRepository;

    private ProjectTaskCountMapper projectTaskCountMapper = ProjectTaskCountMapper.INSTANCE;

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProjectTaskCountDTO> getProjectTaskCount() {
        List<ProjectTaskCount> projectTaskCounts = projectTaskCountRepository.findAll();

        return projectTaskCounts.stream()
                .map(projectTaskCountMapper::toProjectTaskCountDTO)
                .collect(Collectors.toList());
    }

    public void refreshMaterializedView() {
        jdbcTemplate.execute("REFRESH MATERIALIZED VIEW project_task_count");
    }
}

