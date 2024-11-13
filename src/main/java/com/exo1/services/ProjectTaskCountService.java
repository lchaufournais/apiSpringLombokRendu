package com.exo1.services;

import com.exo1.dto.ProjectTaskCountDTO;

import java.util.List;

public interface ProjectTaskCountService {
    List<ProjectTaskCountDTO> getProjectTaskCount();
    void refreshMaterializedView();
}
