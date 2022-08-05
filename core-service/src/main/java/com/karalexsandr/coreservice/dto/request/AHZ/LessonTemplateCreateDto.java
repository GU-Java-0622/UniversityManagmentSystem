package com.karalexsandr.coreservice.dto.request.AHZ;



import lombok.Data;

import java.time.LocalTime;
@Data
public class LessonTemplateCreateDto {
    private String theme;
    private LocalTime duration;
    private Long courseTemplateId;
}
