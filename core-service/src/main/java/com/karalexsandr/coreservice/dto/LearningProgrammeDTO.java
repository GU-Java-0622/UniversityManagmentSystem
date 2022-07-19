package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.model.Lesson;
import com.karalexsandr.coreservice.model.StatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class LearningProgrammeDTO {
    private Long id;
    private String title;
    private List<LessonDTO> lessonList;
    private StatusEnum status;
    private LocalDateTime createAt;
    private LocalDateTime deprecatedUp;
}
