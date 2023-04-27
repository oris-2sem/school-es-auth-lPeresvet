package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.task.TaskDto;
import ru.itis.oris.jpahw.services.TaskService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PutMapping
    public ResponseEntity<TaskDto> add(@RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.save(taskDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable Long id,
                                          @RequestBody TaskDto taskDto) {
        TaskDto taskDtoUpdate = taskService.update(id, taskDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskDtoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
