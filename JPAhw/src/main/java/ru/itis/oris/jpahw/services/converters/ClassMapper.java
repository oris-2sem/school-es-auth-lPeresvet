package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.school_class.ClassDto;
import ru.itis.oris.jpahw.entities.SchoolClass;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassDto fromClass(SchoolClass schoolClass);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "timetable", ignore = true)
    SchoolClass fromDto(ClassDto classDto);
}
