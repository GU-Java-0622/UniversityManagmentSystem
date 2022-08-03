package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.CourseTemplateDto;
import com.karalexsandr.coreservice.dto.LessonTemplateDto;
import com.karalexsandr.coreservice.dto.request.LessonTemplateCreateDto;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.services.template.LessonTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/lessons")
public class LessonTemplateController {
    private final LessonTemplateService lessonTemplateService;

    @PostMapping
    public void createLessonTemplate(@RequestBody LessonTemplateCreateDto dto){
        lessonTemplateService.createLessonTemplate(dto);
    }

    @GetMapping
    public Page<LessonTemplateDto> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        return lessonTemplateService.findAll(PageRequest.of(page-1, size));
    }
}
