package ru.geekbrains.coreservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.geekbrains.coreservice.dto.request.LessonTemplateCreateRequestDto;
import ru.geekbrains.coreservice.services.template.LessonTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/lessons")
@Tag(name = "Сервис работы с шаблонами уроков", description = "Методы работы с шаблонами уроков")
public class LessonTemplateController {
    private final LessonTemplateService lessonTemplateService;

    @Operation(
            summary = "Запрос на удаление шаблона урока",
            responses = {
                    @ApiResponse(
                            description = "Шаблон урока удален", responseCode = "200"
                    )
            }
    )
    @DeleteMapping("/{id}")
    public void deleteLessonTemplate(@PathVariable Long id){
        lessonTemplateService.deleteById(id);
    }

    @Operation(
            summary = "Запрос на создание шаблона урока",
            responses = {
                    @ApiResponse(
                            description = "Шаблон урока создан", responseCode = "200"
                    )
            }
    )
    @PostMapping
    public void createLessonTemplate(@RequestBody LessonTemplateCreateRequestDto dto){
        lessonTemplateService.createLessonTemplate(dto);
    }
}
