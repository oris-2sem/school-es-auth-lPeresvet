package ru.itis.oris.jpahw.dto.parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

    private String login;
}
