package com.sohel.Week3Mappings.week3MappingHomework.controllers;


import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping("")
    public ProfessorEntity createProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createProfessor(professorEntity);
    }

    @PutMapping("/{professorId}/assignProfessorToSubject/{subjectId}")
    public ProfessorEntity assignProfessorToSubject(
            @PathVariable Long professorId,
            @PathVariable Long subjectId){
        return professorService.assignProfessorToSubject(professorId,subjectId);
    }

    @PutMapping("/{professorId}/professorsToStudent/{studentId}")
    public ProfessorEntity professorsToStudent(
            @PathVariable Long professorId,
            @PathVariable Long studentId){
        return professorService.professorsToStudent(professorId,studentId);
    }
}
