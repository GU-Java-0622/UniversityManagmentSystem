package com.karalexsandr.coreservice.dto.request;


import lombok.Data;
import java.util.List;

@Data
public class CourseCreateRequestDto {
    private String title;
    private Long courseTemplateId;
    private List<Long> lessonsId;
    private Long streamId;
    private Long teacherId;



}
