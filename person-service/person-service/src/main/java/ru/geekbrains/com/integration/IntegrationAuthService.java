package ru.geekbrains.com.integration;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.geekbrains.com.configs.AuthServiceIntegrationProperty;
import web.exception.ResourceNotFoundException;
import web.exception.ServerNotResponseException;

@Component
public class IntegrationAuthService {
    private final WebClient authServiceClient;
    private final AuthServiceIntegrationProperty authProperty = new AuthServiceIntegrationProperty();

    public IntegrationAuthService(WebClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    public String getEmailById (Long id){
        return authServiceClient.get()
                .uri(authProperty.getAuthServiceUrl()+"api/v1/auth/get_email/"+id)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ServerNotResponseException("Auth-service временно не доступен")))
                .onStatus(HttpStatus.NOT_FOUND::equals,clientResponse -> Mono.error(new ResourceNotFoundException("Не пользователь с id: "+id)))
                .bodyToMono(String.class)
                .block();
    }
}
