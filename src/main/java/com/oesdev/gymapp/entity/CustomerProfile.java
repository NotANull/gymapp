package com.oesdev.gymapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
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

