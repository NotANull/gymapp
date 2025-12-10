package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerProfile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Membership membership;
    private List<Routine> assignedRoutines;

    @NotNull
    private User user;

    public CustomerProfile() {}

    public CustomerProfile(Membership membership, List<Routine> assignedRoutines, User user) {
        this.membership = membership;
        this.assignedRoutines = new ArrayList<>();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

