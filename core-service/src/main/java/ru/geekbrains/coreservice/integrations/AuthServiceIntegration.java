package ru.geekbrains.coreservice.integrations;

import ru.geekbrains.coreservice.exception.AuthServiceIntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.geekbrains.commons.entity.ProfileDto;
import ru.geekbrains.commons.entity.UserDto;
import ru.geekbrains.commons.entity.UserDtoList;
import ru.geekbrains.commons.exception.AuthServiceAppError;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthServiceIntegration {
    private final WebClient authServiceWebClient;

    public UserDto getUserById(Long id){
        return authServiceWebClient.get()
                .uri("api/v1/users/"+id)
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse ->clientResponse.bodyToMono(AuthServiceAppError.class).map(
                                body->
                                {
                                    if (body.getStatusCode().equals(AuthServiceAppError.AuthServiceError.PROFILE_NOT_FOUND.name())) {
                                        return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: profile не найден");
                                    }
                                    return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: причина неизвестна");
                                }
                        )
                )
                .bodyToMono(UserDto.class)
                .block();
    }
    public UserDtoList getUserListById(List<Long> id){
        return authServiceWebClient.post()
                .uri("api/v1/users/get_users")
                .body(BodyInserters.fromObject(id))
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse ->clientResponse.bodyToMono(AuthServiceAppError.class).map(
                                body->
                                {
                                    if (body.getStatusCode().equals(AuthServiceAppError.AuthServiceError.PROFILE_NOT_FOUND.name())) {
                                        return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: profile не найден");
                                    }
                                    return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: причина неизвестна");
                                }
                        )
                )
                .bodyToMono(UserDtoList.class)
                .block();
    }

    public ProfileDto getProfileById(Long id){
        return authServiceWebClient.get()
                .uri("/profile")
                .header("id", String.valueOf(id))
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse ->clientResponse.bodyToMono(AuthServiceAppError.class).map(
                                body->
                                {
                                    if (body.getStatusCode().equals(AuthServiceAppError.AuthServiceError.PROFILE_NOT_FOUND.name())) {
                                        return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: profile не найден");
                                    }
                                    return new AuthServiceIntegrationException("Выполнен некорректный запрос к сервису auth: причина неизвестна");
                                }
                        )
                )
                .bodyToMono(ProfileDto.class)
                .block();
    }
}
