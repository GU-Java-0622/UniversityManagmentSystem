package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.model.LearningProgramme;
import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.service.LearningProgrammeService;
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
@RequestMapping("api/v1/learningProgramme")
@Tag(name = "Сервис программы обучения", description = "Методы работы с сервисом программы обучения")
public class LearningProgrammeController {
    private final LearningProgrammeService learningProgrammeService;

    @Operation(summary = "Запрос на получение страницы программы обучения",
            responses = {
                    @ApiResponse(description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class)))})
    @GetMapping
    public Page<LearningProgramme> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        if (pageNo<1){
            pageNo = 1;
        }
        Pageable pageable = PageRequest.of((pageNo-1),pageSize);
        return learningProgrammeService.findAll(pageable);
    }

    @Operation(summary = "Запрос на получение программы обучения по title",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LearningProgramme.class))
                    )
            })
    @GetMapping("/{title}")
    public LearningProgramme findByTitle(
            @Parameter(description = "Название программы обучения",required = true)
            @PathVariable String title){
        return learningProgrammeService.findByTitle(title);
    }
}
