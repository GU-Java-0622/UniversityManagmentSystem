package com.karalexsandr.coreservice.controllers;


import com.karalexsandr.coreservice.dto.request.StreamTemplateCreateDto;
import com.karalexsandr.coreservice.dto.request.StreamTemplateUpdateCoursesDto;
import com.karalexsandr.coreservice.dto.response.StreamTemplateResponseDto;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/streams")
public class StreamTemplateController {
    private final StreamTemplateService streamTemplateService;

    @PostMapping
    public void createStreamTemplate(@RequestBody StreamTemplateCreateDto streamTemplateCreateDto){
        streamTemplateService.createStreamTemplate(streamTemplateCreateDto);
    }

    @GetMapping("/{id}")
    public StreamTemplateResponseDto getTemplateById(@PathVariable Long id){
       return streamTemplateService.findById(id);
    }

    @PostMapping("/update_courses")
    public StreamTemplateResponseDto updateCoursesInStreamTemplate(@RequestBody StreamTemplateUpdateCoursesDto dto){
        return streamTemplateService.updateCourses(dto);
    }

}
