package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.student.StudentDto;
import ru.itis.oris.jpahw.entities.users.Student;
import ru.itis.oris.jpahw.entities.users.roles.Role;
import ru.itis.oris.jpahw.repositories.StudentRepository;
import ru.itis.oris.jpahw.services.StudentService;
import ru.itis.oris.jpahw.services.converters.ClassMapper;
import ru.itis.oris.jpahw.services.converters.ParentMapper;
import ru.itis.oris.jpahw.services.converters.StudentMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ParentMapper parentMapper;
    private final ClassMapper classMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public StudentDto getById(Long id) {
        Student student = (Student) GetHelper.getOrThrow(id, studentRepository);
        return studentMapper.fromStudentToDto(student);
    }

    @Override
    public StudentDto save(SignUpDto signUpDto) {
        Student student = studentMapper.fromSignUp(signUpDto);
        student.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        student.setRole(Role.STUDENT);
        studentRepository.save(student);
        return studentMapper.fromStudentToDto(student);
    }

    @Override
    public StudentDto update(Long id, StudentDto updateDto) {
        Student studentToUpdate = (Student) GetHelper.getOrThrow(id, studentRepository);

        studentToUpdate.setLogin(updateDto.getLogin());
        studentToUpdate.setParent(parentMapper.from(updateDto.getParent()));
        studentToUpdate.setName(updateDto.getName());
        studentToUpdate.setSurname(updateDto.getSurname());
        studentToUpdate.setPatronymic(updateDto.getPatronymic());
        studentToUpdate.setSchoolClass(classMapper.fromDto(updateDto.getSchoolClass()));

        studentRepository.save(studentToUpdate);
        return studentMapper.fromStudentToDto(studentToUpdate);
    }

    @Override
    public void delete(Long id) {
        Student student = (Student) GetHelper.getOrThrow(id, studentRepository);
        studentRepository.delete(student);
    }


}
