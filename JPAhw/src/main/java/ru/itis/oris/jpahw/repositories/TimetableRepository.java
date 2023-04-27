package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
