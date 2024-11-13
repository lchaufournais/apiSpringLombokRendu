package com.exo1.mapper;

import com.exo1.dto.ProjectTaskCountDTO;
import com.exo1.entities.ProjectTaskCount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T16:42:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ProjectTaskCountMapperImpl implements ProjectTaskCountMapper {

    @Override
    public ProjectTaskCountDTO toProjectTaskCountDTO(ProjectTaskCount projectTaskCount) {
        if ( projectTaskCount == null ) {
            return null;
        }

        ProjectTaskCountDTO projectTaskCountDTO = new ProjectTaskCountDTO();

        projectTaskCountDTO.setProject_id( projectTaskCount.getProject_id() );
        projectTaskCountDTO.setProject_tilt( projectTaskCount.getProject_tilt() );
        projectTaskCountDTO.setTask_count( projectTaskCount.getTask_count() );

        return projectTaskCountDTO;
    }
}
