package web.security;

import web.entity.ERole;
import web.exception.ForbiddenException;

import java.util.Collections;
import java.util.Set;

public class RoleChecker {
    /*Передаем все роли из заголовка и роль которая должна содержаться*/
    public static void roleCheck(Set<ERole> haveRoles, Set<ERole> neededRole){
        if (haveRoles==null){
            throw new ForbiddenException("Access denied");
        }
        /*Если хотя бы одна из ролей присутствует то все ок*/
       if (Collections.disjoint(haveRoles,neededRole)){
           throw new ForbiddenException("Access denied");
       }
    }
}
