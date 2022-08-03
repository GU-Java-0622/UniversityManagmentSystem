package com.karalexsandr.coreservice.dto.response;


import com.karalexsandr.coreservice.dto.CourseDto;
import com.karalexsandr.coreservice.dto.LessonTemplateDto;
import com.karalexsandr.coreservice.entity.Lesson;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LessonResponseDto {
    private Long id;
    private LessonTemplateDto lessonTemplate;
    private String theme;
    private CourseDto course;
    private LocalDate startedAt;
    private LocalDate finishedAt;
    private String trainingManualUri;
    private String homeWorkUri;
    private boolean isFinished;

    public LessonResponseDto(Lesson lesson) {
        this.id = lesson.getId();
        this.lessonTemplate = new LessonTemplateDto(lesson.getLessonTemplate());
        this.theme = lesson.getTheme();
        this.course = new CourseDto(lesson.getCourse());
        this.startedAt = lesson.getStartedAt();
        this.finishedAt = lesson.getFinishedAt();
        this.trainingManualUri = lesson.getTrainingManualUri();
        this.homeWorkUri = lesson.getHomeWorkUri();
        this.isFinished = lesson.isFinished();
    }
}
