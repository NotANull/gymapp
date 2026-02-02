package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.request.updateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.entity.Membership;
import com.oesdev.gymapp.exception.MembershipNotFoundException;
import com.oesdev.gymapp.mapper.MembershipMapper;
import com.oesdev.gymapp.repository.IMembershipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MembershipServiceImp implements IMembershipService {

    private final IMembershipRepository iMembershipRepository;
    private final MembershipMapper membershipMapper;

    public MembershipServiceImp(IMembershipRepository iMembershipRepository, MembershipMapper membershipMapper) {
        this.iMembershipRepository = iMembershipRepository;
        this.membershipMapper = membershipMapper;
    }

    @Override
    @Transactional
    public MembershipDetailsResponse createMembership(CreateMembershipRequest request) {

        Membership membershipEntity = this.membershipMapper.toMembership(request);
        this.iMembershipRepository.save(membershipEntity);

        return this.membershipMapper.toMembershipResponse(membershipEntity);
    }

    @Override
    public MembershipDetailsResponse getMembership(Long id) {

        Membership membershipEntity = this.iMembershipRepository.findById(id).orElseThrow(() -> new MembershipNotFoundException(id));

        return this.membershipMapper.toMembershipResponse(membershipEntity);
    }

    @Override
    public List<MembershipDetailsResponse> getAllMemberships() {

        return this.iMembershipRepository.findAll().stream()
                .map(this.membershipMapper::toMembershipResponse)
                .toList();

    }

    @Override
    @Transactional
    public MembershipDetailsResponse updateMembership(Long id, updateMembershipRequest request) {

        Membership membershipEntity = this.iMembershipRepository.findById(id).orElseThrow(() -> new MembershipNotFoundException(id));
        this.membershipMapper.updateMembershipFromRequest(membershipEntity, request);
        this.iMembershipRepository.save(membershipEntity);

        return this.membershipMapper.toMembershipResponse(membershipEntity);
    }

    @Override
    @Transactional
    public void deleteMembership(Long id) {

        Membership membershipEntity = this.iMembershipRepository.findById(id).orElseThrow(() -> new MembershipNotFoundException(id));
        this.iMembershipRepository.delete(membershipEntity);

    }
}
