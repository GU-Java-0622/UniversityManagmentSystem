package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.LessonTemplateCreateDto;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.services.template.LessonTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/template/lessons")
public class LessonTemplateController {
    private final LessonTemplateService lessonTemplateService;

    @PostMapping
    public void createLessonTemplate(@RequestBody LessonTemplateCreateDto dto){
        lessonTemplateService.createLessonTemplate(dto);
    }

    @GetMapping
    public List<LessonTemplate> findAll(){
        return lessonTemplateService.findAll();
    }
}
