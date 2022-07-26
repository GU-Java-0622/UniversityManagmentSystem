package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

@Data
public class CourseSetTeacherDto {
    private Long courseId;
    private Long personId;
}
