package com.karalexsandr.coreservice.exception;

import java.util.List;
import java.util.stream.Collectors;

public class StreamNotReadyException extends RuntimeException{
    private final List<String> errorMessages;

    public StreamNotReadyException(List<String> errorMessages){
        this.errorMessages = errorMessages;
    }

    @Override
    public String getMessage(){
        return errorMessages.stream().collect(Collectors.joining(";","{","}"));
    }
}
