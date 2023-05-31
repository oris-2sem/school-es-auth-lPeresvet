package ru.itis.oris.jpahw.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.oris.jpahw.dto.parent.ParentDto;
import ru.itis.oris.jpahw.dto.school_class.ClassDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

    private String login;

    private ParentDto parent;

    private ClassDto schoolClass;
}
