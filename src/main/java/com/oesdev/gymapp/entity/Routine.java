package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Routine {

    private Professor professor;
    private Customer customer;
    private String name;
    private int sets;
    private String reps;
    private int rest;
    private double load;
    private int frequency;

}
