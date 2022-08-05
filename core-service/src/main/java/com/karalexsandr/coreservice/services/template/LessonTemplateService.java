package com.karalexsandr.coreservice.services.template;

import com.karalexsandr.coreservice.dto.AHZ.LessonTemplateDto;
import com.karalexsandr.coreservice.dto.request.AHZ.LessonTemplateCreateDto;
import com.karalexsandr.coreservice.entity.LessonTemplate;
import com.karalexsandr.coreservice.repository.LessonTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonTemplateService {
    private final LessonTemplateRepository repository;
    private final CourseTemplateService courseTemplateService;


    public void createLessonTemplate(LessonTemplateCreateDto dto){
        LessonTemplate lessonTemplate = new LessonTemplate();
        lessonTemplate.setTheme(dto.getTheme());
        lessonTemplate.setDuration(dto.getDuration());
        lessonTemplate.setCourseTemplate(courseTemplateService.getCourseTemplateById(dto.getCourseTemplateId()));
        repository.save(lessonTemplate);
    }

    public Page<LessonTemplateDto> findAll(Pageable pageable){
        return repository.findAll(pageable).map(LessonTemplateDto::new);
    }
}
