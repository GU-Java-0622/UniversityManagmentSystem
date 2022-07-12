package ru.geekbrains.com.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.exception.ResourceNotFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<ProfileAppError> catchResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProfileAppError( e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ProfileAppError> catchServerNotResponse(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ProfileAppError(e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
