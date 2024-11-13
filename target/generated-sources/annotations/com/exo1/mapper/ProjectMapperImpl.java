package com.exo1.mapper;

import com.exo1.dto.ProjectDTO;
import com.exo1.dto.TaskDTO;
import com.exo1.entities.Project;
import com.exo1.entities.Task;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T16:42:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ProjectDTO toProjectDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId( project.getId() );
        projectDTO.setTitle( project.getTitle() );
        projectDTO.setDescription( project.getDescription() );
        projectDTO.setTasks( taskSetToTaskDTOList( project.getTasks() ) );

        return projectDTO;
    }

    @Override
    public Project toProjectEntity(ProjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( dto.getId() );
        project.setTitle( dto.getTitle() );
        project.setDescription( dto.getDescription() );
        project.setTasks( taskDTOListToTaskSet( dto.getTasks() ) );

        return project;
    }

    protected List<TaskDTO> taskSetToTaskDTOList(Set<Task> set) {
        if ( set == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( set.size() );
        for ( Task task : set ) {
            list.add( taskMapper.toTaskDTO( task ) );
        }

        return list;
    }

    protected Set<Task> taskDTOListToTaskSet(List<TaskDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Task> set = new LinkedHashSet<Task>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TaskDTO taskDTO : list ) {
            set.add( taskMapper.toTaskEntity( taskDTO ) );
        }

        return set;
    }
}
