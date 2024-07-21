package com.sohel.Week3Mappings.week3MappingHomework.controllers;

import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import com.sohel.Week3Mappings.week3MappingHomework.services.ProfessorService;
import com.sohel.Week3Mappings.week3MappingHomework.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/{studentId}")
    public StudentEntity getProfessorById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("")
    public StudentEntity createProfessor(@RequestBody StudentEntity studentEntity){
        return studentService.createStudent(studentEntity);
    }
}
