package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.model.Lesson;
import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.service.LessonService;
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


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lesson")
@Tag(name = "Сервис уроков", description = "Методы работы с сервисом уроков")
public class LessonController {
    private final LessonService lessonService;

    @Operation(summary = "Запрос на получение страницы уроков",
            responses = {
                    @ApiResponse(description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class)))})
    @GetMapping
    public Page<Lesson> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        Pageable pageable = PageRequest.of((pageNo - 1), pageSize);
        return lessonService.findAll(pageable);
    }

    @Operation(summary = "Запрос на получение урока по theme",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Lesson.class))
                    )
            })
    @GetMapping("{theme}")
    public Lesson findByTheme(
            @Parameter(description = "Тема урока",required = true)
            @PathVariable String theme){
        return lessonService.findByTheme(theme);
    }

}
