package ru.geekbrains.coreservice.exception;

public class AuthServiceIntegrationException extends RuntimeException {
    public AuthServiceIntegrationException(String message) {
        super(message);
    }
}