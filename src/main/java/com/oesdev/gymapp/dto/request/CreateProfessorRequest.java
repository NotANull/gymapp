package com.oesdev.gymapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateProfessorRequest {

    @Valid
    @NotNull
    private CreateUserRequest user;

}
