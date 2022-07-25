package com.karalexsandr.coreservice.entity.services.template;

import com.karalexsandr.coreservice.dto.request.LessonTemplateCreateDto;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.repository.LessonTemplateRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonTemplateService {
    private final LessonTemplateRepository repository;
    private final CourseTemplateService courseTemplateService;

    public LessonTemplateService(LessonTemplateRepository repository, CourseTemplateService courseTemplateService) {
        this.repository = repository;
        this.courseTemplateService = courseTemplateService;
    }

    public void createLessonTemplate(LessonTemplateCreateDto dto){
        LessonTemplate lessonTemplate = new LessonTemplate();
        lessonTemplate.setTheme(dto.getTheme());
        lessonTemplate.setDuration(dto.getDuration());
        lessonTemplate.setCourseTemplate(courseTemplateService.getCourseTemplateById(dto.getCourseTemplateId()));
        repository.save(lessonTemplate);
    }
}
