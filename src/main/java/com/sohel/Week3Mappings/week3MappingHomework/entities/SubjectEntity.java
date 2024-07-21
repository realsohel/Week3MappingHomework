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
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Professors_to_subjects",referencedColumnName = "id")
    @JsonIgnore
    private ProfessorEntity professor;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student&Subject",
            joinColumns = @JoinColumn(name = "subject_Id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    
    private Set<StudentEntity> student;



    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if(!(obj instanceof SubjectEntity that))
            return false;

        return Objects.equals(getId(),that.getId()) && Objects.equals(getTitle(),that.getTitle());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(),getTitle());
    }

}
