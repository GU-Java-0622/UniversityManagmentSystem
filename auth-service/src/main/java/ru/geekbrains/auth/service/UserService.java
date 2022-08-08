package ru.geekbrains.auth.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.auth.entityes.Role;
import ru.geekbrains.auth.repositories.RoleRepository;
import web.entity.ERole;
import web.entity.UserDto;
import ru.geekbrains.auth.entityes.User;
import ru.geekbrains.auth.repositories.UserRepository;
import ru.geekbrains.auth.repositories.converters.UserConverter;
import web.entity.UserDtoList;

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

    public UserDtoList findUsersById(List<Long> id) {
        return new UserDtoList(userRepository.findAllUsersById(id).stream().map(userConverter::entityToDto).collect(Collectors.toList()));
    }


    public UserDtoList getTeachers() {
        Role role = roleRepository.findByName(ERole.ROLE_TEACHER).orElseThrow();

        List<UserDto> users = userRepository.findAllByRolesContaining(role).stream().map(x->new UserDto(
                x.getId(), x.getFirstname(), x.getSurname(),x.getMiddlename(),x.getEmail()
        )).collect(Collectors.toList());
        return new UserDtoList(users);
    }
}
