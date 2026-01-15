package com.oesdev.gymapp.controller;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.service.IMembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {

    private final IMembershipService iMembershipService;

    public MembershipController(IMembershipService iMembershipService) {
        this.iMembershipService = iMembershipService;
    }

    @PostMapping
    public ResponseEntity<MembershipDetailsResponse> createMembership(@RequestBody CreateMembershipRequest request) {

        MembershipDetailsResponse response = this.iMembershipService.createMembership(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("{id}")
    public ResponseEntity<MembershipDetailsResponse> getMembership(@PathVariable Long id) {

        MembershipDetailsResponse response = this.iMembershipService.getMembership(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<MembershipDetailsResponse>> getMemberships() {
        return ResponseEntity.ok(this.iMembershipService.getAllMemberships());
    }

    @PutMapping("{id}")
    public ResponseEntity<MembershipDetailsResponse> updateMembership(@PathVariable Long id, BigDecimal newPrice) {

        MembershipDetailsResponse response = this.iMembershipService.updateMembership(id, newPrice);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {

        this.iMembershipService.deleteMembership(id);
        return ResponseEntity.noContent().build();

    }

}
