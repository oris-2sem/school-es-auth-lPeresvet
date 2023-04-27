package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.lesson.LessonDto;
import ru.itis.oris.jpahw.entities.Lesson;
import ru.itis.oris.jpahw.repositories.LessonRepository;
import ru.itis.oris.jpahw.services.LessonService;
import ru.itis.oris.jpahw.services.converters.LessonMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto getById(Long id) {
        Lesson lesson = (Lesson) GetHelper.getOrThrow(id, lessonRepository);

        return lessonMapper.fromLesson(lesson);
    }

    @Override
    public LessonDto save(LessonDto lessonDto) {
        Lesson lesson = lessonMapper.fromLessonDto(lessonDto);
        lessonRepository.save(lesson);
        return lessonMapper.fromLesson(lesson);
    }

    @Override
    public LessonDto update(Long id, LessonDto lessonDto) {
        Lesson lessonToUpdate = (Lesson) GetHelper.getOrThrow(id, lessonRepository);

        lessonToUpdate.setTheme(lessonDto.getTheme());
        lessonToUpdate.setTasks(lessonDto.getTasks());

        lessonRepository.save(lessonToUpdate);
        return lessonMapper.fromLesson(lessonToUpdate);
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = (Lesson) GetHelper.getOrThrow(id, lessonRepository);
        lessonRepository.delete(lesson);
    }
}
