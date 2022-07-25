package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "course_template_id")
    private CourseTemplate courseTemplate;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToOne
    private Stream stream;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person teacher;
}
