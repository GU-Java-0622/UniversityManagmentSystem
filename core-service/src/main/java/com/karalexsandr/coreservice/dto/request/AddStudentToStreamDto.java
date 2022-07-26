package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

@Data
public class AddStudentToStreamDto {
    private Long studentId;
    private Long streamId;
}
