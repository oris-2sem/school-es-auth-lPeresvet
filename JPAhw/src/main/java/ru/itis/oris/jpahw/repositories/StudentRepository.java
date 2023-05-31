package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.users.Student;
import ru.itis.oris.jpahw.entities.users.Teacher;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByLogin(String username);
}
