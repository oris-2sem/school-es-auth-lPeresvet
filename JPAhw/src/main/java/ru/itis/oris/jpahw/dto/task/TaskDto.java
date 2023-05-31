package ru.itis.oris.jpahw.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.oris.jpahw.entities.Task;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private Task.TaskType type;
    private String mark;
    private String comment;
    private String description;
}
