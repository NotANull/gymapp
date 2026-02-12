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
import com.oesdev.gymapp.mapper.UserMapper;
import com.oesdev.gymapp.repository.IProfessorRepository;
import com.oesdev.gymapp.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class ProfessorServiceImp implements IProfessorService{

    private final IProfessorRepository iProfessorRepository;
    private final IUserRepository iUserRepository;
    private final ProfessorMapper professorMapper;
    private final UserMapper userMapper;

    public ProfessorServiceImp(IProfessorRepository iProfessorRepository, IUserRepository iUserRepository, ProfessorMapper professorMapper, UserMapper userMapper) {
        this.iProfessorRepository = iProfessorRepository;
        this.iUserRepository = iUserRepository;
        this.professorMapper = professorMapper;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public ProfessorDetailsResponse createProfessor(CreateProfessorRequest request) {

        Optional<User> existingUser = iUserRepository.findByDni(request.getUser().getDni());

        User userEntity;

        if(existingUser.isPresent()) {
            userEntity = existingUser.get();
        } else {
            userEntity = this.userMapper.toUserEntity(request.getUser());
            this.iUserRepository.save(userEntity);
        }

        //Test after use iUserRepository.save()
        userEntity.addRoles(Role.PROFESSOR);
        userEntity.setActive(true);

        ProfessorProfile professorEntity = this.professorMapper.toEntity(request);
        professorEntity.setUser(userEntity);
        professorEntity.setStatus(Status.ACTIVE);
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
