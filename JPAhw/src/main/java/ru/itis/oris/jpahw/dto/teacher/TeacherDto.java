package ru.itis.oris.jpahw.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeacherDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

    private String login;

}
