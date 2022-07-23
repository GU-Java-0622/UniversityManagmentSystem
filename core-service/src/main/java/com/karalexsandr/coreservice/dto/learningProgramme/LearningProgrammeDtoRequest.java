package com.karalexsandr.coreservice.dto.learningProgramme;

import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.entity.StatusEnum;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class LearningProgrammeDtoRequest {
    private Long id;
    private String title;
    private List<Lesson> lessonList;
    private StatusEnum status;
}
