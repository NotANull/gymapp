package com.oesdev.gymapp.exception;

public class MembershipNotFoundException extends RuntimeException{

    public MembershipNotFoundException(Long id) {
        super("Customer with id " + id + "is no longer active");
    }

}
