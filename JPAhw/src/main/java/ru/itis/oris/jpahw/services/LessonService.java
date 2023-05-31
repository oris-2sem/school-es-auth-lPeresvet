package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.lesson.LessonDto;

public interface LessonService {
    LessonDto getById(Long id);
    LessonDto save(LessonDto lessonDto);
    LessonDto update(Long id, LessonDto lessonDto);
    void delete(Long id);
}
