package ru.geekbrains.coreservice.dto.request;

import lombok.Data;

@Data
public class StreamTemplateCreateDto {
    private String title;
    private Long facultyId;
}
