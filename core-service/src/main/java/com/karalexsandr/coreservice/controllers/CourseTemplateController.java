package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.services.template.CourseTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/template/courses")
public class CourseTemplateController {
    private final CourseTemplateService courseTemplateService;

    @PostMapping
    public void createCourseTemplate(@RequestBody String title, @RequestBody Long streamId){
        courseTemplateService.createCourseTemplate(title,streamId);
    }

    @GetMapping
    public List<CourseTemplate> findAll(){
        return courseTemplateService.findAll();
    }
}
