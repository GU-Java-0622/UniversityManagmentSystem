package com.karalexsandr.coreservice.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
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

    @ManyToOne
    @JoinColumn(name = "programme_id")
    private LearningProgrammeTemplate programme;
}
