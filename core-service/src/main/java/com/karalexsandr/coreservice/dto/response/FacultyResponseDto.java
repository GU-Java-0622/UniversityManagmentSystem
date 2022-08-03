package com.karalexsandr.coreservice.dto.response;

import com.karalexsandr.coreservice.dto.StreamDto;
import com.karalexsandr.coreservice.dto.StreamTemplateDto;
import com.karalexsandr.coreservice.entity.Faculty;
import com.karalexsandr.coreservice.entity.StatusStream;
import com.karalexsandr.coreservice.entity.Stream;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FacultyResponseDto {

    private Long id;
    private String title;
    private List<StreamDto> streams;
    private List<StreamTemplateDto> streamTemplate;


    public FacultyResponseDto (Faculty faculty){
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.streams = faculty.getStreams().stream().map(StreamDto::new).collect(Collectors.toList());
        this.streamTemplate = faculty.getStreamTemplate().stream().map(StreamTemplateDto::new).collect(Collectors.toList());
    }


}
