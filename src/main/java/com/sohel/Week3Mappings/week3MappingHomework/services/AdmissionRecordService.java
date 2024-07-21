package com.sohel.Week3Mappings.week3MappingHomework.services;

import com.sohel.Week3Mappings.week3MappingHomework.entities.AdmissionRecordEntity;
import com.sohel.Week3Mappings.week3MappingHomework.repositories.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecordEntity getadmissionRecordById(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId).orElse(null);
    }

    public AdmissionRecordEntity creategetadmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }
}
