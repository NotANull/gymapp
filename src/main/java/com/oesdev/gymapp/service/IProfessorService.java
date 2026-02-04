package com.oesdev.gymapp.service;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.enums.Status;

import java.util.List;

public interface IProfessorService {

    ProfessorDetailsResponse createProfessor(CreateProfessorRequest request);

    ProfessorDetailsResponse getProfessor(Long id);

    List<ProfessorDetailsResponse> getProfessors();

    List<ProfessorDetailsResponse> getProfessorsByStatus(Status status);

    ProfessorDetailsResponse updateProfessor(Long id, UpdateProfessorRequest request);

    void deleteProfessor(Long id);

}
