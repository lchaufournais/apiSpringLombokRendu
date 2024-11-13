package com.exo1.mapper;

import com.exo1.dto.ProjectTaskCountDTO;
import com.exo1.entities.ProjectTaskCount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectTaskCountMapper {
    ProjectTaskCountMapper INSTANCE = Mappers.getMapper(ProjectTaskCountMapper.class);

    ProjectTaskCountDTO toProjectTaskCountDTO(ProjectTaskCount projectTaskCount);
}
