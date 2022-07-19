package ru.geekbrains.auth.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.auth.payload.request.ProfileGetAllDtoRequest;
import ru.geekbrains.auth.payload.response.ProfileDto;
import ru.geekbrains.auth.payload.response.ProfileGetAllDtoResponse;
import ru.geekbrains.auth.service.ProfileService;
import web.entity.ERole;
import web.entity.UserStatus;
import web.exception.ForbiddenException;
import web.security.RoleChecker;

import java.util.Set;


@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /*свой собственный профиль*/
    @GetMapping("/profile")
    public ProfileDto getProfile(@RequestHeader("id") Long id){
        return profileService.getProfileById(id);
    }

    /*Администратор смотрит профиль другого человека*/
    @GetMapping("/get_profile/{id}")
    public ProfileDto getProfileById(@PathVariable Long id, @RequestHeader("role") Set<ERole> roles){
        if (roles==null||!roles.contains(ERole.ROLE_ADMIN)){
            throw new ForbiddenException("Access denied");
        }
        return profileService.getProfileById(id);
    }

    @PostMapping("/get_all")
    public Page<ProfileGetAllDtoResponse> getAllUsersWithFilters(@RequestBody ProfileGetAllDtoRequest param, @RequestHeader("role") Set<ERole> roles) {
        if (roles==null||!roles.contains(ERole.ROLE_ADMIN)){
            throw new ForbiddenException("Access denied");
        }
        return profileService.getAllUsers(param);
    }

    @PutMapping("/delete/{id}")
    public void deleteProfile(@PathVariable Long id, @RequestHeader("role") Set<ERole> roles ) {
        RoleChecker.roleCheck(roles,ERole.ROLE_ADMIN);
        profileService.changeStatus(id, UserStatus.DELETED);
    }

    @PutMapping("/banned/{id}")
    public void bannedProfile(@PathVariable Long id, @RequestHeader("role") Set<ERole> roles) {
        RoleChecker.roleCheck(roles,ERole.ROLE_ADMIN);
        profileService.changeStatus(id, UserStatus.BANNED);
    }

    @PutMapping("/active/{id}")
    public void activeProfile(@PathVariable Long id, @RequestHeader("role") Set<ERole> roles) {
        RoleChecker.roleCheck(roles,ERole.ROLE_ADMIN);
        profileService.changeStatus(id, UserStatus.ACTIVE);
    }


}
