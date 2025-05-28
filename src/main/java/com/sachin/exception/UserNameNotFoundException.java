package com.sachin.exception;

public class UserNameNotFoundException extends RuntimeException {

    public UserNameNotFoundException(String name) {
        super(name);
    }

}