package com.karalexsandr.coreservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id
    private Long id;
    private Group group;
    private LearningProgramme learningProgramme;
    private Lesson lesson;
    private LocalDateTime startedAt;

}
