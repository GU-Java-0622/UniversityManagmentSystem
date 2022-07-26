package com.karalexsandr.coreservice.exception;


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
    public ResponseEntity<CoreException> catchResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new CoreException( e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CoreException> catchStreamNotReady(StreamNotReadyException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new CoreException( e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CoreException> catchCoreException(CoreException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new CoreException( e.getMessage()), HttpStatus.CONFLICT);
    }


}
