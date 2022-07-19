package ru.geekbrains.com.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.com.dto.ProfileDto;
import ru.geekbrains.com.dto.ProfileGetAllDtoRequest;
import ru.geekbrains.com.dto.ProfileGetAllDtoResponse;
import ru.geekbrains.com.entity.ProfileStatus;
import ru.geekbrains.com.service.ProfileService;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/get_profile")
    public ProfileDto getProfile(@RequestHeader("id") Long id){
        return profileService.getProfileById(id);
    }

    @PostMapping("/get_all")
    public Page<ProfileGetAllDtoResponse> getAllUsersWithFilters(@RequestBody ProfileGetAllDtoRequest param) {
        return profileService.getAllUsers(param);
    }

    @PutMapping("/delete/{id}")
    public void deleteProfile(@PathVariable Long id ) {
        profileService.changeStatus(id, ProfileStatus.DELETED);
    }
    @PutMapping("/banned/{id}")
    public void bannedProfile(@PathVariable Long id) {
        profileService.changeStatus(id, ProfileStatus.BANNED);
    }
    @PutMapping("/active/{id}")
    public void activeProfile(@PathVariable Long id) {
        profileService.changeStatus(id, ProfileStatus.ACTIVE);
    }


}
