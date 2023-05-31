package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.timetable.NewTimetableDto;
import ru.itis.oris.jpahw.dto.timetable.TimetableDto;
import ru.itis.oris.jpahw.entities.Lesson;
import ru.itis.oris.jpahw.entities.SchoolClass;
import ru.itis.oris.jpahw.entities.Timetable;
import ru.itis.oris.jpahw.entities.users.Teacher;
import ru.itis.oris.jpahw.repositories.LessonRepository;
import ru.itis.oris.jpahw.repositories.SchoolClassRepository;
import ru.itis.oris.jpahw.repositories.TeacherRepository;
import ru.itis.oris.jpahw.repositories.TimetableRepository;
import ru.itis.oris.jpahw.services.TimetableService;
import ru.itis.oris.jpahw.services.converters.ClassMapper;
import ru.itis.oris.jpahw.services.converters.LessonMapper;
import ru.itis.oris.jpahw.services.converters.TeacherMapper;
import ru.itis.oris.jpahw.services.converters.TimetableMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {
    private final TimetableRepository timetableRepository;
    private final LessonRepository lessonRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final TeacherRepository teacherRepository;

    private final TimetableMapper timetableMapper;
    private final LessonMapper lessonMapper;
    private final ClassMapper classMapper;
    private final TeacherMapper teacherMapper;

    @Override
    public TimetableDto getById(Long id) {
        Timetable timetable = (Timetable) GetHelper.getOrThrow(id, timetableRepository);

        return timetableMapper.fromTimetable(timetable);
    }

    @Override
    public TimetableDto save(NewTimetableDto newTimetableDto) {
        Timetable timetable = Timetable.builder()
                .auditoriumNumber(newTimetableDto.getAuditoriumNumber())
                .date(newTimetableDto.getDate())
                .lesson((Lesson) GetHelper.getOrThrow(newTimetableDto.getLessonId(), lessonRepository))
                .teacher((Teacher) GetHelper.getOrThrow(newTimetableDto.getTeacherId(), teacherRepository))
                .schoolClass((SchoolClass) GetHelper.getOrThrow(newTimetableDto.getSchoolClassId(), schoolClassRepository))
                .build();

        timetableRepository.save(timetable);

        return timetableMapper.fromTimetable(timetable);
    }

    @Override
    public TimetableDto update(Long id, NewTimetableDto updateTimetableDto) {
        Timetable timetableToUpdate = (Timetable) GetHelper.getOrThrow(id, timetableRepository);

        timetableToUpdate.setDate(updateTimetableDto.getDate());
        timetableToUpdate.setAuditoriumNumber(updateTimetableDto.getAuditoriumNumber());
        timetableToUpdate.setLesson((Lesson) GetHelper.getOrThrow(updateTimetableDto.getLessonId(), lessonRepository));
        timetableToUpdate.setTeacher((Teacher) GetHelper.getOrThrow(updateTimetableDto.getTeacherId(), teacherRepository));
        timetableToUpdate.setSchoolClass(
                (SchoolClass) GetHelper.getOrThrow(updateTimetableDto.getSchoolClassId(), schoolClassRepository)
        );

        timetableRepository.save(timetableToUpdate);
        return timetableMapper.fromTimetable(timetableToUpdate);
    }

    @Override
    public void delete(Long id) {
        Timetable timetable = (Timetable) GetHelper.getOrThrow(id, timetableRepository);
        timetableRepository.delete(timetable);
    }
}
