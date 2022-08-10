package ru.geekbrains.commons.entity;

import java.util.List;

public class UserDtoList {
    private List<UserDto> users;

    public UserDtoList(List<UserDto> users) {
        this.users = users;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
