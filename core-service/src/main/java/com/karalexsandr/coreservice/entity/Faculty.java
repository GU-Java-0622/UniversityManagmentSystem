package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faculties")
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty_template_id")
    private FacultyTemplate facultyTemplate;

    @OneToMany(mappedBy = "faculty")
    private List<Group> groups;

    @OneToMany
    @JoinColumn(name = "learning_programme_id")
    private List<LearningProgramme> learningProgrammes;
}
