package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.school_class.ClassDto;

public interface ClassService {
    ClassDto getById(Long id);
    ClassDto save(ClassDto classDto);
    ClassDto update(Long id, ClassDto classDto);
    void delete(Long id);
}
