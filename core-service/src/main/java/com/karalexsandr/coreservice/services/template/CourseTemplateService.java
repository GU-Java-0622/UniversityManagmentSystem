package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.dto.CourseTemplateDto;
import com.karalexsandr.coreservice.dto.request.CourseTemplateCreateDto;
import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.repository.CourseTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
