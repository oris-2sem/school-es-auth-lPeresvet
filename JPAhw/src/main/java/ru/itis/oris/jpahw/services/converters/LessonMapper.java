package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.lesson.LessonDto;
import ru.itis.oris.jpahw.entities.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonDto fromLesson(Lesson lesson);

    @Mapping(target = "id", ignore = true)
    Lesson fromLessonDto(LessonDto lessonDto);
}
