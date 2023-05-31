package ru.itis.oris.jpahw.services;

import ru.itis.oris.jpahw.dto.timetable.NewTimetableDto;
import ru.itis.oris.jpahw.dto.timetable.TimetableDto;

public interface TimetableService {
    TimetableDto getById(Long id);
    TimetableDto save(NewTimetableDto newTimetableDto);
    TimetableDto update(Long id, NewTimetableDto updateTimetableDto);
    void delete(Long id);
}
