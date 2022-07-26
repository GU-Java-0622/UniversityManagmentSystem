package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.repository.CourseTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseTemplateService {
    private final CourseTemplateRepository repository;
    private final StreamTemplateService streamTemplateService;

    public CourseTemplateService(CourseTemplateRepository repository, StreamTemplateService streamTemplateService) {
        this.repository = repository;
        this.streamTemplateService = streamTemplateService;
    }

    public void createCourseTemplate(String title, Long streamTemplateId){
        CourseTemplate courseTemplate = new CourseTemplate();
        courseTemplate.setTitle(title);
        courseTemplate.getStreamTemplates().add(streamTemplateService.getStreamTemplateRefById(streamTemplateId));
        repository.save(courseTemplate);
    }

    public CourseTemplate getCourseTemplateById (Long id){
        return repository.getReferenceById(id);
    }
}
