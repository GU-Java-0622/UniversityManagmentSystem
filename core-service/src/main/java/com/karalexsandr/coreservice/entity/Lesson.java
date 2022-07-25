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
@Table(name = "active_lesson")
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="lesson_template_id")
    private LessonTemplate lessonTemplate;

    @ManyToOne
    @JoinColumn(name = "learning_programm")
    private LearningProgramme learningProgramme;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @ManyToOne
    @JoinColumn(name="cource_id")
    private Stream stream;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    @Column(name = "training manual")
    private String trainingManualUri;

    @Column(name = "homework")
    private String homeWorkUri;

    @Column(name = "is_finished")
    private boolean isFinished;
}
