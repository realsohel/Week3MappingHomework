package com.sohel.Week3Mappings.week3MappingHomework.services;

import com.sohel.Week3Mappings.week3MappingHomework.entities.AdmissionRecordEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.AdmissionRecordRepository;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
     private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }



    public AdmissionRecordEntity getadmissionRecordById(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId).orElse(null);
    }

    public AdmissionRecordEntity creategetadmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public  AdmissionRecordEntity admissionRecordOfStudent(Long admissionRecordId,Long studentId){
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);


        return admissionRecordEntity.flatMap(admission ->
                studentEntity.map(student->{
                    admission.setStudent(student);
                    return admissionRecordRepository.save(admission);
                })
        ).orElse(null);
    }
}
