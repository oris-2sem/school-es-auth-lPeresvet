package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.timetable.NewTimetableDto;
import ru.itis.oris.jpahw.dto.timetable.TimetableDto;
import ru.itis.oris.jpahw.entities.Timetable;

@Mapper(componentModel = "spring")
public interface TimetableMapper {


    TimetableDto fromTimetable(Timetable timetable);

    Timetable fromDto(TimetableDto timetableDto);
}
