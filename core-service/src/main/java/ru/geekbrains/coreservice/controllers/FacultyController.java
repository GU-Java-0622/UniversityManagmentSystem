package ru.geekbrains.coreservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.geekbrains.coreservice.dto.request.FacultyCreateDto;
import ru.geekbrains.coreservice.dto.response.FacultyFullResponseDto;
import ru.geekbrains.coreservice.dto.response.FacultyResponseDto;
import ru.geekbrains.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.security.RoleChecker;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculties")
@Tag(name = "Сервис работы с созданными факультетами", description = "Методы работы с созданными факультетами")
public class FacultyController {
    private final FacultyService facultyService;
    private final RoleChecker roleChecker;

    @Operation(
            summary = "Запрос на создание факультета",
            responses = {
                    @ApiResponse(
                            description = "Факультет создан", responseCode = "200"
                    )
            }
    )
    @PostMapping
    public void createFaculty(@RequestBody FacultyCreateDto facultyCreateDto, @RequestHeader("roles") Set<ERole> roles){
        roleChecker.adminRoleCheck(roles);
        facultyService.createFaculty(facultyCreateDto);
    }

    @Operation(
            summary = "Запрос на получение всех факультетов",
            responses = {
                    @ApiResponse(
                            description = "Факультеты получены", responseCode = "200"
                    )
            }
    )
    @GetMapping
    public List<FacultyResponseDto> getAllFacultyStreamAndTemplate(@RequestHeader("roles") Set<ERole> roles){
        roleChecker.adminRoleCheck(roles);
        return facultyService.getAll().stream().map(FacultyResponseDto::new).collect(Collectors.toList());
    }

    @Operation(
            summary = "Запрос на получение факультета по ID",
            responses = {
                    @ApiResponse(
                            description = "Факультет получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public FacultyFullResponseDto getFacultyById(@PathVariable Long id, @RequestHeader("roles") Set<ERole> roles){
        roleChecker.adminRoleCheck(roles);
        return new FacultyFullResponseDto(facultyService.getById(id));
    }
}


