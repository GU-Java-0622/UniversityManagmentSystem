package com.karalexsandr.coreservice.entity.controllers;

import com.karalexsandr.coreservice.dto.request.LessonTemplateCreateDto;
import com.karalexsandr.coreservice.entity.services.template.CourseTemplateService;
import com.karalexsandr.coreservice.entity.services.template.LessonTemplateService;
import com.karalexsandr.coreservice.entity.services.template.StreamTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("api/v1/template")
public class CreateTemplateController {
    private final CourseTemplateService courseTemplateService;
    private final StreamTemplateService streamTemplateService;
    private final LessonTemplateService lessonTemplateService;

    public CreateTemplateController(CourseTemplateService courseTemplateService, StreamTemplateService streamTemplateService, LessonTemplateService lessonTemplateService) {
        this.courseTemplateService = courseTemplateService;
        this.streamTemplateService = streamTemplateService;
        this.lessonTemplateService = lessonTemplateService;
    }

    @PostMapping("/create_streame_template")
    public void createStreamTemplate(@RequestBody String title, @RequestBody Long facultyId){
        streamTemplateService.createStreamTemplate(title,facultyId);
    }

    @PostMapping("/create_course_template")
    public void createCourseTemplate(@RequestBody String title, @RequestBody Long streamId){
        courseTemplateService.createCourseTemplate(title,streamId);
    }

    @PostMapping("/create_lesson_template")
    public void createLessonTemplate(@RequestBody LessonTemplateCreateDto dto){
        lessonTemplateService.createLessonTemplate(dto);
    }
}
