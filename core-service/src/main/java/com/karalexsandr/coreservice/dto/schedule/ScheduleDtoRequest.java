package com.karalexsandr.coreservice.dto.schedule;

import com.karalexsandr.coreservice.entity.Group;
import com.karalexsandr.coreservice.entity.LearningProgramme;
import com.karalexsandr.coreservice.entity.Lesson;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDtoRequest {
    private Long id;
    private Group groupId;
    private LearningProgramme learningProgramme;
    private Lesson lesson;
    private LocalDateTime startedAt;
}
