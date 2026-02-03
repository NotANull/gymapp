package com.oesdev.gymapp.entity;

import com.oesdev.gymapp.enums.Status;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    public CustomerProfile() {}

    public CustomerProfile(Membership membership, LocalDate enrollmentDate, Status status, User user) {
        this.membership = membership;
        this.assignedRoutines = new ArrayList<>();
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.user = user;
    }

    public Membership getMembership() {
        return membership;
    }

    public Long getId() {
        return id;
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

