package com.oesdev.gymapp.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateCustomerRequest {

    @NotNull
    private CreateMembershipRequest membership;

    private List<CreateRoutineRequest> assignedRoutines;

    @Valid
    @NotNull
    private CreateUserRequest user;

}
