package com.karalexsandr.coreservice.dto.response;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FacultyResponseDto (Faculty faculty){
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.createdAt = faculty.getCreatedAt();
        this.updatedAt = faculty.getUpdatedAt();
        this.streams = faculty.getStreams().stream().map(StreamDto::new).collect(Collectors.toList());
        this.streamTemplate = faculty.getStreamTemplate().stream().map(StreamTemplateDto::new).collect(Collectors.toList());
    }

    @Data
    public static class StreamDto{
        private Long id;
        private StatusStream statusStream;
        private Integer countOfStudents;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public StreamDto (Stream stream){
            this.id = stream.getId();
            this.createdAt = stream.getCreatedAt();
            this.updatedAt = stream.getUpdatedAt();
            this.countOfStudents = stream.getStudents().size();
        }
    }

    @Data
    public static class StreamTemplateDto{
        private Long id;
        private String title;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public StreamTemplateDto(StreamTemplate template){
            this.id = template.getId();
            this.title = template.getTitle();
            this.createdAt = template.getCreatedAt();
            this.updatedAt = template.getUpdatedAt();
        }
    }
}
