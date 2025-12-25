package com.oesdev.gymapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerProfile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

    @OneToMany(mappedBy = "customer")
    private List<Routine> assignedRoutines;

    private LocalDate enrollmentDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public CustomerProfile() {}

    public CustomerProfile(Membership membership, LocalDate enrollmentDate, User user) {
        this.membership = membership;
        this.assignedRoutines = new ArrayList<>();
        this.enrollmentDate = enrollmentDate;
        this.user = user;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public List<Routine> getAssignedRoutines() {
        return assignedRoutines;
    }

    public void setAssignedRoutines(List<Routine> assignedRoutines) {
        this.assignedRoutines = assignedRoutines;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

