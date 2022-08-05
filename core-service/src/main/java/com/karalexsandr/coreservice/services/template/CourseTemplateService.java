package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.dto.AHZ.CourseTemplateDto;
import com.karalexsandr.coreservice.dto.request.AHZ.CourseTemplateCreateDto;
import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.repository.CourseTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseTemplateService {
    private final CourseTemplateRepository repository;
    private final StreamTemplateService streamTemplateService;

    public Page<CourseTemplateDto> findAll(Pageable pageable){
        return repository.findAll(pageable).map(CourseTemplateDto::new);
    }

    public void createCourseTemplate(CourseTemplateCreateDto courseTemplateCreateDto){
        CourseTemplate courseTemplate = new CourseTemplate();
        courseTemplate.setTitle(courseTemplateCreateDto.getTitle());
        courseTemplate.getStreamTemplates().add(streamTemplateService.getStreamTemplateRefById(courseTemplateCreateDto.getStreamTemplateId()));
        repository.save(courseTemplate);
    }

    public CourseTemplate getCourseTemplateById (Long id){
        return repository.getReferenceById(id);
    }
}
