package com.oesdev.gymapp.mapper;

import com.oesdev.gymapp.dto.request.CreateMembershipRequest;
import com.oesdev.gymapp.dto.request.updateMembershipRequest;
import com.oesdev.gymapp.dto.response.MembershipDetailsResponse;
import com.oesdev.gymapp.entity.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

    public Membership toMembership(CreateMembershipRequest request) {

        Membership membershipEntity = new Membership();
        membershipEntity.setPlanName(request.getPlanName());
        membershipEntity.setPrice(request.getPrice());

        return membershipEntity;

    }

    public MembershipDetailsResponse toMembershipResponse(Membership entity) {

        MembershipDetailsResponse response = new MembershipDetailsResponse();
        response.setId(entity.getId());
        response.setPlanName(entity.getPlanName());
        response.setPrice(entity.getPrice());

        return response;
    }

    public void updateMembershipFromRequest(Membership originalEntity, updateMembershipRequest request) {

        if (request != null) {
            originalEntity.setPrice(request.getPrice());
        }

    }

}
