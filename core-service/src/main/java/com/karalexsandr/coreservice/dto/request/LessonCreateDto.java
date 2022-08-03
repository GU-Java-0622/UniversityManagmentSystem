package com.karalexsandr.coreservice.dto.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class LessonCreateDto {
    private Long id;
    private Long lessonTemplateId;
    private String theme;
    private Long courseId;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private String trainingManualUri;
    private String homeWorkUri;
    private boolean isFinished;
}
