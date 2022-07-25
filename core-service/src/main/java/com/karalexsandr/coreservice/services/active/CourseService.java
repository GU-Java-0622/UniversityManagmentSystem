package com.karalexsandr.coreservice.services.active;

import com.karalexsandr.coreservice.dto.request.CourseSetTeacherDto;
import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.Person;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.exception.CoreException;
import com.karalexsandr.coreservice.repository.CourseRepository;
import com.karalexsandr.coreservice.services.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final LessonService lessonService;

    private final PersonService personService;


    public CourseService(CourseRepository repository, LessonService lessonService, PersonService personService) {
        this.repository = repository;
        this.lessonService = lessonService;
        this.personService = personService;

    }

    @Transactional
    public List<Course> createCoursesForStreamTemplate(StreamTemplate streamTemplate){
        List<CourseTemplate> courseTemplates = streamTemplate.getCourseTemplates();
        List<Course> courses = new ArrayList<>();
        for(CourseTemplate courseTemplate: courseTemplates){
            Course course = new Course();
            course.setTitle(courseTemplate.getTitle());
            course.setCourseTemplate(courseTemplate);
            course.setLessons(lessonService.createLessonsByCourseTemplate(courseTemplate));
            repository.save(course);
            courses.add(course);
        }
        return courses;
    }

    public void setTeacher(CourseSetTeacherDto dto) {

        Person person = personService.getById(dto.getPersonId());
        /*Тут надо бы проверить а есть ли роль учителя у этого пользователя*/
        int i = repository.setTeacher(person, dto.getCourseId());
        if(i==0){
            throw new CoreException("Не удалось припязать учителя с id: "+ dto.getPersonId());
        }
    }
}
