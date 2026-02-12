package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.request.UpdateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.entity.CustomerProfile;
import com.oesdev.gymapp.entity.Membership;
import com.oesdev.gymapp.enums.Role;
import com.oesdev.gymapp.enums.Status;
import com.oesdev.gymapp.exception.CustomerNotFoundException;
import com.oesdev.gymapp.exception.MembershipNotFoundException;
import com.oesdev.gymapp.mapper.CustomerMapper;
import com.oesdev.gymapp.repository.ICustomerRepository;
import com.oesdev.gymapp.repository.IMembershipRepository;
import com.oesdev.gymapp.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImp implements ICustomerService{

    private final ICustomerRepository iCustomerRepository;
    private final IMembershipRepository iMembershipRepository;
    private final IUserRepository iUserRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImp(ICustomerRepository iCustomerRepository, IMembershipRepository iMembershipRepository, IUserRepository iUserRepository, CustomerMapper customerMapper) {
        this.iCustomerRepository = iCustomerRepository;
        this.iMembershipRepository = iMembershipRepository;
        this.iUserRepository = iUserRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    @Transactional
    public CustomerDetailsResponse createCustomer(CreateCustomerRequest request) {

        Membership membershipEntity = this.iMembershipRepository.findById(request.getMembershipId()).orElseThrow(() -> new MembershipNotFoundException(request.getMembershipId()));

        CustomerProfile customerEntity = this.customerMapper.toCustomerProfile(request);
        customerEntity.setStatus(Status.ACTIVE); //Once a customer pays for their membership, they can access their user account. Future check
        customerEntity.getUser().addRoles(Role.CUSTOMER); //When a customer is created, their role must be assigned
        this.iUserRepository.save(customerEntity.getUser());

        customerEntity.setMembership(membershipEntity);
        this.iCustomerRepository.save(customerEntity);

        return this.customerMapper.toCustomerResponse(customerEntity);

    }

    @Override
    public CustomerDetailsResponse getCustomer(Long id) {

        //Future implementation: validate states
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
    @Transactional
    public CustomerDetailsResponse updateCustomer(Long id, UpdateCustomerRequest request) {

        CustomerProfile customerEntity = this.iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        this.customerMapper.updateCustomerFromRequest(customerEntity, request);
        this.iCustomerRepository.save(customerEntity);

        return this.customerMapper.toCustomerResponse(customerEntity);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {

        //Besides deleting the customer, we could also manage customer statuses, such as ACTIVE, EXPIRED, etc.
        this.iCustomerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        this.iCustomerRepository.deleteById(id);

    }
}
