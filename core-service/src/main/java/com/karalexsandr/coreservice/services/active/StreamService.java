package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.dto.response.StreamResponseDto;
import com.karalexsandr.coreservice.dto.request.AHZ.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.StreamCreateRequestDto;
import com.karalexsandr.coreservice.entity.*;
import com.karalexsandr.coreservice.exception.StreamNotReadyException;
import com.karalexsandr.coreservice.integrations.AuthServiceIntegration;
import com.karalexsandr.coreservice.repository.StreamRepository;
import com.karalexsandr.coreservice.services.PersonService;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.entity.UserDto;
import web.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StreamService {
    private final StreamRepository repository;
    private final StreamTemplateService streamTemplateService;
    private final CourseService courseService;
    private final PersonService personService;
    private final AuthServiceIntegration authServiceIntegration;



    @Transactional
    public Long createStream(StreamCreateRequestDto dto){
        Stream stream = new Stream();
        stream.setStatusStream(StatusStream.PLANNED);
        StreamTemplate streamTemplate = streamTemplateService.getStreamTemplateRefById(dto.getStreamTemplateId());
        stream.setFaculty(streamTemplate.getFaculties());
        stream.setStreamTemplate(streamTemplate);
        stream.setCourse(courseService.createCoursesForStreamTemplate(streamTemplate));
        repository.save(stream);
        stream.getCourse().forEach(x->courseService.setStream(x,stream));
        return stream.getId();
    }

    public void addStudent(AddStudentToStreamDto dto){
        Stream stream = repository.findById(dto.getStreamId()).orElseThrow(()->new ResourceNotFoundException("Не найден поток с id: "+dto.getStreamId()));
        stream.getStudents().add(personService.getStudentById(dto.getStudentId()));
        repository.save(stream);
    }

    @Transactional
    public void startedStream(Long streamId){
        repository.startedStream(StatusStream.ACTIVE,streamId);
    }

    public StreamResponseDto getById(Long id) {
        Stream streamEntity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Не найден поток с id: " +id));
        System.out.println(streamEntity.getCourse().toString());
        StreamResponseDto dto = new StreamResponseDto(streamEntity);
        List<Long> teachersId =new ArrayList<>();
        streamEntity.getCourse().forEach(course->{
           if (course.getTeacher()!=null){
               teachersId.add( course.getTeacher().getId());
           }
        });
        if(!teachersId.isEmpty()){
            List<UserDto> teachers=authServiceIntegration.getUserListById(teachersId).getUsers();
            dto.getCourseDto().forEach(x->x.setTeacher(teachers.stream()
                    .filter(y->y.getId().equals(x.getTeacherId())).findFirst().orElseThrow(()->new ResourceNotFoundException("Не найден учитель с id: " + x))));
        }
        List<Long> studentsId = streamEntity.getStudents().stream().map(Person::getId).collect(Collectors.toList());
        if(!studentsId.isEmpty()){
            dto.setStudents(authServiceIntegration.getUserListById(studentsId).getUsers());
        }
        System.out.println(dto);
        return dto;
    }
}
