package com.oesdev.gymapp.controller;

import com.oesdev.gymapp.dto.request.CreateCustomerRequest;
import com.oesdev.gymapp.dto.response.CustomerDetailsResponse;
import com.oesdev.gymapp.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    //Only test
    /*@GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id) {
        return "hola cliente con id " + id;
    }*/

    @PostMapping
    public ResponseEntity<CustomerDetailsResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        CustomerDetailsResponse response = this.iCustomerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailsResponse> getCustomer(@PathVariable Long id) {
        CustomerDetailsResponse response = this.iCustomerService.getCustomer(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetailsResponse>> getCustomers() {
        return ResponseEntity.ok(this.iCustomerService.getAllCustomers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDetailsResponse> updateCustomer(@PathVariable Long id, @RequestBody @Valid CreateCustomerRequest request) {
        CustomerDetailsResponse response = this.iCustomerService.updateCustomer(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        this.iCustomerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
