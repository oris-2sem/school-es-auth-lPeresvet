package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.task.TaskDto;
import ru.itis.oris.jpahw.entities.Task;
import ru.itis.oris.jpahw.repositories.TaskRepository;
import ru.itis.oris.jpahw.services.TaskService;
import ru.itis.oris.jpahw.services.converters.TaskMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto getById(Long id) {
        Task task = (Task) GetHelper.getOrThrow(id, taskRepository);

        return taskMapper.fromTask(task);
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task = taskMapper.fromDto(taskDto);
        taskRepository.save(task);
        return taskMapper.fromTask(task);
    }

    @Override
    public TaskDto update(Long id, TaskDto taskDto) {
        Task taskToUpdate = (Task) GetHelper.getOrThrow(id, taskRepository);

        taskToUpdate.setComment(taskDto.getComment());
        taskToUpdate.setDescription(taskDto.getDescription());
        taskToUpdate.setMark(taskDto.getMark());
        taskToUpdate.setType(taskDto.getType());

        taskRepository.save(taskToUpdate);
        return taskMapper.fromTask(taskToUpdate);
    }

    @Override
    public void delete(Long id) {
        Task task = (Task) GetHelper.getOrThrow(id, taskRepository);
        taskRepository.delete(task);
    }
}
