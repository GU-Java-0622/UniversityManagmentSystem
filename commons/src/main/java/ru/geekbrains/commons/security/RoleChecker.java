package ru.geekbrains.commons.security;

import org.springframework.stereotype.Component;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.exception.ForbiddenException;

import java.util.Collections;
import java.util.Set;

@Component
public class RoleChecker {

//    ToDo: 1. Убрать статику; 2. Добавить метод проверки на админство; 3. Сделать бином (сделано)

    /*Передаем все роли из заголовка и роль которая должна содержаться*/
    public void adminRoleCheck(Set<ERole> haveRoles){
        if (haveRoles==null){
            throw new ForbiddenException("Access denied");
        }
        /*Если хотя бы одна из ролей присутствует то все ок*/
       if (!haveRoles.contains(ERole.ROLE_ADMIN)){
           throw new ForbiddenException("Access denied");
       }
    }
}
