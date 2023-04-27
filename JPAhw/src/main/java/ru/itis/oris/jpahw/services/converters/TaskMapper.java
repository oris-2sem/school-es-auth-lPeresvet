package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.task.TaskDto;
import ru.itis.oris.jpahw.entities.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto fromTask(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lesson", ignore = true)
    @Mapping(target = "student", ignore = true)
    Task fromDto(TaskDto taskDto);

}
