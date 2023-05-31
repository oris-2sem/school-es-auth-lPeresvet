package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.teacher.TeacherDto;

public interface TeacherService {
    TeacherDto getById(Long id);
    TeacherDto save(SignUpDto signUpDto);
    TeacherDto update(Long id, UpdateUserDto updateDto);
    void delete(Long id);
}
