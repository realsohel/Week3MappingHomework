package com.sohel.Week3Mappings.week3MappingHomework.controllers;

import com.sohel.Week3Mappings.week3MappingHomework.entities.AdmissionRecordEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admissionRecords")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping("/{admissionRecordId}")
    public AdmissionRecordEntity getadmissionRecordById(@PathVariable Long admissionRecordId){
        return admissionRecordService.getadmissionRecordById(admissionRecordId);
    }

    @PostMapping("")
    public AdmissionRecordEntity creategetadmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.creategetadmissionRecord(admissionRecordEntity);
    }

    @PutMapping("/{admissionRecordId}/admissiondetails/{studentId}")
    public AdmissionRecordEntity admissionRecordOfStudent(
            @PathVariable Long admissionRecordId,
            @PathVariable Long studentId){

        return admissionRecordService.admissionRecordOfStudent(admissionRecordId,studentId);

    }


}
