package ru.itis.oris.jpahw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.oris.jpahw.dto.parent.ParentDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String surname;
    private String name;
    private String patronymic;

    private ParentDto parent;

    private String login;
    private String password;
}
