package ru.geekbrains.auth.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.auth.entityes.Role;
import ru.geekbrains.auth.repositories.RoleRepository;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.entity.UserDto;
import ru.geekbrains.auth.entityes.User;
import ru.geekbrains.auth.repositories.UserRepository;
import ru.geekbrains.auth.repositories.converters.UserConverter;
import ru.geekbrains.commons.entity.UserDtoList;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, UserConverter userConverter, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.roleRepository = roleRepository;
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findUserById(id);

        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getMiddlename(),
                user.getSurname(),
                user.getEmail());
    }

    public List<User> findUsersById(List<Long> id) {
        return userRepository.findAllUsersById(id);
    }


    public List<User> getTeachers() {
        Role role = roleRepository.findByName(ERole.ROLE_TEACHER).orElseThrow();
        return userRepository.findAllByRolesContaining(role);
    }
}
