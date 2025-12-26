package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;

import java.util.List;

public interface ICustomerService {

    CustomerDetailsResponse createCustomer(CreateCustomerRequest request);

    CustomerDetailsResponse getCustomer(Long id);

    List<CustomerDetailsResponse> getAllCustomers();

    CustomerDetailsResponse updateCustomer(Long id, CreateCustomerRequest request);

    void deleteCustomer(Long id);
}
