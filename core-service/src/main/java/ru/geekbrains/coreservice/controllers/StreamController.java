package ru.geekbrains.coreservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.geekbrains.coreservice.dto.response.StreamResponseDto;
import ru.geekbrains.coreservice.dto.request.AHZ.AddStudentToStreamDto;
import ru.geekbrains.coreservice.dto.request.StreamCreateRequestDto;
import ru.geekbrains.coreservice.services.active.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/streams")
@Tag(name = "Сервис работы с созданными потоками", description = "Методы работы с созданными потоками")
public class StreamController {
    private final StreamService streamService;

//ToDo: Заменить Long на DTO
@Operation(
        summary = "Запрос на создание потока",
        responses = {
                @ApiResponse(
                        description = "Поток создан", responseCode = "200"
                )
        }
)
    @PostMapping
    public Long createStream(@RequestBody StreamCreateRequestDto dto){
        return streamService.createStream(dto);
    }

    @Operation(
            summary = "Запрос на получение стартовавшего потока по ID",
            responses = {
                    @ApiResponse(
                            description = "Поток получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/started/{id}")
    public void startedStream(@PathVariable Long id){
        streamService.startedStream(id);
    }

    @Operation(
            summary = "Запрос на добавление студента на поток",
            responses = {
                    @ApiResponse(
                            description = "Студент добавлен", responseCode = "200"
                    )
            }
    )
    @PostMapping("/student/add")
    public void addStudent(@RequestBody AddStudentToStreamDto dto){
        streamService.addStudent(dto);
    }

    @Operation(
            summary = "Запрос на получение потока по ID",
            responses = {
                    @ApiResponse(
                            description = "Поток получен", responseCode = "200"
                    )
            }
    )
    @GetMapping("/{id}")
    public StreamResponseDto getStream(@PathVariable Long id){
       return streamService.getById(id);
    }
}
