package com.karalexsandr.coreservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "learning_programmes")
public class LearningProgramme {
    @Id
    private Long id;
    private String title;
    private List<Lesson> lessonList;
    private StatusEnum status;
    private LocalDateTime createAt;
    private LocalDateTime deprecatedUp;

}
