package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
