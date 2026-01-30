package com.oesdev.gymapp.exception;

public class ProfessorNotFoundException extends RuntimeException {

    public ProfessorNotFoundException(Long id) {
        super("Professor with id " + id + " not found");
    }

}
