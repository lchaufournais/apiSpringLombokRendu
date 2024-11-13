package com.exo1.mapper;

import com.exo1.dto.ProjectDTO;
import com.exo1.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TaskMapper.class})
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO toProjectDTO(Project project);

    Project toProjectEntity(ProjectDTO dto);
}
