package ru.itis.oris.jpahw.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.oris.jpahw.entities.users.Parent;
import ru.itis.oris.jpahw.entities.users.Student;
import ru.itis.oris.jpahw.entities.users.Teacher;
import ru.itis.oris.jpahw.entities.users.User;
import ru.itis.oris.jpahw.repositories.ParentRepository;
import ru.itis.oris.jpahw.repositories.StudentRepository;
import ru.itis.oris.jpahw.repositories.TeacherRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final TeacherRepository teacherRepository;
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Parent> teacher = parentRepository.findByLogin(username);
        Optional<Teacher> admin = teacherRepository.findByLogin(username);
        Optional<Student> student = studentRepository.findByLogin(username);

        User user = null;
        if (teacher.isPresent()) {
            user = teacher.get();
        } else if (admin.isPresent()) {
            user = admin.get();
        } else if (student.isPresent()) {
            user = student.get();
        }
        if (user != null) {
            return new UserDetailsImpl(user);
        } else {
            throw new UsernameNotFoundException(
                    "Пользователя с логином <" + username + "> не найдено"
            );
        }
    }
}
