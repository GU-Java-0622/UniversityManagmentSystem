package ru.geekbrains.commons.security;

import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.exception.ForbiddenException;
import java.util.Set;

public class RoleChecker {


    /*Передаем все роли из заголовка и роль которая должна содержаться*/
    public void adminRoleCheck(Set<ERole> haveRoles){
        if (haveRoles==null){
            throw new ForbiddenException("Access denied");
        }
       if (!haveRoles.contains(ERole.ROLE_ADMIN)){
           throw new ForbiddenException("Access denied");
       }
    }
}
