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
public class Customer extends User{

    private LocalDate enrollmentDate;
    private Membership membership;
    private List<Routine> assignedRoutines;

    public Customer(Long id, String name, String lastname, String dni, String username, String password, String email, String phoneNumber, String emergencyPhoneNumber, Adress adress, LocalDate enrollmentDate, Membership membership, List<Routine> assignedRoutines) {
        super(id, name, lastname, dni, username, password, email, phoneNumber, emergencyPhoneNumber, adress);
        this.enrollmentDate = enrollmentDate;
        this.membership = membership;
        this.assignedRoutines = new ArrayList<>();
    }
}

