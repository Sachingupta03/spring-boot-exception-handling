package com.sachin.exception;

public class UserEmailNotFoundException extends RuntimeException{
    public UserEmailNotFoundException(String message){
        super(message);
    }
}
