package com.sohel.Week3Mappings.week3MappingHomework.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "student")
    @JoinColumn(name = "admission details")
    @JsonIgnore
    private AdmissionRecordEntity admissionRecord;

    @ManyToMany(mappedBy = "student")
    @JsonIgnore
    private Set<ProfessorEntity> professor;

    @ManyToMany(mappedBy = "student")
    @JsonIgnore
    private Set<SubjectEntity> subject;

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if(!(obj instanceof StudentEntity that))
            return false;

        return Objects.equals(getId(),that.getId()) && Objects.equals(getName(),that.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(),getName());
    }
}
