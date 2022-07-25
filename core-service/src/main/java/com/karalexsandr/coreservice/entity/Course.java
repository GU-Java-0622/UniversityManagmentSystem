package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cource_template_id")
    private CourseTemplate courseTemplate;

    @ManyToOne
    @JoinColumn(name = "learning_programme_id")
    private LearningProgramme learningProgramme;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Person teacher;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Group group;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "finished_at")
    private LocalDate finishedAt;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
