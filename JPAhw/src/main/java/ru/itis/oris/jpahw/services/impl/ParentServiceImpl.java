package ru.itis.oris.jpahw.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.dto.SignUpDto;
import ru.itis.oris.jpahw.dto.UpdateUserDto;
import ru.itis.oris.jpahw.dto.parent.ParentDto;
import ru.itis.oris.jpahw.entities.users.Parent;
import ru.itis.oris.jpahw.entities.users.roles.Role;
import ru.itis.oris.jpahw.repositories.ParentRepository;
import ru.itis.oris.jpahw.services.ParentService;
import ru.itis.oris.jpahw.services.converters.ParentMapper;
import ru.itis.oris.jpahw.services.helpers.GetHelper;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ParentMapper parentMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ParentDto getById(Long id) {
        Parent parent = (Parent) GetHelper.getOrThrow(id, parentRepository);
        return parentMapper.fromParentToDto(parent);
    }

    @Override
    public ParentDto save(SignUpDto signUpDto) {
        Parent parent = parentMapper.fromSignUp(signUpDto);
        parent.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        parent.setRole(Role.PARENT);
        parentRepository.save(parent);
        return parentMapper.fromParentToDto(parent);
    }

    @Override
    public ParentDto update(Long id, UpdateUserDto updateDto) {
        Parent parentToUpdate = (Parent) GetHelper.getOrThrow(id, parentRepository);

        parentToUpdate.setLogin(updateDto.getLogin());
        parentToUpdate.setName(updateDto.getName());
        parentToUpdate.setSurname(updateDto.getSurname());
        parentToUpdate.setPatronymic(updateDto.getPatronymic());

        parentRepository.save(parentToUpdate);
        return parentMapper.fromParentToDto(parentToUpdate);
    }

    @Override
    public void delete(Long id) {
        Parent parent = (Parent) GetHelper.getOrThrow(id, parentRepository);
        parentRepository.delete(parent);
    }
}
