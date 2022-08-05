package com.karalexsandr.coreservice.dto.response.AHZ;

import com.karalexsandr.coreservice.dto.AHZ.CourseTemplateDto;
import com.karalexsandr.coreservice.dto.AHZ.LessonDto;
import com.karalexsandr.coreservice.dto.AHZ.PersonDto;
import com.karalexsandr.coreservice.dto.AHZ.StreamDto;
import com.karalexsandr.coreservice.entity.Course;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CourseResponseDto {
    private Long id;
    private String title;
    private CourseTemplateDto courseTemplate;
    private List<LessonDto> lessons;
    private StreamDto stream;
    private PersonDto teacher;

    public CourseResponseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.courseTemplate = new CourseTemplateDto(course.getCourseTemplate());
        this.lessons = course.getLessons().stream().map(LessonDto::new).collect(Collectors.toList());
        if (course.getStream()!=null) {
            this.stream = new StreamDto(course.getStream());
        }else this.stream = null;
        if (course.getTeacher()!=null) {
            this.teacher = new PersonDto(course.getTeacher());
        }else this.teacher = null;
    }
}
