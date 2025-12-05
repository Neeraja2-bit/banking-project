package com.banking.service;

public class BadCreditianlException extends Throwable {
    public BadCreditianlException(String invalidCredentials) {
        super(invalidCredentials);
    }
}
