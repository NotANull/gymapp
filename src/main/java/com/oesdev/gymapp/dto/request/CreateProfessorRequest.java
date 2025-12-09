package com.oesdev.gymapp.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateProfessorRequest {

    private List<CreateRoutineRequest> createdRoutines;
    private List<String> specialties;
    private List<LocalDate> availability;

    @NonNull
    private CreateUserRequest user;

}
