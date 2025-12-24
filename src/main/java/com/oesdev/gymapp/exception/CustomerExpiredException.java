package com.oesdev.gymapp.exception;

public class CustomerExpiredException extends RuntimeException{

    public CustomerExpiredException(Long id) {
        super("Customer with id " + id + "is no longer active");
    }

}
