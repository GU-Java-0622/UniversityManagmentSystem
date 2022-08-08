package com.karalexsandr.coreservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons_template")
@Entity
@Getter
@Setter
public class LessonTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "training_manual")
    private String trainingManualUri;

    @Column(name = "homework")
    private String homeWorkUri;

    @ManyToOne
    @JoinColumn(name = "course_template_id")
    private CourseTemplate courseTemplate;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
