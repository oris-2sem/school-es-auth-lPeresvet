package ru.itis.oris.jpahw.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.itis.oris.jpahw.entities.SchoolClass;
import ru.itis.oris.jpahw.entities.Task;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "student")
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private SchoolClass schoolClass;

    @OneToMany(mappedBy = "student")
    private List<Task> tasks;


}
