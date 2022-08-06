package com.karalexsandr.coreservice.dto.response;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CourseTemplateResponseDto {
    private Long id;
    private String title;
    private List<LessonTemplateDto> lessonTemplates;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalTime countLearningHours;
    private Integer countLessons;

    public CourseTemplateResponseDto(CourseTemplate template){
        this.id= template.getId();
        this.title = template.getTitle();
        this.lessonTemplates = template.getLessonTemplates().stream().map(LessonTemplateDto::new).collect(Collectors.toList());
        this.createdAt = template.getCreatedAt();
        this.updatedAt = template.getUpdatedAt();
        this.countLearningHours = LocalTime.of(0,0,0);
        lessonTemplates.forEach(x->this.countLearningHours=
                this.countLearningHours.plusSeconds(x.getDuration().toSecondOfDay()));
        this.countLessons = lessonTemplates.size();
    }
    @Data
    public static class LessonTemplateDto{
        private Long id;
        private String theme;
        private String trainingManualUri;
        private String homeWorkUri;
        private LocalTime duration;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public LessonTemplateDto(LessonTemplate template){
            this.id= template.getId();
            this.theme = template.getTheme();
            this.homeWorkUri = template.getHomeWorkUri();
            this.trainingManualUri = template.getTrainingManualUri();
            this.duration = template.getDuration();
            this.createdAt = template.getCreatedAt();
            this.updatedAt = template.getUpdatedAt();
        }
    }
}
