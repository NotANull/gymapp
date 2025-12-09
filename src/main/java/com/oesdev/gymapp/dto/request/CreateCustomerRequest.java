package com.oesdev.gymapp.dto.request;

//CAMBIAR CUANDO CREEMOS LOS DEMAS DTO's
import com.oesdev.gymapp.entity.Membership;

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
    private Membership membership;

    private List<CreateRoutineRequest> assignedRoutines;

    @NotNull
    private CreateUserRequest user;

}
