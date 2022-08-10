package ru.geekbrains.additionaly.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends RuntimeException{
    private final HttpStatus status;
    public BadRequestException (String message,HttpStatus status){
        super(message);
        this.status = status;
    }
}
