package ru.itis.oris.jpahw.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.oris.jpahw.entities.Task;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonDto {
    private Long id;
    private String theme;
    private List<Task> tasks;
}
