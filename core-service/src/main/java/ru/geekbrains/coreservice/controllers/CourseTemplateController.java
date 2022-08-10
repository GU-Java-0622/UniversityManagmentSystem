package ru.geekbrains.coreservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.geekbrains.coreservice.dto.request.CourseTemplateCreateDto;
import ru.geekbrains.coreservice.dto.response.CourseTemplateResponseDto;
import ru.geekbrains.coreservice.services.template.CourseTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/courses")
@Tag(name = "Сервис работы с шаблонами курсов", description = "Методы работы с шаблонами курсов")
public class CourseTemplateController {
    private final CourseTemplateService courseTemplateService;


    @Operation(
            summary = "Запрос на создание шаблона курса",
            responses = {
                    @ApiResponse(
                            description = "Шаблон курса создан", responseCode = "200"
                    )
            }
    )
    @PostMapping
    public void createCourseTemplate(@RequestBody CourseTemplateCreateDto dto){
        courseTemplateService.createCourseTemplate(dto.getTitle());
    }

    @Operation(
            summary = "Запрос на получение шаблона курса",
            responses = {
                    @ApiResponse(
                            description = "Шаблон курса получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public CourseTemplateResponseDto getCourseTemplateById(@PathVariable Long id){
        return courseTemplateService.getCourseTemplateWithLessons(id);
    }
}
