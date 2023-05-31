package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
