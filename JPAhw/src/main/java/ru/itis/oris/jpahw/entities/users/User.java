package ru.itis.oris.jpahw.entities.users;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.oris.jpahw.entities.users.roles.Role;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private String surname;
    private String name;
    private String patronymic;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Setter
    private String login;

    @Setter
    private String password;

}
