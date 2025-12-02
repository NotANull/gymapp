package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Professor extends User{

    private List<Routine> createdRoutines;
    private List<String> specialties;
    private List<LocalDate>  availability;

    public Professor(Long id, String name, String lastname, String dni, String username, String password, String email, String phoneNumber, String emergencyPhoneNumber, Adress adress) {
        super(id, name, lastname, dni, username, password, email, phoneNumber, emergencyPhoneNumber, adress);
        this.createdRoutines = new ArrayList<>();
        this.specialties = new ArrayList<>();
        this.availability = new ArrayList<>();
    }
}
