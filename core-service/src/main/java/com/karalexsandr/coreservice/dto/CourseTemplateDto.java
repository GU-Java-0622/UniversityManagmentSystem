package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import lombok.Data;

@Data
public class CourseTemplateDto {
    private Long id;
    private String title;

    public CourseTemplateDto(CourseTemplate courseTemplate) {
        this.id = courseTemplate.getId();
        this.title = courseTemplate.getTitle();
    }
}
