package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.parent.ParentDto;

public interface ParentService {
    ParentDto getById(Long id);
    ParentDto save(SignUpDto signUpDto);
    ParentDto update(Long id, UpdateUserDto updateDto);
    void delete(Long id);
}
