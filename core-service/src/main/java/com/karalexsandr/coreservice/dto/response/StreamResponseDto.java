package com.karalexsandr.coreservice.dto.response;


import com.karalexsandr.coreservice.dto.CourseDto;
import com.karalexsandr.coreservice.dto.FacultyDto;
import com.karalexsandr.coreservice.dto.PersonDto;
import com.karalexsandr.coreservice.dto.StreamTemplateDto;
import com.karalexsandr.coreservice.entity.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StreamResponseDto {
    private Long id;
    private StreamTemplateDto streamTemplate;
    private List<CourseDto> course;
    private StatusStream statusStream;
    private FacultyDto faculty;
    private List<PersonDto> students;

    public StreamResponseDto(Stream stream) {
        this.id = stream.getId();
        this.streamTemplate = new StreamTemplateDto(stream.getStreamTemplate());
        this.course = stream.getCourse().stream().map(CourseDto::new).collect(Collectors.toList());
        this.statusStream = stream.getStatusStream();
        this.faculty = new FacultyDto(stream.getFaculty());
        this.students = stream.getStudents().stream().map(PersonDto::new).collect(Collectors.toList());
    }

}
