package com.karalexsandr.coreservice.dto.schedule;

import com.karalexsandr.coreservice.entity.Group;
import com.karalexsandr.coreservice.entity.LearningProgramme;
import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.entity.Schedule;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDtoResponse {
    private Long id;
    private Group groupId;
    private LearningProgramme learningProgramme;
    private Lesson lesson;
    private LocalDateTime startedAt;

    public ScheduleDtoResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.groupId = schedule.getGroupId();
        this.learningProgramme = schedule.getLearningProgramme();
        this.lesson = schedule.getLesson();
        this.startedAt = schedule.getStartedAt();
    }

    public ScheduleDtoResponse(Long id, Group groupId, LearningProgramme learningProgramme,
                               Lesson lesson, LocalDateTime startedAt) {
        this.id = id;
        this.groupId = groupId;
        this.learningProgramme = learningProgramme;
        this.lesson = lesson;
        this.startedAt = startedAt;
    }
}
