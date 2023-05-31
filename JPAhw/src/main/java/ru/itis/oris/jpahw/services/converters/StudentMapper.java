package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.student.StudentDto;
import ru.itis.oris.jpahw.entities.users.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto fromStudentToDto(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "schoolClass", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Student fromSignUp(SignUpDto signUpDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "schoolClass", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Student fromUpdateDto(UpdateUserDto updateDto);

}
