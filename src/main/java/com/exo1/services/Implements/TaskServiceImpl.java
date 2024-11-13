package com.exo1.services.Implements;

import com.exo1.dto.TaskDTO;
import com.exo1.mapper.ProjectMapper;
import com.exo1.mapper.UserMapper;
import com.exo1.services.TaskService;
import com.exo1.entities.Task;
import com.exo1.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exo1.repositories.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    private TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
        return taskMapper.toTaskDTO(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toTaskEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toTaskDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setStatue(taskDTO.getStatue());

        Task updatedTask = taskRepository.save(existingTask);
        return taskMapper.toTaskDTO(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id " + id);
        }
        taskRepository.deleteById(id);
    }
}
