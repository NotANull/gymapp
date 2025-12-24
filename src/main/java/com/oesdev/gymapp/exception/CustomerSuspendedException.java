package com.oesdev.gymapp.exception;

public class CustomerSuspendedException extends RuntimeException{

    public CustomerSuspendedException(Long id) {
        super("Customer with id " + id + " is suspended");
    }

}
