package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.entity.User;
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
@Transactional(readOnly = true)
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
    @Transactional
    public ProfessorDetailsResponse createProfessor(CreateProfessorRequest request) {

        ProfessorProfile professorEntity = this.professorMapper.toEntity(request);

        User userEntity = professorEntity.getUser();
        userEntity.setActive(true);
        userEntity.addRoles(Role.PROFESSOR);

        professorEntity.setStatus(Status.ACTIVE);

        this.iUserRepository.save(userEntity);
        this.iProfessorRepository.save(professorEntity);

        return this.professorMapper.toResponse(professorEntity);
    }

    @Override
    public ProfessorDetailsResponse getProfessor(Long id) {

        ProfessorProfile professorEntity = this.iProfessorRepository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));
        return this.professorMapper.toResponse(professorEntity);

    }

    @Override
    public List<ProfessorDetailsResponse> getProfessors() {
        return this.iProfessorRepository.findAll().stream()
                .map(this.professorMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProfessorDetailsResponse> getProfessorsByStatus(Status status) {

        return this.iProfessorRepository.findAllByStatus(status).stream()
                .map(this.professorMapper::toResponse)
                .toList();

    }

    @Override
    @Transactional
    public ProfessorDetailsResponse updateProfessor(Long id, UpdateProfessorRequest request) {

        ProfessorProfile professorEntity = this.iProfessorRepository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));
        this.professorMapper.updateProfessorFromRequest(professorEntity, request);
        this.iProfessorRepository.save(professorEntity);

        return this.professorMapper.toResponse(professorEntity);
    }

    @Override
    @Transactional
    public void deleteProfessor(Long id) {

        ProfessorProfile professorEntity = this.iProfessorRepository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));
        professorEntity.setStatus(Status.CANCELLED);
        this.iProfessorRepository.save(professorEntity);

    }
}
