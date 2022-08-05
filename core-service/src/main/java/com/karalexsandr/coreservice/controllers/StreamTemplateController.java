package com.karalexsandr.coreservice.controllers;


import com.karalexsandr.coreservice.dto.request.StreamTemplateCreateDto;
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

}
