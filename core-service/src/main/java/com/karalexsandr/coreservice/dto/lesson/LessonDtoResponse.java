package com.karalexsandr.coreservice.dto.lesson;

import com.karalexsandr.coreservice.entity.Lesson;
import lombok.Data;;
import java.time.LocalTime;

@Data
public class LessonDtoResponse {
    private Long id;
    private String theme;
    private LocalTime duration;

    public LessonDtoResponse(Lesson lesson) {
        this.id = lesson.getId();
        this.theme = lesson.getTheme();
        this.duration = lesson.getDuration();
    }

    public LessonDtoResponse(Long id, String theme, LocalTime duration) {
        this.id = id;
        this.theme = theme;
        this.duration = duration;
    }
}
