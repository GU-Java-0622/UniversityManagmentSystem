package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.model.Faculty;
import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.service.FacultyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/faculty")
@Tag(name = "Сервис факультета", description = "Методы работы с сервисом факультета")
public class FacultyController {
    private final FacultyService facultyService;

    @Operation(summary = "Запрос на получение страницы факультета",
            responses = {
                    @ApiResponse(description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class)))})
    @GetMapping
    public Page<Faculty> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        if (pageNo<1){
            pageNo = 1;
        }
        Pageable pageable = PageRequest.of((pageNo-1),pageSize);
        return facultyService.findAll(pageable);
    }
    @Operation(summary = "Запрос на получение факультета по title",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Faculty.class))
                    )
            })
    @GetMapping("/{title}")
    public Faculty findByTitle(
            @Parameter(description = "Название факультета",required = true)
            @PathVariable String title){
        return facultyService.findByTitle(title);
    }
}
