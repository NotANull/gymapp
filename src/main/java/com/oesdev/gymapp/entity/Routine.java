package com.oesdev.gymapp.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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

    public Routine(String name, int sets, String reps, int rest, double load, int frequency) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.load = load;
        this.frequency = frequency;
    }
}
