package ru.itis.oris.jpahw.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.itis.oris.jpahw.entities.users.Student;
import ru.itis.oris.jpahw.entities.users.Teacher;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "class")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(length = 1)
    private String letter;

    @Column(name = "enter_day")
    private Date enterDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;

    @OneToMany(mappedBy = "schoolClass")
    private List<Timetable> timetable;

}
