package ru.geekbrains.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.auth.entityes.Role;
import ru.geekbrains.auth.entityes.User;
import ru.geekbrains.auth.repositories.RoleRepository;
import ru.geekbrains.auth.repositories.UserRepository;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.entity.ListOfUsersDto;
import ru.geekbrains.commons.entity.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserDto findUserById(Long id) {
        User user = userRepository.findUserById(id);

        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getMiddlename(),
                user.getSurname(),
                user.getEmail());
    }

    public List<User> findUsersById(ListOfUsersDto userDtoList) {

        List<User> userList = userDtoList.getList().stream().map(userRepository::findUserById).collect(Collectors.toList());
        return userList;
    }


    public List<User> getTeachers() {
        Role role = roleRepository.findByName(ERole.ROLE_TEACHER).orElseThrow();
        return userRepository.findAllByRolesContaining(role);
    }
}
