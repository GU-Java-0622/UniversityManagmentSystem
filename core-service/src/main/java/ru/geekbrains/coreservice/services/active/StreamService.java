package ru.geekbrains.coreservice.services.active;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.commons.entity.ERole;
import ru.geekbrains.commons.exception.ResourceNotFoundException;
import ru.geekbrains.coreservice.dto.request.AHZ.AddStudentToStreamDto;
import ru.geekbrains.coreservice.dto.request.StreamCreateRequestDto;
import ru.geekbrains.coreservice.entity.StatusStream;
import ru.geekbrains.coreservice.entity.Stream;
import ru.geekbrains.coreservice.entity.StreamTemplate;
import ru.geekbrains.coreservice.repository.StreamRepository;
import ru.geekbrains.coreservice.services.PersonService;
import ru.geekbrains.coreservice.services.template.StreamTemplateService;

@Service
@RequiredArgsConstructor
public class StreamService {
    private final StreamRepository repository;
    private final StreamTemplateService streamTemplateService;
    private final CourseService courseService;
    private final PersonService personService;


    @Transactional
    public Long createStream(StreamCreateRequestDto dto) {
        Stream stream = new Stream();
        stream.setStatusStream(StatusStream.PLANNED);
        StreamTemplate streamTemplate = streamTemplateService.getStreamTemplateRefById(dto.getStreamTemplateId());
        stream.setFaculty(streamTemplate.getFaculties());
        stream.setStreamTemplate(streamTemplate);
        stream.setCourse(courseService.createCoursesForStreamTemplate(streamTemplate));
        repository.save(stream);
        stream.getCourse().forEach(x -> courseService.setStream(x, stream));
        return stream.getId();
    }

    public void addStudent(AddStudentToStreamDto dto) {
        Stream stream = repository.findById(dto.getStreamId()).orElseThrow(() -> new ResourceNotFoundException("Не найден поток с id: " + dto.getStreamId()));
        stream.getStudents().add(personService.getStudentById(dto.getStudentId(), ERole.ROLE_STUDENT));
        repository.save(stream);
    }

    @Transactional
    public void startedStream(Long streamId) {
        repository.startedStream(StatusStream.ACTIVE, streamId);
    }

    public Stream getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Не найден поток с id: " + id));

    }
}
