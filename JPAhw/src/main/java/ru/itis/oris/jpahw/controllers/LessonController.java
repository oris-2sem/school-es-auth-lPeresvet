package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.lesson.LessonDto;
import ru.itis.oris.jpahw.services.LessonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;

    @PutMapping
    public ResponseEntity<LessonDto> addLesson(@RequestBody LessonDto lessonDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lessonService.save(lessonDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LessonDto> update(@PathVariable Long id,
                                             @RequestBody LessonDto lessonDto) {
        LessonDto lessonUpdate = lessonService.update(id, lessonDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lessonUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        lessonService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
