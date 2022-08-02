package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/template/streams")
public class StreamTemplateController {
    private final StreamTemplateService streamTemplateService;

    @PostMapping
    public void createStreamTemplate(@RequestBody String title, @RequestBody Long facultyId){
        streamTemplateService.createStreamTemplate(title,facultyId);
    }

    @GetMapping
    public List<StreamTemplate> findAll(){
        return streamTemplateService.findAll();
    }
    @GetMapping("/{id}")
    public StreamTemplate findById(@PathVariable Long id){
        return streamTemplateService.findById(id);
    }
}
