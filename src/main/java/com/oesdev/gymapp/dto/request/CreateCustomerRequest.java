package com.oesdev.gymapp.dto.request;

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

    @PastOrPresent
    private LocalDate enrollmentDate;

    @NotNull
    private CreateMembershipRequest membership;

    private List<CreateRoutineRequest> assignedRoutines;

    @NotNull
    private CreateUserRequest user;

}
