package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.CourseSetTeacherDto;
import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.services.active.CourseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @PatchMapping ("/{idCourse}/teacher/{idTeacher}")
    public void setTeacher(@PathVariable Long idCourse, @PathVariable Long idTeacher){
        courseService.setTeacher(idCourse,idTeacher);
    }

    @GetMapping
    public List<Course> findAll(){
        return courseService.findAll();
    }

}
