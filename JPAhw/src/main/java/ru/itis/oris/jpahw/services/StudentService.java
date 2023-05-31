package ru.itis.oris.jpahw.services;


import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.student.StudentDto;

public interface StudentService {
    StudentDto getById(Long id);
    StudentDto save(SignUpDto signUpDto);
    StudentDto update(Long id, StudentDto updateDto);
    void delete(Long id);
}
