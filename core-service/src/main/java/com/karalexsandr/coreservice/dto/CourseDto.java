package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String title;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
    }
}
