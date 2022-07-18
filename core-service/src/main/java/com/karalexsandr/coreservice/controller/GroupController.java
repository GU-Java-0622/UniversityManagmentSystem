package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.model.Schedule;
import com.karalexsandr.coreservice.service.GroupService;
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
@RequestMapping("api/v1/group")
@Tag(name = "Сервис группы", description = "Методы работы с сервисом группы")
public class GroupController {
    private final GroupService groupService;

    @Operation(summary = "Запрос на получение страницы группы",
            responses = {
                    @ApiResponse(description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Page.class)))})
    @GetMapping
    public Page<Group> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        Pageable pageable = PageRequest.of((pageNo - 1), pageSize);
        return groupService.findAll(pageable);
    }

    @Operation(summary = "Запрос на получение группы по title",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Group.class))
                    )
            })
    @GetMapping("/{title}")
    public Group findByTitle(
            @Parameter(description = "Название группы",required = true)
            @PathVariable String title){
        return groupService.findByTitle(title);
    }
}
