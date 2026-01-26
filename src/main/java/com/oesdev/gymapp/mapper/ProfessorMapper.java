package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.CreateUserRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {


    public ProfessorProfile toEntity(CreateProfessorRequest request) {

        //ProfessorProfile professorEntity = new ProfessorProfile();

        return new ProfessorProfile(
                this.toUser(request.getUser())
        );

    }


    public ProfessorDetailsResponse toResponse(ProfessorProfile professorEntity) {

        ProfessorDetailsResponse professorResponse = new ProfessorDetailsResponse();
        List<String> specialitiesResponse = new ArrayList<>(professorEntity.getSpecialties());
        List<LocalDate> availabilityResponse = new ArrayList<>(professorEntity.getAvailability());

        professorResponse.setId(professorEntity.getId());
        professorResponse.setSpecialties(specialitiesResponse);
        professorResponse.setAvailability(availabilityResponse);
        professorResponse.setUser(this.toUserResponse(professorEntity.getUser()));

        return professorResponse;

    }

    private User toUser(CreateUserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setDni(request.getDni());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmergencyPhoneNumber(request.getEmergencyPhoneNumber());

        return user;
    }

    private UserDetailsResponse toUserResponse(User response) {

        UserDetailsResponse userResponse = new UserDetailsResponse();
        userResponse.setName(response.getName());
        userResponse.setLastname(response.getLastname());
        userResponse.setDni(response.getDni());
        userResponse.setEmail(response.getEmail());
        userResponse.setPhoneNumber(response.getPhoneNumber());
        userResponse.setEmergencyPhoneNumber(response.getEmergencyPhoneNumber());

        return userResponse;

    }
}
