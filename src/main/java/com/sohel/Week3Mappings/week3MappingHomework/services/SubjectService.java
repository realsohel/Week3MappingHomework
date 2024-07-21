package com.sohel.Week3Mappings.week3MappingHomework.services;

import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.SubjectEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.StudentRepository;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity assignSubjectsToStudents(Long subjectId, Long studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return subjectEntity.flatMap(subject->
                studentEntity.map(student->{
                    student.getSubject().add(subject);
                    subject.getStudent().add(student);
                    subjectRepository.save(subject);

                    return subject;
                })
        ).orElse(null);
    }
}
