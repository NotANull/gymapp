package com.oesdev.gymapp.entity;

import com.oesdev.gymapp.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfessorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "professor")
    private List<Routine> createdRoutines;

    @ElementCollection
    @CollectionTable(
            name = "professor_specialties",
            joinColumns = @JoinColumn(name = "professor_id")
    )
    @Column(name = "specialty")
    private List<String> specialties;

    @ElementCollection
    @CollectionTable(
            name = "professor_availability",
            joinColumns = @JoinColumn(name = "professor_id")
    )
    @Column(name = "available_date")
    private List<LocalDate> availability;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    public ProfessorProfile() {}

    public ProfessorProfile(User user) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
