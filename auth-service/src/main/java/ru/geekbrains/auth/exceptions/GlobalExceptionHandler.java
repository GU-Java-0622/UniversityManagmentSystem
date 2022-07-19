package ru.geekbrains.auth.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.exception.ForbiddenException;
import web.exception.ResourceNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<AuthException> catchResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AuthException( e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AuthException>  catchTokenRefreshException(TokenRefreshException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AuthException(e.getMessage()),HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    public ResponseEntity<AuthException> accessDeniedException(ForbiddenException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AuthException(e.getMessage()),HttpStatus.FORBIDDEN);
    }

}
