package com.sohel.Week3Mappings.week3MappingHomework.repositories;

import com.sohel.Week3Mappings.week3MappingHomework.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
