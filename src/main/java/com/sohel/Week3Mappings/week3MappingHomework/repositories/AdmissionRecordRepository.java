package com.sohel.Week3Mappings.week3MappingHomework.repositories;

import com.sohel.Week3Mappings.week3MappingHomework.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
