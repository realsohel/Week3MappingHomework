package com.sohel.Week3Mappings.week3MappingHomework.services;


import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }
}
