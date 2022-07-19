package web.security;

import web.entity.ERole;
import web.exception.ForbiddenException;

import java.util.Set;

public class RoleChecker {
    /*Передаем все роли из заголовка и роль которая должна содержаться*/
    public static void roleCheck(Set<ERole> roles, ERole role){
        if (roles==null||!roles.contains(ERole.ROLE_ADMIN)){
            throw new ForbiddenException("Access denied");
        }
    }
}
