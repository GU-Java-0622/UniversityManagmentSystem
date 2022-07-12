package com.karalexsandr.coreservice.dto.lesson;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalTime;

@Data
public class LessonDtoRequest {
    private Long id;
    private String theme;
    private LocalTime duration;
}
