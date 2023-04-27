package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.teacher.TeacherDto;
import ru.itis.oris.jpahw.entities.users.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto fromTeacherToDto(Teacher teacher);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "classes", ignore = true)
    @Mapping(target = "timetable", ignore = true)
    Teacher fromSignUp(SignUpDto signUpDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timetable", ignore = true)
    @Mapping(target = "classes", ignore = true)
    Teacher fromUpdateDto(UpdateUserDto updateDto);
}
