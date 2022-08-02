package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.FacultyDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping
    public List<Faculty> findAll(){
        return facultyService.findAll();
    }

    @PostMapping
    public void createFaculty(@RequestBody FacultyDto facultyDto){
        facultyService.createFaculty(facultyDto);
    }
}
