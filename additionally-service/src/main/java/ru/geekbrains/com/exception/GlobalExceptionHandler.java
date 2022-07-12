package ru.geekbrains.com.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<AppError> catchBadRequest(BadRequestException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(e.getMessage(), HttpStatus.BAD_REQUEST.name()),HttpStatus.BAD_REQUEST);
    }

}
