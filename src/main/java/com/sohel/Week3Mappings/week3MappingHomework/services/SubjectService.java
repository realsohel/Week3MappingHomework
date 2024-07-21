package com.sohel.Week3Mappings.week3MappingHomework.services;

import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.SubjectEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}
