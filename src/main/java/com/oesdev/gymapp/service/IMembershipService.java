package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.request.updateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;

import java.util.List;

public interface IMembershipService {

    MembershipDetailsResponse createMembership(CreateMembershipRequest request);

    MembershipDetailsResponse getMembership(Long id);

    List<MembershipDetailsResponse> getAllMemberships();

    MembershipDetailsResponse updateMembership(Long id, updateMembershipRequest request);

    void deleteMembership(Long id);
}
