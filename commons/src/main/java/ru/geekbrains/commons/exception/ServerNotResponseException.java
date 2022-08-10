package ru.geekbrains.commons.exception;

public class ServerNotResponseException extends RuntimeException{
    public ServerNotResponseException(String message) {
        super(message);
    }
}
