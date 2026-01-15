package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.entity.Membership;
import com.oesdev.gymapp.mapper.MembershipMapper;
import com.oesdev.gymapp.repository.IMembershipRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MembershipServiceImp implements IMembershipService {

    private final IMembershipRepository iMembershipRepository;
    private final MembershipMapper membershipMapper;

    public MembershipServiceImp(IMembershipRepository iMembershipRepository, MembershipMapper membershipMapper) {
        this.iMembershipRepository = iMembershipRepository;
        this.membershipMapper = membershipMapper;
    }

    @Override
    public MembershipDetailsResponse createMembership(CreateMembershipRequest request) {

        Membership membershipEntity = this.membershipMapper.toMembership(request);
        this.iMembershipRepository.save(membershipEntity);

        return this.membershipMapper.toMembershipResponse(membershipEntity);
    }

    @Override
    public MembershipDetailsResponse getMembership(Long id) {
        return null;
    }

    @Override
    public List<MembershipDetailsResponse> getAllMemberships() {
        return List.of();
    }

    @Override
    public MembershipDetailsResponse updateMembership(Long id, BigDecimal newPrice) {
        return null;
    }

    @Override
    public void deleteMembership(Long id) {

    }
}
