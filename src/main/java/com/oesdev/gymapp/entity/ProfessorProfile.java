package com.oesdev.gymapp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ProfessorProfile {

    private List<Routine> createdRoutines;
    private List<String> specialties;
    private List<LocalDate> availability;
    private User user;

}
