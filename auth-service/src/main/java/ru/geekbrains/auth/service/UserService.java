package ru.geekbrains.auth.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.auth.dto.UserDto;
import ru.geekbrains.auth.entityes.User;
import ru.geekbrains.auth.repositories.UserRepository;
import ru.geekbrains.auth.repositories.converters.UserConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
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

    public List<UserDto> findUsersById(List<Long> id) {
        return userRepository.findAllUsersById(id).stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }


}
