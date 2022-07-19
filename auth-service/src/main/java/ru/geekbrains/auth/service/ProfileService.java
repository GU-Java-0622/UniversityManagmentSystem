package ru.geekbrains.auth.service;

import org.springframework.data.domain.Page;
import ru.geekbrains.auth.payload.request.ProfileGetAllDtoRequest;
import ru.geekbrains.auth.payload.response.ProfileDto;
import ru.geekbrains.auth.payload.response.ProfileGetAllDtoResponse;
import web.entity.UserStatus;


public interface ProfileService {
    Page<ProfileGetAllDtoResponse> getAllUsers(ProfileGetAllDtoRequest param);

    void changeStatus(Long id, UserStatus status);
    ProfileDto getProfileById(Long id);
}
