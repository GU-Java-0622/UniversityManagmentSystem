package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.CourseTemplateCreateDto;
import com.karalexsandr.coreservice.services.template.CourseTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/courses")
public class CourseTemplateController {
    private final CourseTemplateService courseTemplateService;

    @PostMapping
    public void createCourseTemplate(@RequestBody CourseTemplateCreateDto dto){
        courseTemplateService.createCourseTemplate(dto.getTitle());
    }
}
