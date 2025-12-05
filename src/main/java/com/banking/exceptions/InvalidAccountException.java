package com.banking.exceptions;

public class InvalidAccountException extends RuntimeException{
    public InvalidAccountException(String message){
        super(message);
    }
}
