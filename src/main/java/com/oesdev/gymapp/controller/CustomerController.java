package com.oesdev.gymapp.controller;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.entity.Routine;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    //Only test
    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id) {
        return "hola cliente con id " + id;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDetailsResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        CustomerDetailsResponse response = this.iCustomerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
