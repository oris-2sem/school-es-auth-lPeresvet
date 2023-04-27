package ru.itis.oris.jpahw.entities.users;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.oris.jpahw.entities.SchoolClass;
import ru.itis.oris.jpahw.entities.Timetable;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "teacher")
    private List<SchoolClass> classes;

    @OneToMany(mappedBy = "teacher")
    private List<Timetable> timetable;
}
