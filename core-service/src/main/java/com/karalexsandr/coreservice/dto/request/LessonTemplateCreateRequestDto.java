package com.karalexsandr.coreservice.dto.request;


import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class LessonTemplateCreateRequestDto {
    private String theme;
    private LocalTime duration;
    private Long courseTemplateId;
    private String trainingManualUri;
    private String homeWorkUri;
}
