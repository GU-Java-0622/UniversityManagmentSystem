package ru.geekbrains.coreservice.dto.request.AHZ;

import lombok.Data;

@Data
public class AddStudentToStreamDto {
    private Long studentId;
    private Long streamId;
}
