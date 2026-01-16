package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.*;
import com.oesdev.gymapp.dto.response.AddressDetailsResponse;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public CustomerProfile toCustomerProfile(CreateCustomerRequest request) {

        CustomerProfile customerEntity = new CustomerProfile();

        Address addressEntity = this.toAddress(request.getUser().getAddress());

        User userEntity = this.toUser(request.getUser());
        userEntity.setAddress(addressEntity);

        customerEntity.setEnrollmentDate(LocalDate.now());
        customerEntity.setUser(userEntity);
        return customerEntity;
    }

    public CustomerDetailsResponse toCustomerResponse(CustomerProfile entity) {

        CustomerDetailsResponse response = new CustomerDetailsResponse();

        MembershipDetailsResponse membershipResponse = new MembershipDetailsResponse(); //✔
        membershipResponse.setId(entity.getMembership().getId());
        membershipResponse.setPlanName(entity.getMembership().getPlanName());
        membershipResponse.setPrice(entity.getMembership().getPrice());

        UserDetailsResponse userResponse = new UserDetailsResponse(); //✔
        userResponse.setId(entity.getUser().getId());
        userResponse.setName(entity.getUser().getName());
        userResponse.setLastname(entity.getUser().getLastname());
        userResponse.setDni(entity.getUser().getDni());
        userResponse.setEmail(entity.getUser().getEmail());
        userResponse.setPhoneNumber(entity.getUser().getPhoneNumber());
        userResponse.setEmergencyPhoneNumber(entity.getUser().getEmergencyPhoneNumber());

        AddressDetailsResponse addressResponse = new AddressDetailsResponse(); //✔
        addressResponse.setStreet(entity.getUser().getAddress().getStreet());
        addressResponse.setNumber(entity.getUser().getAddress().getNumber());
        addressResponse.setCity(entity.getUser().getAddress().getCity());
        addressResponse.setCountry(entity.getUser().getAddress().getCountry());

        userResponse.setAddress(addressResponse);

        response.setId(entity.getId());
        response.setMembership(membershipResponse);
        response.setUser(userResponse);
        response.setStatus(entity.getUser().getStatus());

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

    private Address toAddress(CreateAddressRequest request) {

        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setNumber(request.getNumber());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());

        return address;

    }

}
