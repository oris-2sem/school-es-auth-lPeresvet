package ru.itis.oris.jpahw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
