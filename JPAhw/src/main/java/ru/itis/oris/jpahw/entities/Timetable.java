package ru.itis.oris.jpahw.entities;

import lombok.*;
import ru.itis.oris.jpahw.entities.users.Teacher;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @Column(name = "auditorium_number", length = 5)
    private String auditoriumNumber;

    private Date date;
}
