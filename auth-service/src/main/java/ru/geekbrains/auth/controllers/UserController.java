package ru.geekbrains.auth.controllers;


import org.springframework.web.bind.annotation.*;
import ru.geekbrains.auth.dto.UserDto;
import ru.geekbrains.auth.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*Выдача фамилии по id*/
    @GetMapping("/get_surname/{id}")
    public UserDto getSurnameById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    /*Выдача списка пользователей по id*/
    @GetMapping("/get_users/")
    public List<UserDto> getCurrentUsers(@RequestBody List<Long> id) {
        return userService.findUsersById(id);
    }


}
