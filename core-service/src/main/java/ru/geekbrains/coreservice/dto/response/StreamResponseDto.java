package ru.geekbrains.coreservice.dto.response;

import ru.geekbrains.coreservice.entity.Course;
import ru.geekbrains.coreservice.entity.StatusStream;
import ru.geekbrains.coreservice.entity.Stream;
import lombok.Data;
import ru.geekbrains.commons.entity.UserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StreamResponseDto {
    private Long id;
    private String facultyTitle;
    private String templateTitle;
    private StatusStream statusStream;
    private Integer countOfStudents;
    private List<CourseDto> courseDto;
    private List<UserDto> students;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public StreamResponseDto(Stream stream){
        this.id = stream.getId();
        this.statusStream = stream.getStatusStream();
        this.templateTitle= stream.getStreamTemplate().getTitle();
        this.countOfStudents = stream.getStudents().size();
        this.courseDto = stream.getCourse().stream().map(CourseDto::new).collect(Collectors.toList());
        this.facultyTitle = stream.getFaculty().getTitle();
        this.createdAt = stream.getCreatedAt();
        this.updatedAt = stream.getUpdatedAt();
    }
    @Data
    public static class CourseDto{
        private Long id;
        private String title;
        private Long teacherId;
        private UserDto teacher;
        private Integer countLesson;


        public CourseDto(Course course){
            this.id = course.getId();
            this.title = course.getTitle();
            this.countLesson = course.getLessons().size();
            if(course.getTeacher()!=null) {
                this.teacherId = course.getTeacher().getId();
            }
        }
    }
}
