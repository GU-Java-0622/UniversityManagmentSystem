package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.dto.request.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.StreamCreateRequestDto;
import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.StatusStream;
import com.karalexsandr.coreservice.entity.Stream;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.exception.StreamNotReadyException;
import com.karalexsandr.coreservice.repository.StreamRepository;
import com.karalexsandr.coreservice.services.PersonService;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreamService {
    private final StreamRepository repository;
    private final StreamTemplateService streamTemplateService;
    private final CourseService courseService;

    private final PersonService personService;

    private final LessonService lessonService;

    public StreamService(StreamRepository repository, StreamTemplateService streamTemplateService, CourseService courseService, PersonService personService, LessonService lessonService) {
        this.repository = repository;
        this.streamTemplateService = streamTemplateService;
        this.courseService = courseService;
        this.personService = personService;
        this.lessonService = lessonService;
    }

    @Transactional
    public void createStream(StreamCreateRequestDto dto){
        Stream stream = new Stream();
        stream.setStatusStream(StatusStream.PLANNED);
        StreamTemplate streamTemplate = streamTemplateService.findById(dto.getStreamTemplateId());
        stream.setFaculty(streamTemplate.getFaculties());
        stream.setStreamTemplate(streamTemplate);
        stream.setCourse(courseService.createCoursesForStreamTemplate(streamTemplate));
        repository.save(stream);
    }

    public void addStudent(AddStudentToStreamDto dto){
        Stream stream = repository.findById(dto.getStreamId()).orElseThrow(()->new ResourceNotFoundException("Не найден поток с id: "+dto.getStreamId()));
        stream.getStudents().add(personService.findPersonById(dto.getStudentId()));
        repository.save(stream);
    }

    public void startedStream(Long streamId){
        List<String> errorMessage = new ArrayList<>();
        Stream stream = repository.findById(streamId).orElseThrow(()->new ResourceNotFoundException("Не найден поток с id: " + streamId));
        /*Проверка у каждого ли курса есть учитель*/
        List<Course> courses = stream.getCourse();
        courses.stream().filter(x->x.getTeacher()==null).forEach(x->errorMessage.add("У курса '"+x.getTitle()+"' с id:'"+x.getId()+" не назначен учитель"));
        /*Проверка что у каждого урока есть время его старта то есть проставлено ли расписание*/
        lessonService.getNotReadyLesson(courses).forEach(x->errorMessage.add("У урока с id: "
                +x.getId()+" с темой '"+x.getTheme()+"' не назначено время проведения"));
        if (!errorMessage.isEmpty()){
            throw new StreamNotReadyException(errorMessage);
        }
        repository.startedStream(StatusStream.ACTIVE,streamId);
    }
}
