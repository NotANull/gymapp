package com.oesdev.gymapp.exception;

public class MembershipNotFoundException extends RuntimeException{

    public MembershipNotFoundException(Long id) {
        super("Membership with id " + id + " not found");
    }

}
