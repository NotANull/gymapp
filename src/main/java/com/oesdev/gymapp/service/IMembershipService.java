package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;

import java.math.BigDecimal;
import java.util.List;

public interface IMembershipService {

    MembershipDetailsResponse createMembership(CreateMembershipRequest request);

    MembershipDetailsResponse getMembership(Long id);

    List<MembershipDetailsResponse> getAllMemberships();

    MembershipDetailsResponse updateMembership(Long id, BigDecimal newPrice);

    void deleteMembership(Long id);
}
