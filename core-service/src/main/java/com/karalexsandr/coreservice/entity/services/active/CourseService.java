package com.karalexsandr.coreservice.entity.services.active;

import com.karalexsandr.coreservice.entity.Course;
import com.karalexsandr.coreservice.entity.CourseTemplate;
import com.karalexsandr.coreservice.entity.StreamTemplate;
import com.karalexsandr.coreservice.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;
    private final LessonService lessonService;

    public CourseService(CourseRepository repository, LessonService lessonService) {
        this.repository = repository;
        this.lessonService = lessonService;
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
}
