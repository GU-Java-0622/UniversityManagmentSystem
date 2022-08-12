package ru.geekbrains.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.auth.payload.request.ProfileGetAllDtoRequest;
import ru.geekbrains.auth.payload.response.ProfileDto;
import ru.geekbrains.auth.payload.response.ProfileGetAllDtoResponse;
import ru.geekbrains.auth.service.ProfileService;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.entity.UserStatus;
import ru.geekbrains.commons.security.RoleChecker;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("api/v1/profiles")
@RequiredArgsConstructor
@Tag(name = "Сервис для работы с профилями пользователей", description = "Методы работы с сервисом профилей пользователей")
public class ProfileController {
    private final ProfileService profileService;
    private final RoleChecker roleChecker;

    @Operation(
            summary = "Запрос на получение профиля пользователя",
            responses = {
                    @ApiResponse(
                            description = "Профиль возвращен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/current")
    public ProfileDto getProfile(@RequestHeader("id") Long id){
        return profileService.getProfileById(id);
    }

    @Operation(
            summary = "Запрос на получение профиля конкретного пользователя",
            responses = {
                    @ApiResponse(
                            description = "Профиль возвращен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public ProfileDto getProfileById(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles){
        roleChecker.adminRoleCheck(roles);
        return profileService.getProfileById(id);
    }

    @Operation(
            summary = "Запрос на получение профилей всех пользователей",
            responses = {
                    @ApiResponse(
                            description = "Профили возвращены", responseCode = "200"
                    )
            }
    )
    @PostMapping("/find")
    public Page<ProfileGetAllDtoResponse> getAllUsersWithFilters(@RequestBody ProfileGetAllDtoRequest param, @RequestHeader("roles") Set<ERole> roles) {
        roleChecker.adminRoleCheck(roles);
        return profileService.getAllUsers(param);
    }

    @Operation(
            summary = "Запрос на изменение профиля пользователя (выставление статуса Userstatus == deleted)",
            responses = {
                    @ApiResponse(
                            description = "Статус профиля изменен на deleted", responseCode = "200"
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles ) {
        roleChecker.adminRoleCheck(roles);
        profileService.changeStatus(id, UserStatus.DELETED);
    }

    @Operation(
            summary = "Запрос на изменение профиля пользователя (выставление статуса Userstatus == banned)",
            responses = {
                    @ApiResponse(
                            description = "Статус профиля изменен на banned", responseCode = "200"
                    )
            }
    )

    @PatchMapping("/{id}/ban")
    public void bannedProfile(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles) {
        roleChecker.adminRoleCheck(roles);
        profileService.changeStatus(id, UserStatus.BANNED);
    }

    @Operation(
            summary = "Запрос на изменение профиля пользователя (выставление статуса Userstatus == active)",
            responses = {
                    @ApiResponse(
                            description = "Статус профиля изменен на active", responseCode = "200"
                    )
            }
    )
    @PatchMapping("/{id}/active")
    public void activeProfile(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles) {
        roleChecker.adminRoleCheck(roles);
        profileService.changeStatus(id, UserStatus.ACTIVE);
    }


}
