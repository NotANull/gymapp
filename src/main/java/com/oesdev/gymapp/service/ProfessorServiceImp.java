package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.entity.ProfessorProfile;
import com.oesdev.gymapp.mapper.ProfessorMapper;
import com.oesdev.gymapp.repository.IProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImp implements IProfessorService{

    private final IProfessorRepository iProfessorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImp(IProfessorRepository iProfessorRepository, ProfessorMapper professorMapper) {
        this.iProfessorRepository = iProfessorRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public ProfessorDetailsResponse createProfessor(CreateProfessorRequest request) {

        ProfessorProfile professorEntity = this.professorMapper.toEntity(request);
        this.iProfessorRepository.save(professorEntity);

        return this.professorMapper.toResponse(professorEntity);
    }

    @Override
    public ProfessorDetailsResponse getProfessor(Long id) {
        return null;
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
