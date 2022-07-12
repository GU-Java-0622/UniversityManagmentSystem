package ru.geekbrains.com.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.com.dto.ProfileDto;
import ru.geekbrains.com.dto.ProfileGetAllDtoRequest;
import ru.geekbrains.com.dto.ProfileGetAllDtoResponse;
import ru.geekbrains.com.entity.ProfileStatus;


public interface ProfileService {
    Page<ProfileGetAllDtoResponse> getAllUsers(ProfileGetAllDtoRequest param);

    void changeStatus(Long id, ProfileStatus status);
    ProfileDto getProfileById(Long id);
}
