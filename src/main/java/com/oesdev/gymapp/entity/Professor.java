package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Professor extends User{

    private List<Routine> createdRoutines;

    public Professor(Long id, String name, String lastname, String dni, String phoneNumber, String emergencyPhoneNumber, Adress adress) {
        super(id, name, lastname, dni, phoneNumber, emergencyPhoneNumber, adress);
        this.createdRoutines = new ArrayList<>();
    }
}
