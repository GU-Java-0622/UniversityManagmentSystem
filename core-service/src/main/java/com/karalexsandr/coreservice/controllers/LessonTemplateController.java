package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.LessonTemplateCreateRequestDto;
import com.karalexsandr.coreservice.services.template.LessonTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/lessons")
public class LessonTemplateController {
    private final LessonTemplateService lessonTemplateService;

    @GetMapping("/delete/{id}")
    public void deleteLessonTemplate(@PathVariable Long id){
        lessonTemplateService.deleteById(id);
    }

    @PostMapping("/create")
    public void createLessonTemplate(@RequestBody LessonTemplateCreateRequestDto dto){
        lessonTemplateService.createLessonTemplate(dto);
    }
}
