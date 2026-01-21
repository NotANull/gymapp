package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface IProfessorService {

    ProfessorDetailsResponse createProfessor(@Valid CreateProfessorRequest request);

    ProfessorDetailsResponse getProfessor(Long id);

    List<ProfessorDetailsResponse> getProfessors();

    ProfessorDetailsResponse updateProfessor(Long id, UpdateProfessorRequest request);

    void deleteProfessor(Long id);

}
