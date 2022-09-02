package ru.geekbrains.coreservice.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.coreservice.dto.request.StreamTemplateCreateDto;
import ru.geekbrains.coreservice.dto.request.StreamTemplateUpdateCoursesDto;
import ru.geekbrains.coreservice.dto.response.StreamTemplateResponseDto;
import ru.geekbrains.coreservice.repository.converters.StreamTemplateConverter;
import ru.geekbrains.coreservice.services.template.StreamTemplateService;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/templates/streams")
@Tag(name = "Сервис работы с шаблонами потоков", description = "Методы работы с шаблонами потоков")
public class StreamTemplateController {
    private final StreamTemplateService streamTemplateService;
    private final StreamTemplateConverter streamTemplateConverter;

    @Operation(
            summary = "Запрос на создание шаблона потока",
            responses = {
                    @ApiResponse(
                            description = "Шаблон потока создан", responseCode = "200"
                    )
            }
    )
    @PostMapping
    public void createStreamTemplate(@RequestBody StreamTemplateCreateDto streamTemplateCreateDto) {
        streamTemplateService.createStreamTemplate(streamTemplateCreateDto);
    }

    @Operation(
            summary = "Запрос на получение шаблона потока",
            responses = {
                    @ApiResponse(
                            description = "Шаблон потока получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public StreamTemplateResponseDto getTemplateById(@PathVariable Long id) {
        return streamTemplateConverter.entityToDto(streamTemplateService.findById(id));
    }

    @Operation(
            summary = "Запрос на обновление курсов в шаблоне потока",
            responses = {
                    @ApiResponse(
                            description = "Шаблон потока обновлен", responseCode = "200"
                    )
            }
    )
    @PutMapping
    public StreamTemplateResponseDto updateCoursesInStreamTemplate(@RequestBody StreamTemplateUpdateCoursesDto dto) {
        return streamTemplateConverter.entityToDto(streamTemplateService.updateCourses(dto));
    }

}
