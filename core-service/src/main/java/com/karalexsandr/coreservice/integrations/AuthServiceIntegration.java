package com.karalexsandr.coreservice.integrations;

import com.karalexsandr.coreservice.exception.AuthServiceIntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import web.entity.ProfileDto;

import web.exception.AuthServiceAppError;

@Component
@RequiredArgsConstructor
public class AuthServiceIntegration {
    private final WebClient authServiceWebClient;

    public ProfileDto getUserById(Long id){
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
