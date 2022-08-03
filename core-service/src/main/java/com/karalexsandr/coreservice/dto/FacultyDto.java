package com.karalexsandr.coreservice.dto;


import com.karalexsandr.coreservice.entity.Faculty;
import lombok.Data;

@Data
public class FacultyDto {
    private Long id;
    private String title;

    public FacultyDto(Faculty faculty) {
        this.id = faculty.getId();
        this.title = faculty.getTitle();
    }
}