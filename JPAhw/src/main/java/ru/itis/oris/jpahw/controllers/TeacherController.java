package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.teacher.TeacherDto;
import ru.itis.oris.jpahw.services.TeacherService;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PutMapping
    public ResponseEntity<TeacherDto> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teacherService.save(signUpDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeacherDto> update(@PathVariable Long id,
                                             @RequestBody UpdateUserDto updateDto) {
        TeacherDto teacherDto = teacherService.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(teacherDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        teacherService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
