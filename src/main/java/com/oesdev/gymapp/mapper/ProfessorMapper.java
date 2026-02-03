package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.*;
import com.oesdev.gymapp.dto.response.AddressDetailsResponse;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.Address;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.entity.User;
import com.oesdev.gymapp.enums.Status;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {


    public ProfessorProfile toEntity(CreateProfessorRequest request) {

        return new ProfessorProfile(
                Status.ACTIVE, this.toUser(request.getUser())
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

    public void updateProfessorFromRequest(ProfessorProfile professorEntity, UpdateProfessorRequest request) {

        if (request.getUser() != null) {
            updateUserRequest(professorEntity.getUser(), request.getUser());
        }

    }

    private void updateUserRequest(User user, UpdateUserRequest request) {

        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getLastname() != null) {
            user.setLastname(request.getLastname());
        }
        if (request.getDni() != null) {
            user.setDni(request.getDni());
        }
        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPhoneNumber() != null) {
            user.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getEmergencyPhoneNumber() != null) {
            user.setEmergencyPhoneNumber(request.getEmergencyPhoneNumber());
        }
        if(request.getAddress() != null){
            updateAddressRequest(user.getAddress(), request.getAddress());
        }
    }

    private void updateAddressRequest(Address address, UpdateAddressRequest request) {

        if(request.getStreet() != null) {
            address.setStreet(request.getStreet());
        }
        if(request.getNumber() != null) {
            address.setNumber(request.getNumber());
        }
        if(request.getCity() != null) {
            address.setCity(request.getCity());
        }
        if(request.getCountry() != null) {
            address.setCountry(request.getCountry());
        }

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
        user.setAddress(this.toAddress(request.getAddress()));

        return user;
    }

    private Address toAddress(CreateAddressRequest request) {

        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setNumber(request.getNumber());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());

        return address;

    }

    private UserDetailsResponse toUserResponse(User response) {

        UserDetailsResponse userResponse = new UserDetailsResponse();
        userResponse.setName(response.getName());
        userResponse.setLastname(response.getLastname());
        userResponse.setDni(response.getDni());
        userResponse.setEmail(response.getEmail());
        userResponse.setPhoneNumber(response.getPhoneNumber());
        userResponse.setEmergencyPhoneNumber(response.getEmergencyPhoneNumber());
        userResponse.setAddress(this.toAddressResponse(response.getAddress()));

        return userResponse;

    }

    private AddressDetailsResponse toAddressResponse(Address response) {

        AddressDetailsResponse addressResponse = new AddressDetailsResponse();
        addressResponse.setStreet(response.getStreet());
        addressResponse.setNumber(response.getNumber());
        addressResponse.setCity(response.getCity());
        addressResponse.setCountry(response.getCountry());

        return addressResponse;
    }


}
