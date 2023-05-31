package ru.itis.oris.jpahw.services.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.parent.ParentDto;
import ru.itis.oris.jpahw.entities.users.Parent;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    ParentDto fromParentToDto(Parent parent);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "children", ignore = true)
    Parent from(ParentDto parentDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "children", ignore = true)
    Parent fromSignUp(SignUpDto signUpDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "children", ignore = true)
    Parent fromUpdateDto(UpdateUserDto updateDto);
}
