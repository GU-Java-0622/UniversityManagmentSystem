package com.karalexsandr.coreservice.dto.response;


import com.karalexsandr.coreservice.entity.Faculty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacultyResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FacultyResponseDto(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.createdAt = faculty.getCreatedAt();
        this.updatedAt = faculty.getUpdatedAt();
    }
}