package com.oesdev.gymapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorProfile professor;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;


    private String name;
    private int sets;
    private String reps;
    private int rest;
    private double load;
    private int frequency;

}
