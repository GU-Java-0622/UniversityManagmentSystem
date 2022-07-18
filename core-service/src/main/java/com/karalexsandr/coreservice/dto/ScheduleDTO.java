package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.model.LearningProgramme;
import com.karalexsandr.coreservice.model.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ScheduleDTO {
    private Long id;
    private GroupDTO groupId;
    private LearningProgrammeDTO learningProgramme;
    private LessonDTO lesson;
    private LocalDateTime startedAt;
}
