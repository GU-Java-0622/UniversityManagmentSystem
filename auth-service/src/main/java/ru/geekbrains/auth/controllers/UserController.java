package ru.geekbrains.auth.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.auth.repositories.converters.UserConverter;
import ru.geekbrains.commons.entity.ListOfUsersDto;
import ru.geekbrains.commons.entity.UserDto;
import ru.geekbrains.auth.service.UserService;
import ru.geekbrains.commons.entity.UserDtoList;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Сервис для работы с пользователями", description = "Методы работы с сервисом работы с пользователями")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @Operation(
            summary = "Запрос на получение пользователя по ID",
            responses = {
                    @ApiResponse(
                            description = "Пользователь получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @Operation(
            summary = "Запрос на получение списка пользователей по массиву ID",
            responses = {
                    @ApiResponse(
                            description = "Пользователи получены", responseCode = "200"
                    )
            }
    )
    @GetMapping ("/all")
    public List<UserDto> getCurrentUsers(@RequestBody ListOfUsersDto userDtoList) {
        return userService.findUsersById(userDtoList).stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }

    @Operation(
            summary = "Запрос на получение пользователей с ролью TEACHER по ID",
            responses = {
                    @ApiResponse(
                            description = "Пользователь получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/teachers")
    public List<UserDto> getAllTeachers(){
        return userService.getTeachers().stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }


}
