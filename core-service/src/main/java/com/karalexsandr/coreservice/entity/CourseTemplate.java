package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups_template")
@Entity
@Getter
@Setter
public class CourseTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "programme")
    private List<LessonTemplate> lessonTemplates;

    @OneToMany(mappedBy = "courseTemplate")
    private List<ActiveCourse> activeCourses;
    @ManyToMany
    @JoinTable(name = "cource_facultiy",
            joinColumns = @JoinColumn(name = "cource_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id") )
    private List<Faculty> faculties;

}
