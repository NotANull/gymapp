package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.*;
import com.oesdev.gymapp.dto.response.*;
import com.oesdev.gymapp.entity.*;
import com.oesdev.gymapp.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    private final UserMapper userMapper = new UserMapper();
    private final RoutineMapper routineMapper = new RoutineMapper();

    public CustomerProfile toCustomerProfile(CreateCustomerRequest request) {

        CustomerProfile customerEntity = new CustomerProfile();

        //Address addressEntity = this.toAddress(request.getUser().getAddress());

        //User userEntity = this.toUser(request.getUser());
        //userEntity.setAddress(addressEntity);

        customerEntity.setEnrollmentDate(LocalDate.now());
        customerEntity.setUser(this.userMapper.toUserEntity(request.getUser()));
        return customerEntity;
    }

    public CustomerDetailsResponse toCustomerResponse(CustomerProfile entity) {

        CustomerDetailsResponse response = new CustomerDetailsResponse();

        //VERIFICAR POR QUÉ ESTÁ MAL
        List<RoutineDetailsResponse> routinesResponse = new ArrayList<>();
        routinesResponse = new ArrayList<>(
                entity.getAssignedRoutines().stream()
                        .map(this.routineMapper::toRoutineResponse)
                        .toList()
        );

        MembershipDetailsResponse membershipResponse = new MembershipDetailsResponse(); //✔
        membershipResponse.setId(entity.getMembership().getId());
        membershipResponse.setPlanName(entity.getMembership().getPlanName());
        membershipResponse.setPrice(entity.getMembership().getPrice());

        response.setId(entity.getId());
        response.setMembership(membershipResponse);
        response.setAssignedRoutines(routinesResponse);
        response.setUser(this.userMapper.toUserResponse(entity.getUser()));
        response.setStatus(entity.getStatus());

        return response;
    }

    public void updateCustomerFromRequest(CustomerProfile originalEntity, UpdateCustomerRequest request) {

        if (request.getUser() != null) {
            updateUserRequest(originalEntity.getUser(), request.getUser());
        }

    }

    private void updateUserRequest(User user, UpdateUserRequest request) {

        if(request.getName() != null){
            user.setName(request.getName());
        }
        if(request.getLastname() != null){
            user.setLastname(request.getLastname());
        }
        if(request.getDni() != null) {
            user.setDni(request.getDni());
        }
        if(request.getPassword() != null){
            user.setPassword(request.getPassword());
        }
        if(request.getEmail() != null){
            user.setEmail(request.getEmail());
        }
        if(request.getPhoneNumber() != null){
            user.setPhoneNumber(request.getPhoneNumber());
        }
        if(request.getEmergencyPhoneNumber() != null){
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

}
