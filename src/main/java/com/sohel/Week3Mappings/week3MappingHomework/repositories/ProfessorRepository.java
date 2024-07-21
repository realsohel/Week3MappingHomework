package com.sohel.Week3Mappings.week3MappingHomework.repositories;

import com.sohel.Week3Mappings.week3MappingHomework.entities.ProfessorEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
