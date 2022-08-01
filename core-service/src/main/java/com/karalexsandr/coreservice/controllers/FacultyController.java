package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.FacultyDto;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculties")
public class FacultyController {
    private final FacultyService facultyService;


    @PostMapping
    public void createFaculty(@RequestBody FacultyDto facultyDto){
        facultyService.createFaculty(facultyDto);
    }
}
