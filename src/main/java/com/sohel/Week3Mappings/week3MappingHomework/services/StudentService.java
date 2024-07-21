package com.sohel.Week3Mappings.week3MappingHomework.services;

import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }
}
