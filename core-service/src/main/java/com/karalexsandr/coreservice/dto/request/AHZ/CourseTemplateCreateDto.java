package com.karalexsandr.coreservice.dto.request.AHZ;

import lombok.Data;

@Data
public class CourseTemplateCreateDto {
    private String title;
    private Long streamTemplateId;
}
