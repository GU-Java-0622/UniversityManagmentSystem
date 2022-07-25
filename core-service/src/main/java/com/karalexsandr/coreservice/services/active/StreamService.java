package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.dto.request.AddStudentToStreamDto;
import com.karalexsandr.coreservice.dto.request.StreamCreateRequestDto;
import com.karalexsandr.coreservice.entity.StatusStream;
import com.karalexsandr.coreservice.entity.Stream;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.services.PersonService;
import com.karalexsandr.coreservice.services.template.StreamTemplateService;
import com.karalexsandr.coreservice.repository.StreamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.exception.ResourceNotFoundException;

@Service
public class StreamService {
    private final StreamRepository repository;
    private final StreamTemplateService streamTemplateService;
    private final CourseService courseService;

    private final PersonService personService;

    public StreamService(StreamRepository repository, StreamTemplateService streamTemplateService, CourseService courseService, PersonService personService) {
        this.repository = repository;
        this.streamTemplateService = streamTemplateService;
        this.courseService = courseService;
        this.personService = personService;
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
        Stream stream = repository.findById(dto.getStreamId()).orElseThrow(()->new ResourceNotFoundException("Не найден поток с id:"+dto.getStreamId()));
        stream.getStudents().add(personService.findPersonById(dto.getStudentId()));
        repository.save(stream);
    }

    public void startedStream(Long streamId){

        repository.startedStream(StatusStream.ACTIVE,streamId);
    }
}
