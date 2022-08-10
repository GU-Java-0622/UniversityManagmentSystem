package ru.geekbrains.coreservice.controllers;

import ru.geekbrains.coreservice.dto.request.FacultyCreateDto;
import ru.geekbrains.coreservice.dto.response.FacultyFullResponseDto;
import ru.geekbrains.coreservice.dto.response.FacultyResponseDto;
import ru.geekbrains.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.security.RoleChecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    @PostMapping
    public void createFaculty(@RequestBody FacultyCreateDto facultyCreateDto, @RequestHeader("roles") Set<ERole> roles){
        //      ToDo: Заменить на вызов бина RoleChecker
        HashSet<ERole> neededRole = new HashSet<>();
        neededRole.add(ERole.ROLE_ADMIN);
        RoleChecker.roleCheck(roles,neededRole);
        facultyService.createFaculty(facultyCreateDto);
    }

    @GetMapping("/get_all_faculty")
    public List<FacultyResponseDto> getAllFacultyStreamAndTemplate(@RequestHeader("roles") Set<ERole> roles){
        //      ToDo: Заменить на вызов бина RoleChecker
        HashSet<ERole> neededRole = new HashSet<>();
        neededRole.add(ERole.ROLE_ADMIN);
        RoleChecker.roleCheck(roles,neededRole);
        return facultyService.getAll();
    }
    @GetMapping("/get_faculty/{id}")
    public FacultyFullResponseDto getFacultyById(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles){
        //      ToDo: Заменить на вызов бина RoleChecker
        HashSet<ERole> neededRole = new HashSet<>();
        neededRole.add(ERole.ROLE_ADMIN);
        RoleChecker.roleCheck(roles,neededRole);
        return facultyService.getById(id);
    }
}


