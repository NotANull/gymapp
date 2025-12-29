package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.AddressDetailsResponse;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.dto.response.UserDetailsResponse;
import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.enums.Status;
import com.oesdev.gymapp.mapper.CustomerMapper;
import com.oesdev.gymapp.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService{

    private final ICustomerRepository iCustomerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImp(ICustomerRepository iCustomerRepository, CustomerMapper customerMapper) {
        this.iCustomerRepository = iCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDetailsResponse createCustomer(CreateCustomerRequest request) {

        CustomerProfile entity = customerMapper.toCustomerProfile(request);
        this.iCustomerRepository.save(entity);

        return null;

    }

    @Override
    public CustomerDetailsResponse getCustomer(Long id) {
        return null;
    }

    @Override
    public List<CustomerDetailsResponse> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDetailsResponse updateCustomer(Long id, CreateCustomerRequest request) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
