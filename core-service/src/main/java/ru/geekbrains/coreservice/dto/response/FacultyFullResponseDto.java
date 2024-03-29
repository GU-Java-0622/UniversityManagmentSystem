package ru.geekbrains.coreservice.dto.response;

import ru.geekbrains.coreservice.entity.Faculty;
import ru.geekbrains.coreservice.entity.StatusStream;
import ru.geekbrains.coreservice.entity.Stream;
import ru.geekbrains.coreservice.entity.StreamTemplate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FacultyFullResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<StreamDto> streams;
    private List<TemplateDto> templates;


    public FacultyFullResponseDto(Faculty faculty){
        this.id = faculty.getId();
        this.title = faculty.getTitle();
        this.createdAt = faculty.getCreatedAt();
        this.updatedAt = faculty.getUpdatedAt();
        this.streams = faculty.getStreams().stream().map(StreamDto::new).collect(Collectors.toList());
        this.templates = faculty.getStreamTemplate().stream().map(TemplateDto::new).collect(Collectors.toList());
    }

    @Data
    public static class StreamDto{
        private Long id;
        private StatusStream statusStream;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Integer countStudents;

        public StreamDto (Stream stream){
            this.id = stream.getId();
            this.statusStream = stream.getStatusStream();
            this.createdAt = stream.getCreatedAt();
            this.updatedAt = stream.getUpdatedAt();
            this.countStudents = stream.getStudents().size();
        }
    }
    @Data
    public static class TemplateDto{
        private Long id;
        private String title;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Integer countCreatedStreams;


        public TemplateDto(StreamTemplate template){
            this.id = template.getId();
            this.title = template.getTitle();
            this.createdAt = template.getCreatedAt();
            this.updatedAt = template.getUpdatedAt();
        }
    }


}
