package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.AddressDetailsResponse;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.*;
import com.oesdev.gymapp.enums.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    public CustomerProfile toCustomerProfile(CreateCustomerRequest request) {

        CustomerProfile customer = new CustomerProfile();

        Address address = new Address();
        address.setStreet(request.getUser().getAddress().getStreet());
        address.setNumber(request.getUser().getAddress().getNumber());
        address.setCity(request.getUser().getAddress().getCity());
        address.setCountry(request.getUser().getAddress().getCountry());

        User user = new User(); //✔
        user.setName(request.getUser().getName());
        user.setLastname(request.getUser().getLastname());
        user.setDni(request.getUser().getDni());
        user.setUsername(request.getUser().getUsername());
        user.setPassword(request.getUser().getPassword());
        user.setEmail(request.getUser().getEmail());
        user.setPhoneNumber(request.getUser().getPhoneNumber());
        user.setEmergencyPhoneNumber(request.getUser().getEmergencyPhoneNumber());
        user.setAdress(address);

        Membership membership = new Membership(); //✔
        membership.setPlanName(request.getMembership().getPlanName());
        membership.setPrice(request.getMembership().getPrice());
        membership.setStatus(Status.ACTIVE); //When a customer is created, the status starts as ACTIVE


        customer.setMembership(membership);
        customer.setEnrollmentDate(LocalDate.now());
        customer.setUser(user);
        return customer;
    }

    public CustomerDetailsResponse toCustomerResponse(CustomerProfile entity) {

        CustomerDetailsResponse response = new CustomerDetailsResponse();

        MembershipDetailsResponse membershipResponse = new MembershipDetailsResponse(); //✔
        membershipResponse.setId(entity.getMembership().getId());
        membershipResponse.setPlanName(entity.getMembership().getPlanName());
        membershipResponse.setPrice(entity.getMembership().getPrice());
        membershipResponse.setStatus(entity.getMembership().getStatus());

        UserDetailsResponse userResponse = new UserDetailsResponse(); //✔
        userResponse.setId(entity.getUser().getId());
        userResponse.setName(entity.getUser().getName());
        userResponse.setLastname(entity.getUser().getLastname());
        userResponse.setDni(entity.getUser().getDni());
        userResponse.setEmail(entity.getUser().getEmail());
        userResponse.setPhoneNumber(entity.getUser().getPhoneNumber());
        userResponse.setEmergencyPhoneNumber(entity.getUser().getEmergencyPhoneNumber());

        AddressDetailsResponse addressResponse = new AddressDetailsResponse(); //✔
        addressResponse.setStreet(entity.getUser().getAdress().getStreet());
        addressResponse.setNumber(entity.getUser().getAdress().getNumber());
        addressResponse.setCity(entity.getUser().getAdress().getCity());
        addressResponse.setCountry(entity.getUser().getAdress().getCountry());

        userResponse.setAddress(addressResponse);

        response.setId(entity.getId());
        response.setMembership(membershipResponse);
        response.setUser(userResponse);

        return response;
    }

}
