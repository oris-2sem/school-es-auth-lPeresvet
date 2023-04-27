package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.school_class.ClassDto;
import ru.itis.oris.jpahw.services.ClassService;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @PutMapping
    public ResponseEntity<ClassDto> signUp(@RequestBody ClassDto classDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(classService.save(classDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClassDto> update(@PathVariable Long id,
                                           @RequestBody ClassDto classDto) {
        ClassDto classDtoUpdate = classService.update(id, classDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(classDtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        classService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
