package ru.geekbrains.coreservice.services.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.commons.exception.ResourceNotFoundException;
import ru.geekbrains.coreservice.dto.request.StreamTemplateCreateDto;
import ru.geekbrains.coreservice.dto.request.StreamTemplateUpdateCoursesDto;
import ru.geekbrains.coreservice.entity.StreamTemplate;
import ru.geekbrains.coreservice.repository.StreamTemplateRepository;
import ru.geekbrains.coreservice.services.FacultyService;

@Service
@RequiredArgsConstructor
public class StreamTemplateService {
    private final FacultyService facultyService;
    private final StreamTemplateRepository repository;


    public void createStreamTemplate(StreamTemplateCreateDto streamTemplateCreateDto) {
        StreamTemplate streamTemplate = new StreamTemplate();
        streamTemplate.setTitle(streamTemplateCreateDto.getTitle());
        streamTemplate.setFaculties(facultyService.getFacultyRefById(streamTemplateCreateDto.getFacultyId()));
        repository.save(streamTemplate);
    }

    public StreamTemplate getStreamTemplateRefById(Long id) {
        return repository.getReferenceById(id);
    }

    public StreamTemplate findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Не найден шаблон для потока с id:" + id));
    }


    public StreamTemplate updateCourses(StreamTemplateUpdateCoursesDto dto) {
        return repository.findById(dto.getStreamTemplateId())
                .orElseThrow(() -> new ResourceNotFoundException("Не найден шаблон для потока с id:" + dto.getStreamTemplateId()));
    }
}
