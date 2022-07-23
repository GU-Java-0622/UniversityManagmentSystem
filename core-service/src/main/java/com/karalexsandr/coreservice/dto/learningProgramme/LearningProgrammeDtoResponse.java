package com.karalexsandr.coreservice.dto.learningProgramme;

import com.karalexsandr.coreservice.entity.LearningProgramme;
import com.karalexsandr.coreservice.entity.Lesson;
import com.karalexsandr.coreservice.entity.StatusEnum;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class LearningProgrammeDtoResponse {
    private Long id;
    private String title;
    private List<Lesson> lessonList;
    private StatusEnum status;
    private LocalDateTime createAt;
    private LocalDateTime deprecatedUp;

    public LearningProgrammeDtoResponse(LearningProgramme learningProgramme) {
        this.id = learningProgramme.getId();
        this.title = learningProgramme.getTitle();
        this.lessonList = learningProgramme.getLessonList();
        this.status = learningProgramme.getStatus();
        this.createAt = learningProgramme.getCreateAt();
        this.deprecatedUp = learningProgramme.getDeprecatedUp();
    }

    public LearningProgrammeDtoResponse(Long id, String title, List<Lesson> lessonList,
                                        StatusEnum status, LocalDateTime createAt,
                                        LocalDateTime deprecatedUp) {
        this.id = id;
        this.title = title;
        this.lessonList = lessonList;
        this.status = status;
        this.createAt = createAt;
        this.deprecatedUp = deprecatedUp;
    }
}
