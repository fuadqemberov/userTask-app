package com.company.usertask.exception;

public class UserNotFoundException extends RuntimeException {



    public UserNotFoundException(String message){
        super(message);
    }
}
