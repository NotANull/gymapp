package com.oesdev.gymapp.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class RoutineDetailsResponse {

    private Long id;
    private String name;
    private int sets;
    private int reps;
    private int rest;
    private double load;
    private int frequency;

}
