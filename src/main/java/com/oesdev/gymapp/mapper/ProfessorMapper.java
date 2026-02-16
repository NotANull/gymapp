package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.*;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.entity.ProfessorProfile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {

    private final UserMapper userMapper = new UserMapper();

    public ProfessorProfile toEntity(CreateProfessorRequest request) {

        return new ProfessorProfile(
                this.userMapper.toUserEntity(request.getUser())
        );

    }

    public ProfessorDetailsResponse toResponse(ProfessorProfile professorEntity) {

        ProfessorDetailsResponse professorResponse = new ProfessorDetailsResponse();
        List<String> specialitiesResponse = new ArrayList<>(professorEntity.getSpecialties());
        List<LocalDate> availabilityResponse = new ArrayList<>(professorEntity.getAvailability());

        professorResponse.setId(professorEntity.getId());
        professorResponse.setSpecialties(specialitiesResponse);
        professorResponse.setAvailability(availabilityResponse);
        professorResponse.setStatus(professorEntity.getStatus());
        professorResponse.setUser(this.userMapper.toUserResponse(professorEntity.getUser()));

        return professorResponse;

    }

    public void updateProfessorFromRequest(ProfessorProfile professorEntity, UpdateProfessorRequest request) {

        if (request.getUser() != null) {
            this.userMapper.updateUser(professorEntity.getUser(), request.getUser());
        }

    }

}
