package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.enums.Role;
import com.oesdev.gymapp.enums.Status;
import com.oesdev.gymapp.exception.ProfessorNotFoundException;
import com.oesdev.gymapp.mapper.ProfessorMapper;
import com.oesdev.gymapp.repository.IProfessorRepository;
import com.oesdev.gymapp.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImp implements IProfessorService{

    private final IProfessorRepository iProfessorRepository;
    private final IUserRepository iUserRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImp(IProfessorRepository iProfessorRepository, IUserRepository iUserRepository, ProfessorMapper professorMapper) {
        this.iProfessorRepository = iProfessorRepository;
        this.iUserRepository = iUserRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public ProfessorDetailsResponse createProfessor(CreateProfessorRequest request) {

        ProfessorProfile professorEntity = this.professorMapper.toEntity(request);

        professorEntity.getUser().setStatus(Status.ACTIVE);
        professorEntity.getUser().setRole(Role.PROFESSOR);
        this.iUserRepository.save(professorEntity.getUser());
        this.iProfessorRepository.save(professorEntity);

        return this.professorMapper.toResponse(professorEntity);
    }

    @Override
    @Transactional
    public ProfessorDetailsResponse getProfessor(Long id) {

        ProfessorProfile professorEntity = this.iProfessorRepository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));
        return this.professorMapper.toResponse(professorEntity);

    }

    @Override
    public List<ProfessorDetailsResponse> getProfessors() {
        return List.of();
    }

    @Override
    public ProfessorDetailsResponse updateProfessor(Long id, UpdateProfessorRequest request) {
        return null;
    }

    @Override
    public void deleteProfessor(Long id) {

    }
}
