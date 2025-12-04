package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class CustomerProfile{

    private LocalDate enrollmentDate;
    private Membership membership;
    private List<Routine> assignedRoutines;
    private User user;

}

