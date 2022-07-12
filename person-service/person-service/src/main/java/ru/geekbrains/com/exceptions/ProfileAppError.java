package ru.geekbrains.com.exceptions;

public class ProfileAppError extends RuntimeException{
    public ProfileAppError (String message){
        super(message);
    }
}
