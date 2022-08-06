package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.CourseTemplateCreateDto;
import com.karalexsandr.coreservice.dto.response.CourseTemplateResponseDto;
import com.karalexsandr.coreservice.services.template.CourseTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/courses")
public class CourseTemplateController {
    private final CourseTemplateService courseTemplateService;

    @PostMapping
    public void createCourseTemplate(@RequestBody CourseTemplateCreateDto dto){
        courseTemplateService.createCourseTemplate(dto.getTitle());
    }
    @GetMapping("/{id}")
    public CourseTemplateResponseDto getCourseTemplateById(@PathVariable Long id){
        return courseTemplateService.getCourseTemplateWithLessons(id);
    }
}
