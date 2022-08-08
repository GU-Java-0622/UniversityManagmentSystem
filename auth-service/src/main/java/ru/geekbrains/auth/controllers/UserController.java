package ru.geekbrains.auth.controllers;


import org.springframework.web.bind.annotation.*;
import ru.geekbrains.auth.entityes.Role;
import ru.geekbrains.auth.repositories.RoleRepository;
import web.entity.ERole;
import web.entity.UserDto;
import ru.geekbrains.auth.service.UserService;
import web.entity.UserDtoList;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*Выдача фамилии по id*/
    @GetMapping("/get_user/{id}")
    public UserDto getSurnameById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    /*Выдача списка пользователей по id*/
    @PostMapping("/get_users/")
    public UserDtoList getCurrentUsers(@RequestBody List<Long> id) {
        return userService.findUsersById(id);
    }

    @GetMapping("/get_teachers")
    public UserDtoList getAllTeachers(){
        return userService.getTeachers();
    }


}
