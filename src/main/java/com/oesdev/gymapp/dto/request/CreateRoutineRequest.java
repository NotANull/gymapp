package com.oesdev.gymapp.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateRoutineRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Positive
    private int sets;

    @NotBlank
    @Size(min = 3, max = 50)
    private String reps;

    @PositiveOrZero
    private int rest;

    @PositiveOrZero
    @NotNull
    private Double load;

    @Positive
    private int frequency;

}
