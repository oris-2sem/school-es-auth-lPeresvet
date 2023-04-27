package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.timetable.NewTimetableDto;
import ru.itis.oris.jpahw.dto.timetable.TimetableDto;
import ru.itis.oris.jpahw.services.TimetableService;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    @PutMapping
    public ResponseEntity<TimetableDto> add(@RequestBody NewTimetableDto newTimetableDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(timetableService.save(newTimetableDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(timetableService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TimetableDto> update(@PathVariable Long id,
                                               @RequestBody NewTimetableDto updateDto) {
        TimetableDto timetableDto = timetableService.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(timetableDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        timetableService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
