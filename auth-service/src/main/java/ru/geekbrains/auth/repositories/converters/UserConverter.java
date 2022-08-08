package ru.geekbrains.auth.repositories.converters;

import org.springframework.stereotype.Component;
import web.entity.UserDto;
import ru.geekbrains.auth.entityes.User;

@Component
public class UserConverter {

    public UserDto entityToDto(User user) {
        UserDto out = new UserDto();
        out.setId(user.getId());
        out.setFirstname(user.getFirstname());
        out.setMiddlename(user.getMiddlename());
        out.setSurname(user.getSurname());
        out.setEmail(user.getEmail());
        return out;
    }

    public UserConverter() {
    }


}
