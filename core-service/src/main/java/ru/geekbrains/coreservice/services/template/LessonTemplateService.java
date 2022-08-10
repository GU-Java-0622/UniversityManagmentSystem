package ru.geekbrains.coreservice.services.template;


import ru.geekbrains.coreservice.dto.request.LessonTemplateCreateRequestDto;
import ru.geekbrains.coreservice.entity.LessonTemplate;
import ru.geekbrains.coreservice.repository.LessonTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonTemplateService {
    private final LessonTemplateRepository repository;
    private final CourseTemplateService courseTemplateService;


    public void createLessonTemplate(LessonTemplateCreateRequestDto dto){
        LessonTemplate lessonTemplate = new LessonTemplate();
        lessonTemplate.setTheme(dto.getTheme());
        lessonTemplate.setDuration(dto.getDuration());
        lessonTemplate.setHomeWorkUri(dto.getHomeWorkUri());
        lessonTemplate.setTrainingManualUri(dto.getTrainingManualUri());
        lessonTemplate.setCourseTemplate(courseTemplateService.getCourseTemplateById(dto.getCourseTemplateId()));
        repository.save(lessonTemplate);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
