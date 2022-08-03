package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.LessonTemplate;
import lombok.Data;

import java.time.LocalTime;

@Data
public class LessonTemplateDto {
    private Long id;
    private String theme;
    private LocalTime duration;
    private String trainingManualUri;
    private String homeWorkUri;

    public LessonTemplateDto(LessonTemplate lessonTemplate) {
        this.id = lessonTemplate.getId();
        this.theme = lessonTemplate.getTheme();
        this.duration = lessonTemplate.getDuration();
        this.trainingManualUri = lessonTemplate.getTrainingManualUri();
        this.homeWorkUri = lessonTemplate.getHomeWorkUri();
    }
}
