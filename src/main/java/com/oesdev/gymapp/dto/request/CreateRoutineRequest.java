package com.oesdev.gymapp.dto.request;

import com.oesdev.gymapp.entity.ProfessorProfile;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateRoutineRequest {

    @NotNull
    private CreateProfessorRequest professor;

    @NotNull
    private CreateCustomerRequest customer;

    private String name;
    private int sets;
    private String reps;
    private int rest;
    private double load;
    private int frequency;

}
