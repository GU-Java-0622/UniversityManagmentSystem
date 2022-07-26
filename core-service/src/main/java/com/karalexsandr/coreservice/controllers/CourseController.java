package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.CourseSetTeacherDto;
import com.karalexsandr.coreservice.services.active.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PutMapping("/set_teacher")
    public void setTeacher(@RequestBody CourseSetTeacherDto dto){
        courseService.setTeacher(dto);
    }

}
