package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.LessonTemplateDto;
import com.karalexsandr.coreservice.dto.StreamTemplateDto;
import com.karalexsandr.coreservice.dto.request.StreamTemplateCreateDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/streams")
public class StreamTemplateController {
    private final StreamTemplateService streamTemplateService;

    @PostMapping
    public void createStreamTemplate(@RequestBody StreamTemplateCreateDto streamTemplateCreateDto){
        streamTemplateService.createStreamTemplate(streamTemplateCreateDto);
    }

    @GetMapping
    public Page<StreamTemplateDto> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        return streamTemplateService.findAll(PageRequest.of(page-1, size));
    }


}
