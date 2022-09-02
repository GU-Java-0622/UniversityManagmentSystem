package ru.geekbrains.coreservice.services.template;


import ru.geekbrains.coreservice.dto.response.CourseTemplateResponseDto;
import ru.geekbrains.coreservice.entity.CourseTemplate;
import ru.geekbrains.coreservice.repository.CourseTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.commons.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseTemplateService {
    private final CourseTemplateRepository repository;

    public List<CourseTemplate> getCourseNotInStreamTemplate(List<Long> courseInStreamTemplate){
        if (courseInStreamTemplate.isEmpty()){
            return repository.findAll();
        }
        return repository.findAllByIdNotIn(courseInStreamTemplate);
    }

    public List<CourseTemplate> getCourseTemplateIn(List<Long> courseIds){
        return repository.findAllByIdIn(courseIds);
    }

    public void createCourseTemplate(String title){
        CourseTemplate courseTemplate = new CourseTemplate();
        courseTemplate.setTitle(title);
        repository.save(courseTemplate);
    }

    public CourseTemplate getCourseTemplateById (Long id){
        return repository.getReferenceById(id);
    }


    public CourseTemplateResponseDto getCourseTemplateWithLessons (Long id){
        return new CourseTemplateResponseDto(repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Не найден шаблон для курса с id:"+id)));
    }
}
