package com.karalexsandr.coreservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
public class LessonDTO {
    private Long id;
    private String theme;
    private LocalTime duration;
}
