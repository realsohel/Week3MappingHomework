package com.sohel.Week3Mappings.week3MappingHomework.services;


import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.SubjectEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.ProfessorRepository;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }


    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignProfessorToSubject(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject->{
                    subject.setProfessor(professor);
                    subjectRepository.save(subject);

                    professor.getSubjects().add(subject);
                    return professor;
                })
        ).orElse(null);
    }
}
