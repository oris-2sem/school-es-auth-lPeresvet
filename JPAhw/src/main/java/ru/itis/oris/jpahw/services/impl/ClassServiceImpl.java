package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.school_class.ClassDto;
import ru.itis.oris.jpahw.entities.SchoolClass;
import ru.itis.oris.jpahw.repositories.SchoolClassRepository;
import ru.itis.oris.jpahw.services.ClassService;
import ru.itis.oris.jpahw.services.converters.ClassMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final SchoolClassRepository classRepository;
    private final ClassMapper classMapper;

    @Override
    public ClassDto getById(Long id) {
        SchoolClass schoolClass = (SchoolClass) GetHelper.getOrThrow(id, classRepository);
        return classMapper.fromClass(schoolClass);
    }

    @Override
    public ClassDto save(ClassDto classDto) {
        SchoolClass schoolClass = classMapper.fromDto(classDto);
        classRepository.save(schoolClass);
        return classMapper.fromClass(schoolClass);
    }

    @Override
    public ClassDto update(Long id, ClassDto classDto) {
        SchoolClass schoolClassToUpdate = (SchoolClass) GetHelper.getOrThrow(id, classRepository);

        schoolClassToUpdate.setEnterDate(classDto.getEnterDate());
        schoolClassToUpdate.setLetter(classDto.getLetter());

        classRepository.save(schoolClassToUpdate);
        return classMapper.fromClass(schoolClassToUpdate);
    }

    @Override
    public void delete(Long id) {
        SchoolClass schoolClass = (SchoolClass) GetHelper.getOrThrow(id, classRepository);
        classRepository.delete(schoolClass);
    }
}
