package com.oesdev.gymapp.controller;

import com.oesdev.gymapp.dto.request.CreateProfessorRequest;
import com.oesdev.gymapp.dto.request.CreateRoutineRequest;
import com.oesdev.gymapp.dto.request.UpdateProfessorRequest;
import com.oesdev.gymapp.dto.response.ProfessorDetailsResponse;
import com.oesdev.gymapp.dto.response.RoutineDetailsResponse;
import com.oesdev.gymapp.enums.Status;
import com.oesdev.gymapp.service.IProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final IProfessorService iProfessorService;

    public ProfessorController(IProfessorService iProfessorService) {
        this.iProfessorService = iProfessorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorDetailsResponse> createProfessor(@RequestBody @Valid CreateProfessorRequest request) {

        ProfessorDetailsResponse response = this.iProfessorService.createProfessor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/{id}/routines")
    public ResponseEntity<RoutineDetailsResponse> createRoutine(@RequestBody @Valid CreateRoutineRequest request, @PathVariable Long id) {

        RoutineDetailsResponse response = this.iProfessorService.createRoutine(request, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @GetMapping("{id}")
    public ResponseEntity<ProfessorDetailsResponse> getProfessor(@PathVariable Long id) {

        ProfessorDetailsResponse response = this.iProfessorService.getProfessor(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<ProfessorDetailsResponse>> getProfessorsByStatus(@RequestParam(required = false) Status status) {
        List<ProfessorDetailsResponse> response = (status != null) ? iProfessorService.getProfessorsByStatus(status) : iProfessorService.getProfessors();
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfessorDetailsResponse> updateProfessor(@PathVariable Long id, @RequestBody @Valid UpdateProfessorRequest request) {

        ProfessorDetailsResponse response = this.iProfessorService.updateProfessor(id, request);
        return ResponseEntity.ok(response);

    }

    @PatchMapping("{id}/ban")
    public ResponseEntity<Void> banProfessor(@PathVariable Long id) {
        this.iProfessorService.banProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        this.iProfessorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
