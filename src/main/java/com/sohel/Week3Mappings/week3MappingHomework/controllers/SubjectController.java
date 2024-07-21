package com.sohel.Week3Mappings.week3MappingHomework.controllers;

import com.sohel.Week3Mappings.week3MappingHomework.entities.SubjectEntity;
import com.sohel.Week3Mappings.week3MappingHomework.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController( SubjectService subjectService1) {
        this.subjectService = subjectService1;
    }

    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping("")
    public SubjectEntity createSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createSubject(subjectEntity);
    }

    @PutMapping("/{subjectId}/assignSubjectsToStudents/{studentId}")
    public SubjectEntity assignSubjectsToStudents(
            @PathVariable Long subjectId,
            @PathVariable Long studentId){
        return subjectService.assignSubjectsToStudents(subjectId,studentId);
    }
}
