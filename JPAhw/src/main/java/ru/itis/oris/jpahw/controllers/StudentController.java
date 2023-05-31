package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.student.StudentDto;
import ru.itis.oris.jpahw.services.StudentService;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PutMapping
    public ResponseEntity<StudentDto> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.save(signUpDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Long id,
                                             @RequestBody StudentDto updateDto) {
        StudentDto studentDto = studentService.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
