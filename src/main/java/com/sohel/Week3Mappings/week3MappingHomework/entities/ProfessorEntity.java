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
@Table(name = "professors")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "professor")
    private Set<SubjectEntity> subjects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Professors&Student",
            joinColumns = @JoinColumn(name= "Professor_id"),
            inverseJoinColumns = @JoinColumn(name = "Student_id")
    )
    @JsonIgnore
    private Set<StudentEntity> student ;

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if(!(obj instanceof ProfessorEntity that))
            return false;

        return Objects.equals(getId(),that.getId()) && Objects.equals(getName(),that.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getId(),getName());
    }
}
