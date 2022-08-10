package com.karalexsandr.coreservice.dto.response;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StreamTemplateResponseDto {
    private Long id;
    private String title;
    private String facultyTitle;
    private List<CourseTemplateDto> courseTemplate;
    private List<CourseTemplateDto> courseNotInTemplate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StreamTemplateResponseDto(StreamTemplate template){
        this.id = template.getId();
        this.title = template.getTitle();
        this.facultyTitle = template.getFaculties().getTitle();
        this.courseTemplate = template.getCourseTemplates().stream().map(CourseTemplateDto::new).collect(Collectors.toList());
        this.createdAt = template.getCreatedAt();
        this.updatedAt = template.getUpdatedAt();
    }

    @Data
    public static class CourseTemplateDto{
        private Long id;
        private String title;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Integer countLessons;

        public CourseTemplateDto(CourseTemplate template){
            this.id = template.getId();
            this.title = template.getTitle();
            this.createdAt = template.getCreatedAt();
            this.updatedAt = template.getUpdatedAt();
            this.countLessons = template.getLessonTemplates().size();
        }
    }
}
