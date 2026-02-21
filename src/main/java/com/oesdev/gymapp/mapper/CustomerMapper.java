package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.*;
import com.oesdev.gymapp.dto.response.*;
import com.oesdev.gymapp.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class CustomerMapper {

    private final UserMapper userMapper;
    private final RoutineMapper routineMapper;
    private final MembershipMapper membershipMapper;

    public CustomerMapper(UserMapper userMapper, RoutineMapper routineMapper, MembershipMapper membershipMapper) {
        this.userMapper = userMapper;
        this.routineMapper = routineMapper;
        this.membershipMapper = membershipMapper;
    }

    public CustomerProfile toCustomerEntity(CreateCustomerRequest request) {

        CustomerProfile customerEntity = new CustomerProfile();

        customerEntity.setEnrollmentDate(LocalDate.now());
        customerEntity.setUser(this.userMapper.toUserEntity(request.getUser()));
        return customerEntity;
    }

    public CustomerDetailsResponse toCustomerResponse(CustomerProfile entity) {

        if (entity == null) {
            return null;
        }

        CustomerDetailsResponse response = new CustomerDetailsResponse();

        List<RoutineDetailsResponse> routinesResponse = (entity.getAssignedRoutines() != null)
                ? entity.getAssignedRoutines().stream()
                        .map(this.routineMapper::toRoutineResponse)
                        .toList()
                : Collections.emptyList();

        response.setId(entity.getId());
        response.setMembership(this.membershipMapper.toMembershipResponse(entity.getMembership()));
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
