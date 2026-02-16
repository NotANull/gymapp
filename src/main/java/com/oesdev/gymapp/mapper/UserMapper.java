package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateAddressRequest;
import com.oesdev.gymapp.dto.request.CreateUserRequest;
import com.oesdev.gymapp.dto.request.UpdateAddressRequest;
import com.oesdev.gymapp.dto.request.UpdateUserRequest;
import com.oesdev.gymapp.dto.response.AddressDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.Address;
import com.oesdev.gymapp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUserEntity(CreateUserRequest userRequest) {

        User userEntity = new User();

        userEntity.setName(userRequest.getName());
        userEntity.setLastname(userRequest.getLastname());
        userEntity.setDni(userRequest.getDni());
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setEmergencyPhoneNumber(userRequest.getEmergencyPhoneNumber());
        userEntity.setAddress(this.toAddressEntity(userRequest.getAddress()));

        return userEntity;
    }

    public UserDetailsResponse toUserResponse(User userEntity) {

        UserDetailsResponse userResponse = new UserDetailsResponse();

        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());
        userResponse.setLastname(userEntity.getLastname());
        userResponse.setDni(userEntity.getDni());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setPhoneNumber(userEntity.getPhoneNumber());
        userResponse.setEmergencyPhoneNumber(userEntity.getEmergencyPhoneNumber());
        userResponse.setAddress(this.toAddressResponse(userEntity.getAddress()));
        userResponse.setRoles(userEntity.getRoles());
        userResponse.setActive(userEntity.isActive());

        return userResponse;
    }

    public void updateUser(User user, UpdateUserRequest userRequest) {

        if (userRequest.getName() != null) {
            user.setName(userRequest.getName());
        }
        if (userRequest.getLastname() != null) {
            user.setLastname(userRequest.getLastname());
        }
        if (userRequest.getDni() != null) {
            user.setDni(userRequest.getDni());
        }
        if (userRequest.getPassword() != null) {
            user.setPassword(userRequest.getPassword());
        }
        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }
        if (userRequest.getPhoneNumber() != null) {
            user.setPhoneNumber(userRequest.getPhoneNumber());
        }
        if (userRequest.getEmergencyPhoneNumber() != null) {
            user.setEmergencyPhoneNumber(userRequest.getEmergencyPhoneNumber());
        }
        if(userRequest.getAddress() != null){
            this.updateAddress(user.getAddress(), userRequest.getAddress());
        }

    }

    private Address toAddressEntity(CreateAddressRequest addressRequest) {

        return new Address(
                addressRequest.getStreet(),
                addressRequest.getNumber(),
                addressRequest.getCity(),
                addressRequest.getCountry()
        );

    }

    private AddressDetailsResponse toAddressResponse(Address addressEntity) {

        return new AddressDetailsResponse(
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getCity(),
                addressEntity.getCountry()
        );

    }

    private void updateAddress(Address address, UpdateAddressRequest addressRequest) {

        if(addressRequest.getStreet() != null) {
            address.setStreet(addressRequest.getStreet());
        }
        if(addressRequest.getNumber() != null) {
            address.setNumber(addressRequest.getNumber());
        }
        if(addressRequest.getCity() != null) {
            address.setCity(addressRequest.getCity());
        }
        if(addressRequest.getCountry() != null) {
            address.setCountry(addressRequest.getCountry());
        }

    }

}
