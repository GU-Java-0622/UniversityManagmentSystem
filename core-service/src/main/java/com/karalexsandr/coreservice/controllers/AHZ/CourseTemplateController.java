package com.karalexsandr.coreservice.controllers.AHZ;

import com.karalexsandr.coreservice.dto.AHZ.CourseTemplateDto;
import com.karalexsandr.coreservice.dto.request.AHZ.CourseTemplateCreateDto;
import com.karalexsandr.coreservice.services.template.CourseTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/courses")
public class CourseTemplateController {
    private final CourseTemplateService courseTemplateService;

    @PostMapping
    public void createCourseTemplate(@RequestBody CourseTemplateCreateDto courseTemplateCreateDto) {
        courseTemplateService.createCourseTemplate(courseTemplateCreateDto);
    }

    @GetMapping
    public Page<CourseTemplateDto> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        return courseTemplateService.findAll(PageRequest.of(page-1, size));
    }
}
