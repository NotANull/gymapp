package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.request.UpdateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.exception.CustomerNotFoundException;
import com.oesdev.gymapp.mapper.CustomerMapper;
import com.oesdev.gymapp.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

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

        return this.iCustomerRepository.findAll().stream()
                .map(this.customerMapper::toCustomerResponse)
                .toList();

    }

    @Override
    public CustomerDetailsResponse updateCustomer(Long id, UpdateCustomerRequest request) {

        CustomerProfile customer = this.iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

        this.customerMapper.updateCustomerFromRequest(customer, request);

        this.iCustomerRepository.save(customer);

        return this.customerMapper.toCustomerResponse(customer);
    }

    @Override
    public void deleteCustomer(Long id) {

        //Besides deleting the customer, we could also manage customer statuses, such as ACTIVE, EXPIRED, etc.

        this.iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

        this.iCustomerRepository.deleteById(id);

    }
}
