package ru.itis.oris.jpahw.dto.timetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.oris.jpahw.dto.lesson.LessonDto;
import ru.itis.oris.jpahw.dto.school_class.ClassDto;
import ru.itis.oris.jpahw.dto.teacher.TeacherDto;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TimetableDto {
    private Long id;
    private LessonDto lesson;
    private ClassDto schoolClass;
    private TeacherDto teacher;
    private String auditoriumNumber;
    private Date date;
}
