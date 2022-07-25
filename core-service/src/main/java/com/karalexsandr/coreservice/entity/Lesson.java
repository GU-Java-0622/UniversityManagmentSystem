package com.karalexsandr.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lessons_template_id")
    private LessonTemplate lessonTemplate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "day_of_the_lesson")
    private LocalDateTime dayOfTheLesson;

    @Column(name = "training manual")
    private String trainingManualUri;

    @Column(name = "homework")
    private String homeWorkUri;

    @Column(name = "is_active")
    private boolean isActive;


}
