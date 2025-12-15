package com.oesdev.gymapp.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProfessorDetailsResponse {

    private Long id;
    private List<RoutineDetailsResponse> createdRoutines;
    private List<String> specialties;
    private List<LocalDate> availability;
    private UserDetailsResponse user;

}
