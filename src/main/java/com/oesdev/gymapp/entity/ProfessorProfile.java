package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfessorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Routine> createdRoutines;
    private List<String> specialties;
    private List<LocalDate> availability;
    private User user;

    public ProfessorProfile() {}

    public ProfessorProfile(Long id, User user) {
        this.id = id;
        this.createdRoutines = new ArrayList<>();
        this.specialties = new ArrayList<>();
        this.availability = new ArrayList<>();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Routine> getCreatedRoutines() {
        return createdRoutines;
    }

    public void setCreatedRoutines(List<Routine> createdRoutines) {
        this.createdRoutines = createdRoutines;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public List<LocalDate> getAvailability() {
        return availability;
    }

    public void setAvailability(List<LocalDate> availability) {
        this.availability = availability;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
