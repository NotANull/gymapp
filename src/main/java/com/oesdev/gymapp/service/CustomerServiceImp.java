package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService{

    private ICustomerRepository iCustomerRepository;

    public CustomerServiceImp(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public CustomerDetailsResponse createCustomer(CreateCustomerRequest request) {
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
