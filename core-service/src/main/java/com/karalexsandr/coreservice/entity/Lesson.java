package com.karalexsandr.coreservice.entity;

import com.karalexsandr.coreservice.dto.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "theme")
    private String theme;
    @ManyToOne
    @JoinColumn(name = "learning_programm")
    private Course course;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "finished_at")
    private LocalDate finishedAt;

    @Column(name = "training_manual")
    private String trainingManualUri;

    @Column(name = "homework")
    private String homeWorkUri;

    @Column(name = "is_finished")
    private boolean isFinished;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
