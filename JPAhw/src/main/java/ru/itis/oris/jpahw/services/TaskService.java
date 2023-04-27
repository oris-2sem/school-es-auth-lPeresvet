package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.task.TaskDto;
public interface TaskService {
    TaskDto getById(Long id);
    TaskDto save(TaskDto taskDto);
    TaskDto update(Long id, TaskDto taskDto);
    void delete(Long id);
}
