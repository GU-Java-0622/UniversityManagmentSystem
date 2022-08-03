package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.Lesson;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LessonDto {
    private Long id;
    private String theme;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private String trainingManualUri;
    private String homeWorkUri;
    private boolean isFinished;

    public LessonDto(Long id, String theme, LocalDate startedAt,
                     LocalDate finishedAt, String trainingManualUri,
                     String homeWorkUri, boolean isFinished) {
        this.id = id;
        this.theme = theme;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.trainingManualUri = trainingManualUri;
        this.homeWorkUri = homeWorkUri;
        this.isFinished = isFinished;
    }

    public LessonDto(Lesson lesson) {
        this.id = lesson.getId();
        this.theme = lesson.getTheme();
        this.startedAt = lesson.getStartedAt();
        this.finishedAt = lesson.getFinishedAt();
        this.trainingManualUri = lesson.getTrainingManualUri();
        this.homeWorkUri = lesson.getHomeWorkUri();
        this.isFinished = lesson.isFinished();


    }
}