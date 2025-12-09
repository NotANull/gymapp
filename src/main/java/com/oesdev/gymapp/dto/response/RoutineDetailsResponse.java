package com.oesdev.gymapp.dto.response;

//Cambiar los imports cuando se crean los demás DTO's
import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.entity.ProfessorProfile;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class RoutineDetailsResponse {

    private Long id;
    private ProfessorProfile professor;
    private CustomerProfile customer;
    private String name;
    private int sets;
    private String reps;
    private int rest;
    private double load;
    private int frequency;

}
