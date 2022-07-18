package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.service.ScheduleService;
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
@RequestMapping("api/v1/schedule")
@Tag(name = "Сервис расписания", description = "Методы работы с сервисом расписания")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Operation(summary = "Запрос на получение страницы расписания",
            responses = {
                    @ApiResponse(description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class)))})
    @GetMapping
    public Page<Schedule> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        if (pageNo<1){
            pageNo = 1;
        }
        Pageable pageable = PageRequest.of((pageNo-1),pageSize);
        return scheduleService.findAll(pageable);
    }

    @Operation(summary = "Запрос на получение расписания по id",
    responses = {
            @ApiResponse(
                    description = "Успешный ответ", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Schedule.class))
            )
    })
    @GetMapping("/{id}")
    public Schedule findByTitle(
            @Parameter(description = "Индентификатор расписания",required = true)
            @PathVariable Long id){
        return scheduleService.findById(id);
    }
}
