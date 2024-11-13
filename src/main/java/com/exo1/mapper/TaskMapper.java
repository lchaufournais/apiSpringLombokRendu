package com.exo1.mapper;

import com.exo1.dto.TaskDTO;
import com.exo1.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toTaskDTO(Task task);

    Task toTaskEntity(TaskDTO dto);
}
