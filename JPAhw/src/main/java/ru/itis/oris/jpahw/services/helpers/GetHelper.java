package ru.itis.oris.jpahw.services.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oris.jpahw.exceptions.NotFoundException;

public class GetHelper {
    public static Object getOrThrow(Long id, JpaRepository<?, Long> repository) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No entity with id <" + id + ">."));
    }
}
