package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course_template")
@Entity
@Getter
@Setter
public class CourseTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "courseTemplate")
    private List<LessonTemplate> lessonTemplates;

    @ManyToOne
    @JoinColumn(name = "learning_programme_template_id")
    private LearningProgrammeTemplate learningProgrammeTemplate;


}
