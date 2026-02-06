package com.oesdev.gymapp.dto.response;

import com.oesdev.gymapp.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ProfessorDetailsResponse {

    private Long id;
    private List<String> specialties;
    private List<LocalDate> availability;
    private Status status;
    private UserDetailsResponse user;

}
