package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.dto.request.StreamTemplateCreateDto;
import com.karalexsandr.coreservice.dto.request.StreamTemplateUpdateCoursesDto;
import com.karalexsandr.coreservice.dto.response.StreamTemplateResponseDto;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.repository.StreamTemplateRepository;
import com.karalexsandr.coreservice.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.exception.ResourceNotFoundException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StreamTemplateService {
    private final FacultyService facultyService;
    private final CourseTemplateService courseTemplateService;
    private final StreamTemplateRepository repository;


    public void createStreamTemplate(StreamTemplateCreateDto streamTemplateCreateDto){
        StreamTemplate streamTemplate = new StreamTemplate();
        streamTemplate.setTitle(streamTemplateCreateDto.getTitle());
        streamTemplate.setFaculties(facultyService.getFacultyRefById(streamTemplateCreateDto.getFacultyId()));
        repository.save(streamTemplate);
    }

    public StreamTemplate getStreamTemplateRefById(Long id){
       return repository.getReferenceById(id);
    }

    public StreamTemplateResponseDto findById(Long id){
        StreamTemplate template = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Не найден шаблон для потока с id:"+id));
        StreamTemplateResponseDto templateResponseDto = new StreamTemplateResponseDto(template);
        templateResponseDto.setCourseNotInTemplate(courseTemplateService.getCourseNotInStreamTemplate(templateResponseDto.getCourseTemplate()
                .stream().map(StreamTemplateResponseDto.CourseTemplateDto::getId)
                .collect(Collectors.toList())).stream()
                .map(StreamTemplateResponseDto.CourseTemplateDto::new).collect(Collectors.toList()));
        return templateResponseDto;
    }


    public StreamTemplateResponseDto updateCourses(StreamTemplateUpdateCoursesDto dto) {
        StreamTemplate template = repository.findById(dto.getStreamTemplateId())
                .orElseThrow(()-> new ResourceNotFoundException("Не найден шаблон для потока с id:"+dto.getStreamTemplateId()));
        template.setCourseTemplates(courseTemplateService.getCourseTemplateIn(dto.getCoursesTemplateIds()));
        repository.save(template);
        StreamTemplateResponseDto templateResponseDto = new StreamTemplateResponseDto(template);
        templateResponseDto.setCourseNotInTemplate(courseTemplateService.getCourseNotInStreamTemplate(templateResponseDto.getCourseTemplate()
                        .stream().map(StreamTemplateResponseDto.CourseTemplateDto::getId)
                        .collect(Collectors.toList())).stream()
                .map(StreamTemplateResponseDto.CourseTemplateDto::new).collect(Collectors.toList()));
        return templateResponseDto;
    }
}
