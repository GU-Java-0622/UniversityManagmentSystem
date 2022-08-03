package com.karalexsandr.coreservice.controllers;

import com.karalexsandr.coreservice.dto.request.FacultyDto;
import com.karalexsandr.coreservice.dto.response.FacultyResponseDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.entity.ERole;
import web.security.RoleChecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculties")
public class FacultyController {
    private final FacultyService facultyService;



    @PostMapping
    public void createFaculty(@RequestBody FacultyDto facultyDto,@RequestHeader("roles") Set<ERole> roles){
        HashSet<ERole> neededRole = new HashSet<>();
        neededRole.add(ERole.ROLE_ADMIN);
        RoleChecker.roleCheck(roles,neededRole);
        facultyService.createFaculty(facultyDto);
    }

    @GetMapping("/get_all_faculty")
    public List<FacultyResponseDto> getAllFacultyStreamAndTemplate(@RequestHeader("roles") Set<ERole> roles){
        HashSet<ERole> neededRole = new HashSet<>();
        neededRole.add(ERole.ROLE_ADMIN);
        RoleChecker.roleCheck(roles,neededRole);
        return facultyService.getAll();
    }
}


