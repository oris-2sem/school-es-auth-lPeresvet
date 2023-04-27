package ru.itis.oris.jpahw.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.parent.ParentDto;
import ru.itis.oris.jpahw.services.ParentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;

    @PutMapping
    public ResponseEntity<ParentDto> signUp(@RequestBody SignUpDto signUpDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(parentService.save(signUpDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(parentService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ParentDto> update(@PathVariable Long id,
                                            @RequestBody UpdateUserDto updateDto) {
        ParentDto parentDto = parentService.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(parentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        parentService.delete(id);
        return ResponseEntity.accepted().build();
    }

}
