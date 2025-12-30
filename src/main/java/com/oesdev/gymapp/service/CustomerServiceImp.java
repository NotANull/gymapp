package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.exception.CustomerNotFoundException;
import com.oesdev.gymapp.mapper.CustomerMapper;
import com.oesdev.gymapp.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        CustomerProfile entity = this.customerMapper.toCustomerProfile(request);
        this.iCustomerRepository.save(entity);

        return this.customerMapper.toCustomerResponse(entity);

    }

    @Override
    public CustomerDetailsResponse getCustomer(Long id) {
        //Para más adelante, validar los estados
        CustomerProfile entity = this.iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

        return this.customerMapper.toCustomerResponse(entity);
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
